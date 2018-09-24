package firefoxTests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FullAppPage;

import static core.Config.*;
import static core.Config.MOB_PHONE_PREFIX;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.Assert.assertTrue;

public class TestFullAppPage extends BaseTest {

    private String mobilePhone;

    @Test
    public void testFullApp(){

        CommonPage commonPage = new CommonPage(driver);
        FullAppPage fullAppPage = new FullAppPage(driver);

        do {
            assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
            assertTrue(commonPage.isOpened());
            commonPage.openAddApplication();
            assertThat(textToBePresentInElement(fullAppPage.titleAddApplication, TITLE_NEW_ADDAPPLICATION));
            if (!(fullAppPage.titleAddApplication.getText().contentEquals(TITLE_NEW_FULLAPPLICATION))){
                find(fullAppPage.buttonExitAddAppPage).click();
            }
        }while (!(fullAppPage.titleAddApplication.getText().contentEquals(TITLE_NEW_FULLAPPLICATION)));

        assertThatFieldIsNotEmpty(fullAppPage.lastNameUkr);
        assertThatFieldIsNotEmpty(fullAppPage.firstNameUkr);
        assertThatFieldIsNotEmpty(fullAppPage.middleNameUkr);
        assertThatFieldIsReadOnlyNotEmpty(fullAppPage.mobilePhone);
        assertThatFieldIsNotEmpty(fullAppPage.email);
        assertThatFieldIsReadOnlyNotEmpty(fullAppPage.taxId);
        assertThatFieldIsReadOnlyNotEmpty(fullAppPage.dateOfBirth);
        assertThatFieldIsNotEmpty(fullAppPage.applicantGender);
        find(fullAppPage.applicantEducationType).click();
        assertThatFieldIsNotEmpty(fullAppPage.typeOfEmployment);
        jsScrollPageToElement(fullAppPage.typeOfEmployment);
        assertThatPhotoIsUploaded(fullAppPage.photoImage);
        assertThatFieldIsReadOnlyNotEmpty(fullAppPage.docTypeText);

        if (pasportType(fullAppPage.pasportTypeUsual)){
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportUsualSeries);
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportUsualNumber);
            find(fullAppPage.pasportUsualPlaceOfIssue).sendKeys("Печерський РУ ГУ МВС в м. Києві");
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportDateOfIssue);
        }else{
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportIdNumber);
            find(fullAppPage.pasportIdPlaceOfIssue).sendKeys("3121");
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportIdIssueDate);
            assertThatFieldIsReadOnlyNotEmpty(fullAppPage.pasportIdEndDate);
            find(fullAppPage.pasportIdRecordNo).sendKeys("20000101-00026");
        }
        jsScrollPageToElement(fullAppPage.docTypeText);
        jsCheckBoxClick(fullAppPage.equalsFieldsOfAddress);
        assertTrue(fullAppPage.equalsFieldsOfAddress.isSelected());
        jsCheckBoxClick(fullAppPage.noRememberPostCose);
        assertTrue(fullAppPage.noRememberPostCose.isSelected());
        assertThatCityIsSelected(fullAppPage.addrCityFullSpecification);
        find(fullAppPage.addrStreet).sendKeys("вул. Урицького");
        jsScrollPageToElement(fullAppPage.equalsFieldsOfAddress);
        find(fullAppPage.addrHouseNo).sendKeys("44б");
        find(fullAppPage.addrFlat).sendKeys("32");
        jsCheckBoxClick(fullAppPage.noStTelephone);
        assertTrue(fullAppPage.noStTelephone.isSelected());
        find(fullAppPage.contactStartDateYear).sendKeys("7");
        find(fullAppPage.contactStartDateMonth).sendKeys("1");
        find(fullAppPage.propertyType).click();
        find(fullAppPage.familyStatus).click();
        find(fullAppPage.numberOfChildren).sendKeys("0");
        jsScrollPageToElement(fullAppPage.familyStatus);
        find(fullAppPage.contPersLastName).sendKeys("Іванов");
        find(fullAppPage.contPersFirstName).sendKeys("Іван");
        find(fullAppPage.contPersMiddleName).sendKeys("Іванович");
        find(fullAppPage.typeOfContactRelation).click();
        find(fullAppPage.phoneOfContactRelation).click();
        find(fullAppPage.phoneOfContactRelation).sendKeys(MOB_PHONE_PREFIX + randomNumber(7));
        jsScrollPageToElement(fullAppPage.contPersLastName);
        find(fullAppPage.workName).sendKeys("ТОВ \"Радуга\"");
        find(fullAppPage.countOfEmployees).click();
        find(fullAppPage.workScopeActivity).click();
        find(fullAppPage.actualWorkSector).sendKeys("будує дачі генералам");
        jsScrollPageToElement(fullAppPage.workName);
        jsCheckBoxClick(fullAppPage.workNoRememberPostCode);
        assertTrue(fullAppPage.workNoRememberPostCode.isSelected());
        selectDropDownList(fullAppPage.workAddress,"ров");
        assertThatCityIsSelected(fullAppPage.workAddress);
        find(fullAppPage.actualWorkStreet).sendKeys("вул. Степана Бандери");
        find(fullAppPage.actualWorkHouse).sendKeys("4в");
        jsScrollPageToElement(fullAppPage.workNoRememberPostCode);
        find(fullAppPage.actualWorkPhoneNumber).click();
        find(fullAppPage.actualWorkPhoneNumber).sendKeys(MOB_PHONE_PREFIX + randomNumber(7));
        find(fullAppPage.hrPhoneNumber).click();
        find(fullAppPage.hrPhoneNumber).sendKeys(MOB_PHONE_PREFIX + randomNumber(7));
        find(fullAppPage.actualWorkPost).click();
        find(fullAppPage.actualWorkPostClient).sendKeys("різноробочий");
        find(fullAppPage.actualWorkStartDateYear).sendKeys("12");
        find(fullAppPage.actualWorkExpMonths).sendKeys("2");
        find(fullAppPage.totalWorkExpYears).sendKeys("15");
        find(fullAppPage.totalWorkExpMonths).sendKeys("0");
        jsScrollPageToElement(fullAppPage.actualWorkPostClient);
        find(fullAppPage.financeBasicIncomeAmount).sendKeys("5000");
        find(fullAppPage.financeBasicIncomeDescription).click();
        find(fullAppPage.financeBasicIncomeAmount2).sendKeys("3000");
        find(fullAppPage.financeBasicIncomeDescription2).click();
        find(fullAppPage.financeBasicIncomeAmount3).sendKeys("1000");
        find(fullAppPage.financeBasicIncomeDescription3).click();
        find(fullAppPage.financeAdditionalIncomeAmount).sendKeys("1500");
        find(fullAppPage.financeAdditionalIncomeDesc).click();
        find(fullAppPage.financeMonthlyCharges).sendKeys("2500");
        find(fullAppPage.comment).sendKeys("тут добавити більше і нічого)");






//        find(fullAppPage.buttonExitAddAppPage).click();


    }

}
