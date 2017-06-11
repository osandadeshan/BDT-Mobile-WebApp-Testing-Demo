package stepImpl;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import static stepImpl.DriverSetup.driver;

/**
 * Created by Osanda on 4/29/2017.
 */

public class BasePageStepImpl {

    @Step("Retrieve the current Operating System name")
    public void getOS() {
        System.out.println(System.getenv("OPERATING_SYSTEM"));
        Gauge.writeMessage(System.getenv("OPERATING_SYSTEM"));
    }


    @Step("Retrieve the current Browser name")
    public void getBrowserName() {
        System.out.println(System.getenv("BROWSER"));
        Gauge.writeMessage(System.getenv("BROWSER"));
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
