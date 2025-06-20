package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // 👇 Locator mới, chú ý update nếu inspect không khớp
    private By inputRetailer = By.id("Retailer");
    private By inputUser = By.id("UserName");
    private By inputPassword = By.id("Password");
    private By buttonLoginAdmin = By.name("quan-ly");
    private By buttonLoginCashier = By.id("loginNewSale");
    private By buttonClosePopup = By.xpath("(//span[@class='vodal-close'])[1]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Hành động đăng nhập
    public void loginManager(String retailer, String user, String password) {
        sendKeys(inputRetailer, retailer);
        sendKeys(inputUser, user);
        sendKeys(inputPassword, password);
        click(buttonLoginAdmin);
        waitForPageLoaded();
//        sleepInSeconds(10);
//        click(buttonClosePopup);
//        sleepInSeconds(1);
//        if (isVisible(buttonClosePopup)) {
//            click(buttonClosePopup);
//            sleepInSeconds(1);
//        }
    }
}
