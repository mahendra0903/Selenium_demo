package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public static WebDriver openChromeBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\u729097\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver openfirefoxBrowser()
    {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\u729097\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe\\");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
