package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import general.RentTerm;

import java.time.Duration;

public class RentPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder, 'Когда')]")
    private WebElement inputWhen;

    @FindBy(xpath = "//div[contains(@class, 'Dropdown-placeholder')and contains (text(), 'Срок аренды')]")
    private WebElement fieldRentTerm;

    private final String dropdownTime = "//div[contains(@class, 'Dropdown-option')and text()='%s']";

    @FindBy(xpath = "//div[contains(@class, 'Order')]/button[text()='Заказать']")
    private WebElement createOrderButton;

    public RentPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this); // при создании экземляра класса проинициализирует элементы
    }

    public void setInputWhen (String dateWhen) {
        inputWhen.sendKeys(dateWhen);
        inputWhen.sendKeys(Keys.ENTER);
    }

    public void setDropdownTime (RentTerm rentTerm) {

        fieldRentTerm.click();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(dropdownTime,rentTerm.getDescription())))));
        element.click();


    }
    public void clickOrderButton () {
        createOrderButton.click();
    }

}
