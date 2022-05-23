package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class MainPage extends AbstractPage {

    @FindBy(xpath = ".//span[contains(.,'Войти')]")
    private WebElement entrance1;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastName;

     @FindBy(css=".lnPUio")
     private WebElement entrance2;

    @FindBy(css=".dqBnxB")
    private WebElement accaunt;

    @FindBy(css=".ebIolo")
    private WebElement lk;

    @FindBy(xpath="//button[contains(.,'Редактировать профиль')]")
    private WebElement editing ;

    @FindBy(xpath="//button[contains(.,'Сохранить изменения')]")
    private WebElement change;

    @FindBy(xpath=".//input[@value='']")
    private WebElement value;

    @FindBy(id="searchSubmit")
    private WebElement searchSubmit;

    @FindBy(xpath=".//input[@value='омез']")
    private WebElement valueOmez;

    @FindBy(xpath="//img[@alt='logo']")
    private WebElement logo;

    @FindBy(xpath=".//input[@type='search']")
    private WebElement search;

    @FindBy(xpath=".//input[@value='jvtp']")
    private WebElement valueJvtp;

    @FindBy(xpath="//img[@alt='Эркафарм Пустырник с витамином С таб.№60']")
    private WebElement imgPustyrnik;

    @FindBy(css=".ggnCCj > .AppButton__AppButtonDefault-sc-122azo8-0")
    private WebElement puy;

    @FindBy(css=".AppCircularCounter__AppCircularCounterBlock-sc-1l48tdq-0 ")
    private WebElement basket;

    @FindBy(xpath="//*[@href='/catalog/product/erkafarm-pustyrnik-s-vitaminom-s-tab-60/']")
    private WebElement pustyrnik;

    @FindBy(xpath="//*[@href='/lk/bonuses/']")
    private WebElement bonus;

    @FindBy(css=".FavoritesWidget__FavoritesWidgetIcon-sc-ctistr-1")
    private WebElement favorite;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage setPhone(String PhoneText) {
        this.phone.sendKeys(PhoneText);
        return this;
    }
        public MainPage setPassword(String PasswordText){
            this.password.click();
            this.password.sendKeys(PasswordText);
            return this;
        }

    public MainPage setLastName(String LastNameText){
        WebElement lastName = (new WebDriverWait(getDriver(), Duration.ofSeconds(5)))
                .until(presenceOfElementLocated(By.xpath("//*[@id='lastName']")));
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(LastNameText);
        return this;
    }
    public MainPage clickentrance1(){
        entrance1.click();
        return this;
    }
    public MainPage clickentrance2(){
        entrance2.click();
        return this;
    }
    public MainPage clickaccaunt(Object WebDriver) throws InterruptedException{

        JavascriptExecutor executor1 = (JavascriptExecutor)WebDriver;
        executor1.executeScript("arguments[0].click();", new Object[]{accaunt});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dqBnxB")));
        return this;
    }
    public MainPage clickediting(Object WebDriver) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Редактировать профиль')]")));
        JavascriptExecutor executor2 = (JavascriptExecutor)WebDriver;
        executor2.executeScript("arguments[0].click();", new Object[]{editing});
        return this;
    }

    public MainPage clickchange(Object WebDriver) throws InterruptedException{
        JavascriptExecutor executor3 = (JavascriptExecutor)WebDriver;
        executor3.executeScript("arguments[0].click();", new Object[]{change});
        return this;
    }

    public MainPage setValue(String ValueText) throws InterruptedException {
        this.value.click();
        this.value.sendKeys(ValueText);
        return this;
    }

    public MainPage clicklk(Object WebDriver) throws InterruptedException{
        JavascriptExecutor executor4 = (JavascriptExecutor)WebDriver;
        executor4.executeScript("arguments[0].click();", new Object[]{lk});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Личный кабинет"));
        return this;

    }

    public MainPage clicksearchSubmit(){
        searchSubmit.click();
        return this;
    }

    public MainPage clickvalueOmez(Object WebDriver) throws InterruptedException  {
        JavascriptExecutor executor5 = (JavascriptExecutor)WebDriver;
        executor5.executeScript("arguments[0].click();", new Object[]{valueOmez});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Результаты поиска"));
        this.valueOmez.clear();
        return this;
    }

    public MainPage clicklogo(Object WebDriver) throws InterruptedException  {
        JavascriptExecutor executor6 = (JavascriptExecutor)WebDriver;
        executor6.executeScript("arguments[0].click();", new Object[]{logo});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='logo']")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств"));
        return this;
    }

    public MainPage setSearch(String SearchText) throws InterruptedException{

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@type='search']")));
        this.search.click();
        this.search.sendKeys(SearchText);
        return this;
    }



    public MainPage clickimgPustyrnik(Object WebDriver) throws InterruptedException {

        JavascriptExecutor executor8 = (JavascriptExecutor)WebDriver;
        executor8.executeScript("arguments[0].click();", new Object[]{imgPustyrnik});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Интернет-аптека \"СуперАптека\" - продажа лекарственных препаратов в Санкт-Петербургe, поиск лекарств"));
        return this;

    }

    public MainPage clickpuy(Object WebDriver) throws InterruptedException {
      JavascriptExecutor executor9 = (JavascriptExecutor)WebDriver;
      executor9.executeScript("arguments[0].click();", new Object[]{puy});
        Thread.sleep(3000);
        return this;
    }

    public MainPage clickbasket(Object WebDriver) throws InterruptedException {
        JavascriptExecutor executor10 = (JavascriptExecutor)WebDriver;
        executor10.executeScript("arguments[0].click();", new Object[]{basket});
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".AppCircularCounter__AppCircularCounterBlock-sc-1l48tdq-0 ")));
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Корзина Superapteka"));
        return this;
    }



    public MainPage clickbonus(){
        bonus.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Начисление бонусов"));
        return this;
    }

    public MainPage clickfavorite(){
        favorite.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Избранные товары"));
        return this;
    }



}
