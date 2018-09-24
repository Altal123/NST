package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Друк пакету документів')]")
    public WebElement titlePrintPage;

    @FindBy(xpath = "//button[contains(text(),'Друк документів для Клієнта')]")
    public WebElement buttonPrintForClient;

    @FindBy(xpath = "//div[contains(text(),'Для клієнта')]")
    public WebElement tytleOfAgreementPrintForClient;

    @FindBy(css = "span#ClientContractDateTimeToShowSpan")
    public WebElement dateTimeContractForClient;

    @FindBy(xpath = "//button[contains(text(),'Друк документів для Магазина')]")
    public WebElement buttonPrintForSeller;

    @FindBy(xpath = "//div[contains(text(),'Для магазину')]")
    public WebElement tytleOfAgreementPrintForSeller;

    @FindBy(css = "span#SellerContractDateTimeToShowSpan")
    public WebElement dateTimeContractForSeller;

    @FindBy(xpath = "//button[contains(text(),'Друк документів для Банка')]")
    public WebElement buttonPrintForBank;

    @FindBy(xpath = "//div[contains(text(),'Для банку')]")
    public WebElement tytleOfAgreementPrintForBank;

    @FindBy(css = "span#BankContractDateTimeToShowSpan")
    public WebElement dateTimeContractForBank;

    @FindBy(xpath = "//button[contains(text(),'Надруковано та підписано')]")
    public WebElement buttonComplianceOfAgreement;

    @FindBy(xpath = "//button[contains(text(),'Відмова від підписання')]")
    public WebElement buttonRefuseOfAgreement;

    @FindBy(xpath = "//button[contains(text(),'Так')]")
    public WebElement buttonApprove;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    public WebElement buttonOk;

    public PrintPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;

}
