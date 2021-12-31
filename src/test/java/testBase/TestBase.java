package testBase;

import driverFactory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.Loader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static private Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    private static DriverFactory driverFactory;

    private static Loader loader;

    @BeforeAll
    static void setDriver() throws IOException {
        loader = new Loader();
        driverFactory = new DriverFactory();
        logger.info("Webdriver initialized");
    }

    @BeforeEach
    void setUp() {
        driver = driverFactory.getDriver(loader.getBrowser());
        logger.info("Webdriver window start");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Webdriver window closed");
    }
}
