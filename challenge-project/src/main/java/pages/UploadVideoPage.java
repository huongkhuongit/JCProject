package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploadVideoPage {
    private String inputVideo = "//input[@type='file']";
    private String inputCaptionEditor = "//div[@contenteditable='true' and contains(@class,'public-DraftEditor-content')]";
    private String btnCheckMusic = "//input[@id=':r4i:']/parent::div";
    private String btnCheckContent = "//input[@id=':r4u:']/parent::div";
    private String btnPost = "//button[@data-e2e='post_video_button']";


    private String hashTags = "#fyp #viral #japan #japantiktok";
    public void uploadVideo(WebDriver driver, String videoPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // 1. Upload video
        File file = new File(videoPath);
        if (!file.exists()) {
            throw new RuntimeException("❌ File not found: " + file.getAbsolutePath());
        }
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputVideo)));
        fileInput.sendKeys(file.getAbsolutePath());

        // 2. Chờ editor caption xuất hiện
        WebElement captionEditor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputCaptionEditor)));

        // 3. Clear caption cũ và nhập hashtags
        captionEditor.click();
        captionEditor.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        captionEditor.sendKeys(Keys.DELETE); // delete
        captionEditor.sendKeys(hashTags);

//        // 4. Đợi tắt check
        WebElement checkMusic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnCheckMusic)));
        if(checkMusic.getAttribute("data-state").contains("checked")){
            checkMusic.click();
        }
        WebElement checkContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnCheckContent)));
        if(checkContent.getAttribute("data-state").contains("checked")){
            checkContent.click();
        }

        // 5. Click Post
        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPost)));
        postButton.click();
    }

}
