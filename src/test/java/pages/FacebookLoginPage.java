package pages;

import com.thoughtworks.gauge.Gauge;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 5/24/2017.
 */

public class FacebookLoginPage extends BasePage {

    @FindBy(name="email") WebElement EMAIL_TEXT_BOX;
    @FindBy(name="pass") WebElement PASSWORD_TEXT_BOX;
    @FindBy(id="u_0_q") WebElement SUBMIT_BUTTON;

    public void navigateToFacebook(){
        driver.get("http://www.facebook.com");
    }

    public String pageTitle(){
        System.out.println("Page Title: "+driver.getTitle());
        Gauge.writeMessage("Page Title: "+driver.getTitle());
        return driver.getTitle();
    }

    public void signIn(String email, String password){
        waitForElement(EMAIL_TEXT_BOX);
        EMAIL_TEXT_BOX.sendKeys(email);
        waitForElement(PASSWORD_TEXT_BOX);
        PASSWORD_TEXT_BOX.sendKeys(password);
        waitForElement(SUBMIT_BUTTON);
        SUBMIT_BUTTON.click();
    }

}
