package com.example.challengeproject.TestCase;

import com.example.challengeproject.PageObject.SearchPage;
import com.example.challengeproject.core.BaseTest;
import org.junit.jupiter.api.*;


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
