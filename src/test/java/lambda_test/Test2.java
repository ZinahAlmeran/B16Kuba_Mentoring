package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtil;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {

    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement table = driver.findElement(By.linkText("Table Pagination"));
        table.click();
        WebElement options = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtil.selectBy(options,"index","0");
//        Select select = new Select(options);
//        select.getFirstSelectedOption();
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String,String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map.put(BrowserUtil.getText(allNames.get(i)),BrowserUtil.getText(allEmails.get(i)));
        }
        System.out.println(map);

    }

    @Test
    public void test2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement table = driver.findElement(By.linkText("Table Pagination"));
        table.click();
        Thread.sleep(2000);
        WebElement options = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtil.selectBy(options,"value","5000");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumbers =driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String,Long> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map.put(BrowserUtil.getText(allNames.get(i)),Long.parseLong(BrowserUtil.getText(allNumbers.get(i)).replace("-","")));

        }
        System.out.println("map  + "+map);



    }
}
