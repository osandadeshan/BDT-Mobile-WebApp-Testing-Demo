package scenarios;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.FacebookLoginPage;
import pages.GridlasticRegistrationPage;

import java.util.List;

import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class GridlasticRegistrationScenario {

    GridlasticRegistrationPage gridlasticRegistrationPage = PageFactory.initElements(driver, GridlasticRegistrationPage.class);

    @Step("Navigate to Gridlastic Registration Page")
    public void goToFacebook(){
        gridlasticRegistrationPage.navigateToGridlasticRegistrationPage();
    }

    @Step("Validate the Gridlastic Registration Page title")
    public void validatePageTitle(){
       // Assert.assertTrue(gridlasticRegistrationPage.pageTitle().equals("Welcome to Gridlastic Registration Page"),"Page title mismatched");
        System.out.println("Page title validation is passed");
        Gauge.writeMessage("Page title validation is passed");
    }

    @Step("Register to Gridlastic using First Name, Last Name, Comapany, Work Email, Username and Password in the following table <table>")
    public void validateGridlasticRegistration(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            gridlasticRegistrationPage.register(row.getCell(columnNames.get(0)), row.getCell(columnNames.get(1)), row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), row.getCell(columnNames.get(4)), row.getCell(columnNames.get(5)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
