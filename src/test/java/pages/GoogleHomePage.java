package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static scenarios.AndroidSetup.driver;

/**
 * Created by Osanda on 5/14/2017.
 */

public class GoogleHomePage extends BasePage {

    @FindBy(xpath="//input[@id='lst-ib']")
    WebElement searchBox;
    @FindBy(xpath="//input[@value='Google Search']")
    WebElement searchButton;

    public void navigateToGoogle(){
        driver.get("https://www.google.lk");
    }

    public void googleSearch(String text){
        searchBox.sendKeys(text);
        searchButton.click();
    }

}
