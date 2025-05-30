package com.example.challengeproject;

public class SearchPage {
    public static final String INPUT_SEARCH = "//div[@class='search-container']/input";
    public static final String BUTTON_SEARCH = "//button[@type='submit']";
    public static final String ITEM_SEARCH_DROPDOWN_MENU_BY_TEXT = "(//ul[@class='search-dropdown-menu']//span[contains(text(),'%s')])[1]";
    public static final String ITEM_CITY_HEADER = "//div[@id='weather-widget']//h2";
    public static final String ITEM_CITY_DATE = "#weather-widget .current-container .orange-text";
    public static final String ITEM_CITY_TEMPERATURE = "//div[@id='weather-widget']//span[@class='heading']";
    public static final String ITEM_CITY_HEADER_BY_TEXT = "//div[@id='weather-widget']//h2[contains(text(),'%s')]";


}
