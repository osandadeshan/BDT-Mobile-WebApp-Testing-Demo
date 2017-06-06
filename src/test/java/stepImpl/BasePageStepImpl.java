package stepImpl;

import com.thoughtworks.gauge.Step;
import java.io.IOException;
import java.net.MalformedURLException;
import static stepImpl.AndroidSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class BasePageStepImpl {

    @Step("Closing the driver")
    public void after(){
        driver.quit();
    }


    @Step("Wait <seconds> seconds")
    public void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

}
