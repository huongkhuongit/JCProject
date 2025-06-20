package config;

import constants.GlobalVariables;
import net.serenitybdd.core.Serenity;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("⚠️ Cannot load config.properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getUserName() {
        return get("userName");
    }

    public static String getPassword() {
        return get("password");
    }

    public static String getRetailer() {
        return get("retailer");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static void storeData() {
        String url = getBaseUrl();
        String retailer = getRetailer();
        Serenity.setSessionVariable(GlobalVariables.RETAILER).to(retailer);
        Serenity.setSessionVariable(GlobalVariables.HOST).to(url);
    }
}
