package testClass_Package;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom_Package.Login_Page;
import testBrowserSetup.Base;
import utilities.Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test_Class extends Base {
    WebDriver driver;
    pom_Package.Login_Page login;
    int testID;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = openChromeBrowser();
        }
        if(browser.equalsIgnoreCase("firefox"))
        {
            driver = openfirefoxBrowser();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void beforeClass()
    {
        login = new pom_Package.Login_Page(driver);
    }

    @BeforeMethod
    public void Login()
    {
        driver.navigate().to("http://www.testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx");
        driver.manage().window().maximize();
        login.sendLoginID();
        login.sendPassword();
        login.clickLogin();
    }

    @Test
    public void verifyLoginButton() throws InterruptedException {
        testID=100;
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Thread.sleep(2000);
        Assert.assertEquals(url,"http://www.testyou.in/Student/StudentIndex.aspx1");

    }

    @AfterMethod
    public void logOut(ITestResult result) throws IOException, InterruptedException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            Utility.takescreenshot((TakesScreenshot)driver,testID);
        }
        Thread.sleep(3000);
    }

    @AfterClass
    public void clearObjects()
    {
        login=null;
    }

    @AfterTest
    public void closedBrowser()
    {
        driver.quit();
        driver=null;
    }

}
