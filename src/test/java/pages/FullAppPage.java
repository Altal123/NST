package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FullAppPage extends BasePage{

    @FindBy(css = "#ui-id-2")
    public WebElement titleAddApplication;

    @FindBy(css = "button#LoanApplicationFormExitButton")
    public WebElement buttonExitAddAppPage;

    @FindBy(css = "fieldset #LastNameUkr")
    public WebElement lastNameUkr;

    @FindBy(css = "fieldset #FirstNameUkr")
    public WebElement firstNameUkr;

    @FindBy(css = "fieldset #MiddleNameUkr")
    public WebElement middleNameUkr;

    @FindBy(css = "fieldset #ContInf2Cellur")
    public WebElement mobilePhone;

    @FindBy(css = "input#ContInf5Email")
    public WebElement email;

    @FindBy(css = "input#TaxId")
    public WebElement taxId;

    @FindBy(css = "input#DateOfBirth")
    public WebElement dateOfBirth;

    @FindBy(css = "select#ApplicantGenderId")
    public WebElement applicantGender;

    @FindBy(css = "select#ApplicantEducationTypeId [value='HIGH']")
    public WebElement applicantEducationType;

    @FindBy(css = "select#TypeOfEmployment")
    public WebElement typeOfEmployment;

    @FindBy(css = "img#LoanApplicationPhotoImage")
    public WebElement photoImage;

    @FindBy(css = "input#DocTypeText")
    public WebElement docTypeText;

    @FindBy(css = "#DocTypeIdDependent1")
    public WebElement pasportTypeUsual;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1Sr")
    public WebElement pasportUsualSeries;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1No")
    public WebElement pasportUsualNumber;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1DocIssPlace")
    public WebElement pasportUsualPlaceOfIssue;

    @FindBy(css = "#DocTypeIdDependent1 #DocType1IssueDate")
    public WebElement pasportDateOfIssue;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29No")
    public WebElement pasportIdNumber;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29DocIssPlace")
    public WebElement pasportIdPlaceOfIssue;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29IssueDate")
    public WebElement pasportIdIssueDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29EndDate")
    public WebElement pasportIdEndDate;

    @FindBy(css = "#DocTypeIdDependent29 #DocType29RecordNo")
    public WebElement pasportIdRecordNo;


    @FindBy(css = "input#IsEqualPerm")
    public WebElement equalsFieldsOfAddress;

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

    @FindBy(css = "select#ApplicantFamilyStatusTypeId [value='NEVER_MARIAGED']")
    public WebElement familyStatus;

    @FindBy(css = "input#NumberOfChildren")
    public WebElement numberOfChildren;

    @FindBy(css = "input#ContPersLastName")
    public WebElement contPersLastName;

    @FindBy(css = "input#ContPersFirstName")
    public WebElement contPersFirstName;

    @FindBy(css = "input#ContPersMiddleName")
    public WebElement contPersMiddleName;

    @FindBy(css = "select#ContPersType [value='FRIEND']")
    public WebElement typeOfContactRelation;

    @FindBy(css = "input#ContInf8Contper")
    public WebElement phoneOfContactRelation;

    @FindBy(css = "input#ActualWorkTradingName")
    public WebElement workName;

    @FindBy(css = "select#ActualWorkNumberOfEmployeesId [value='OVER_500']")
    public WebElement countOfEmployees;

    @FindBy(css = "select#ActualWorkScopeActivityId [value='BUILD']")
    public WebElement workScopeActivity;

    @FindBy(css = "input#ActualWorkSector")
    public WebElement actualWorkSector;

    @FindBy(css = "input#ActualWorkNoRememberPostCode")
    public WebElement workNoRememberPostCode;

    @FindBy(css = "input#ActualWorkCityFullSpecification")
    public WebElement workAddress;

    @FindBy(css = "input#ActualWorkStreet")
    public WebElement actualWorkStreet;

    @FindBy(css = "input#ActualWorkHouse")
    public WebElement actualWorkHouse;

    @FindBy(css = "input#ActualWorkPhoneNumber")
    public WebElement actualWorkPhoneNumber;

    @FindBy(css = "input#HrPhoneNumber")
    public WebElement hrPhoneNumber;

    @FindBy(css = "select#ActualWorkPost [value='SALE']")
    public WebElement actualWorkPost;

    @FindBy(css = "input#ActualWorkPostClient")
    public WebElement actualWorkPostClient;

    @FindBy(css = "input#ActualWorkStartDateYear")
    public WebElement actualWorkStartDateYear;

    @FindBy(css = "input#ActualWorkExpMonths")
    public WebElement actualWorkExpMonths;

    @FindBy(css = "input#TotalWorkExpYears")
    public WebElement totalWorkExpYears;

    @FindBy(css = "input#TotalWorkExpMonths")
    public WebElement totalWorkExpMonths;

    @FindBy(css = "input#FinanceBasicIncomeAmount")
    public WebElement financeBasicIncomeAmount;

    @FindBy(css = "select#FinanceBasicIncomeDescription [value='SAVINGS']")
    public WebElement financeBasicIncomeDescription;

    @FindBy(css = "input#FinanceBasicIncomeAmount2")
    public WebElement financeBasicIncomeAmount2;

    @FindBy(css = "select#FinanceBasicIncomeDescription2 option[value='SALE_PROPERTY']")
    public WebElement financeBasicIncomeDescription2;

    @FindBy(css = "input#FinanceBasicIncomeAmount3")
    public WebElement financeBasicIncomeAmount3;

    @FindBy(css = "select#FinanceBasicIncomeDescription3 option[value='ASSISTANCE']")
    public WebElement financeBasicIncomeDescription3;

    @FindBy(css = "input#FinanceAdditionalIncomeAmount")
    public WebElement financeAdditionalIncomeAmount;

    @FindBy(css = "select#FinanceAdditionalIncomeDesc option[value='HOME_MADE']")
    public WebElement financeAdditionalIncomeDesc;

    @FindBy(css = "input#FinanceMonthlyChargesGr")
    public WebElement financeMonthlyCharges;

    @FindBy(css = "input#AgentAdditionalInformation")
    public WebElement comment;

    private WebDriver driver;

    public FullAppPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
