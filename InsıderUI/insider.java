package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class insider {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://useinsider.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void test() throws InterruptedException {
        //çerezleri kabul et yapıldı.
        WebElement cookie = driver.findElement(By.xpath("//div/a[contains(text(),'Accept All')]"));
        cookie.click();
        //Ana sayfanın açıldıgı kontrol edildi.
        WebElement homePageControl = driver.findElement(By.xpath("//li/a[@class='nav-link account text-center text-lg-left']"));
        Assert.assertTrue(homePageControl.isDisplayed());
        //More butonuna basıldı.
        WebElement moreButton = driver.findElement(By.xpath("(//a/span[contains(text(),'More')])[1]"));
        moreButton.click();
        //kariyer seçeneği seçildi.
        WebElement careerButton = driver.findElement(By.xpath("//a/h5[contains(text(),'Careers')]"));
        careerButton.click();
        //sayfa kontrol edildi.
        WebElement careerControl = driver.findElement(By.xpath("//div/h2[contains(text(),'Life at Insider')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", careerControl);
        Assert.assertTrue(careerControl.isDisplayed());
        Thread.sleep(3000);
        //See all theme tıklandı.
        WebElement customerSuccesControl = driver.findElement(By.xpath("//a/h3[contains(text(),'Customer Success')]"));
        WebElement seeAllButtonteamsButton = driver.findElement(By.xpath("//div/a[contains(text(),'See all teams')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", customerSuccesControl);
        Thread.sleep(1000);
        seeAllButtonteamsButton.click();
        //Quality Assurance seçildi.
        WebElement qualityAssuranceChoose = driver.findElement(By.xpath("(//a/h3[@class='text-center mb-4 mb-xl-5'])[12]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", qualityAssuranceChoose);
        Thread.sleep(1000);
        qualityAssuranceChoose.click();
        //See all QA juba tıklandı.
        WebElement allQaJobsButton = driver.findElement(By.xpath("//div/a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']"));
        allQaJobsButton.click();
        //All buton tıklandı.
        Thread.sleep(3400);
        WebElement allButton = driver.findElement(By.id("select2-filter-by-location-container"));
        allButton.click();
        Thread.sleep(2000);
        // istanbul seçenegi seçildi.
        WebElement lct2 = driver.findElement(By.xpath("//li[contains(@id,'Istanbul, Turkey')]"));
        lct2.click();
        //aq kontrol edildi.
        WebElement qaControl = driver.findElement(By.xpath("//span[contains(@title,'Quality Assurance')]"));
        Assert.assertTrue(qaControl.isDisplayed());
        //iş seçildi.


        Actions act = new Actions(driver);
        WebElement browseOpenPositions = driver.findElement(By.xpath("(//h3[@data-animate-way=\"bottom-top\"])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", browseOpenPositions);

        Thread.sleep(3000);
        WebElement SoftwareQualityEngineer = driver.findElement(By.xpath("//p[text()='Software Quality Assurance Engineer (Remote)']"));
        act.moveToElement(SoftwareQualityEngineer).build().perform();

        WebElement aplyButton2 = driver.findElement(By.xpath("(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[2]"));
        aplyButton2.click();


    }
}
