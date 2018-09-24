package pages;

import core.BasePage;
import core.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Gan on 10.09.2017.
 */
public class ShortAppPage extends BasePage{

    @FindBy(css = "#ui-id-4")
    public WebElement titleNewShortApplication;

    @FindBy(css = "fieldset #LastNameUkr")
    public WebElement lastNameUkr;

    @FindBy(css = "fieldset #FirstNameUkr")
    public WebElement firstNameUkr;

    @FindBy(css = "fieldset #MiddleNameUkr")
    public WebElement middleNameUkr;

    @FindBy(css = "fieldset #ContInf2Cellur")
    public WebElement mobilePhone;

    @FindBy(css = "fieldset #DateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(css = "select#DocTypeId option[value = '1']")
    public WebElement selectUsualPassport;

    @FindBy(css = "select#DocTypeId option[value = '29']")
    public WebElement selectIdPassport;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1Sr") //#DocType1Sr
    public WebElement pasportUsualSeries;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1No")
    public WebElement pasportUsualNumber;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1IssueDate")
    public WebElement pasportUsualIssueDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29No")
    public WebElement pasportIdNumber;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29IssueDate")
    public WebElement pasportIdIssueDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29EndDate")
    public WebElement pasportIdEndDate;

    @FindBy(css = "fieldset #TaxId")
    public WebElement taxId;

    @FindBy(css = "select#TypeOfEmployment option[value='PENSIONER']")
    public WebElement typeOfEmployment;

    @FindBy(css = "#ContInf5Email")
    public WebElement email;

    @FindBy(css = "#AddrCityFullSpecification")
    public WebElement listOfCity;

    @FindBy(css = "fieldset #AddrCity")
    public WebElement listOfCitySelected;

    @FindBy(css = "input#DataProcessingConsent")
    public WebElement checkBox;

    @FindBy(linkText = "умовами")
    public WebElement linkToPrintConditions;

//    @FindBy(xpath = "//button[contains(text(),'Друк згоди на обробку та зберігання даних Клієнта')]")
    @FindBy(css = ".button-auxiliary.button-print") //
    public WebElement buttonPrintCondition;

    @FindBy(xpath = "//div[contains(text(),'ЗГОДА СУБ’ЄКТА ПЕРСОНАЛЬНИХ ДАНИХ')]")
    public WebElement titleOfAgreement;

    @FindBy(css = "#ui-id-3 + button.ui-dialog-titlebar-close")
    public WebElement closeButton;

    @FindBy(xpath = "//button[contains(text(),'Прикріпити фото клієнта до заявки')]")
    public WebElement linkToPhoto;

    @FindBy(css = "#FilePath")
    public WebElement buttonObzor;

    @FindBy(css = "#LoanApplicationPhotoFormOkButton")
    public WebElement buttonAttachPhoto;

    @FindBy(css = "fieldset #LoanApplicationPhotoImage")
    public WebElement photoImage;

    @FindBy(css = "fieldset #ShopOrderId")
    public WebElement shopOrderId;

    @FindBy(css = "#CreditProductInvoiceNo")
    public WebElement invoiceNo;

    @FindBy(css = "fieldset #GoodsBookingTerm")
    public WebElement goodsBookingTerm;

    @FindBy(css = "#ShopId option[value='12549']")
    public WebElement shopId;

    @FindBy(css = "#MerchandiseItemsRegion option[value='FOOD']")
    public WebElement typeOfGoods;

    @FindBy(css = "fieldset input[id$='MerchandiseName']")
    public WebElement merchandiseName;

    @FindBy(css = "fieldset input[id$='_MerchandisePrice']")
    public WebElement merchandisePrice;

    @FindBy(css = "#SubProductCode option[value='CFILN002']")
    public WebElement subProductCode;

    @FindBy(css = "#LoanTerm option[value='12']")
    public WebElement loanTerm;

    @FindBy(css = "fieldset #RateOfInitialPayment")
    public WebElement initialPayment;

    @FindBy(css = "#InsuranceItemsRegion input[id*='TypeOfLifeInsurance']")
    public WebElement insuranceCheckBox;

    @FindBy(css = "label[for='LoanProvidingFeeRateSum']")
    public WebElement loanFeeRateSum;

    @FindBy(css = "#AgentAdditionalInformation")
    public WebElement comment;

    @FindBy(css = "button#LoanApplicationFormSaveButton")
    public WebElement buttonSaveAppPage;

    @FindBy(css = "button#LoanApplicationFormExitButton")
    public WebElement buttonExitAppPage;

    @FindBy(css = "button#LoanApplicationFormSendButton")
    public WebElement buttonSendToBank;

    private WebDriver driver;

    public ShortAppPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void robotInsertAndClickEnter(String url){
        StringSelection stringSelection = new StringSelection(url);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(2000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (AWTException e){
            e.printStackTrace();
        }
    }

    public WebElement listOfInsurance(){

        By locator = By.cssSelector("#InsuranceItemsRegion input[id*='TypeOfLifeInsurance']");

        (new WebDriverWait(driver, 4)).until(ExpectedConditions.
                attributeToBeNotEmpty(driver.findElements(locator).get(0), "value"));

        int place = 0;
        for(WebElement i: driver.findElements(locator)){

            if(i.getAttribute("value").contains("NST УНІКА Base"))
                break;
            place++;
        }
        return driver.findElements(locator).get(place);
    }

    public void waitToAppearListOfCities(){

        (new WebDriverWait(driver, 4)).until(ExpectedConditions.
                        numberOfElementsToBeMoreThan(By.cssSelector(".ui-menu-item"), 0));
                //visibilityOfAllElements(driver.findElements(By.cssSelector(".ui-menu-item"))));
    }

}
