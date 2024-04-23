package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;
    //private By orderButton = By.xpath("//div[contains(@class, 'Header')]/button[text()='Заказать']");  //кнопка для заказика
    @FindBy(xpath = "//div[contains(@class, 'Header')]/button[text()='Заказать']")
    private WebElement orderButton; // кнопка для заказа

    private final String questionsLocator = "accordion__heading-%s";
    // private final String answerLocator = "//div[contains(@id, 'accordion__panel-')][.='%s']";
    private final String answerLocator = "accordion__panel-%s";
    public MainPage (WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void clickOrderButton () {
         orderButton.click();
    }

    public void clickQuestion (int index) {
          // перевод переменной в стринг формат, индекс - число,которое заменяет %s
        WebElement element = driver.findElement(By.id(String.format(questionsLocator, index))); ;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getAnswer (int index) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id(String.format(answerLocator, index)))));
        return element.getText();  // получить текст из выпадашки
    }
    }

