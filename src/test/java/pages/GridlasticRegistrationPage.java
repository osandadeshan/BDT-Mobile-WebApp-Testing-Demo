package pages;

import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 5/24/2017.
 */

public class GridlasticRegistrationPage extends BasePage {

   @FindBy(xpath = "//input[@name='fname']") WebElement FIRST_NAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='lname']") WebElement LAST_NAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='company']") WebElement COMPANY_TEXT_BOX;
   @FindBy(xpath = "//input[@name='email']") WebElement WORK_EMAIL_TEXT_BOX;
   @FindBy(xpath = "//input[@name='username']") WebElement USERNAME_TEXT_BOX;
   @FindBy(xpath = "//input[@name='password']") WebElement PASSWORD_TEXT_BOX;
   @FindBy(xpath = "//button[@type='submit']") WebElement GET_FREE_ACCOUNT_BUTTON;

    public void navigateToGridlasticRegistrationPage(){
        driver.get("https://www.gridlastic.com/register.php");
    }

    public String pageTitle(){
        System.out.println("Page Title: "+driver.getTitle());
        Gauge.writeMessage("Page Title: "+driver.getTitle());
        return driver.getTitle();
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

}
