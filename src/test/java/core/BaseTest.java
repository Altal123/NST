package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    protected String parentHandle;

    public static CommonPage commonPage;
    public static LoginPage loginPage;
    public static ShortAppPage shortAppPage;
    public static FinalAppPage finalAppPage;
    public static PrintPage printPage;

    @BeforeSuite
    public void initialBrowser(){

        System.setProperty("webdriver.gecko.driver","D:\\Lessons_Selenium_Bionics\\loanNSTautotest\\lib\\geckodriver.exe");
//        ProfilesIni profile = new ProfilesIni();
//        FirefoxProfile myProfile = profile.getProfile("MyProfile");
        driver = new FirefoxDriver();
//        driver = new FirefoxDriver(myProfile);

//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        this.loginPage = new LoginPage(driver);
        this.commonPage = new CommonPage(driver);
        this.shortAppPage = new ShortAppPage(driver);
        this.finalAppPage = new FinalAppPage(driver);
        this.printPage = new PrintPage(driver);

//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setAcceptUntrustedCertificates(true);
//        profile.setAssumeUntrustedCertificateIssuer(true);
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {

//        Thread.sleep(5000);
        driver.close();
    }

    public void assertThat (ExpectedCondition<Boolean> condition){
        (new WebDriverWait(driver, 15)).until(condition);
    }

    protected void waitTillFieldIsDisplayed(WebElement element){
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToFrame(){

//        parentHandle = driver.getWindowHandle();

        (new WebDriverWait(driver, 6)).until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt(0));

//        System.out.println("parentHandle: " + parentHandle);
//        for (String temp: driver.getWindowHandles()){
//            if (!temp.equals(parentHandle)){
//                childHandle = temp;
////                driver.switchTo().window(childHandle);
//            }
//            System.out.println("temp: " + temp);
//        }
//        System.out.println("childHandle: " + childHandle);

    }

    public void switchToParentHandle(){
//        driver.switchTo().window(parentHandle);
        driver.switchTo().defaultContent();
    }

    public void assertThatPhotoIsUploaded(WebElement element){
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.attributeToBeNotEmpty(element, "src"));
    }

    public void assertThatCityIsSelected(WebElement element){
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
    }

    public void assertThatFieldIsNotEmpty(WebElement element){
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
    }

    public void assertThatFieldIsReadOnlyNotEmpty(WebElement element){
        WebDriverWait field = new WebDriverWait(driver, 4);
        field.until(ExpectedConditions.attributeToBe(element, "readonly", "true"));
        field.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
    }


    public WebElement find (WebElement proxyElement){
        WebDriverWait element = new WebDriverWait(driver,4);
        element.until(ExpectedConditions.visibilityOf(proxyElement));
        return element.until(ExpectedConditions.elementToBeClickable(proxyElement));
    }

    public void jsCheckBoxClick(WebElement element){
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.
                not(ExpectedConditions.elementToBeSelected(element)));
//        dumbWait(1);

        if (!element.isSelected())
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void jsClick(WebElement element){
        (new WebDriverWait(driver, 4)).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void jsScrollPageToElement (WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * generating random number, where length is amount of numbers in result`s number
     */
    public String randomNumber (int length){
        StringBuilder temp = new StringBuilder("1");
        for (int i = 1; i < length; i++){
            temp.append(0);
        }
        int result = Integer.parseInt(temp.toString());
        return String.valueOf((int)(result + (result*9) * Math.random()));
    }

    /**
     * Generating random mobile number
     */
    public String randomMobileNumber(){
        String prefix = "";
        switch (Integer.parseInt(randomNumber(1))) {
            case 1:  prefix = "095";
                break;
            case 2:  prefix = "050";
                break;
            case 3:  prefix = "063";
                break;
            case 4:  prefix = "066";
                break;
            case 5:  prefix = "067";
                break;
            case 6:  prefix = "073";
                break;
            case 7:  prefix = "068";
                break;
            case 8:  prefix = "091";
                break;
            case 9:  prefix = "093";
                break;
        }

        return prefix + randomNumber(7);
    }


    public boolean randomZeroOrOne(){
        if (Integer.parseInt(randomNumber(1))/5 == 1) return true;
        return false;
    }

    public String randomName (String[] name){
        return name[Integer.parseInt(randomNumber(1))];
    }

    protected void dumbWait (int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean pasportType(WebElement element){
        if (element.getAttribute("style").contentEquals("display: block;")) return true;
        return false;
    }

    public void selectDropDownList(WebElement element, String startFrom){
        find(element).sendKeys(startFrom);
        dumbWait(1);
        (new WebDriverWait(driver, 6)).until(ExpectedConditions.
                not(ExpectedConditions.attributeContains(element, "class", "loading")));
        find(element).sendKeys(Keys.DOWN);
        find(element).sendKeys(Keys.ENTER);
    }

    public String getCurrentDate(String date){
        Date dateNow = new Date();

        if(date.equals("Date"))
            return (new SimpleDateFormat("dd.MM.yyyy")).format(dateNow);
        else
            return (new SimpleDateFormat("yyyy")).format(dateNow);
    }

}
