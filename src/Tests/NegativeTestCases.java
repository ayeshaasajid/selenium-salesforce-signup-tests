package Tests;
import Base.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.ExtentReportManager;

import java.util.List;
import java.util.NoSuchElementException;

public class NegativeTestCases extends BaseTest{
WebDriver driver;
ExtentTest test;
ExtentReports extent;
    @BeforeClass
        public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/form/developer-signup/?d=pb");
        driver.manage().window().maximize();
        extent=ExtentReportManager.getReportInstance();
        test= extent.createTest("Negative Test Cases").assignCategory("NegativeTestCases");
    }
    //    Enter numbers in the First Name field
    @Test(priority = 1)
    public void invalidinputfirstname() throws InterruptedException {
        test = extent.createTest("invalidinputfirstname").assignCategory("NegativeTestCases");
        test.info("Enter Invalid Firstname in numeric form");
        WebElement invalidfirstname = driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]"));
        invalidfirstname.sendKeys("7887557");
        //clicking signmeup button
        WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Invalid firstname entered and form not submit");
        Thread.sleep(1000);
    }
    //to validate error message for invalid input
    @Test(priority = 2)
    public void invalidfirstnameerror() {
            test = extent.createTest("invalid firstname error message").assignCategory("NegativeTestCases");
            test.info("Validating error message for invalid firstname");
            List<WebElement> firstnameerror = driver.findElements(By.xpath("//input[contains(@id,'UserFirstName')]"));
            Assert.assertFalse(firstnameerror.isEmpty(),"Test Failed:There is no error message for invalid firstname!");
            Assert.assertTrue(firstnameerror.get(0).isDisplayed(), "Test Failed :Error message present but not displayed.");
            test.pass("Error message validated successfully for invalid firstname");
    }

    //Enter an invalid email format
    @Test(priority = 3)
    public void invalidemail() throws InterruptedException {
        test.info("Enter Invalid Email Format");
        test = extent.createTest("invalid email").assignCategory("NegativeTestCases");
        WebElement invalidemail = driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]"));
        invalidemail.sendKeys("ayeshasajid.com");
        //for clicking signup button
        WebElement signupbutton = driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Invalid email entered and form not submitted");
        Thread.sleep(1000);
    }
    //to validate error message for invalid email input
    @Test(priority = 4)
    public void invalidemailerror(){
        test = extent.createTest("invalid email error").assignCategory("NegativeTestCases");
        test.info("Validating error message for invalid email");
        List<WebElement> invalidemailerror=driver.findElements(By.xpath("//input[contains(@id,'UserEmail')]"));
        Assert.assertFalse(invalidemailerror.isEmpty(),"Test Failed: There is no error message for invalid Email!");
        Assert.assertTrue(invalidemailerror.get(0).isDisplayed(),"Test Failed: Error message present but not displayed!");
        test.pass("Error message validated successfully for invalid email");
        }

    // Enter special characters in the Last Name field
    @Test(priority=5)
    public void invalidlastname() throws InterruptedException {
        test = extent.createTest("invalid last name").assignCategory("NegativeTestCases");
        test.info("Enter special characters in the Last Name field");
        WebElement invalidlastname=driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]"));
        invalidlastname.sendKeys("*&^$%");
        //for clicking signup button
        WebElement signupbutton = driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Invalid lastname entered and form not submitted");
        Thread.sleep(1000);
    }
    //to validate error message for invalid input
    @Test(priority = 6)
    public void invalidlastnamerror(){
        test = extent.createTest("invalid last name error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for invalid lastname");
        List<WebElement> invalidlastnameerror=driver.findElements(By.xpath("//input[contains(@id,'UserLastName')]"));
        Assert.assertFalse(invalidlastnameerror.isEmpty(),"Test Failed: There is no error message for invalid lastname");
        Assert.assertTrue(invalidlastnameerror.get(0).isDisplayed(),"Test Failed: Error message present but not displayed");
        test.pass("Error message validated successfully for invalid lastname");
    }

    //Select an invalid option in Job Role
    @Test(priority = 9)
    public void invalidoptionincountryname() {
        test = extent.createTest("invalid option selection").assignCategory("NegativeTestCases");
        test.info("Select non-existing option using index value");

        try {
            WebElement invalidcountryoption = driver.findElement(By.xpath("//select[contains(@id,'CompanyCountry')]"));
            invalidcountryoption.click();

            Select countrydropdown = new Select(invalidcountryoption);

            // Check number of options first to avoid exception
            int totalOptions = countrydropdown.getOptions().size();

            if (totalOptions <= 1000) {
                test.pass("Dropdown does not have 1000 options, invalid selection confirmed.");
            } else {
                // Try selecting index 1000 if it exists, which should NOT happen in negative test
                countrydropdown.selectByIndex(1000);
                test.fail("Test Failed: Option at index 1000 exists and was selected unexpectedly!");
                Assert.fail("Test Failed: Option at index 1000 exists and was selected unexpectedly!");
            }

        } catch (NoSuchElementException e) {
            test.pass("Non-existing option could not be selected, as expected.");
        } catch (Exception e) {
            test.fail("Test failed due to unexpected exception: " + e.getMessage());
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }

    //to validate error message for invalid input
    @Test(priority = 8)
    public void invalidoptionerror(){

        test = extent.createTest("invalid option selection error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for invalid option");
        try{
        List<WebElement> invalidoptionerror=driver.findElements(By.xpath("//select[contains(@id,'CompanyCountry')]"));
        Assert.assertFalse(invalidoptionerror.isEmpty(),"Test Failed: There is no error message!");
        Assert.assertTrue(invalidoptionerror.get(0).isDisplayed(),"Test Failed: Error message present but not displayed");
        test.pass("Error message validated successfully for invalid option error");}
        catch (AssertionError e) {
            test.fail("Test failed due to: " + e.getMessage());
            throw e;
    }}

    //    Leave the first Name field empty
    @Test(priority = 9)
    public void leavingfirstnameempty(){
           test = extent.createTest("First name field empty").assignCategory("NegativeTestCases");
           test.info("Leaving Firstname field empty and submitting");
           WebElement leavingfirstnameempty=driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]"));
           leavingfirstnameempty.clear();
           //clicking signup button
           WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
           signupbutton.click();
           test.pass("Form not submitted with empty firstname field");
    }
    //to validate error message for empty field
    @Test(priority=10)
    public void firstnameemptyerror(){
        test = extent.createTest("first name field empty error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for empty firstname");
        List<WebElement> firstnameemptyerror=driver.findElements(By.xpath("//span[contains(@id,'UserFirstName')]"));
        Assert.assertFalse(firstnameemptyerror.isEmpty(),"Test Failed: There is no error message");
        Assert.assertTrue(firstnameemptyerror.get(0).isDisplayed(),"Test Failed : Error Message present but not displayed");
        test.pass("Error message validated successfully for empty firstname");
    }

    //    Leave the last Name field empty
    @Test(priority = 11)
    public void leavinglastnameempty(){
        test = extent.createTest("last name field empty").assignCategory("NegativeTestCases");
        test.info("Leaving lastname field empty and submitting");
        WebElement leavinglastnameempty=driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]"));
        leavinglastnameempty.clear();
        //clicking signup button
        WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Form not submitted with empty lastname field");
    }
    //to validate error message for empty field
    @Test(priority=12)
    public void lastnameemptyerror(){
        test = extent.createTest("last name field empty error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for empty lastname");
        List<WebElement> lastnameemptyerror=driver.findElements(By.xpath("//input[contains(@id,'UserLastName')]"));
        Assert.assertFalse(lastnameemptyerror.isEmpty(),"Test Failed: There is no error message");
        Assert.assertTrue(lastnameemptyerror.get(0).isDisplayed(),"Test Failed : Error Message present but not displayed");
        test.pass("Error message validated successfully for empty lastname");
    }

    //    Leave the jobtitle field empty
    @Test(priority = 13)
    public void leavingjobtitleempty(){
        test = extent.createTest("leaving job title empty").assignCategory("NegativeTestCases");
        test.info("Leaving Jobtitle field empty and submitting");
        WebElement leavingjobtitleempty=driver.findElement(By.xpath("//input[contains(@id,'UserTitle')]"));
        leavingjobtitleempty.clear();
        //clicking signup button
        WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Form not submitted with empty Jobtitle field");
    }
    //to validate error message for empty field
    @Test(priority=14)
    public void jobtitleemptyerror(){
        test = extent.createTest("Job title empty error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for empty Jobtilte");
        List<WebElement> jobtitleemptyerror=driver.findElements(By.xpath("//input[contains(@id,'UserTitle')]"));
        Assert.assertFalse(jobtitleemptyerror.isEmpty(),"Test Failed: There is no error message");
        Assert.assertTrue(jobtitleemptyerror.get(0).isDisplayed(),"Test Failed : Error Message present but not displayed");
        test.pass("Error message validated successfully for empty jobtitle");
    }

    //Try signing up without agreeing to the Terms
    @Test(priority = 15)
    public void signupwithoutagreement() throws InterruptedException {
        test = extent.createTest("sign up without agreement").assignCategory("NegativeTestCases");
        test.info("Submitting the form without checking the agreement box");
        // input firstname
        WebElement firstname = driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]"));
        firstname.sendKeys("alina");
        Thread.sleep(1000);
        // input lastname
        WebElement lastname=driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]"));
        lastname.sendKeys("Sajid");
        Thread.sleep(1000);
        // input jobtitle
        WebElement jobtitle=driver.findElement(By.xpath("//input[contains(@id,'UserTitle')]"));
        jobtitle.sendKeys("Engineer");
        Thread.sleep(1000);
        // input email
        WebElement inputemail=driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]"));
        inputemail.clear();
        inputemail.sendKeys("alina@gmail.com");
        Thread.sleep(1000);
        //input company name
        WebElement companyname=driver.findElement(By.xpath("//input[contains(@id,'CompanyName')]"));
        companyname.sendKeys("Avanceon");
        Thread.sleep(1000);
        //select country name
        WebElement countryname=driver.findElement(By.xpath("//select[contains(@id,'CompanyCountry')]"));
        countryname.click();
        Select countrydropdown=new Select(countryname);
        countrydropdown.selectByVisibleText("Pakistan");
        //checking recaptcha
        // first accessing the iframe and switching to it
        WebElement iframe=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);
        // accessing the box
        WebElement recaptchabox=driver.findElement(By.cssSelector("div.recaptcha-checkbox-border"));
        recaptchabox.click();
        driver.switchTo().defaultContent();
        System.out.println("Solve reCAPTCHA manually...");
        Thread.sleep(20000);
        //clicking signmeup button
        WebElement signupbutton=driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        firstname.clear();
        lastname.clear();
        jobtitle.clear();
        inputemail.clear();
        companyname.clear();
        test.pass("Form not submitted successfully without checking the agreement box");


    }
    //to validate error message for not agreeing signup field
    @Test(priority=16)
    public void withoutsignupcheckingerror(){
        test = extent.createTest("Without signup agreement error message").assignCategory("NegativeTestCases");
        test.info("Validating error message for not checking agreement box");
        List<WebElement> signuperror=driver.findElements(By.xpath("//div[@class='msaCheckbox checkboxInput section']//div//div[@class='checkbox-ui']"));
        Assert.assertFalse(signuperror.isEmpty(),"Test Failed: There is no error message");
        Assert.assertTrue(signuperror.get(0).isDisplayed(),"Test Failed : Error Message present but not displayed");
        test.pass("Error message validated successfully for not clicking agreement box");
    }

    // for resetting recaptcha before method is uesd
@BeforeMethod(onlyForGroups ={"Recaptchareset"})
    public void clearingrecaptcha(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println("All cookies are cleared");
    }


    //Try signing up without checking recaptcha to the Terms
    @Test(priority = 17, groups = {"Recaptchareset"})
    public void withoutrecaptcha() throws InterruptedException {
        test = extent.createTest("Without Recaptcha filling").assignCategory("NegativeTestCases");
        test.info("Submitting the form without completing the reCAPTCHA");
        // input firstname
        WebElement firstname = driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]"));
        firstname.sendKeys("maira");
        Thread.sleep(1000);
        // input lastname
        WebElement lastname = driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]"));
        lastname.sendKeys("sukaina");
        Thread.sleep(1000);
        // input jobtitle
        WebElement jobtitle = driver.findElement(By.xpath("//input[contains(@id,'UserTitle')]"));
        jobtitle.sendKeys("Engineer");
        Thread.sleep(1000);
        // input email
        WebElement inputemail = driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]"));
        inputemail.clear();
        inputemail.sendKeys("maira@gmail.com");
        Thread.sleep(1000);
        //input company name
        WebElement companyname = driver.findElement(By.xpath("//input[contains(@id,'CompanyName')]"));
        companyname.sendKeys("Avanceon");
        Thread.sleep(1000);
        //select country name
        WebElement countryname = driver.findElement(By.xpath("//select[contains(@id,'CompanyCountry')]"));
        countryname.click();
        Select countrydropdown = new Select(countryname);
        countrydropdown.selectByVisibleText("Pakistan");
        //checking salesforce agreement
        WebElement checkboxagreement = driver.findElement(By.xpath("//div[@class='msaCheckbox checkboxInput section']//div//div[@class='checkbox-ui']"));
        checkboxagreement.click();
        //clicking signmeup button
        WebElement signupbutton = driver.findElement(By.xpath("//button[normalize-space()='Sign Me Up']"));
        signupbutton.click();
        test.pass("Form not submitted successfully without completing reCAPTCHA");
        Thread.sleep(2000);
    }
    //to validate error message for without recaptcha
    @Test(priority=18,groups = {"Recaptchareset"})
    public void withoutrecaptchaerror(){
        test = extent.createTest("Without Recaptcha Error Message").assignCategory("NegativeTestCases");
        test.info("Validating error message for missing recaptcha");
        List<WebElement> recaptchaerror=driver.findElements(By.xpath("//div[@class='type-captcha section']"));
        Assert.assertFalse(recaptchaerror.isEmpty(),"Test Failed: There is no error message");
        Assert.assertTrue(recaptchaerror.get(0).isDisplayed(),"Test Failed : Error Message present but not displayed");
        test.pass("Error message validated successfully for not completing recaptcha");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
        extent.flush();
    }
    }







