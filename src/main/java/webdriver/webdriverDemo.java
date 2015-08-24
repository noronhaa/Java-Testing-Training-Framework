package webdriver;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Automation on 19/08/15.
 */
public class webdriverDemo {

    WebDriver webDriver = new FirefoxDriver();

    @Test
    public void myFirstWebdriverTest(){

        webDriver.get("http://www.google.com");
        webDriver.findElement(By.id("lst-ib")).sendKeys("bbc news");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.linkText("Home - BBC News")).click();

        assertEquals("Home - BBC News",webDriver.getTitle());

        webDriver.quit();

    }


    @Test
    public void formTest(){
        webDriver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
        webDriver.findElement(By.id("alert")).click();
        Alert alert = webDriver.switchTo().alert();
        alert.accept();



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();

    }
}
