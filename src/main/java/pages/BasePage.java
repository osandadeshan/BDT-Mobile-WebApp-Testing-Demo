package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepImpl.AndroidSetup;

/**
 * Created by Osanda on 5/24/2017.
 */

public class BasePage {

    protected static String URL = System.getenv("APP_ENDPOINT");

    public void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(AndroidSetup.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(AndroidSetup.driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setTextAs(WebElement element, String text){
        waitForElementClickable(element);
        element.sendKeys(text);
    }

}
