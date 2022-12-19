package StepDefinitionfile;

import ReusableFile.BrowserInvocation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.time.Duration;

public class loginSteps extends BrowserInvocation {

    WebDriver driver;

    String director1;
    String country1;
    String launua;
    String date;
    String director2;
    String actualDate;
    String country2;
    String lanua2;

    @Given("To Navigate required url")
    public void navigateUrl() throws IOException {
        driver = BrowserInvocation.launchBrowser();

    }

    @Then("Handle the wikipedia frame")
    public void handleTheWikipediaFrame() {
        director1 = driver.findElement(By.partialLinkText("Lokesh Kanagaraj")).getText();
        WebElement size = driver.findElement(By.xpath("//table[@class=\"infobox vevent\"]/tbody/tr[14]"));
        country1 = size.findElement(By.tagName("td")).getText();
        WebElement size1 = driver.findElement(By.xpath("//table[@class=\"infobox vevent\"]/tbody/tr[15]"));
        launua = size1.findElement(By.tagName("td")).getText();

        WebElement size2 = driver.findElement(By.xpath("//table[@class=\"infobox vevent\"]/tbody/tr[12]/th/following::div[@class=\"plainlist\"]"));
        date = size2.findElement(By.tagName("li")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @And("Navigate IMDB frame")
    public void navigateIMDBFrame() {

        driver.get("https://www.imdb.com/title/tt9179430/?ref_=nv_sr_srsg_0");
        director2 = driver.findElement(By.partialLinkText("Lokesh Kanagaraj")).getText();

        String date2 = driver.findElement(By.partialLinkText("June 3, 2022 (India)")).getText().substring(0, 4);
        String date3 = driver.findElement(By.partialLinkText("June 3, 2022 (India)")).getText().substring(5, 6);
        String date4 = driver.findElement(By.partialLinkText("June 3, 2022 (India)")).getText().substring(8, 12);
        actualDate = (date3 + " " + date2 + " " + date4);
        country2 = driver.findElement(By.linkText("India")).getText();
        lanua2 = driver.findElement(By.linkText("Tamil")).getText();
    }
        @And("To validate information")
         public void comparison(){

        Assert.assertEquals(director1,director2);
        Assert.assertEquals(country1,country2);
        Assert.assertEquals(date,actualDate);
        Assert.assertEquals(launua,lanua2);

    }

}
