package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 5/14/2017.
 */

public class GoogleHomePage extends BasePage {

    @FindBy(id="tsfi") WebElement searchBox;
    @FindBy(id="tsbb") WebElement searchButton;

    public void navigateToGoogle(){
        driver.get("https://www.google.lk");
    }

    public void googleSearch(String text){
        waitForElement(searchBox);
        searchBox.sendKeys(text);
        searchButton.click();
    }

}
