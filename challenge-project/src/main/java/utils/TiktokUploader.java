package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import pages.UploadVideoPage;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TiktokUploader {
    private WebDriver driver;

    public void startFirefox(String profilePath) {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-profile", profilePath);
        options.addArguments("-no-remote");
        options.addArguments("-new-instance");
        driver = new FirefoxDriver(options);
        driver.get("https://www.tiktok.com/tiktokstudio/upload?from=webap");

    }

    public void upVideo(String videoPath) {
        UploadVideoPage page = new UploadVideoPage();
        System.out.println("Sẵn sàng tải lên: "+DateTimePrint.getDateDateTimeNow());;
        page.uploadVideo(driver, videoPath);
        endFirefox();
    }
    public void endFirefox() {
        driver.close();
    }
}
