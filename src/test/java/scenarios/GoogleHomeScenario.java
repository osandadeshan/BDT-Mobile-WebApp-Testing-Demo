package scenarios;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleHomePage;
import java.util.List;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class GoogleHomeScenario {

    GoogleHomePage googleHomePage = PageFactory.initElements(driver, GoogleHomePage.class);

    @Step("Navigate to Google")
    public void goToGoogle(){
        googleHomePage.navigateToGoogle();
    }

    @Step("Validate that the Google search works for the text <table>")
    public void googleSearchTest(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            googleHomePage.googleSearch(row.getCell(columnNames.get(0)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
