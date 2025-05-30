package com.example.challengeproject;

import com.example.challengeproject.core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class OpenWeatherMapTest extends Base {
    SearchPage searchPage = new SearchPage();

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
    void testSearch() {
        // Exercise
        driver.get("https://openweathermap.org");

        String cityNameExpect = "Los Angeles, US";

        sendKeys(SearchPage.INPUT_SEARCH, cityNameExpect);
        click(SearchPage.BUTTON_SEARCH);
        click(SearchPage.ITEM_SEARCH_DROPDOWN_MENU_BY_TEXT, cityNameExpect);
        waitForElementVisible(SearchPage.ITEM_CITY_HEADER_BY_TEXT, cityNameExpect);

        // 1. Verify city name
        assertEquals("City name not found", "Los Angeles, US", getText(SearchPage.ITEM_CITY_HEADER));

        // 2. Verify current date
        assertTrue("Date does not match today", getText(SearchPage.ITEM_CITY_DATE).contains(String.valueOf(LocalDate.now().getDayOfMonth())));

        // 3. Verify temperature is a number
        // e.g. "25°C"
        String tempText = getText(SearchPage.ITEM_CITY_TEMPERATURE);
        assertTrue("Temperature is not a number: " + tempText, Pattern.matches("\\d{1,3}.*", tempText));
    }
}
