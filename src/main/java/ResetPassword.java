import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPassword {
    public WebElement linkElement(WebDriver driver){
        By linkk = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
        WebElement link = driver.findElement(linkk);
        return link;
    }
    public WebElement EmailElement(WebDriver driver){
        By emaill = By.name("Email");
        WebElement email = driver.findElement(emaill);
        return email;
    }
    public WebElement passwordrecoverylinkElement(WebDriver driver){
        By passwordrecoverylinkk = By.cssSelector("a[href=\"/passwordrecovery\"]");
        WebElement passwordrecoverylink = driver.findElement(passwordrecoverylinkk);
        return passwordrecoverylink;
    }
    public WebElement EmailconfirmElement(WebDriver driver){
        By emaill = By.name("Email");
        WebElement email = driver.findElement(emaill);
        return email;
    }
    public WebElement sendmailElement(WebDriver driver){
        By sendemaill = By.name("send-email");
        WebElement sendemail = driver.findElement(sendemaill);
        return sendemail;
    }


}
