package ICanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewPaste {
    private WebDriver driver;
       @BeforeMethod(alwaysRun = true)
    public void browserSetup() {driver = new ChromeDriver();
          }

    @Test
    public void PasteResultsSuccessful() throws InterruptedException {

       // WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        driver.get("https://pastebin.com/");

        driver.findElement(By.id("postform-text"))
                .sendKeys("Hello from WebDriver");

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        driver.findElement(By.xpath("//label[text() = 'Paste Expiration:']/following-sibling::div/span/span/span[@role='combobox']"))
                .click();

        driver.findElement(By.xpath("//li[text() = '10 Minutes']"))
                .click();

        driver.findElement(By.id("postform-name"))
                .sendKeys("helloweb");

        driver.findElement(By.xpath("//*[@class =  'btn -big']"))
                .click();

        new WebDriverWait(driver,10).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//*[@class='notice -success -post-view']")));


        WebElement successMessage = driver.findElement(By.xpath("//*[@class='notice -success -post-view']"));

        Thread.sleep(10000);

        System.out.println("Check if the message was posted");
        Assert.assertTrue(successMessage.isDisplayed(), "Your message was not posted");




    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
