package basePage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Random;

public class BasePage {
    static private Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public Actions action;
    public Random random;
    public FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        random = new Random();
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

    String getElementSelector(WebElement element) {
//        return element.toString().split("->")[1];
        return element.toString();
    }

    public void performClick(WebElement element) {
        try {
            logger.info("Trying to click on element: {}", getElementSelector(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error("Element not found");
        }
    }


    public void typeTextTo(WebElement element, String message) {
        element.clear();
        element.sendKeys(message);
        logger.info("Text: {} has been typed to element: {}", message, element);
    }


}
