package stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Checkout;
import pageobjects.Login;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Steps {
    private WebDriver driver;
    private Login log_;
    private Checkout check_;
    private By login1_ = By.xpath("//input[@id='login-button']");
    private By item1_ = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By item2_ = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    private By cart_ = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By checkout_ = By.xpath("//button[@id='checkout']");
    private By continue_ = By.xpath("//input[@id='continue']");
    private By finish_ = By.xpath("//button[@id='finish']");
    private By backButton_ =By.xpath("//button[@id='back-to-products']");

    @Before
    @Given("The Webpage is displayed for user")
    public void the_webpage_is_displayed_for_user() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen.png"));
        System.out.println("Webpage open.....");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Then("^User enters (.*) and (.*)$")
    public void user_enters_and(String Username, String Password) throws IOException {
        log_ = new Login(driver);
        log_.user_enters(Username, Password);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen1.png"));
        System.out.println("Keys were sent.....");

    }
    @Then("The user is logged on to the web application")
    public void The_user_is_logged_on_to_the_web_application() throws IOException {
        driver.findElement(login1_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen2.png"));
        System.out.println("Login button clicked.....");

    }
    @Then("The user adds the items to purchase")
    public void The_user_adds_the_items_to_purchase() throws IOException {
        driver.findElement(item1_).click();
        driver.findElement(item2_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen3.png"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Items added to cart.....");

    }
    @Then("The user goes to the cart")
    public void The_user_goes_to_the_cart() throws IOException {
        driver.findElement(cart_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen4.png"));
        System.out.println("Cart has been open.....");

    }
    @Then("The user finishes the order")
    public void The_user_finishes_the_order() throws IOException {
        driver.findElement(checkout_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen5.png"));
        System.out.println("Checkout button clicked.....");
    }
    @Then("^User enters (.*), (.*), (.*),")
    public void user_enters(String Firstname, String Lastname, String Zip) throws IOException {
        check_ = new Checkout(driver);
        check_.user_enters(Firstname,Lastname, Zip);
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen6.png"));
        System.out.println("Keys were sent.....");

    }
    @Then("User clicks continue button")
    public void user_clicks_continue_button() throws IOException {
        driver.findElement(continue_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen7.png"));
        System.out.println("Continue button clicked.....");

    }
    @Then("User clicks finish button")
    public void user_clicks_finish_button() throws IOException {
        driver.findElement(finish_).click();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen8.png"));
        System.out.println("User finishes the purchase order.....");

    }

    //commented out code
    @After
    @Then("User goes back to home page")
    public void user_goes_back_to_home_page() throws IOException {
        //driver.findElement(backButton_).click();
        //File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshotFile, new File(".//screenshots/screen9.p4ng"));
        //System.out.println("User goes back to the homepage.....");
        driver.quit();

    }
}
