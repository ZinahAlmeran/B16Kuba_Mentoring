package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test
    public void testCase(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement inputForm = driver.findElement(By.xpath("//a[contains(text(), 'Input Form Submit')]"));
        inputForm.click();
        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Jenny Joe");
        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("jenny@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("12345");
        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("Testing");
        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("https://www.google.com/");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");
        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("WM");
        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("123 Test St");
        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("SUITE 12");
        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("GA");
        WebElement zipCode = driver.findElement(By.cssSelector("#inputZip"));
        zipCode.sendKeys("12345");
        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.click();








    }

}
