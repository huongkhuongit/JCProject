package com.example.challengeproject.TestCase;

import com.example.challengeproject.PageObject.SearchPage;
import com.example.challengeproject.core.Base;
import com.example.challengeproject.core.BaseTest;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class OpenWeatherMapTest extends BaseTest {

    @Test
    void testSearch() {
        SearchPage searchPage = new SearchPage(driver, wait);
        // Exercise
        driver.get("https://openweathermap.org");
        String cityNameExpect = "Los Angeles, US";
        searchPage.searchByText(cityNameExpect);
        searchPage.verify(cityNameExpect);

    }
}
