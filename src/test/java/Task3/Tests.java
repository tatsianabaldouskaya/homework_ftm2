package Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Tests {
    WebDriver driver;
    MainPage mainPage;
    SearchResults searchResults;
    Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        mainPage = new MainPage(driver);
        searchResults = new SearchResults(driver);
        calculator = new Calculator(driver);
        driver.get("https://cloud.google.com/");
    }

    @Test

    public void ResultsSearch() throws InterruptedException {
        mainPage.Search();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        System.out.println("check that results are displayed");
        Assert.assertTrue(searchResults.allResults.size() > 0);

    }

    @Test
    public void CalcOpened() throws InterruptedException {
        mainPage.Search();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        searchResults.OpenCalculator();

        System.out.println("Check that calculator is opened");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://cloud.google.com/products/calculator"));
    }

    @Test

    public void CheckCalculation() throws InterruptedException {
        mainPage.Search();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        searchResults.OpenCalculator();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("goog_1699018510"));
          driver.switchTo().frame(driver.findElement(By.id("myFrame")));



       calculator.SelectEngine();
       calculator.SelectCommitUsage();
       calculator.SelectMachineType();
       calculator.SelectOperSystem();
       calculator.SetNumberOfInst();
       calculator.Calculate();

        Thread.sleep(5000);
    }








        @AfterMethod(alwaysRun = true)
        public void browserTearDown() {
            driver.quit();
            driver = null;
        }


    }

