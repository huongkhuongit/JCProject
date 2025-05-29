package com.example.challengeproject;

import com.example.challengeproject.core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OpenWeatherMapTest extends Base {
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://openweathermap.org");

        sendKeys("//div[@class='search-container']/input", "Los Angeles, US");
        click("//div[@class='search-container']/input");
        String actual = getText("//div[@class='search-container']/input");
//// Find search box and search city
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search city']")));
//        searchBox.sendKeys("Los Angeles");
//        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        searchButton.click();
//
//        // Wait and select "Los Angeles, US" in dropdown
//        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='search-dropdown-menu']//span[text()='Los Angeles, US']")));
//        dropdownOption.click();
//
//        // Wait for weather card to appear
//        WebElement cityHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='weather-widget']//h2")));
//
//        // 1. Verify city name
//        assertTrue(cityHeader.getText().contains("Los Angeles"), "City name not found");
//
//        // 2. Verify current date
//        String dateString = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy")); // e.g. May 29, 2025
//        WebElement dateElement = driver.findElement(By.cssSelector("#weather-widget .current-container .orange-text"));
//        assertTrue(dateElement.getText().contains(String.valueOf(LocalDate.now().getDayOfMonth())), "Date does not match today");
//
//        // 3. Verify temperature is a number
//        WebElement tempElement = driver.findElement(By.xpath("//div[@id='weather-widget']//span[@class='heading']"));
//        String tempText = tempElement.getText(); // e.g. "25°C"
//        assertTrue(Pattern.matches("\\d{1,3}.*", tempText), "Temperature is not a number: " + tempText);
        // Verify
        assertEquals("All Developer Tools and Products by JetBrains", actual);

    }
}
