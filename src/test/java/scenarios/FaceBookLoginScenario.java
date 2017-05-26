package scenarios;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.FacebookLoginPage;

import java.util.List;

import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class FaceBookLoginScenario {

    FacebookLoginPage facebookLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);

    @Step("Navigate to Facebook")
    public void goToFacebook(){
        facebookLoginPage.navigateToFacebook();
    }

    @Step("Validate the page title")
    public void validatePageTitle(){
        Assert.assertTrue(facebookLoginPage.pageTitle().equals("Welcome to Facebook"),"Page title mismatched");
        System.out.println("Page title validation is passed");
        Gauge.writeMessage("Page title validation is passed");
    }

    @Step("Validate the facebook login using email address and password <table>")
    public void validateFacebookLogin(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            facebookLoginPage.signIn(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
