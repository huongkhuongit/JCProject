package utils;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            String channelUrl = "https://www.youtube.com/@sunnydayanimation2623/shorts";  // 👉 đổi link kênh bạn muốn
            String dbFile = "data/downloaded_videos.json";
            String downloadDir = "videos/";

            // 1️⃣ Lấy danh sách video ID từ kênh
            System.out.println("🔎 Fetching video list...");
            List<String> allIds = Downloader.getVideoIdsFromChannel(channelUrl);
            System.out.println("✅ Total found: " + allIds.size());

            // 2️⃣ Đọc DB đã tải
            Set<String> downloadedIds = Downloader.loadDownloadedIds(dbFile);
            System.out.println("✅ Already downloaded: " + downloadedIds.size());

            // 3️⃣ Lọc video mới
            List<String> newIds = allIds.stream()
                    .filter(id -> !downloadedIds.contains(id))
                    .toList();
            System.out.println("🆕 New videos to download: " + newIds.size());

            // 4️⃣ Download + Process
            for (String id : newIds) {
                System.out.println("\n📥 Downloading video ID: " + id);
                Downloader.downloadVideo(id, downloadDir);

                // Tìm file .mp4 (yt-dlp thường xuất ra mp4 hoặc webm tùy stream)
                String inputFile = downloadDir + id + ".mp4";
                String outputFile = downloadDir + id + "_processed.mp4";

                System.out.println("⚙️ Processing video...");
                VideoProcessor.speedUpVideo(inputFile, outputFile);

                // Ghi vào DB
                downloadedIds.add(id);
                Downloader.saveDownloadedIds(downloadedIds, dbFile);

                System.out.println("✅ Done: " + id);
            }

            System.out.println("\n🎉 All done!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error occurred!");
        }
    }
}
