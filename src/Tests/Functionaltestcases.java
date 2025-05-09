package Tests;
import Base.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utils.ExtentReportManager;

public class Functionaltestcases extends BaseTest{
    WebDriver driver;
    ExtentTest test;
    ExtentReports extent;
        //to get chrome driver
        @BeforeClass
        public void setup () {
            driver = new ChromeDriver();
            driver.get("https://www.salesforce.com/form/developer-signup/?d=pb");
            //maximize window
            driver.manage().window().maximize();
            //handle single first window
            String firstwindow = driver.getWindowHandle();
            extent=ExtentReportManager.getReportInstance();
            test= extent.createTest("Functional Test Cases").assignCategory("Functionaltestcases");
        }
        //input first name
        @Test(priority = 1)
        public void inputfirstname () throws InterruptedException {
            test= extent.createTest("Input First Name").assignCategory("Functionaltestcases");
        //if the id is dynamic use contain
            test.info("Entering First Name");
            WebElement firstname = driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]"));
            firstname.sendKeys("Ayesha");
            test.pass("First Name Entered Successfully");
            Thread.sleep(1000);

        }

        //input second name
        @Test(priority = 2)
        public void inputlastname () throws InterruptedException {
            test= extent.createTest("Input Last Name").assignCategory("Functionaltestcases");
            test.info("Entering Last Name");
            WebElement lastname = driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]"));
            lastname.sendKeys("Sajid");
            test.pass("Last Name Entered Successfully");
            Thread.sleep(1000);

        }

        // input jobtitle
        @Test(priority = 3)
        public void inputjobtitle () throws InterruptedException {
            test= extent.createTest("Input Job Title").assignCategory("Functionaltestcases");
            test.info("Entering Jobtitle");
            WebElement jobtitle=driver.findElement(By.xpath("//input[contains(@id,'UserTitle')]"));
            jobtitle.sendKeys("SQA Engineer");
            test.pass("Jobtitle Entered Successfully");
            Thread.sleep(1000);
        }

        // input email
        @Test(priority = 4)
        public void inputemail () throws InterruptedException {
            test= extent.createTest("Input Email").assignCategory("Functionaltestcases");
            test.info("Entering Email");
            WebElement inputemail=driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]"));
            inputemail.sendKeys("ayesha@gmail.com");
            test.pass("Email Entered Sucessfully");
            Thread.sleep(1000);
        }

        //input company name
        @Test(priority = 5)
        public void inputcompanyname () throws InterruptedException {
            test= extent.createTest("Input Company Name").assignCategory("Functionaltestcases");
            test.info("Entering Company name");
            WebElement companyname=driver.findElement(By.xpath("//input[contains(@id,'CompanyName')]"));
            companyname.sendKeys("Avanceon");
            test.pass("Company Name entered Successfully");
            Thread.sleep(1000);
        }

        //select country name
        @Test(priority = 6)
        public void selectcountryname () {
            test= extent.createTest("Select Country name").assignCategory("Functionaltestcases");
          test.info("Selecting Country");
          WebElement countryname=driver.findElement(By.xpath("//select[contains(@id,'CompanyCountry')]"));
          countryname.click();
          Select countrydropdown=new Select(countryname);
          countrydropdown.selectByVisibleText("Pakistan");
          test.pass("Country selected successfully.");
        }

        //checking salesforceagreement
        @Test(priority = 7)
        public void checkingsalesforceagreement () {
            test= extent.createTest("Checking salesforceagreement").assignCategory("Functionaltestcases");
           test.info("Clicking on Agreement Checkbox");
           WebElement checkboxagreement=driver.findElement(By.xpath("//div[@class='msaCheckbox checkboxInput section']//div//div[@class='checkbox-ui']"));
           checkboxagreement.click();
           test.pass("Agreement Checkbox checked successfully.");
        }

        // checkbox of recaptcha
        @Test(priority = 8)
        public void recaptcha() throws InterruptedException {
            test= extent.createTest("Checking Recaptcha checkbox").assignCategory("Functionaltestcases");
        // first accessing the iframe and switching to it
            test.info("Handling reCAPTCHA...");
            WebElement iframe=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
            driver.switchTo().frame(iframe);
        // accessing the box
            WebElement recaptchabox=driver.findElement(By.cssSelector("div.recaptcha-checkbox-border"));
            recaptchabox.click();
            driver.switchTo().defaultContent();
            System.out.println("Solve reCAPTCHA manually");
            test.warning("Solve reCAPTCHA manually");
            Thread.sleep(20000);

        }

        //clicking signmeup button
        @Test(priority = 9)
        public void clickingsignupbutton () throws InterruptedException {
            test= extent.createTest("Clicking Sign me up button").assignCategory("Functionaltestcases");
            test.info("Clicking Signup Button.");
            WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
            signupbutton.click();
            test.pass("Signup Button clicked successfully.");
            Thread.sleep(9000);
        }
        @AfterClass
        public void teardown () {
            test.info("Closing Browser...");
            driver.quit();
            test.pass("Browser closed successfully.");

        }

    }









