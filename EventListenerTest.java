package Lesson6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class EventListenerTest extends AbstractTest{

    @Test
    void test(){
        try {
            getWebDriver().findElement(By.id("нет такого"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure- Lesson6.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }



}