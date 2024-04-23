package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {

    private WebDriver driver;

    public SuccessPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this); // при создании экземляра класса проинициализирует элементы
    }

    @FindBy(xpath = "//div[text() = 'Заказ оформлен']")
    private WebElement successOrder;

    public boolean showSuccessPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(successOrder));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
