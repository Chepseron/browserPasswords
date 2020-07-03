package browserpass;

import java.util.Collections;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserPass {

    @PersistenceContext(unitName = "browserpasswords?zeroDateTimeBehavior=convertToNullPU")
    private EntityManager em;
    @Resource

    public static void main(String[] args) {
        BrowserPass pass = new BrowserPass();
        pass.chrome();
    }

    public void chrome() {
        System.setProperty("webdriver.chrome.driver", "src\\browserpass\\chromedriver_2.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        driver.get("chrome://settings/passwords?search=passwords");

        for (int i = 1; i < 10; i++) {
            WebElement passwordList = driver.findElement(By.id("frb" + i));
            WebElement listitem = passwordList.findElement(By.className("list-item"));
            WebElement websitecolumn = listitem.findElement(By.className("website-column"));
            String originurl = websitecolumn.findElement(By.id("originUrl")).getText();
            String username = websitecolumn.findElement(By.id("username")).getText();
            WebElement passwordColumn = listitem.findElement(By.className("password-column"));
            String password = passwordColumn.findElement(By.id("password")).getText();
        }

        String actualUrl = "chrome://settings/passwords?search=passwords";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public void opera() {
        System.setProperty("webdriver.opera.driver", "src\\browserpass\\operadriver.exe");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//button[text()='Sign in']"));
        username.sendKeys("example@gmail.com");
        password.sendKeys("password");
        login.click();
        String actualUrl = "https://www.linkedin.com/feed/";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public void firefox() {
        System.setProperty("webdriver.gecko.driver", "src\\browserpass\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("about:preferences#privacy");
//        WebElement username = driver.findElement(By.id("username"));
//        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//button[text()='Saved Logins...']"));
//        username.sendKeys("chepseron@gmail.com");
//        password.sendKeys("benson32!");
        login.click();
        String actualUrl = "about:preferences#privacy";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public void IE() {
        System.setProperty("webdriver.ie.driver", "src\\browserpass\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.xpath("//button[text()='Sign in']"));
        username.sendKeys("example@gmail.com");
        password.sendKeys("password");
        login.click();
        String actualUrl = "https://www.linkedin.com/feed/";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

   
}
