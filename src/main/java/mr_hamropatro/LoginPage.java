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

    public void profile() {
        WebElement clickOnProfile = this.driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[1]/div/div/header/div[3]/div"));
        clickOnProfile.click();
        System.out.println("Clicked on profile Icon");
    }

    public void loginButton(){
        WebElement clickOnLoginButton = this.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[4]/div/div/div/div/section/div[1]/div/button"));
        wait.until(ExpectedConditions.visibilityOf(clickOnLoginButton));
        clickOnLoginButton.click();
        System.out.println("Clicked on login button..");
    }

    public void googleSignInButton() {
        System.out.println("Google Sign in Button");
        WebElement clickOnGoogleSignInButton = driver.findElement(By.xpath("/html/body/div[17]/div/div[2]/div[4]/div/div/div[1]/div[1]/h3"));
        wait.until(ExpectedConditions.elementToBeClickable(clickOnGoogleSignInButton));
        System.out.println(clickOnGoogleSignInButton.isDisplayed());
        clickOnGoogleSignInButton.click();
        System.out.println(clickOnGoogleSignInButton.isEnabled());
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
        WebElement enterPassword = driver.findElement(By.cssSelector(".whsOnd.zHQkBf"));
        enterPassword.sendKeys(cred.getPassword());
        Thread.sleep(2000);
        enterPassword.sendKeys(Keys.ENTER);
        System.out.println("Password is entered successfully..");
        Thread.sleep(2000);
    }
}
