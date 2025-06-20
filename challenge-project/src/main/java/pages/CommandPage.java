package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommandPage extends BasePage {

    private By buttonDropEmployee = By.xpath("//section[@class='container']/ul/li[6]");
    private By buttonOpenListEmployee = By.xpath("//*[text()='Danh sách nhân viên']");

    public CommandPage(WebDriver driver) {
        super(driver);
    }

    public void openEmployeePage() {
        hoverElement(buttonDropEmployee);
        click(buttonOpenListEmployee);
        waitForPageLoaded();
    }
}
