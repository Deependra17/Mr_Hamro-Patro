package mr_hamropatro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverUtil;

import java.time.Duration;
import java.util.Random;

public class CommentPage {
    private final WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(null, Duration.ofSeconds(5000));

    public CommentPage(WebDriver driver) {
        this.driver = driver;
    }
public static WebDriver initializeDriver(String browserType) {
    return WebDriverUtil.getDriver(browserType);
}

    public void eventDetailPage(WebDriver driver) {
        WebElement eventDetail = driver.findElement(By.xpath("//*[@id=\"main-card\"]/div[2]/div[2]/div/div[1]/div/div[2]"));
        eventDetail.click();
        System.out.println("Clicked on today's event");
    }
    public void commentSection() {
        WebElement commentBox = driver.findElement(By.id("comment"));
        wait.until(ExpectedConditions.visibilityOf(commentBox));
        String[] comments = {
                "Great post!",
                "Thanks for sharing!",
                "This is amazing!",
                "I totally agree!",
                "Interesting perspective!"
        };
        Random random = new Random();
        String randomComment = comments[random.nextInt(comments.length)];
        commentBox.sendKeys(randomComment);
        commentBox.sendKeys(Keys.ENTER);
        System.out.println("Random comment sent: " + randomComment);
    }

    public void likeIcon() {
        WebElement like = driver.findElement(By.xpath(""));
        like.click();
    }

    public void CommentIcon() {
        WebElement cLickOnCommentIcon = driver.findElement(By.xpath(""));
        cLickOnCommentIcon.click();
    }

    public void commentInputBox() {
        WebElement clickOnCommentInputField = driver.findElement(By.xpath(""));
        clickOnCommentInputField.sendKeys("");
    }
}
