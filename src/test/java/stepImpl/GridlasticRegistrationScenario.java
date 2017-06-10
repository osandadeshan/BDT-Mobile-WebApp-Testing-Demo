package stepImpl;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.GridlasticRegistrationPage;
import static stepImpl.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class GridlasticRegistrationScenario {

    GridlasticRegistrationPage gridlasticRegistrationPage = PageFactory.initElements(driver, GridlasticRegistrationPage.class);

    @Step("Navigate to Gridlastic Registration Page")
    public void goToFacebook(){
        driver.get(GridlasticRegistrationPage.GridlasticRegistrationPageUrl);
    }

    @Step("Validate the Gridlastic Registration Page title")
    public void validatePageTitle() {
        Assert.assertEquals(gridlasticRegistrationPage.pageTitle(), "Gridlastic Dashboard", "Page title validation is failed");
        System.out.println("Page title validation is passed");
        Gauge.writeMessage("Page title validation is passed");
    }

    @Step("Validate the registraion to Gridlastic using First Name as <First_Name>, Last Name as <Last_Name>, Comapany as <Comapany>, Work Email as <Work_Email>, Username as <Username> and Password as <Password> in the following table")
    public void gridlasticRegistration(String First_Name, String Last_Name, String Comapany, String Work_Email, String Username, String Password) {
            gridlasticRegistrationPage.register(First_Name, Last_Name, Comapany, Work_Email, Username, Password);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    @Step("Validate that the registration result is success")
    public void validationOfRegistration(){
        gridlasticRegistrationPage.validateRegistrationResult();
    }

}
