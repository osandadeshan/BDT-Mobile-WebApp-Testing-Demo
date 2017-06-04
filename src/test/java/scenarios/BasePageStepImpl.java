package scenarios;

import com.thoughtworks.gauge.Step;
import utilities.AndroidSetup;
import java.io.IOException;
import java.net.MalformedURLException;
import static utilities.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class BasePageStepImpl {

    @Step("Setting up environment to run Android in Appium")
    public void setUp(){
        try {
            AndroidSetup.prepareAndroidForAppium();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step("Closing the driver")
    public void after(){
        driver.quit();
    }

    @Step("Wait <seconds> seconds")
    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

}
