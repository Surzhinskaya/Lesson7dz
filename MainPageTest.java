package Lesson6;

import io.qameta.allure.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainPageTest extends AbstractTest {
    @Test
    @DisplayName("Авторизация")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.BLOCKER)
    public void authorizationTest() throws InterruptedException {

        MainPage mainPage = new MainPage(eventDriver);
        mainPage.clickentrance1();
        mainPage.setPhone("9111123435");
        mainPage.setPassword("tm05TM05");
        mainPage.clickentrance2();
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", eventDriver.getTitle(), "страница входа недоступна");

    }


    @Test
    @DisplayName("Замена личных данных")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.NORMAL)
    public void surNameTest() throws InterruptedException {
        MainPage mainPage = new MainPage(eventDriver);

        mainPage.clickentrance1();
        mainPage.setPhone("9111123435");
        mainPage.setPassword("tm05TM05");
        mainPage.clickentrance2();
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", eventDriver.getTitle(), "страница входа недоступна");
        mainPage.clickaccaunt(eventDriver);
        mainPage.clicklk(eventDriver);
        Assertions.assertEquals("Личный кабинет", eventDriver.getTitle(), "страница  недоступна");
        mainPage.clickediting(eventDriver);
        mainPage.setLastName("Иванова");
        mainPage.clickchange(eventDriver);
        Assertions.assertEquals("Личный кабинет", eventDriver.getTitle(), "страница недоступна");



    }

    @Test
    @DisplayName("Поиск")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.CRITICAL)
    public void searchTest() throws InterruptedException {
            MainPage mainPage = new MainPage(eventDriver);
            mainPage.setValue("омез");
            mainPage.clicksearchSubmit();
            Assertions.assertTrue(eventDriver.findElement(By.xpath(".//input[@value='омез']")).isDisplayed());
            mainPage.clickvalueOmez(eventDriver);
            mainPage.clicklogo(eventDriver);
            Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", eventDriver.getTitle(), "страница входа недоступна");
            mainPage.setSearch("jvtp");
            Assertions.assertTrue(eventDriver.findElement(By.xpath(".//input[@value='jvtp']")).isDisplayed());
            mainPage.clicksearchSubmit();

        }



    @Test
    @DisplayName("Добавление в корзину через кнопку")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.CRITICAL)
    public void basketTest() throws InterruptedException {
        MainPage mainPage=new MainPage(eventDriver);
        mainPage.clickimgPustyrnik(eventDriver);
        mainPage.clickpuy(eventDriver);
        mainPage.clickbasket(eventDriver);
        Assertions.assertEquals("Корзина Superapteka", eventDriver.getTitle(), "страница недоступна");
        Assertions.assertTrue(eventDriver.findElement(By.xpath("//*[@href='/catalog/product/erkafarm-pustyrnik-s-vitaminom-s-tab-60/']")).isDisplayed());

    }


   @Test
    @DisplayName("Проверка бонусов")
   @Issue("https://superapteka.ru")
   @Severity(SeverityLevel.MINOR)
    public void BonusTest() throws InterruptedException {

       MainPage mainPage = new MainPage(eventDriver);
       mainPage.clickentrance1();
       mainPage.setPhone("9111123435");
       mainPage.setPassword("tm05TM05");
       mainPage.clickentrance2();
       Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", eventDriver.getTitle(), "страница входа недоступна");
       mainPage.clickbonus();
       Assertions.assertEquals("Начисление бонусов", eventDriver.getTitle(), "страница недоступна");
   }

    @Test
    @DisplayName("Любимые товары")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.MINOR)
    public void FavoriteItemTest() throws InterruptedException {
        MainPage mainPage=new MainPage(eventDriver);
        mainPage.clickfavorite();
        Assertions.assertEquals("Избранные товары", eventDriver.getTitle(), "страница недоступна");
    }

    @Test
    @DisplayName("Сделай скрин")
    @Description("Тест создает скрин")
    @Link("http://google.com")
    @Issue("https://superapteka.ru")
    @Severity(SeverityLevel.BLOCKER)
    void testFalse() throws InterruptedException, IOException {
        Thread.sleep(1000);
        File file = MyUtils.makeScreenshot(getWebDriver(),"failure- Lesson6.MainPageTest.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(true);
    }

    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
    }
