package SauceDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FailedLogin {
    public WebDriver driver;

    @BeforeMethod
    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }

    @Test
    public void failedLogin() {
        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("wrongpassword");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String failedLoginResult;
        WebElement errorMessage = driver.findElement(By.className("error-button"));
        if (errorMessage.isDisplayed()) {
            failedLoginResult = "PASS";
        } else {
            failedLoginResult = "FAIL";
            Assert.fail();
        }
        System.out.println("Failed login test: " + failedLoginResult);
    }
}