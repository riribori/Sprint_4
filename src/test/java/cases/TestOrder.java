package cases;

import org.junit.Assert;
import org.junit.Test;
import general.*;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestOrder extends BaseTest {



    @Test
    public void TestOrder() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setInputName("Имя");
        orderPage.setInputLastName("Фамилия");
        orderPage.setInputAddress("Адрес");
        orderPage.setInputSubwayStation("Лихоборы");
        orderPage.setInputPhone("11111111111");
        orderPage.clickNext();
        RentPage rentPage = new RentPage(driver);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YY");
        String formattedDate = sdf.format(calendar.getTime()); // выбор даты сегодня + 1 день в календаре
        rentPage.setInputWhen(formattedDate);
        rentPage.setDropdownTime(RentTerm.SIXDAY);
        rentPage.clickOrderButton();
        AcceptPage acceptPage = new AcceptPage(driver);
        acceptPage.clickYesButton();
        SuccessPage successPage = new SuccessPage(driver);
        Assert.assertTrue("Не появилось окно успеха",successPage.showSuccessPage());
    }

}
