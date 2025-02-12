package utils;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class TestSetUp {

    private WebDriver driver;
    private LoginUtils loginUtils;
    public TestSetUp(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp(String browser) throws InterruptedException {
        driver = WebDriverUtil.getDriver(browser);
        this.loginUtils = new LoginUtils(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        System.out.println("Test Started..");

        String url = "https://app-staging.hamrostack.com/";
        long startTime = System.currentTimeMillis();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //A simple ExpectedCondition to check if the page is fully loaded
        ExpectedCondition<Boolean> pageLoadCondition = webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");

        try {
            // Wait for the page to load completely
            wait.until(pageLoadCondition);
            System.out.println("Page loaded successfully on first attempt.");
        } catch (TimeoutException e) {
            System.out.println("Page did not load within 10 seconds on first attempt, refreshing page...");
            driver.navigate().refresh();
            // Wait again after refresh
            wait.until(pageLoadCondition);
            System.out.println("Page loaded successfully after refresh.");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Page Load Time: " + (endTime - startTime) + "ms");
        System.out.println("Browser Launched Successfully..");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Login Started..");
       loginUtils.loginSetUp();
        System.out.println("Logged in Successfully.");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser Closed Successfully..");
        }
    }
}
