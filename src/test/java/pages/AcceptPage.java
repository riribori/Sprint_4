package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptPage {
    private WebDriver driver;
    public AcceptPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this); // при создании экземляра класса проинициализирует элементы
    }

    @FindBy(xpath = "//button[text() = 'Да']")
    private WebElement yesButton;

    public void clickYesButton () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(yesButton));
        yesButton.click();
    }

}
