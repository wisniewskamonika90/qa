package com.jsystems.qa.qagui.classic;

import com.jsystems.qa.qagui.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigFrontend {
    protected WebDriver driver;

    //    String chromePath;
    String fireFoxPath;
    {
        try {
//            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("drivers/geckodriver.exe")
                    .toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpEach() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);

      //  driver = new FirefoxDriver();
        if(Configuration.MACHINE.equals("local")) {
            setUpLocalDriver();
        }
        else {
            setUpRemoteDriver();
        }



        setupDriver();
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setPlatform(Platform.LINUX);
//        cap.setVersion("");
//
//
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("platform", "LINUX");
//        options.setCapability("browserName", "chrome");
//        driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL("http://10.0.75.1:4444/wd/hub"), cap);
//        setupDriver();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }

    private void setUpLocalDriver() {
        setupSystemProperties();
        if(Configuration.BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    private void setUpRemoteDriver() {
        DesiredCapabilities cap;

        if(Configuration.BROWSER.equals("firefox")) {
            cap = DesiredCapabilities.firefox();
        } else {
            cap = DesiredCapabilities.chrome();
        }

        cap.setPlatform(Platform.LINUX);
        cap.setVersion("");

        driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Configuration.REMOTE_URL), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDownEach() {
        driver.quit();
    }

    private void setupSystemProperties() {
//        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
    }

    protected void setupDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }
}
