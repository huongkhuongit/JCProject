package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String channelUrl = "https://www.youtube.com/@2chmatome_meigen/shorts";
        String dbFile = "data/downloaded_videos.json";
        String downloadDir = "videos/";
        String doneDir = "videos/done/";
        String profilePath = "D:/firefox/profilekenh1";
        new File(doneDir).mkdirs();
        while (true){
            try {
                // 1️⃣ Lấy danh sách video ID từ kênh
                System.out.println("Fetching video list at: "+DateTimePrint.getDateDateTimeNow());;
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
                for (String id : newIds) {
                    try {
                        System.out.println("\n📥 "+DateTimePrint.getDateDateTimeNow()+" -- "+"Downloading video ID: " + id);
                        Downloader.downloadVideo(id, downloadDir);

                        String inputFile = downloadDir + id + ".mp4";
                        String outputFile = downloadDir + id + "_processed.mp4";
//
//                        System.out.println("⚙️ Processing video...");
//                        VideoProcessor.speedUpVideo(inputFile, outputFile);

                        // Ghi DB
                        downloadedIds.add(id);
                        Downloader.saveDownloadedIds(downloadedIds, dbFile);

//                        // Di chuyển vào thư mục done
                        String videoPath = "videos/" + id + ".mp4";
//                        new File(outputFile).renameTo(new File(videoPath));

                        // Upload TikTok
                        TiktokUploader tiktokUploader = new TiktokUploader();
                        tiktokUploader.startFirefox(profilePath);
                        tiktokUploader.upVideo(videoPath);

                        // Xoá file gốc
                        new File(inputFile).delete();

                        System.out.println("✅ Done: " + id);
                    } catch (Exception e) {
                        System.err.println("❌ Error with ID: " + id);
                        e.printStackTrace();
                    }
                }

                System.out.println("\n🎉 All done!");

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("❌ Error occurred!");
            }
        }

    }
}
