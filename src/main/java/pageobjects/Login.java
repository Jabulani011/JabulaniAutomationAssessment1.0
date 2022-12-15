package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By usernaam_ = By.xpath("//input[@id='user-name']");
    private By password_ = By.xpath("//input[@id='password']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void user_enters(String Username, String password) {
        driver.findElement(usernaam_).sendKeys("standard_user");
        driver.findElement(password_).sendKeys("secret_sauce");
    }

}
