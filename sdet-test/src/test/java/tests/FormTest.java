package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class FormTest {
    private WebDriver driver;
    private FormPage formPage;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(600));
        driver.get("https://practice-automation.com/form-fields/");
        formPage = new FormPage(driver);
    }

    @Test
    @Description("Test form submission")
    public void testFormSubmission() {
        formPage.fillName("User")
                .fillPassword("password123")
                .selectMilkAndCoffee()
                .selectYellow()
                .selectLikeAutomationYes()
                .fillEmail("name@example.com")
                .fillMessage("5 Katalon Studio")
                .submitForm();

        String alertText = formPage.getAlertText();
        Assert.assertEquals(alertText, "Message received!","The message was not received");

        // Attach screenshot to Allure
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}