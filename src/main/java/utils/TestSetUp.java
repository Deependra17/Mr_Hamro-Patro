package utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

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

        String url = "https://app-dev.hamrostack.com/";
        driver.get(url);
        System.out.println("Browser Launched Successfully..");

        driver.manage().window().maximize();
        Thread.sleep(5000);
        loginUtils.loginSetUp();
        System.out.println("User is logged in Successfully..");
        Thread.sleep(5000);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser Closed Successfully..");
        }
    }
}
