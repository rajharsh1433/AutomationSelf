package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistration {

    private WebDriver driver;

    public AccountRegistration(WebDriver driver) {
        this.driver = driver;
    }

    private By maletitle = By.id("id_gender1");
    private By femaletitle = By.id("id_gender2");
    private By password = By.id("password");
    private By Newsletter = By.id("newsletter");
    private By optin = By.id("optin"); // corrected typo
    private By First_Name = By.id("first_name");
    private By last_Name = By.id("last_name");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By State = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By CreateAccBtn = By.cssSelector("button[data-qa='create-account']");
    private By validationText = By.xpath("//b[normalize-space()='Account Created!']");

    public void EnterPersonalInformation(String title, String pwd) {
        if ("Mr".equals(title)) {
            driver.findElement(maletitle).click();
        } else {
            driver.findElement(femaletitle).click();
        }
        driver.findElement(password).sendKeys(pwd);
    }

    public void EnterDoB(String day, String month, String year) {
        new Select(driver.findElement(By.id("days"))).selectByVisibleText(day);
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(month);
        new Select(driver.findElement(By.id("years"))).selectByVisibleText(year);
    }

    public void SelectNewsletter() {
        driver.findElement(Newsletter).click();
    }

    public void Selectoptin() {
        driver.findElement(optin).click();
    }

    public void AddressDetails(String fName, String lName, String comp, String add1, String add2,
                                String country, String state, String City, String ZipCode, String mobilenumber) {
        driver.findElement(First_Name).sendKeys(fName);
        driver.findElement(last_Name).sendKeys(lName);
        driver.findElement(company).sendKeys(comp);
        driver.findElement(address1).sendKeys(add1);
        driver.findElement(address2).sendKeys(add2);
        new Select(driver.findElement(By.id("country"))).selectByVisibleText(country);
        driver.findElement(State).sendKeys(state);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(ZipCode);
        driver.findElement(mobile).sendKeys(mobilenumber);
    }

    public void ClickCreateBtn() {
        driver.findElement(CreateAccBtn).click();
    }

    public boolean AccountCreated() {
        String text = driver.findElement(validationText).getText();
        return "ACCOUNT CREATED!".equals(text.trim());
    }
}
