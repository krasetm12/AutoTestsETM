import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SimpleTest {
    public RemoteWebDriver driver;

      //http://localhost:4444/wd/hub"

    private static final
    String SELENIUM_URL = "http://autotest.etm.corp:4444/wd/hub";
    String ITEST_HOME_PAGE= "https://itest.etm.ru:3004";
    String SITE_URL="https://idev.etm.ru/ipro3";
    String LOGIN_MARKET="9216572712";
    String PASSWORD_MARKET="qakras123";
    String LOGIN_IPRO="60004392kal";
    String PASSWORD_IPRO="qakras123";


    @BeforeTest
    public void start() throws Exception {
        this.driver = new RemoteWebDriver(
                new URL(SELENIUM_URL),
                new ChromeOptions()
        );
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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


    public void test13MakingAnOrderByPickUpByWriteScore() throws Exception {
      this.driver.get(ITEST_HOME_PAGE);
      System.out.println("начало второго теста" );
      /*this.takeSceenshot();
      Cookie cookiesession=driver.manage().getCookieNamed("session-id");
      if(cookiesession==null){
      //driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();
      //driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();
        waitForElementPresent(By.xpath("//button[@data-testid='understand-button']"),"все понятно не появилось", 10);
        this.driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();
        this.takeSceenshot();
        this.driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();
        this.takeSceenshot();
      }
      else
      driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
      driver.findElement(By.name("login")).clear();
      driver.findElement(By.name("login")).sendKeys(LOGIN_MARKET);
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys(PASSWORD_MARKET);
      driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
      this.takeSceenshot();

       */


      //driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();
      //driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();

      if(this.driver.findElementsByXPath("//button[@data-testid='understand-button']").size() >0){
        waitForElementPresent(By.xpath("//button[@data-testid='understand-button']"),"все понятно не появилось", 10);
        this.driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();
      }
      else if(this.driver.findElementsByXPath("//button[@data-testid='okay-button']").size() >0) {

        this.takeSceenshot();
        this.driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();
        this.takeSceenshot();
      }
      //if(cookieSession==null) {
        waitForElementPresent(By.xpath("//button[@data-testid='authorization-button']"), "кнопка войти не появилась", 10);
        this.driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        this.takeSceenshot();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_MARKET);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_MARKET);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
      //Cookie cookieSession=this.driver.manage().getCookieNamed("session-id");
      Set<Cookie> cookieSession = (Set<Cookie>) driver.manage().getCookieNamed("session-id");
      for(Cookie getCookieNamed :cookieSession) {
        System.out.println(getCookieNamed );
      }
      System.out.println(cookieSession);

      try {
        WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-estimates']"));
        button.click();
      } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        WebElement button = driver.findElement(By.xpath("//a[@data-testid='top-menu-estimates']"));
        button.click();
      }
      driver.findElement(By.xpath("//button[@id='composition-button']")).click();
      driver.findElement(By.xpath("//li[@data-testid='drop-menu-item-exit']")).click();
      System.out.println("конец второго теста" );

      /*MainPageObject.waitForElementAndSendKeys("//input[@name='nameEst']", "999/0817524", "not found the data entry element ", 5);
      MainPageObject.waitForElementAndClick("//button[@data-testid='search-button']", "not found and click element of search", 5);

      MainPageObject.waitForElementAndClickable("//span[contains(.,'999/0816925')]", "not found element add to cart", 5);
      MainPageObject.waitForElementPresent("//tr[@data-testid='estimate-item-1']", "not found estimate", 5);
      MainPageObject.waitForElementAndClickable("//button[@data-testid='estimate-item-1-button-cart']", "not found element add to cart", 5);
      MainPageObject.waitForElementAndClick("//button[@data-testid='estimate-item-1-button-cart']", "not found and click element of search", 5);
      MainPageObject.waitForElementAndClick("//button[@data-testid='message-close-button']", "not found and click element X", 5);
      MainPageObject.waitForElementAndClick("//p[@data-testid='go-to-basket']", "not found and click element of go to basket", 5);
    */
    }

    @Test


    public void test12MakingAnOrderByCDEKPayUponReceipt() throws Exception{
        this.driver.get(ITEST_HOME_PAGE);
      System.out.println("начало первого теста" );
      Set<Cookie> cookiesListNew =  driver.manage().getCookies();
      for(Cookie getcookies :cookiesListNew) {
        System.out.println(getcookies );
      }


      Cookie cookieSession=this.driver.manage().getCookieNamed("session-id");

        //driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();
        //driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();

        if(this.driver.findElementsByXPath("//button[@data-testid='understand-button']").size() >0){
          waitForElementPresent(By.xpath("//button[@data-testid='understand-button']"),"все понятно не появилось", 10);
          this.driver.findElement(By.xpath("//button[@data-testid='understand-button']")).click();
          this.takeSceenshot();
        }
        else if(this.driver.findElementsByXPath("//button[@data-testid='okay-button']").size() >0) {

          this.takeSceenshot();
          this.driver.findElement(By.xpath("//button[@data-testid='okay-button']")).click();

        }
      //if(cookieSession==null) {

        waitForElementPresent(By.xpath("//button[@data-testid='authorization-button']"), "кнопка войти не появилась", 10);
        this.driver.findElement(By.xpath("//button[@data-testid='authorization-button']")).click();
        this.takeSceenshot();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(LOGIN_MARKET);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD_MARKET);
        driver.findElement(By.xpath("//button[@data-testid='go-to-system']")).click();
      Set<Cookie> cookieSessionm = (Set<Cookie>) driver.manage().getCookieNamed("session-id");
      for(Cookie getCookieNamed :cookieSessionm) {
        System.out.println(getCookieNamed );
      }
      System.out.println(cookieSessionm);


        driver.findElement(By.xpath("//button[@id='composition-button']")).click();
        driver.findElement(By.xpath("//li[@data-testid='drop-menu-item-exit']")).click();
      System.out.println("конец первого теста" );


        /*try {
            WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = driver.findElement(By.xpath("//a[@href='/catalog']"));
            button.click();
        }

        try {
            WebElement button = this.driver.findElement(By.xpath("//a[@data-testid='top-menu-catalog']"));
            button.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement button = this.driver.findElement(By.xpath("//a[@data-testid='top-menu-catalog']"));
            button.click();
        }
        this.takeSceenshot();



        driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-2']//input[@value=''])[1]")).click();
        driver.findElement(By.xpath("(//div[@data-testid='catalog-item-product-2']//input[@value=''])[1]")).sendKeys("10");
        driver.findElement(By.xpath("//div[@data-testid='catalog-item-product-2']//span[@class='MuiButton-label']")).click();
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root jss4']")).click();
        driver.findElement(By.xpath("//p[@data-testid='go-to-basket']")).click();

        driver.findElement(By.xpath("//*[@data-testid='go-checkout-btn']")).click();
        waitForElementPresent(By.xpath("//div[contains(text(),'Самовывоз ЭТМ')]"),"the PickUp is not issued",5);
        driver.findElement(By.xpath("//*[contains(.,'Самовывоз ЭТМ')]")).click();
        //driver.findElement(By.xpath("//div[@data-testid='option-delivery']")).click();
        clickVisible(By.xpath("//div[contains(.,'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]") ,"not click delivery point", 5 );
        waitForElementPresent(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]"),"the delivery point is not issued",5);
        driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'пос. Шушары, Ленсоветовская дорога, д.12, корп.2, лит.Б')]")).click();
        waitForElementPresent(By.xpath("//div[@data-testid='option-payment-5']"),"при получении не отображается",5);
        driver.findElement(By.xpath("//div[@data-testid='option-payment-5']")).click();

        driver.findElement(By.xpath("//span[contains(.,'Оформить заказ')]")).click();
        waitForElementPresent(By.xpath("//p[contains(.,'Благодарим вас за использование системы iPRO!')]"),"the order is not issued",5);
        driver.findElement(By.xpath("//span[contains(.,'Перейти в Заказы')]")).click();

        driver.findElement(By.xpath("//button[@title='Выход']")).click();

         */
    }


    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
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
    }
    public void clickVisible(By by ,String error_message, long timeoutInSeconds ){
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
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
