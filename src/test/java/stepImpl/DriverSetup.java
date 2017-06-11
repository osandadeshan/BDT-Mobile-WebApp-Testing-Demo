package stepImpl;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;

public class DriverSetup {
    private static final String DEFAULT_OS = "windows";
    private static final String ANDROID = "android";
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";
    private static final String DEFAULT_BROWSER = "chrome";

    String OS = System.getenv("OPERATING_SYSTEM");
    String BROWSER = System.getenv("BROWSER");

    String APPIUM_HOST = System.getenv("appium_host");
    String APPIUM_PORT = System.getenv("appium_port");
    String ANDROID_VERSION = System.getenv("android_version");
    String APPIUM_SERVER_URL = "http://" + APPIUM_HOST + ":" + APPIUM_PORT + "/wd/hub";

    public static WebDriver driver;


    @BeforeSuite
    public void Setup() throws IOException {
        // Uses Windows OS by default
        if (OS == null) {
            OS = DEFAULT_OS;
        }

        // Uses chrome driver by default
        if (BROWSER == null) {
            BROWSER = DEFAULT_BROWSER;
        }

            if(OS.toLowerCase().equals(DEFAULT_OS)) {
                if (BROWSER.toLowerCase().equals(FIREFOX)) {
                    FirefoxDriverManager.getInstance().setup();     // Tested on Firefox 41.0
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                } else if (BROWSER.toLowerCase().equals(IE)) {
                    InternetExplorerDriverManager.getInstance().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                } else {
                    ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            }

            if (OS.toLowerCase().equals(ANDROID)) {
                prepareAndroidForAppium();
            }

    }


    public void prepareAndroidForAppium() throws IOException {
        // Create object of  DesiredCapabilities class and specify android platform
        DesiredCapabilities capabilities=DesiredCapabilities.android();

        // Set the capability to execute test in chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);

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


    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }

}
