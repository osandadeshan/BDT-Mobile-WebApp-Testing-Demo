package utilities;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static stepImpl.DriverSetup.driver;

/**
 * Created by Osanda on 5/25/2017.
 */

public class CustomScreenshotFactory implements ICustomScreenshotGrabber {
    // Return a screenshot byte array
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
