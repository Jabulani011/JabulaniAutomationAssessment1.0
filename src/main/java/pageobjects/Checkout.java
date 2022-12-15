package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;
    private By firstname_ = By.xpath("//input[@id='first-name']");
    private By lastname_ =By.xpath("//input[@id='last-name']");
    private By zip_ = By.xpath("//input[@id='postal-code']");

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void user_enters(String Firstname, String Lastname, String Zip){
        driver.findElement(firstname_).sendKeys("Jabulani");
        driver.findElement(lastname_).sendKeys("Mtungwa");
        driver.findElement(zip_).sendKeys("2001");
    }


}
