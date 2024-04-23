package cases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import general.WebDriverFactory;
import general.WebDriverName;

public class BaseTest {
    protected   WebDriver driver;

    @Before
    public void setUp()
    {
        driver = WebDriverFactory.create(WebDriverName.FIREFOX);
        driver.manage().window().maximize();
    }
     @After
    public void teardown() {
        //    Закрой браузер
        driver.quit();
    }
}
