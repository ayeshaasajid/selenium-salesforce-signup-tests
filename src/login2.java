import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class login2 {

    WebDriver driver;

    // Setup method
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://developer.salesforce.com/signup");
        driver.manage().window().maximize();
        String firstwindow = driver.getWindowHandle();
    }

    public void inputfirstname() {
        WebElement parenthost = driver.findElement(By.xpath("//dw-de-signup-form"))
                .getShadowRoot()
                .findElement(By.cssSelector("dx-input.full-name-field[name='first_name']"))
                .getShadowRoot()
                .findElement(By.cssSelector("input[name='first_name'][id='input'][placeholder='Your first name']"));
        parenthost.sendKeys("Ayesha");
    }

    public void inputlastname() {
        WebElement parenthost1 = driver.findElement(By.xpath("//dw-de-signup-form"))
                .getShadowRoot()
                .findElement(By.cssSelector("form"))
                .findElement(By.cssSelector("dx-input[name='last_name']"));
        parenthost1.sendKeys("Sajid");
    }

    public void inputemail() {
        WebElement parenthostElement = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext shadow3 = parenthostElement.getShadowRoot();
        WebElement childhostElement = shadow3.findElement(By.cssSelector("dx-input[name='email']"));
        SearchContext shadow4 = childhostElement.getShadowRoot();
        WebElement emailinput = shadow4.findElement(By.cssSelector("input#input"));
        emailinput.sendKeys("ayeshasajid300@gmail.com");
    }

    public void inputcompanyname() {
        WebElement hostElement = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext shadow0 = hostElement.getShadowRoot();
        WebElement companyInputHost = shadow0.findElement(By.cssSelector("dx-input[name='company']"));
        SearchContext shadow1 = companyInputHost.getShadowRoot();
        WebElement companyInput = shadow1.findElement(By.cssSelector("#input"));
        companyInput.sendKeys("Devsinc");
    }

    public void selectjobrole() {
        WebElement parenthostElementJobRole = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext JobRoleShadow1 = parenthostElementJobRole.getShadowRoot();
        WebElement childhostElementJobRole = JobRoleShadow1.findElement(By.cssSelector("dx-select[name='job_role']"));
        SearchContext JobRoleShadow2 = childhostElementJobRole.getShadowRoot();
        WebElement JobRoleSelect = JobRoleShadow2.findElement(By.cssSelector("select#select"));
        JobRoleSelect.click();
        Select JobRoleDropDown = new Select(JobRoleSelect);
        JobRoleDropDown.selectByIndex(1);
    }

    public void selectcountryname() {
        WebElement CountryNameParentElement = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext CountryNameShadow1 = CountryNameParentElement.getShadowRoot();
        WebElement CountryNameChildElement = CountryNameShadow1.findElement(By.cssSelector("dx-select[name='country']"));
        SearchContext CountryNameShadow2 = CountryNameChildElement.getShadowRoot();
        WebElement CountryNameSelect = CountryNameShadow2.findElement(By.cssSelector("#select"));
        CountryNameSelect.click();
        Select CountryNameDropDown = new Select(CountryNameSelect);
        CountryNameDropDown.selectByVisibleText("Pakistan");
    }

    public void inputpostalcode() {
        WebElement ParentElementPostalCode = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext PostalCodeShadowroot1 = ParentElementPostalCode.getShadowRoot();
        WebElement ChildElementPostalCode = PostalCodeShadowroot1.findElement(By.cssSelector("dx-input[name='postal_code']"));
        SearchContext PostalCodeShadowroot2 = ChildElementPostalCode.getShadowRoot();
        WebElement PostalCodeInput = PostalCodeShadowroot2.findElement(By.cssSelector("#input"));
        PostalCodeInput.sendKeys("1122");
    }

    public void inputusername() {
        WebElement ParentElementUsername = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext UsernameShadowroot1 = ParentElementUsername.getShadowRoot();
        WebElement ChildElementUsername = UsernameShadowroot1.findElement(By.cssSelector("dx-input[name='username']"));
        SearchContext UsernameShadowroot2 = ChildElementUsername.getShadowRoot();
        WebElement UsernameInput = UsernameShadowroot2.findElement(By.cssSelector("#input"));
        UsernameInput.sendKeys("ayeshasajid300@gmail.com");
    }

    public void checkingsalesforceagreement() {
        WebElement ParentElementAgreement = driver.findElement(By.cssSelector("dw-de-signup-form"));
        SearchContext AgreementShadowroot1 = ParentElementAgreement.getShadowRoot();
        WebElement ChildElementAgreement = AgreementShadowroot1.findElement(By.cssSelector("dx-checkbox[name='eula']"));
        SearchContext AgreementShadowroot2 = ChildElementAgreement.getShadowRoot();
        WebElement AgreementCheck = AgreementShadowroot2.findElement(By.cssSelector("input[name='eula']"));
        AgreementCheck.click();
    }

    public void checkingrecaptcha() throws InterruptedException {
        WebElement iframelocate = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframelocate);
        WebElement Recapchacheck = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        Recapchacheck.click();
        driver.switchTo().defaultContent();
        System.out.println("Solve reCAPTCHA manually...");
        Thread.sleep(30000);
    }

    public void clickingsignupbutton() {
        WebElement parenthostbutton1 = driver.findElement(By.xpath("//dw-de-signup-form"))
                .getShadowRoot()
                .findElement(By.cssSelector(".submit-button"));
        parenthostbutton1.click();
    }

    public void teardown() {
        driver.quit();
    }
}
