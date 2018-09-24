package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Gan on 10.09.2017.
 */
public class BasePage {

//    private WebDriver driver;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
//        this.driver = driver;
    }

//    public void robotPressSequence(String seq){
//        StringSelection stringSelection = new StringSelection(seq);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//
//        try {
//            Robot robot = new Robot();
//            robot.setAutoDelay(1000);
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.keyRelease(KeyEvent.VK_V);
//        }catch (AWTException e){
//            e.printStackTrace();
//        }
//    }

    public void robotChooseDropdownList(int numberOfSelect){
        try {
            Robot robot = new Robot();
            robot.delay(500);
            for (int i = 0; i < numberOfSelect ; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            }catch (AWTException e){
            e.printStackTrace();
        }
    }

    public void robotEsc (){
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(500);
            robot.keyPress(KeyEvent.VK_ESCAPE);

        }catch (AWTException e){
            e.printStackTrace();
        }
    }

    protected void dumbWait (int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
