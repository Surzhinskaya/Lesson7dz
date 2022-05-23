package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class AbstractTest {

        static WebDriver webDriver;

        @BeforeAll
        static void setDriver(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            options.addArguments("start-maximized");
            options.setPageLoadTimeout(Duration.ofSeconds(10));

            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @BeforeEach
        void initMainPage(){
            Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://www.superapteka.ru"),
                    "Страница не доступна");
            Assertions.assertTrue(true);

        }

    @BeforeEach
        void getPage() {
        webDriver.get("https://www.superapteka.ru");
        webDriver.manage().deleteAllCookies();
    }


        @AfterAll
        public static void exit(){

            if(webDriver !=null) webDriver.quit();
        }

        public WebDriver getWebDriver(){
            return this.webDriver;
        }
    }

