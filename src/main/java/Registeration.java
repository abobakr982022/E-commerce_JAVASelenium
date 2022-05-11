import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registeration {
    public WebElement userElement(WebDriver driver){
        By usernamee = By.name("FirstName");
        WebElement username = driver.findElement(usernamee);
        return username;
    }
    public WebElement LastnameElement(WebDriver driver){
        By LastNamee = By.name("LastName");
        WebElement LastName = driver.findElement(LastNamee);
        return LastName;
    }
    public WebElement dayElement(WebDriver driver){
        By dayy = By.cssSelector("select[name=\"DateOfBirthDay\"] option[value=\"8\"]");
        WebElement day = driver.findElement(dayy);
        return day;
    }
    public WebElement monthElement(WebDriver driver){
        By monthh = By.cssSelector("select[name=\"DateOfBirthMonth\"] option[value=\"5\"]");
        WebElement month = driver.findElement(monthh);
        return month;
    }
    public WebElement yearElement(WebDriver driver){
        By yearr = By.cssSelector("select[name=\"DateOfBirthYear\"] option[value=\"1998\"]");
        WebElement year = driver.findElement(yearr);
        return year;
    }
    public WebElement EmailElement(WebDriver driver){
        By emaill = By.name("Email");
        WebElement email = driver.findElement(emaill);
        return email;
    }
    public WebElement companyElement(WebDriver driver){
        By Companyy = By.name("Company");
        WebElement Company = driver.findElement(Companyy);
        return Company;
    }
    public WebElement NewsletterElement(WebDriver driver){
        By Newsletterr = By.name("Newsletter");
        WebElement Newsletter = driver.findElement(Newsletterr);
        return Newsletter;
    }
    public WebElement PasswordElement(WebDriver driver){
        By Passwordd = By.name("Password");
        WebElement Password = driver.findElement(Passwordd);
        return Password;
    }
    public WebElement ConfirmPasswordElement(WebDriver driver){
        By ConfirmPasswordd = By.name("ConfirmPassword");
        WebElement ConfirmPassword = driver.findElement(ConfirmPasswordd);
        return ConfirmPassword;
    }
    public WebElement registercontinuebuttonElement(WebDriver driver){
        By registercontinuebuttonn = By.className("register-continue-button");
        WebElement registercontinuebutton = driver.findElement(registercontinuebuttonn);
        return registercontinuebutton;
    }
    public WebElement registerbuttonElement(WebDriver driver){
        By registerbuttonn = By.name("register-button");
        WebElement registerbutton = driver.findElement(registerbuttonn);
        return registerbutton;
    }
    public WebElement linkRegisterationElement(WebDriver driver){
        By linkk = By.cssSelector("a[href=\"/register?returnUrl=%2F\"]");
        WebElement link = driver.findElement(linkk);
        return link;
    }
    public WebElement gender(WebDriver driver){
        By genderr = By.cssSelector("input[value=\"M\"]");
        WebElement gender = driver.findElement(genderr);
        return gender;
    }






}
