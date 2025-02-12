package mr_tests;

import mr_hamropatro.CommentPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestSetUp;

public class TestCommentFunctionality {
    TestSetUp setUp;
    private CommentPage commentPage;
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.out.println("Before Method Started");
        setUp = new TestSetUp(driver);
        setUp.setUp("chrome");
        driver = setUp.getDriver();
        commentPage = new CommentPage(driver);
        System.out.println("Before Method Completed.");

    }

    @AfterMethod
    public void tearDown()   {
        setUp.tearDown();
    }

    @Test
    public void commentTest() throws InterruptedException {
        System.out.println("Test initiated successfully..");
        commentPage.eventDetailPage(driver);
        System.out.println("test started..");
            commentPage.commentSection();
    }
}
