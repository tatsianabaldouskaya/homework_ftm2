package Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calculator {
        private WebDriver driver;
        private WebDriverWait wait;



        @FindBy(xpath = "//div[@title='Compute Engine'][1]")
            private WebElement tabItem;


        @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
                private WebElement numberOfInst;


        @FindBy(xpath = "//label[text()='Operating System / Software']/following::*[@class='md-select-value'][1]")
                private WebElement opersystemList;


        @FindBy(xpath ="//md-option[@value='free']")
                private WebElement opersystemSelect;


        @FindBy(xpath="//*[text() = 'Machine type']/following::*[@class = 'md-select-value'][1]")
                private WebElement machineTypelist;


        @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-2']")
                private WebElement machineTypeSelect;


        @FindBy(xpath = "//*[text() = 'Committed usage']/following::*[@class = 'md-select-value'][1]")
                private WebElement commitUsagelist;


        @FindBy(xpath = "//md-option[@ng-value='1']/following::*[text()='1 Year']")
                private WebElement commitUsageSelect;


        @FindBy(xpath = "//*[text() = 'Instances']/following::button[@aria-label= 'Add to Estimate'][1]")
                private WebElement addbtn;



        public Calculator(WebDriver driver) {
            wait = new WebDriverWait(driver, 10);
            PageFactory.initElements(driver, this);
            this.driver = driver;


        }

        public void SelectEngine()
        {
            tabItem.click();
        }

        public void SetNumberOfInst(){

            numberOfInst.sendKeys("4");
        }

        public void SelectOperSystem(){
            opersystemList.click();
            opersystemSelect.click();
        }
        public void SelectMachineType(){
            machineTypelist.click();
            machineTypeSelect.click();
        }

        public void SelectCommitUsage(){
            commitUsagelist.click();
            commitUsageSelect.click();
        }

        public void Calculate(){
            addbtn.click();
        }





}
