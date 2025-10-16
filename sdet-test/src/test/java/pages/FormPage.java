package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    private WebDriver driver;

    @FindBy(id = "name") // ID selector
    private WebElement nameField;

    @FindBy(css = "input[type='password']") // CSS selector
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='milk']") // XPath for checkbox
    private WebElement milkCheckbox;

    @FindBy(xpath = "//input[@value='coffee']")
    private WebElement coffeeCheckbox;

    @FindBy(xpath = "//input[@value='yellow']")
    private WebElement yellowRadio;

    @FindBy(xpath = "//input[@value='yes']") // Assuming 'yes' for like automation
    private WebElement likeAutomationYes;

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Fluent interface methods
    public FormPage fillName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public FormPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public FormPage selectMilkAndCoffee() {
        milkCheckbox.click();
        coffeeCheckbox.click();
        return this;
    }

    public FormPage selectYellow() {
        yellowRadio.click();
        return this;
    }

    public FormPage selectLikeAutomationYes() {
        likeAutomationYes.click();
        return this;
    }

    public FormPage fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public FormPage fillMessage(String message) {
        messageField.sendKeys(message);
        return this;
    }

    public FormPage submitForm() {
        submitButton.click();
        return this;
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
}