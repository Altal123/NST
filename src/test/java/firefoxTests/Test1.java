package firefoxTests;

import core.BaseTest;
import org.testng.annotations.*;
import pages.*;


import static core.Config.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test1 extends BaseTest {

    private String mobilePhone;

    @Test
    public void testLoginPage(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openURL();

        //Hash(#) refers to Id !!!
        //dot(.) refers to class !!!

        assertThat(textToBePresentInElement(loginPage.title,TITLE_LOGINPAGE));

        find(loginPage.userName).sendKeys(USERNAME);
        find(loginPage.password).sendKeys(PASSWORD);
        find(loginPage.buttonOk).click();

    }

//        @Test(enabled = false)
    @Test(dependsOnMethods = {"testLoginPage"})
    public void testShortApp(){

        ShortAppPage shortAppPage = new ShortAppPage(driver);
        CommonPage commonPage = new CommonPage(driver);

        assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
        assertTrue(commonPage.isOpened());
        find(commonPage.createShortApplication).click();

        assertThat(textToBePresentInElement(shortAppPage.titleNewShortApplication, TITLE_NEW_SHORTAPPLICATION));
        find(shortAppPage.lastNameUkr).sendKeys(randomName(lastNameUkrMale));
        find(shortAppPage.firstNameUkr).sendKeys(randomName(firstNameUkrMale));
        find(shortAppPage.middleNameUkr).sendKeys(randomName(middleNameUkrMale));
        find(shortAppPage.mobilePhone).click();
        mobilePhone = MOB_PHONE_PREFIX + randomNumber(7);
//        shortAppPage.robotPressSequence(mobilePhone);
        find(shortAppPage.mobilePhone).sendKeys(mobilePhone);
        find(shortAppPage.dateOfBirth).sendKeys("12121980");
          jsScrollPageToElement(shortAppPage.dateOfBirth);

        if (randomZeroOrOne()){
            find(shortAppPage.selectUsualPassport).click();
            find(shortAppPage.pasportUsualSeries).sendKeys("МО");
            find(shortAppPage.pasportUsualNumber).sendKeys(randomNumber(6));
            find(shortAppPage.pasportUsualIssueDate).sendKeys("121210");
        }else {
            find(shortAppPage.selectIdPassport).click();
            find(shortAppPage.pasportIdNumber).sendKeys(randomNumber(9));
            find(shortAppPage.pasportIdIssueDate).sendKeys("120116");
            find(shortAppPage.pasportIdEndDate).sendKeys("110118");
        }
//        find(shortAppPage.taxId).sendKeys(randomNumber(10));
        find(shortAppPage.taxId).sendKeys("2819226288"); //In this case will be chosen "Final page"
        find(shortAppPage.typeOfEmployment).click();
        find(shortAppPage.email).sendKeys("ugaday@gmail.com");
        find(shortAppPage.listOfCity).sendKeys("халеп");
        shortAppPage.waitToAppearListOfCities();
        shortAppPage.robotChooseDropdownList(1);
        assertThatCityIsSelected(shortAppPage.listOfCitySelected);
        jsCheckBoxClick(shortAppPage.checkBox);
        assertTrue(shortAppPage.checkBox.isSelected());

        find(shortAppPage.linkToPrintConditions).click();

        parentHandle = driver.getWindowHandle();
        find(shortAppPage.buttonPrintCondition).click();
        switchToFrame();
        assertThat(textToBePresentInElement(shortAppPage.titleOfAgreement, TITLE_OF_AGREEMENT_SHORT_APP));
//        find(shortAppPage.closeButton).click();
        shortAppPage.robotEsc();
        switchToParentHandle();

        shortAppPage.robotEsc();
//        find(shortAppPage.buttonApprove).click();
          jsScrollPageToElement(shortAppPage.taxId);
        find(shortAppPage.linkToPhoto).click();
        jsClick(shortAppPage.buttonObzor);
        shortAppPage.robotInsertAndClickEnter(LINK_TO_PHOTO);
        find(shortAppPage.buttonAttachPhoto).click();
        assertThatPhotoIsUploaded(shortAppPage.photoImage);
          jsScrollPageToElement(shortAppPage.photoImage);
        find(shortAppPage.shopOrderId).sendKeys(randomNumber(8));
        find(shortAppPage.invoiceNo).sendKeys(randomNumber(8));
//        find(shortAppPage.goodsBookingTerm).sendKeys("26.10.2017");
        find(shortAppPage.goodsBookingTerm).sendKeys(getCurrentDate("Date"));
        shortAppPage.robotEsc();
        find(shortAppPage.shopId).click();
          jsScrollPageToElement(shortAppPage.linkToPhoto);
        find(shortAppPage.typeOfGoods).click();
        find(shortAppPage.merchandiseName).sendKeys("Протеїн харчовий");
        find(shortAppPage.merchandisePrice).sendKeys("6000");
          jsScrollPageToElement(shortAppPage.shopId);
        find(shortAppPage.subProductCode).click();
        find(shortAppPage.loanTerm).click();
        find(shortAppPage.initialPayment).sendKeys("500");
          jsScrollPageToElement(shortAppPage.loanFeeRateSum);
        find(shortAppPage.comment).sendKeys("Все чудово");
        dumbWait(1);
          jsScrollPageToElement(shortAppPage.merchandiseName);
        jsCheckBoxClick(shortAppPage.listOfInsurance());
        assertTrue(shortAppPage.listOfInsurance().isSelected());

        assertThat(attributeContains(shortAppPage.listOfInsurance(), "value",
                "NST УНІКА Base"));
//        assertThat(attributeContains(shortAppPage.listOfInsurance(), "value", "Base"));

          jsScrollPageToElement(shortAppPage.loanFeeRateSum);
//        find(shortAppPage.buttonSaveAppPage).click();
//        find(shortAppPage.buttonExitAppPage).click();
//        assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
//        assertTrue(commonPage.isOpened());

    }

//    @Test(dependsOnMethods = {"testLoginPage"})
    @Test(enabled = false)
    public void testFinalApp(){

        CommonPage commonPage = new CommonPage(driver);
        FinalAppPage finalAppPage = new FinalAppPage(driver);

        do {
            assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
            assertTrue(commonPage.isOpened());
            commonPage.openAddApplication();
            assertThat(textToBePresentInElement(finalAppPage.titleAddApplication, TITLE_NEW_ADDAPPLICATION));
            if (!(finalAppPage.titleAddApplication.getText().contentEquals(TITLE_NEW_FINALAPPLICATION))){
             find(finalAppPage.buttonExitAddAppPage).click();
            }
        }while (!(finalAppPage.titleAddApplication.getText().contentEquals(TITLE_NEW_FINALAPPLICATION)));

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
        find(finalAppPage.companyName).sendKeys("ТОВ \"Веселка\"");
        find(finalAppPage.workPosition).click();
        find(finalAppPage.financeBasicIncomeAmount).sendKeys("10000");
        find(finalAppPage.financeBasicIncomeDescription).click();
        find(finalAppPage.financeBasicIncomeAmount2).sendKeys("2000");
        find(finalAppPage.financeBasicIncomeDescription2).click();
        find(finalAppPage.financeBasicIncomeAmount3).sendKeys("1200");
        find(finalAppPage.financeBasicIncomeDescription3).click();
        find(finalAppPage.financeAdditionalIncomeAmount).sendKeys("100");
        find(finalAppPage.financeAdditionalIncomeDesc).click();
          jsScrollPageToElement(finalAppPage.propertyType);
        find(finalAppPage.comment).sendKeys("все чудово");
        find(finalAppPage.buttonExitAddAppPage).click();

    }

//    @Test(dependsOnMethods = {"testLoginPage"})
    @Test(enabled = false)
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
