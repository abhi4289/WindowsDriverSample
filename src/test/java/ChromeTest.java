import io.appium.java_client.windows.WindowsDriver;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeTest {
    public  static WindowsDriver driver = null;
    @BeforeClass
    public void SetUp(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");

        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public  void cleanUp(){
        driver.quit();
        SetUp();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @Test
    public  void check() throws InterruptedException {
        driver.findElementByName("Address and search bar").click();
        driver.getKeyboard().sendKeys("https://mail.google.com");
        driver.getKeyboard().sendKeys(Keys.ENTER);

        driver.findElementByName("Email or phone").sendKeys("abhishekgupta.jdp@gmail.com");
        driver.findElementByName("Next").click();

        Thread.sleep(5000);
    }
}
