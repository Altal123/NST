package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static core.Config.*;

public class CommonPage extends BasePage{

    @FindBy(css = ".header h1")
    public WebElement title;

    @FindBy(css = "button[id = \"ApplicationAddButton\"]")
    public WebElement createShortApplication;

    @FindBy(css = "div[aria-describedby='LoanApplicationFormDialog']")
    private WebElement checkApplicationOpen;

    @FindBy(xpath = "//*[text()='Заповнити додаткову анкету']")
    private List<WebElement> listAddApplications;

    @FindBy(xpath = "//*[text()='Друк документів']")
    private List<WebElement> listPrintPages;

    @FindBy(css = "#LoanApplicationsMessageDialogContent")
    public WebElement passwordAlmostExpired;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    public WebElement buttonPasswordAlmostExpired;

    public static String mobilePhone;// = "730502323";
//    private String linkAddApplication = "//*[text()='Заповнити додаткову анкету']";
    private String countAvailableLinks = ".//../../td[10]/p";
    private String relativeLinkAddApplication = ".//../../td[10]/p/a";
    private String relativeLinkPrintPage = ".//../../td[10]/p[2]/a";

//    private String relativeLinkMobilePhone = ".//../../../td[8]/p";
    private String linkMobilePhone = "//td[8]/p";
//    private List<WebElement> listAddApplication;
    private List<WebElement> listMobilePhones;
    private int countAddApplications = 0;

    private WebDriver driver;

    public CommonPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean isOpened(){
        return driver.getCurrentUrl().equals(URL_COMMONPAGE);
    }

    public void waitForApplicationClosed(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOf(checkApplicationOpen));
    }

    public void openAddApplication(){
        dumbWait(1);
//        listAddApplication = driver.findElements(By.xpath(linkAddApplication));
        boolean isClicked = false;

        if (listAddApplications.size() > 0 && mobilePhone == null && listAddApplications.size() > countAddApplications)
            listAddApplications.get(countAddApplications).click();

        //waiting 120 sec for appearing link to Additional Application
        if (mobilePhone != null){

            for (int i = 0; i < 12 ; i++) {
                listMobilePhones = driver.findElements(By.xpath(linkMobilePhone));
                for (WebElement webElement : listMobilePhones) {
                    if (webElement.getText().equals("+380" + mobilePhone)) {
                        WebElement temp = webElement.findElement(By.xpath(relativeLinkAddApplication));
                        if (temp.getText().equals("Заповнити додаткову анкету")){
                            temp.click();
                            isClicked = true;
                        }
                        else break;
                    }
                }
                if (!isClicked){
                    driver.navigate().refresh();
                    dumbWait(10);
                }else break;
            }
        }

        if(listAddApplications.size() == 0 || listAddApplications.size() <= countAddApplications){
            System.out.println("There are no links to additional applications!");
            System.exit(-1);
        }

        if (mobilePhone != null && !isClicked){
            System.out.println("There is no link to Additional Agreement for current mobile`s number!");
            System.exit(-1);
        }
        countAddApplications++;   //number of AddApplication
    }

    public void openPrintPage() {
        dumbWait(1);
        boolean isClicked = false;
        if (listPrintPages.size() > 0 && mobilePhone == null) {
            listPrintPages.get(0).click();
            isClicked = true;
        }
        if (listPrintPages.size() > 0 && mobilePhone != null) {
            for (int i = 0; i < 4; i++) {
                listMobilePhones = driver.findElements(By.xpath(linkMobilePhone));
                for (WebElement webElement : listMobilePhones) {
                    if (webElement.getText().equals("+380" + mobilePhone)
                            && webElement.findElements(By.xpath(countAvailableLinks)).size() > 1) {
                        System.out.println("Кол-во ссылок: " + webElement.findElements(By.xpath(countAvailableLinks)).size());
                        WebElement temp = webElement.findElement(By.xpath(relativeLinkPrintPage));
                        if (temp.getText().equals("Друк документів")) {
                            temp.click();
                            isClicked = true;
                        } else break;
                    }
                }
                if (!isClicked) {
                    driver.navigate().refresh();
                    dumbWait(2);
                } else break;
            }
        }

            if (!isClicked || listPrintPages.size() == 0) {
                System.out.println("Не найдено ссылок на печать документов!");
                System.exit(-1);
            }
        }

        public boolean checkAppearingPasswordAlmostExpired (WebElement element){
            return new WebDriverWait(driver, 1).until(ExpectedConditions.invisibilityOf(element));
        }

    // Install the all-trusting trust manager (чтобы не было ошибки SSLHandshakeException при вызове executeQuery)
//        try
//    {
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, new java.security.SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    }
//        catch (Exception e)
//    {
//        System.out.println(e);
//    }

//    private TrustManager[] trustAllCerts = new TrustManager[]{
//            new X509TrustManager() {
//
//                public java.security.cert.X509Certificate[] getAcceptedIssuers()
//                {
//                    return null;2
//                }
//                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
//                {
//                    //No need to implement.
//                }
//                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
//                {
//                    //No need to implement.
//                }
//            }
//    };
}
