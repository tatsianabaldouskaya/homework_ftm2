package Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResults {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    public WebElement calcResult;

    @FindBy(xpath = "//div[@class='gsc-webResult gsc-result']")
    public List<WebElement> allResults;

    public SearchResults(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

public void OpenCalculator(){
    calcResult.click();
}
public void FindResult(){

}


}
