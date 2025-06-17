import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZipCodeTest {

    @Test
    public void testNegative() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessage = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit();
    }

    @Test
    public void testPostive() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        Assert.assertTrue(registerButton.isDisplayed());
        driver.quit();
    }
}
