package ReusableFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserInvocation {
    static WebDriver driver;

    public static WebDriver launchBrowser() throws IOException, IOException {

        String path = System.getProperty("user.dir");
        System.out.println(path);
        FileInputStream fis = new FileInputStream(new File("K:\\Selenium\\Newproject\\src\\main\\resources\\Vikramutility\\Vikram.properties"));
        Properties properties = new Properties();
        properties.load(fis);


        if (properties.getProperty("Browser").equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
            //driver.get("https://book.spicejet.com/");
        }
        else {
            throw new IllegalArgumentException("Please select the correct browser");

        }

        driver.navigate().to(properties.getProperty("url"));
        driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }



}
