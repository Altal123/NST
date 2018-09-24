package firefoxTests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static core.Config.PASSWORD;
import static core.Config.TITLE_LOGINPAGE;
import static core.Config.USERNAME;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class TestLoginPage extends BaseTest{

    @Test
    public void testLoginPage(){

//        LoginPage loginPage = new LoginPage(driver);

        loginPage.openURL();

        //Hash(#) refers to Id !!!
        //dot(.) refers to class !!!

        assertThat(textToBePresentInElement(loginPage.title,TITLE_LOGINPAGE));

        find(loginPage.userName).sendKeys(USERNAME);
        find(loginPage.password).sendKeys(PASSWORD);
        find(loginPage.buttonOk).click();

    }
}
