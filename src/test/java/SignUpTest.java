import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUpTest {

    @Test
    public void testPostive() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        Assert.assertTrue(registerButton.isDisplayed());
        driver.findElement(By.name("first_name")).sendKeys("Olga");
        driver.findElement(By.name("last_name")).sendKeys("Mart");
        driver.findElement(By.name("email")).sendKeys("teat@test.ru");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String passesMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(passesMessage, "Account is created!");
        driver.quit();
    }
}
