import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchProducts {
    public WebElement linkElement(WebDriver driver){
        By linkk = By.cssSelector("a[href=\"/\"]");
        WebElement link = driver.findElement(linkk);
        return link;
    }
    public WebElement search(WebDriver driver){
        By searchh = By.className("search-box-text");
        WebElement search = driver.findElement(searchh);
        return search;
    }
    public WebElement selectsearch(WebDriver driver){
        By selectsearchh = By.id("ui-id-2");
        WebElement selectsearch = driver.findElement(selectsearchh);
        return selectsearch;
    }
}
