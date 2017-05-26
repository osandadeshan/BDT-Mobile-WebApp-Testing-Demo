package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 5/24/2017.
 */

public class BasePage {

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
