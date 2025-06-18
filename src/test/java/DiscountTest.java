import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DiscountTest {

    @Test
    public void testDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=111111&first_name=Test&last_name" +
                "=Test&email=test%40test.com&password1=Test&password2=Test");
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=2");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discountPersant = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPersant, "0");
        softAssert.assertEquals(discountDollar, "0");
        softAssert.assertEquals(total, "190");
        //driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void testDiscount4() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=111111&first_name=Test&last_name" +
                "=Test&email=test%40test.com&password1=Test&password2=Test");
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=2");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("102");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discountPersant = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPersant, "4");
        softAssert.assertEquals(discountDollar, "40.8");
        softAssert.assertEquals(total, "1060.80");
        //driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void testDiscount7() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=111111&first_name=Test&last_name" +
                "=Test&email=test%40test.com&password1=Test&password2=Test");
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("6000");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String discountPersant = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPersant, "7");
        softAssert.assertEquals(discountDollar, "4200.0");
        softAssert.assertEquals(total, "64200.00");
        //driver.quit();
        softAssert.assertAll();
    }
}
