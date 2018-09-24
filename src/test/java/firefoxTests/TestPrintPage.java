package firefoxTests;

import core.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static core.Config.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class TestPrintPage extends BaseTest {

    @Test
    public void testPrintPage() {

        commonPage.waitForApplicationClosed();
        commonPage.openPrintPage();
        waitTillFieldIsDisplayed(printPage.titlePrintPage);

        find(printPage.buttonPrintForClient).click();
        switchToFrame();
        assertThat(textToBePresentInElement(printPage.tytleOfAgreementPrintForClient, TITLE_OF_AGREEMENT_PRINT_FOR_CLIENT));
        printPage.robotEsc();
        switchToParentHandle();
        assertThat(ExpectedConditions.textToBePresentInElement(printPage.dateTimeContractForClient, getCurrentDate("Year")));

        find(printPage.buttonPrintForSeller).click();
        switchToFrame();
        assertThat(textToBePresentInElement(printPage.tytleOfAgreementPrintForSeller, TITLE_OF_AGREEMENT_PRINT_FOR_SELLER));
        printPage.robotEsc();
        switchToParentHandle();
        assertThat(ExpectedConditions.textToBePresentInElement(printPage.dateTimeContractForSeller, getCurrentDate("Year")));

        find(printPage.buttonPrintForBank).click();
        switchToFrame();
        assertThat(textToBePresentInElement(printPage.tytleOfAgreementPrintForBank, TITLE_OF_AGREEMENT_PRINT_FOR_BANK));
        printPage.robotEsc();
        switchToParentHandle();
        assertThat(ExpectedConditions.textToBePresentInElement(printPage.dateTimeContractForBank, getCurrentDate("Year")));

        find(printPage.buttonComplianceOfAgreement).click();
//        find(printPage.buttonRefuseOfAgreement).click();
        find(printPage.buttonApprove).click();
        switchToParentHandle();
        find(printPage.buttonOk).click();

    }

}
