import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class SimpleTest {
    public RemoteWebDriver driver;
    private static final String SELENIUM_URL = "http://localhost:4444/wd/hub";
    String SITE_URL="https://idev.etm.ru/ipro3";

    @BeforeTest
    public void start() throws Exception {
        this.driver = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new ChromeOptions()
        );
    }
    @AfterTest
    public void closeSeleniumSession() {
        this.driver.close();
        this.driver.quit();
    }
    
    /*@Test
    public void simpleTest() throws Exception {
        this.driver.get(SITE_URL);
        this.takeSceenshot();
    }*/
    @Test


    public void test13MakingAnOrderByPickUpByWriteScore() throws Exception{
        this.driver.get(SITE_URL);
        this.takeSceenshot();
        driver.findElement(By.xpath("//span[contains(.,'Все понятно')]")).click();
        this.takeSceenshot();
        driver.findElement(By.xpath("//span[contains(.,'Все верно')]")).click();
        this.takeSceenshot();
        driver.findElement(By.xpath("//span[contains(.,'Вход / Регистрация')]")).click();
        this.takeSceenshot();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("60004392kal");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("hzlc3549");
        driver.findElement(By.xpath("//span[contains(.,'Войти в систему')]")).click();

        try {
            WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
            button.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
            button.click();
        }
   /* try {
      WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-catalog']"));
      button.click();
    }
    catch(org.openqa.selenium.StaleElementReferenceException ex)
    {
      WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-catalog']"));
      button.click();
    }*/



        driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).click();
        driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-1']//input[@value=''])[1]")).sendKeys("10");
        driver.findElement(By.xpath("//div[@data-testid='add-basket-button-1']")).click();
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
        driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

        driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
        waitForElementPresent(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]"),"the PickUp is not issued",5);
        //driver.findElement(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]")).click();
    /*driver.findElement(By.xpath("//img[@src='/assets/img/logo_etm_blue.png']")).click();
    driver.findElement(By.xpath("//img[@src='/assets/img/logo_etm_blue.png']")).click();
    clickVisible(By.xpath("//div[contains(.,'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]") ,"not click delivery point", 5 );
    waitForElementPresent(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]"),"the delivery point is not issued",5);
    driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();
    driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();*/

        driver.findElement(By.xpath("//div[@data-testid='option-payment-1']")).click();
        driver.findElement(By.xpath("//span[contains(.,'Оформить заказ')]")).click();
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
        driver.findElement(By.xpath("//button[@data-testid='closePopup']")).click();
        waitForElementPresent(By.xpath("//p[contains(.,'Благодарим вас за использование системы iPRO!')]"),"the order is not issued",5);
        driver.findElement(By.xpath("//span[contains(.,'Перейти в Документы')]")).click();

        driver.findElement(By.xpath("//button[@title='Выход']")).click();
    }
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    /*private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
      WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
      element.click();

      return element;

    }
    private WebElement waitForElementAndClickable(By by, String error_message, long timeoutInSeconds){
      WebDriverWait wait=new WebDriverWait(driver, 10);
      wait.withMessage(error_message + "\n");
      return wait.until
              (ExpectedConditions.elementToBeClickable(by));

    }


    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
      WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
      element.sendKeys(value);

      return element;

    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
      wait.withMessage(error_message + "\n");

      return wait.until(
              ExpectedConditions.invisibilityOfElementLocated(by)
      );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
      WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
      element.clear();
      return element;
    }
    private WebElement waitForElementLocated(By by, String error_message, long timeoutInSeconds) {
      WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
      wait.withMessage(error_message + "\n");

      return wait.until(
              ExpectedConditions.visibilityOfElementLocated(by)
      );
    }*/
    public void clickVisible(By by ,String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        final Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    private void takeSceenshot() throws Exception {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./screenshot.png"));
        System.out.println("The Screenshot is taken...");

    }


}
