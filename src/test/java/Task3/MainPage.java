package Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchArea;

    public MainPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



        public void Search () throws InterruptedException {
            System.out.println("Search for calculator");
            searchArea.click();
            searchArea.sendKeys("Google Cloud Platform Pricing Calculator");
            searchArea.sendKeys(Keys.ENTER);

            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='gsc-webResult gsc-result']")));


        }






       // new WebDriverWait(driver,10).until(ExpectedConditions.
             //   presenceOfAllElementsLocatedBy(By.xpath("//div[@class='gsc-webResult gsc-result']")));





    }

