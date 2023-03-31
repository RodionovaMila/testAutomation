package app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverTests {
    private static WebDriver driver;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginRegistrationLink() {
        driver.get("https://watatsumi.com.ua");
        WebElement loginRegistration = driver.findElement(By.cssSelector("#menu-item-106 > a"));
        Assertions.assertTrue(loginRegistration.isDisplayed());
    }

    @Test
    public void registrationMyaccount() {
        driver.get("https://watatsumi.com.ua/my-account");
        WebElement registration = driver.findElement(By.xpath("//*[@id='reg_email']"));
        registration.sendKeys("watatsumi@gmail.com");
        Assertions.assertTrue(registration.isDisplayed());
    }

    @Test
    public void siteContacts() {
        driver.get("https://watatsumi.com.ua/kontakty");
        WebElement kontakty = driver.findElement(By.cssSelector(".map"));
        Assertions.assertTrue(kontakty.isDisplayed(), "Contact page not loaded");
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();

    }
}

