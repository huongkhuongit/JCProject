package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Downloader {

    public static List<String> getVideoIdsFromChannel(String channelUrl) throws IOException {
        List<String> videoIds = new ArrayList<>();

        ProcessBuilder pb = new ProcessBuilder(
                "yt-dlp", "-j", channelUrl
        );
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();

        // Định dạng ngày thành chuỗi "YYYYMMDD"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String todayString = today.format(formatter);

        Process process = pb.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject obj = new JSONObject(line);
                if (obj.getString("upload_date").equals(todayString)){
                    videoIds.add(obj.getString("id"));
                }else break;
            }
        }

        return videoIds;
    }

    public static Set<String> loadDownloadedIds(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) return new HashSet<>();

        String content = new String(Files.readAllBytes(file.toPath()));
        JSONObject obj = new JSONObject(content);
        JSONArray arr = obj.getJSONArray("downloaded");

        Set<String> ids = new HashSet<>();
        for (int i = 0; i < arr.length(); i++) {
            ids.add(arr.getString(i));
        }

        return ids;
    }

    public static void saveDownloadedIds(Set<String> ids, String filePath) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("downloaded", new JSONArray(ids));
        Files.write(Paths.get(filePath), obj.toString(2).getBytes());
    }

    public static void downloadVideo(String videoId, String outputDir) throws IOException, InterruptedException {
        String url = "https://www.youtube.com/watch?v=" + videoId;

        ProcessBuilder pb = new ProcessBuilder(
                "yt-dlp",
                "--no-mtime",
                "-f", "bestvideo+bestaudio/best",
                "--merge-output-format", "mp4",
                "-o", outputDir + "/" + videoId + ".mp4",
                url
        );


        pb.inheritIO();  // Log ra console
        Process process = pb.start();
        process.waitFor();
    }
}
