package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalAppPage extends BasePage{

//    @FindBy(css = "#ui-id-4")
    @FindBy(xpath = "//span[text()='Працювати із заявкою на отримання кредиту (фінальною)']")
    public WebElement titleAddApplication;

    @FindBy(css = "fieldset #LastNameUkr")
    public WebElement lastNameUkr;

    @FindBy(css = "fieldset #FirstNameUkr")
    public WebElement firstNameUkr;

    @FindBy(css = "fieldset #MiddleNameUkr")
    public WebElement middleNameUkr;

    @FindBy(css = "fieldset #ContInf2Cellur")
    public WebElement mobilePhone;

    @FindBy(css = "fieldset #TaxId")
    public WebElement taxId;

    @FindBy(css = "fieldset #DateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(css = "#ApplicantGenderId option[value='M']")
    public WebElement applicantGenderId;

    @FindBy(css = "#ApplicantEducationTypeId option[value='HIGH']")
    public WebElement applicantEducationType;

    @FindBy(css = "#DocTypeText")
    public WebElement docTypeText;

    @FindBy(css = "#DocTypeIdDependent1")
    public WebElement pasportTypeUsual;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1Sr")
    public WebElement pasportUsualSeries;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1No")
    public WebElement pasportUsualNumber;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1IssPlace")
    public WebElement pasportUsualPlaceOfIssue;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1IssueDate")
    public WebElement pasportDateOfIssue;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29No")
    public WebElement pasportIdNumber;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29IssPlace")
    public WebElement pasportIdPlaceOfIssue;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29IssueDate")
    public WebElement pasportIdIssueDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29EndDate")
    public WebElement pasportIdEndDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29RecordNo")
    public WebElement pasportIdRecordNo;

    @FindBy(css = "fieldset #IsEqualPerm")
    public WebElement equalsFieldsOfAddress;

    @FindBy(css = "button#LoanApplicationFormExitButton")
    public WebElement buttonExitAddAppPage;

    @FindBy(css = "input#NoRememberPostCode")
    public WebElement noRememberPostCose;

    @FindBy(css = "input#AddrCityFullSpecification")
    public WebElement addrCityFullSpecification;

    @FindBy(css = "input#AddrStreet")
    public WebElement addrStreet;

    @FindBy(css = "input#AddrHouseNo")
    public WebElement addrHouseNo;

    @FindBy(css = "input#AddrFlat")
    public WebElement addrFlat;

    @FindBy(css = "input#NoContInf1Home")
    public WebElement noStTelephone;

    @FindBy(css = "input#ContactStartDateYear")
    public WebElement contactStartDateYear;

    @FindBy(css = "input#ContactStartDateMonth")
    public WebElement contactStartDateMonth;

    @FindBy(css = "select#ResidingPropertyTypeId [value='ENTIRELY_PROPERTY']")
    public WebElement propertyType;

    @FindBy(css = "input#ActualWorkTradingName")
    public WebElement companyName;

    @FindBy(css = "#ActualWorkPost [value='HIGH_BOSS']")
    public WebElement workPosition;

    @FindBy(css = "input#FinanceBasicIncomeAmount")
    public WebElement financeBasicIncomeAmount;

    @FindBy(css = "#FinanceBasicIncomeDescription [value='SAVINGS']")
    public WebElement financeBasicIncomeDescription;

    @FindBy(css = "input#FinanceBasicIncomeAmount2")
    public WebElement financeBasicIncomeAmount2;

    @FindBy(css = "#FinanceBasicIncomeDescription2 [value='SALE_PROPERTY']")
    public WebElement financeBasicIncomeDescription2;

    @FindBy(css = "input#FinanceBasicIncomeAmount3")
    public WebElement financeBasicIncomeAmount3;

    @FindBy(css = "#FinanceBasicIncomeDescription3 [value='ASSISTANCE']")
    public WebElement financeBasicIncomeDescription3;

    @FindBy(css = "input#FinanceAdditionalIncomeAmount")
    public WebElement financeAdditionalIncomeAmount;

    @FindBy(css = "#FinanceAdditionalIncomeDesc [value='HOME_MADE']")
    public WebElement financeAdditionalIncomeDesc;

    @FindBy(css = "#AgentAdditionalInformation")
    public WebElement comment;

    @FindBy(css = "button#LoanApplicationFormSendButton")
    public WebElement buttonSendToBank;

    private WebDriver driver;

    public FinalAppPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
