package pages;

import core.BasePage;
import core.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(css="#UserName")
    public WebElement userName;

    @FindBy(css = "#Password")   //то же самое что driver.findElement(By.cssSelector("#Password"))
    public WebElement password;

    @FindBy(css = ".button-ok")
    public WebElement buttonOk;

    @FindBy(css = ".header h1")
    public WebElement title;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    public LoginPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }

    public void openURL(){
        driver.get(Config.URL_LOGINPAGE);
    }

}
