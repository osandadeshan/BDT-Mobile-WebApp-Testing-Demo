package pages;

import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import stepImpl.DriverSetup;

/**
 * Created by Osanda on 5/24/2017.
 */

public class GridlasticRegistrationPage extends BasePage {

    public static String GridlasticRegistrationPageUrl = URL.concat("register.php");
    Boolean isVisible = false;

   @FindBy(xpath = "//input[@name='fname']") WebElement FIRST_NAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='lname']") WebElement LAST_NAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='company']") WebElement COMPANY_TEXT_BOX;
   @FindBy(xpath = "//input[@name='email']") WebElement WORK_EMAIL_TEXT_BOX;
   @FindBy(xpath = "//input[@name='username']") WebElement USERNAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='password']") WebElement PASSWORD_TEXT_BOX;
   @FindBy(xpath = "//button[@type='submit']") WebElement GET_FREE_ACCOUNT_BUTTON;
   @FindBy(xpath = "//div[@class='col_full center']/h1") WebElement VALIDATION_LABEL;


    public String pageTitle(){
        System.out.println("Page Title: "+ DriverSetup.driver.getTitle());
        Gauge.writeMessage("Page Title: "+ DriverSetup.driver.getTitle());
        return DriverSetup.driver.getTitle();
    }

    public void register(String fName, String lName, String company, String wEmail, String uName, String pw){
       setTextAs(FIRST_NAME_TEXT_BOX, fName);
       setTextAs(LAST_NAME_TEXT_BOX, lName);
       setTextAs(COMPANY_TEXT_BOX, company);
       setTextAs(WORK_EMAIL_TEXT_BOX, wEmail);
       setTextAs(USERNAME_TEXT_BOX, uName);
       setTextAs(PASSWORD_TEXT_BOX, pw);
       GET_FREE_ACCOUNT_BUTTON.click();
    }

    public void registrationFailedActions(){
        System.out.println("Registration Failed");
        Gauge.writeMessage("Registration Failed");
    }

    public void registrationSuccessedActions(){
        System.out.println("Registration Completed Successfully");
        Gauge.writeMessage("Registration Completed Successfully");
    }

    public void validateRegistrationResult() {
        try {
            waitForElementVisible(VALIDATION_LABEL);
            Assert.assertTrue(VALIDATION_LABEL.isDisplayed(), "Registration Failed");
            registrationSuccessedActions();
        } catch (TimeoutException ex){
            registrationFailedActions();
            Assert.assertTrue(isVisible);
            ex.printStackTrace();
        } catch (NoSuchElementException ex){
            registrationFailedActions();
            Assert.assertTrue(isVisible);
            ex.printStackTrace();
        }
    }

}
