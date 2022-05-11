import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidLoginAfterReset {

    public WebElement loginlinkElement(WebDriver driver){
        By loginnlink = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
        WebElement loginlink = driver.findElement(loginnlink);
        return loginlink;
    }
    public WebElement Email(WebDriver driver){
        By Emaill = By.name("Email");
        WebElement Email = driver.findElement(Emaill);
        return Email;
    }
    public WebElement password(WebDriver driver){
        By Passwordd = By.name("Password");
        WebElement Password = driver.findElement(Passwordd);
        return Password;
    }
    public WebElement loginbutton(WebDriver driver){
        By loginbuttonn = By.className("login-button");
        WebElement loginbutton = driver.findElement(loginbuttonn);
        return loginbutton;
    }
}
