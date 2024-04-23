package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder, 'Имя')]")
    private WebElement inputName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Фамилия')]")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Адрес')]")
    private WebElement inputAddress;

    @FindBy(xpath = "//input[contains(@placeholder, 'Станция метро')]")
    private WebElement inputSubwayStation;

    @FindBy(xpath = "//input[contains(@placeholder, 'Телефон')]")
    private WebElement inputPhone;

    @FindBy(xpath = "//button[text()='Далее']")
    private WebElement buttonNext;

    private final String stationName = "//div[text()='%s']";

    public OrderPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this); // при создании экземляра класса проинициализирует элементы
    }

    public void setInputName (String name) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);
    }

    public void setInputLastName (String lastName) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputLastName));
        inputLastName.sendKeys(lastName);
    }

    public void setInputAddress (String address) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputAddress));
        inputAddress.sendKeys(address);
    }

    public void setInputSubwayStation (String subwayStation) {

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputSubwayStation));
        inputSubwayStation.sendKeys(subwayStation);
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format(stationName,subwayStation)))));
        element.click();
    }

    public void setInputPhone(String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputPhone));
        inputPhone.sendKeys(phone);
    }

    public void clickNext () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(buttonNext));
        buttonNext.click();
    }
}




