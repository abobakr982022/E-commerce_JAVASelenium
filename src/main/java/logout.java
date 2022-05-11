import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logout {
    public WebElement logout(WebDriver driver){
        By logoutt = By.cssSelector("a[href=\"/logout\"]");
        WebElement logout = driver.findElement(logoutt);
        return logout;
    }
}
