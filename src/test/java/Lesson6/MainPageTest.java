package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MainPageTest extends AbstractTest {
    @Test
    @DisplayName("Авторизация")
    public void authorizationTest() throws InterruptedException {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickentrance1();
        mainPage.setPhone("9111123435");
        mainPage.setPassword("tm05TM05");
        mainPage.clickentrance2();
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", webDriver.getTitle(), "страница входа недоступна");

    }


    @Test
    @DisplayName("Замена личных данных")
    public void surNameTest() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.clickentrance1();
        mainPage.setPhone("9111123435");
        mainPage.setPassword("tm05TM05");
        mainPage.clickentrance2();
        Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", webDriver.getTitle(), "страница входа недоступна");
        mainPage.clickaccaunt(webDriver);
        mainPage.clicklk(webDriver);
        Assertions.assertEquals("Личный кабинет", webDriver.getTitle(), "страница  недоступна");
        mainPage.clickediting(webDriver);
        mainPage.setLastName("Иванова");
        mainPage.clickchange(webDriver);
        Assertions.assertEquals("Личный кабинет", webDriver.getTitle(), "страница недоступна");



    }

    @Test
    @DisplayName("Поиск")
    public void searchTest() throws InterruptedException {
            MainPage mainPage = new MainPage(webDriver);
            mainPage.setValue("омез");
            mainPage.clicksearchSubmit();
            Assertions.assertTrue(webDriver.findElement(By.xpath(".//input[@value='омез']")).isDisplayed());
            mainPage.clickvalueOmez(webDriver);
            mainPage.clicklogo(webDriver);
            Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", webDriver.getTitle(), "страница входа недоступна");
            mainPage.setSearch("jvtp");
            Assertions.assertTrue(webDriver.findElement(By.xpath(".//input[@value='jvtp']")).isDisplayed());
            mainPage.clicksearchSubmit();

        }



    @Test
    @DisplayName("Добавление в корзину через кнопку")
    public void basketTest() throws InterruptedException {
        MainPage mainPage=new MainPage(webDriver);
        mainPage.clickimgPustyrnik(webDriver);
        mainPage.clickpuy(webDriver);
        mainPage.clickbasket(webDriver);
        Assertions.assertEquals("Корзина Superapteka", webDriver.getTitle(), "страница недоступна");
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@href='/catalog/product/erkafarm-pustyrnik-s-vitaminom-s-tab-60/']")).isDisplayed());

    }


   @Test
    @DisplayName("Проверка бонусов")
    public void BonusTest() throws InterruptedException {

       MainPage mainPage = new MainPage(webDriver);
       mainPage.clickentrance1();
       mainPage.setPhone("9111123435");
       mainPage.setPassword("tm05TM05");
       mainPage.clickentrance2();
       Assertions.assertEquals("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств", webDriver.getTitle(), "страница входа недоступна");
       mainPage.clickbonus();
       Assertions.assertEquals("Начисление бонусов", webDriver.getTitle(), "страница недоступна");
   }

    @Test
    @DisplayName("Любимые товары")
    public void FavoriteItemTest() throws InterruptedException {
        MainPage mainPage=new MainPage(webDriver);
        mainPage.clickfavorite();
        Assertions.assertEquals("Избранные товары", webDriver.getTitle(), "страница недоступна");
    }


    }
