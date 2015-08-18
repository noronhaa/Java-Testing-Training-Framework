package webdriver;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by noronhaa on 28/05/15.
 */
public class webdriver {

    public static final String USERNAME_LOCATOR = "//*[@id='login-username']";
    public static final String PASSWORD_LOCATOR = "//*[@id='login-password']";
    public static final String PASSWORD = "test";
    public static final String LOGIN_BUTTON_LOCATOR = "//*[@value='Login']";
    public static final String BASE_URL = "http://www.futurefit.co.uk/student-zone/myzone/";


    public static String GLOBAL_VARIABLE;

    public static String getGlobalVariable() {
        return GLOBAL_VARIABLE;
    }

    public static void setGlobalVariable(String globalVariable) {
        GLOBAL_VARIABLE = globalVariable;
    }

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();

        //this sets an implicit wait for the entire time the browser is open - will wait for 10 seconds while trying to find
        //something before it times out
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //page load timeouts
        driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

    }

    @After
    public void tearDown(){
        System.out.println("tearing down");
        driver.quit();
    }

    @Test
    public void TestSuccessfulLogin() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.findElement(By.xpath(USERNAME_LOCATOR)).sendKeys("ashleydeannoronha@gmail.com");
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR)).submit();
        assertEquals("Login unsuccessful", "MyZone | Student Zone", driver.getTitle());
    }


    @Test
    public void TestUnsuccessfulLoginWithIncorrectUsername(){
            driver = new FirefoxDriver();
            driver.get(BASE_URL);

            String username = RandomStringUtils.randomAlphabetic(8);
            driver.findElement(By.xpath(USERNAME_LOCATOR)).sendKeys( username + "@gmail.com");
            driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys("AH14533");
            driver.findElement(By.xpath(LOGIN_BUTTON_LOCATOR)).click();
            assertFalse("Successful login with incorect username",driver.getTitle().contains("MyZone | Student Zone"));
            assertTrue(driver.findElement(By.xpath("//*[@class='error']")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//*[@class='error']")).getText().contains("The username or password you entered is incorrect. Please check the username, re-type the password, and try again."));


        }

    @Test
    public void TestDropDownMenu(){
        driver.get("http://www.toolsqa.com/automation-practice-form/");
        Select dropdown = new Select(driver.findElement(By.cssSelector("#continents")));
//        dropdown.selectByVisibleText("Australia");
        dropdown.selectByIndex(4);
            driver.quit();

    }

    @Test
    public void TestFindElementsAndPrint() throws InterruptedException {



        driver.get("http://www.which.co.uk");

        List<WebElement> menuListItems = driver.findElements(By.cssSelector(".popular-categories-block > a"));
//        driver.findElement(B)
        for (WebElement menuListItem : menuListItems){
            System.out.println(menuListItem.getText());
        }
        driver.quit();
    }



    @Test
    public void TestHoverFunctionality() throws InterruptedException {
        driver.get("http://www.which.co.uk/technology/");
        Actions action = new Actions(driver);
        WebElement buttonToHover = driver.findElement(By.cssSelector("nav.mega-menu .nav-links li:nth-of-type(1) span"));
        action.moveToElement(buttonToHover).build().perform();
        Thread.sleep(3000);

    }



    @Test
    public void TestDragAndDropFunctionality(){
//        todo
        WebElement element = driver.findElement(By.cssSelector(""));
        WebElement target = driver.findElement(By.cssSelector(""));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(element,target);
//        actions.
    }



    @Test
    public void TestJavascriptfunctionality(){

    }

    @Test
    public void TestAlertFunctionality(){
        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
        driver.findElement(By.xpath("//*[@id='alert']")).click();
        driver.switchTo().alert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void TestManageWindowSize(){
        driver.get("http://www.which.co.uk");
        driver.manage().window().maximize();

    }

    @Test
    public void TestTakeScreenshotWhenFail(){

    }

    @Test
    public void TestpressingKeysOnKeyboard(){
        WebElement ele1 = driver.findElement(By.cssSelector(""));
        WebElement ele2 = driver.findElement(By.cssSelector(""));
        Actions action = new Actions(driver);
        action.keyDown(Keys.COMMAND).click(ele1).click(ele2).keyUp(Keys.COMMAND);
    }

    @Test
    public void TestCountLinksOnPage(){
        driver.get("http://www.which.co.uk");
        List<WebElement> links = driver.findElements(By.cssSelector("a"));
        System.out.println(links.size());
    }

    @Test
    public void TestiframeFuntionality(){
        driver.get("http://www.toolsqa.com/iframe-practice-page/");
        driver.switchTo().frame(driver.findElement(By.id("IF1")));
        String Subtitle = driver.findElement(By.cssSelector("h1")).getText();
        driver.switchTo().defaultContent();
        System.out.println(Subtitle);
    }

    @Test
    public void TestSwitchWindowFunctionality(){
        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        driver.findElement(By.xpath("//*[@id='button1']")).click();
        String secondWindow = null;
        for (String window : driver.getWindowHandles()){
            if (!window.equals(mainWindow)){
                secondWindow = window;
            }
        }
        driver.switchTo().window(secondWindow);
        System.out.println(driver.getTitle());

        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());

    }

    @Test
    public void webdriverFunctionality(){

//        custom wait function
        WebDriverWait wait  = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

//        Navigate Back - browser back
        driver.navigate().back();

//        Navigate Browser Forward
        driver.navigate().forward();

//        Refresh Page
        driver.navigate().refresh();



    }

    @Test
    public void webdriverWaitTestAndAlerts(){
        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Alert expectedAlert = wait.until(ExpectedConditions.alertIsPresent());
        wait.until(ExpectedConditions.alertIsPresent());
        expectedAlert.accept();
    }

    @Test
    public void customWebdriverWait(){

        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
        driver.findElement(By.xpath("//*[@id='timingAlert']"));

        FluentWait wait = new FluentWait(driver);

        wait.withTimeout(60, TimeUnit.SECONDS);
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.ignoring(ElementNotVisibleException.class);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='clock']")), "Buzz Buzz"));
        System.out.println(driver.findElement(By.xpath("//*[@id='clock']")).getText());

    }



}
