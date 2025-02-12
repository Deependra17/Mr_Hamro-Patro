package utils;

import lombok.Getter;
import mr_hamropatro.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

@Getter
public class LoginUtils {
    WebDriver driver = LoginPage.initializeDriver("chrome");
    LoginPage log = new LoginPage(driver);
    private String parentHandle;
    public LoginUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void loginSetUp() throws InterruptedException {
        log.profile();
        log.loginButton();
        log.googleSignInButton();
        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return;
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }
        log.emailInputBox();
        log.passwordInputBox();
        driver.switchTo().window(parentHandle);
    }
}

