import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;


public class main {
    Registeration registeration = new Registeration();
    logout logout =new logout();
    ValidLogin validLogin =new ValidLogin();
    ResetPassword resetPassword=new ResetPassword();
    ValidLoginAfterReset validLoginAfterReset=new ValidLoginAfterReset();
    searchProducts searchProducts =new searchProducts();
    WebDriver driver =  null;
    SoftAssert soft = new SoftAssert();
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        String chromeDriverPath= System.getProperty("user.dir")+"\\src\\main\\resources\\browsers\\chromedriver.exe";
        System.out.println(chromeDriverPath);
        //link between  testScript and browser
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        //create object
        driver = new ChromeDriver();
        //openbrowser
        driver.navigate().to("https://demo.nopcommerce.com/");
        //maximize
        driver.manage().window().maximize();
        //test script
        Thread.sleep(3000);
    }
    String email="abobavkrahmed9d8cs2d0sd233c5dcd2@gmail.com";
    String password = "123456";

    @Test(priority = 1) //Registeration
    public void validRegisteration () throws InterruptedException {
        registeration.linkRegisterationElement(driver).click();
        Thread.sleep(1000);
       registeration.gender(driver).click();
        Thread.sleep(1000);
        registeration.userElement(driver).sendKeys("Bakr");
        Thread.sleep(1000);
        registeration.LastnameElement(driver).sendKeys("Ahmed");
        registeration.dayElement(driver).click();
        registeration.monthElement(driver).click();
        registeration.yearElement(driver).click();
        registeration.EmailElement(driver).sendKeys(email);
        registeration.companyElement(driver).sendKeys("Bakr-Group");
        for (int i=0; i<=3 ; i++){
            registeration.NewsletterElement(driver).click();
            Thread.sleep(500);
        }
        registeration.PasswordElement(driver).sendKeys(password);
        registeration.ConfirmPasswordElement(driver).sendKeys(password);
        registeration.registerbuttonElement(driver).click();
        //Assertion
        String ExpectedValue = "Your registration completed";
        String ActualValue=  driver.findElement(By.className("result")).getText();
        System.out.println(ActualValue);
        soft.assertTrue(ExpectedValue.contains(ActualValue),"Assertion for completing registeration");
        registeration.registercontinuebuttonElement(driver).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void logout(){
        logout.logout(driver).click();
    }

    @Test(priority = 3)
    public void ValidLogin() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        validLogin.linkLogin(driver).click();
        validLogin.Email(driver).sendKeys(email);
        validLogin.password(driver).sendKeys(password);
        validLogin.loginbutton(driver).click();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void logoutForReset(){
        logout.logout(driver).click();
    }
    @Test(priority = 5)
    public void resetPassword() throws InterruptedException {
       resetPassword.linkElement(driver).click();
        resetPassword.EmailElement(driver).sendKeys(email);
        resetPassword.passwordrecoverylinkElement(driver).click();
        resetPassword.EmailconfirmElement(driver).sendKeys(email);
        resetPassword.sendmailElement(driver).click();
        //Assertion for text 'Email with instructions has been sent to you'.
        String ExpectedResult="Email with instructions has been sent to you.";
        String ActualResult = driver.findElement(By.className("content")).getText() ;
        soft.assertTrue(ActualResult.contains(ExpectedResult),"Assertion for text 'Email with instructions has been sent to you'");
        Thread.sleep(3000);
    }
    @Test(priority = 6)
    public void ValidLoginAfterReset() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        validLoginAfterReset.loginlinkElement(driver).click();
        validLoginAfterReset.Email(driver).sendKeys(email);
        validLoginAfterReset.password(driver).sendKeys(password);
        validLoginAfterReset.loginbutton(driver).click();
        Thread.sleep(3000);
    }
    @Test(priority = 6)
    public void searchProducts() throws InterruptedException {
        searchProducts.linkElement(driver).click();
        Thread.sleep(1500);
        searchProducts.search(driver).sendKeys("Cam");
        Thread.sleep(1500);
        searchProducts.selectsearch(driver).click();
        WebElement Element= driver.findElement(By.className("product-name"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void changeCurrancy() throws InterruptedException {
        WebElement Element= driver.findElement(By.name("customerCurrency"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Element.sendKeys(Keys.ARROW_DOWN);
        Element.sendKeys(Keys.ENTER);
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://demo.nopcommerce.com/leica-t-mirrorless-digital-camera");
        WebElement Element2= driver.findElement(By.id("main-product-img-16"));
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView();", Element2);
        Thread.sleep(1500);
    }
    @Test(priority = 8)
    public void chooseCatagory() throws InterruptedException {
        WebElement Element= driver.findElement(By.name("customerCurrency"));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href=\"/\"]")).click();
        Thread.sleep(1000);
        WebElement Element2=driver.findElement(By.cssSelector("a[href=\"/electronics\"]"));
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView();", Element2);
        Thread.sleep(1000);
        Element2.click();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000006_camera-photo_450.jpeg\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[title=\"List\"]")).click();
        WebElement Element3=driver.findElement(By.cssSelector("a[href=\"/apple-icam\"]"));
        JavascriptExecutor jsss =(JavascriptExecutor) driver;
        jsss.executeScript("arguments[0].scrollIntoView();", Element3);
    }
    @Test(priority = 9)
    public void filterColor() throws InterruptedException {
        driver.navigate().to(" https://demo.nopcommerce.com/camera-photo");
        Thread.sleep(3000);
        WebElement Element3=driver.findElement(By.cssSelector("a[href=\"/apparel\"]"));
        JavascriptExecutor jsss =(JavascriptExecutor) driver;
        jsss.executeScript("arguments[0].scrollIntoView();", Element3);
        Element3.click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000010_shoes_450.jpeg\"]")).click();
        WebElement Element=driver.findElement(By.className("prices"));
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 10)
    public void selectTags() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/apparel");
        WebElement Element=driver.findElement(By.cssSelector("a[href=\"/producttag/all\"]"));
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        jss.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.cssSelector("a[href=\"/game\"]")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 11)
    public void addtoShoppingCart() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/game");
        driver.findElement(By.cssSelector("a[href=\"/game\"]")).click();
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        WebElement Element=driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000034_sound-forge-pro-11-recurring_415.jpeg\"]"));
        jss.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
        driver.findElement(By.className("button-2")).click();
        Thread.sleep(2000);
        //Assertion for text 'The product has been added to your shopping cart'.
        String ExpectedResult="The product has been added to your shopping cart";
        String ActualResult = driver.findElement(By.className("content")).getText() ;
        soft.assertTrue(ActualResult.contains(ExpectedResult),"The product has been added to your shopping cart");
    }
    @Test(priority = 12)
    public void addtoWishlist() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/game");
        driver.findElement(By.cssSelector("a[href=\"/books\"]")).click();
        driver.findElement(By.cssSelector("div[data-productid=\"37\"] button[title=\"Add to wishlist\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[data-productid=\"38\"] button[title=\"Add to wishlist\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[data-productid=\"39\"] button[title=\"Add to wishlist\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href=\"/wishlist\"]")).click();
        Thread.sleep(3000);
        System.out.print(driver.getCurrentUrl());
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        WebElement Element=driver.findElement(By.cssSelector("a[href=\"/fahrenheit-451-by-ray-bradbury\"]"));
        jss.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
    }
    @Test(priority = 13)
    public void addtoCompareList() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        driver.findElement(By.cssSelector("a[href=\"/jewelry\"]")).click();
        driver.findElement(By.cssSelector("div[data-productid=\"40\"] button[title=\"Add to compare list\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[data-productid=\"41\"] button[title=\"Add to compare list\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[data-productid=\"42\"] button[title=\"Add to compare list\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href=\"/compareproducts\"]")).click();
        Thread.sleep(2000);
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        WebElement Element=driver.findElement(By.cssSelector("a[href=\"/elegant-gemstone-necklace-rental\"]"));
        jss.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);
    }
    @Test(priority = 14)
    public void createsuccessfulOrder() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.name("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.cssSelector("select[data-trigger=\"country-select\"]")).click();
        driver.findElement(By.cssSelector("select[data-trigger=\"country-select\"]")).sendKeys("g");
        driver.findElement(By.cssSelector("select[data-trigger=\"country-select\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("BillingNewAddress.City")).sendKeys("Giza");
        driver.findElement(By.name("BillingNewAddress.Address1")).sendKeys("El-Haram");
        driver.findElement(By.name("BillingNewAddress.Address2")).sendKeys("El-Haram2");
        driver.findElement(By.name("BillingNewAddress.ZipPostalCode")).sendKeys("25656");
        driver.findElement(By.name("BillingNewAddress.PhoneNumber")).sendKeys("01222565233");
        driver.findElement(By.name("BillingNewAddress.FaxNumber")).sendKeys("0235647896");
        driver.findElement(By.name("save")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[id=\"shipping-method-buttons-container\"] button[type=\"button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("CardholderName")).sendKeys("bakr");
        driver.findElement(By.name("CardNumber")).sendKeys("125125125125");
        driver.findElement(By.name("ExpireMonth")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("select[data-val-required=\"Expire month is required\"] option[value=\"5\"]")).click();
        driver.findElement(By.name("CardCode")).sendKeys("122");
        driver.findElement(By.className("payment-info-next-step-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[id=\"confirm-order-buttons-container\"] button[type=\"button\"]")).click();
        String Expectedvalue="Your order has been successfully processed!";
        String ActualValue = driver.findElement(By.tagName("strong")).getText();
        soft.assertTrue(ActualValue.contains(Expectedvalue),"Your order has been successfully processed!");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class=\"buttons\"] button[type=\"button\"]")).click();
        Thread.sleep(1000);

    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
