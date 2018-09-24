package firefoxTests;

import core.BaseTest;
import org.testng.annotations.Test;

import static core.Config.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.Assert.assertTrue;

public class TestShortAppPage extends BaseTest {

    @Test
    public void testShortApp(){

//        ShortAppPage shortAppPage = new ShortAppPage(driver);
//        CommonPage commonPage = new CommonPage(driver);

        assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
        assertTrue(commonPage.isOpened());

        try{
            commonPage.checkAppearingPasswordAlmostExpired(commonPage.passwordAlmostExpired);
        }catch(Exception e){
            System.out.println("bla bla bla");
            find(commonPage.buttonPasswordAlmostExpired).click();
        }

        find(commonPage.createShortApplication).click();

        assertThat(textToBePresentInElement(shortAppPage.titleNewShortApplication, TITLE_NEW_SHORTAPPLICATION));
        find(shortAppPage.lastNameUkr).sendKeys("Толян");//randomName(lastNameUkrMale));
        find(shortAppPage.firstNameUkr).sendKeys(randomName(firstNameUkrMale));
        find(shortAppPage.middleNameUkr).sendKeys(randomName(middleNameUkrMale));
        find(shortAppPage.mobilePhone).click();
        commonPage.mobilePhone = MOB_PHONE_PREFIX + randomNumber(7);
//        shortAppPage.robotPressSequence(mobilePhone);
//        commonPage.mobilePhone = "+380993535453";
        find(shortAppPage.mobilePhone).sendKeys(commonPage.mobilePhone);
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

//        parentHandle = driver.getWindowHandle();
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
        find(shortAppPage.buttonSendToBank).click();


//        assertThat(textToBePresentInElement(commonPage.title, TITLE_COMMONPAGE));
//        assertTrue(commonPage.isOpened());

    }
}
