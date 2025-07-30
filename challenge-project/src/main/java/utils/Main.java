package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try {
            String channelUrl = "https://www.youtube.com/@sunnydayanimation2623/shorts";  // 👉 đổi link kênh bạn muốn
            String dbFile = "data/downloaded_videos.json";
            String downloadDir = "videos/";
            String doneDir = "videos/done/";

            new File(doneDir).mkdirs();

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

            // 4️⃣ Đa luồng tải & xử lý
            ExecutorService executor = Executors.newFixedThreadPool(4);

            for (String id : newIds) {
                executor.submit(() -> {
                    try {
                        System.out.println("\n📥 Downloading video ID: " + id);
                        Downloader.downloadVideo(id, downloadDir);

                        String inputFile = downloadDir + id + ".mp4";
                        String outputFile = downloadDir + id + "_processed.mp4";

                        System.out.println("⚙️ Processing video...");
                        VideoProcessor.speedUpVideo(inputFile, outputFile);

                        // Ghi DB
                        synchronized (downloadedIds) {
                            downloadedIds.add(id);
                            Downloader.saveDownloadedIds(downloadedIds, dbFile);
                        }

                        // Di chuyển vào thư mục done
                        new File(outputFile).renameTo(new File(doneDir + id + ".mp4"));

                        // Xóa file gốc
                        new File(inputFile).delete();

                        System.out.println("✅ Done: " + id);
                        // Step 1: Setup ChromeDriver
                        WebDriverManager.chromedriver().setup();

                        ChromeOptions options = new ChromeOptions();
                        // Trỏ đến thư mục user data của Chrome
                        options.addArguments("--user-data-dir=" + System.getProperty("user.home") + "/Library/Application Support/Google/Chrome");
                        // Dùng đúng profile đã đặt tên là 'tiktok1'
                        options.addArguments("--profile-directory=Profile 1");
                        // Bắt buộc nếu bạn dùng Selenium 4+
                        options.addArguments("--remote-allow-origins=*");

                        // Step 3: Mở trình duyệt với profile
                        WebDriver driver = new ChromeDriver(options);

                        // Step 4: Điều hướng đến TikTok
                        driver.get("https://www.tiktok.com/");
                    } catch (Exception e) {
                        System.err.println("❌ Error with ID: " + id);
                        e.printStackTrace();
                    }
                });
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(1000);
            }
            System.out.println("\n🎉 All done!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error occurred!");
        }
    }
}
