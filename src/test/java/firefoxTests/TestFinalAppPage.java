package firefoxTests;

import core.BaseTest;
import org.testng.annotations.Test;

import static core.Config.TITLE_NEW_FINALAPPLICATION;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.Assert.assertTrue;

public class TestFinalAppPage extends BaseTest{

    @Test
    public void testFinalApp(){

//        CommonPage commonPage = new CommonPage(driver);
//        FinalAppPage finalAppPage = new FinalAppPage(driver);

        do {
//            assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
//            assertTrue(commonPage.isOpened());
            commonPage.waitForApplicationClosed();
            commonPage.openAddApplication();
//            commonPage.waitForAddApplicationIsOpened();
            waitTillFieldIsDisplayed(finalAppPage.titleAddApplication);
//            assertThat(textToBePresentInElement(finalAppPage.titleAddApplication, TITLE_NEW_FINALAPPLICATION));
            if (!(finalAppPage.titleAddApplication.getText().equals(TITLE_NEW_FINALAPPLICATION))){
                find(finalAppPage.buttonExitAddAppPage).click();
            }
        }while (!(finalAppPage.titleAddApplication.getText().equals(TITLE_NEW_FINALAPPLICATION)));

        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.lastNameUkr);
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.firstNameUkr);
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.middleNameUkr);
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.mobilePhone);
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.taxId);
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.dateOfBirth);
        find(finalAppPage.applicantGenderId).click();
        find(finalAppPage.applicantEducationType).click();
        assertThatFieldIsReadOnlyNotEmpty(finalAppPage.docTypeText);
        jsScrollPageToElement(finalAppPage.mobilePhone);

        if (pasportType(finalAppPage.pasportTypeUsual)){
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportUsualSeries);
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportUsualNumber);
            find(finalAppPage.pasportUsualPlaceOfIssue).sendKeys("Печерський РУ ГУ МВС в м. Києві");
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportDateOfIssue);
        }else{
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportIdNumber);
            find(finalAppPage.pasportIdPlaceOfIssue).sendKeys("3121");
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportIdIssueDate);
            assertThatFieldIsReadOnlyNotEmpty(finalAppPage.pasportIdEndDate);
            find(finalAppPage.pasportIdRecordNo).sendKeys("20000101-00026");
        }

        jsScrollPageToElement(finalAppPage.docTypeText);
        jsCheckBoxClick(finalAppPage.equalsFieldsOfAddress);
        assertTrue(finalAppPage.equalsFieldsOfAddress.isSelected());
        jsCheckBoxClick(finalAppPage.noRememberPostCose);
        assertTrue(finalAppPage.noRememberPostCose.isSelected());
        assertThatCityIsSelected(finalAppPage.addrCityFullSpecification);
        find(finalAppPage.addrStreet).sendKeys("Миклухи Маклая");
        jsScrollPageToElement(finalAppPage.equalsFieldsOfAddress);
        find(finalAppPage.addrHouseNo).sendKeys("36");
        find(finalAppPage.addrFlat).sendKeys("12");
        jsCheckBoxClick(finalAppPage.noStTelephone);
        assertTrue(finalAppPage.noStTelephone.isSelected());
        find(finalAppPage.contactStartDateYear).sendKeys("5");
        find(finalAppPage.contactStartDateMonth).sendKeys("0");
        find(finalAppPage.propertyType).click();
        jsScrollPageToElement(finalAppPage.noStTelephone);
//        find(finalAppPage.companyName).sendKeys("ТОВ \"Веселка\"");
//        find(finalAppPage.workPosition).click();
        find(finalAppPage.financeBasicIncomeAmount).sendKeys("10000");
        find(finalAppPage.financeBasicIncomeDescription).click();
        find(finalAppPage.financeBasicIncomeAmount2).sendKeys("2000");
        find(finalAppPage.financeBasicIncomeDescription2).click();
        find(finalAppPage.financeBasicIncomeAmount3).sendKeys("1200");
        find(finalAppPage.financeBasicIncomeDescription3).click();
        find(finalAppPage.financeAdditionalIncomeAmount).sendKeys("100");
        find(finalAppPage.financeAdditionalIncomeDesc).click();
        jsScrollPageToElement(finalAppPage.propertyType);
//        find(finalAppPage.comment).sendKeys("все чудово");
//        find(finalAppPage.buttonExitAddAppPage).click();
        find(shortAppPage.buttonSendToBank).click();

    }

}
