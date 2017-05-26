package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import static utilities.PropertyReader.readingFromPropertyFile;

/**
 * Created by Osanda on 4/26/2017.
 */

public abstract class AndroidSetup {

    public static WebDriver driver;

        public static void prepareAndroidForAppium() throws IOException {
            String APPIUM_HOST = readingFromPropertyFile("appium_host");
            String APPIUM_PORT = readingFromPropertyFile("appium_port");
            String ANDROID_VERSION = readingFromPropertyFile("android_version");
            String APPIUM_SERVER_URL = "http://" + APPIUM_HOST + ":" + APPIUM_PORT + "/wd/hub";

            // Create object of  DesiredCapabilities class and specify android platform
            DesiredCapabilities capabilities=DesiredCapabilities.android();

            // Set the capability to execute test in chrome browser
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

            // Set the capability to execute our test in Android Platform
            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

            // We need to define platform name
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

            // Set the device name as well (you can give any name)
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"My phone");

            // Set the android version as well
            capabilities.setCapability(MobileCapabilityType.VERSION,ANDROID_VERSION);

            // Create object of URL class and specify the appium server address
            URL url= new URL(APPIUM_SERVER_URL);

            // Create object of  AndroidDriver class and pass the url and capability that we created
             driver = new AndroidDriver(url, capabilities);
        }

}
