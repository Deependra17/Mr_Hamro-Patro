package mr_hamropatro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Credentials;
import utils.WebDriverUtil;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait = new WebDriverWait(null, Duration.ofSeconds(5000));
    private final Credentials cred = new Credentials();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver initializeDriver(String browserType) {
        return WebDriverUtil.getDriver(browserType);
    }

    public void profile(WebDriver driver) {
        WebElement clickOnProfile = this.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[2]"));
        clickOnProfile.click();
        System.out.println("Clicked on profile Icon");
    }

    public void loginButton() throws InterruptedException {
        WebElement clickOnLoginButton = driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[4]/div/div/div/div/section/div[2]/div/button"));
        wait.until(ExpectedConditions.visibilityOf(clickOnLoginButton));
        clickOnLoginButton.click();
        System.out.println("Clicked on login button..");
        Thread.sleep(3000);
    }

    public void googleSignInButton() {
        WebElement clickOnGoogleSignInButton = driver.findElement(By.xpath("/html/body/div[@role='button' and contains(@class, 'clickable') and contains(@class, 'outline-none') and contains(text(), 'Sign in With Google')]\n"));
        wait.until(ExpectedConditions.visibilityOf(clickOnGoogleSignInButton));
        clickOnGoogleSignInButton.click();
        System.out.println("clicked on google sign in button..");
    }

    public void emailInputBox() throws InterruptedException {
        WebElement enterEmail = driver.findElement(By.cssSelector(".whsOnd.zHQkBf"));
        enterEmail.sendKeys(cred.getUsername());
        Thread.sleep(2000);
        enterEmail.sendKeys(Keys.ENTER);
        System.out.println("Email is entered successfully..");
        Thread.sleep(2000);
    }

    public void passwordInputBox() throws InterruptedException {
        WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        enterPassword.sendKeys(cred.getPassword());
        Thread.sleep(2000);
        enterPassword.sendKeys(Keys.ENTER);
        System.out.println("Password is entered successfully..");
        Thread.sleep(2000);
    }
}
