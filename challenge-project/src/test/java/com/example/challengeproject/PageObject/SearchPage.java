package com.example.challengeproject.PageObject;

import com.example.challengeproject.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchPage extends Base {
    public static final String INPUT_SEARCH = "//div[@class='search-container']/input";
    public static final String BUTTON_SEARCH = "//button[@type='submit']";
    public static final String ITEM_SEARCH_DROPDOWN_MENU_BY_TEXT = "(//ul[@class='search-dropdown-menu']//span[contains(text(),'%s')])[1]";
    public static final String ITEM_CITY_HEADER = "//div[@id='weather-widget']//h2";
    public static final String ITEM_CITY_DATE = "#weather-widget .current-container .orange-text";
    public static final String ITEM_CITY_TEMPERATURE = "//div[@id='weather-widget']//span[@class='heading']";
    public static final String ITEM_CITY_HEADER_BY_TEXT = "//div[@id='weather-widget']//h2[contains(text(),'%s')]";

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void searchByText(String cityNameExpect) {
        sendKeys(SearchPage.INPUT_SEARCH, cityNameExpect);
        click(SearchPage.BUTTON_SEARCH);
        click(SearchPage.ITEM_SEARCH_DROPDOWN_MENU_BY_TEXT, cityNameExpect);
        waitForElementVisible(SearchPage.ITEM_CITY_HEADER_BY_TEXT, cityNameExpect);
    }

    public void verify(String cityNameExpect) {
        // 1. Verify city name
        assertEquals("City name not found", cityNameExpect, getText(SearchPage.ITEM_CITY_HEADER));

        // 2. Verify current date
        // 2. Lấy ngày hôm nay tại Los Angeles
        ZoneId laZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime nowInLA = ZonedDateTime.now(laZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, hh:mma", Locale.ENGLISH);
        String expectDate = nowInLA.format(formatter).replace("AM", "am").replace("PM", "pm");;

        assertEquals("Date does not match today",expectDate, getText(SearchPage.ITEM_CITY_DATE));

        // 3. Verify temperature is a number
        // e.g. "25°C"
        String tempText = getText(SearchPage.ITEM_CITY_TEMPERATURE);
        assertTrue("Temperature is not a number: " + tempText, Pattern.matches("\\d{1,3}.*", tempText));
    }

}