import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class LinkTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTesting () throws InterruptedException {



        //Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();


       //Find My Destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path =whereToGo.getAttribute("href");
        System.out.println("This Link ID going to: " + path);
        Thread.sleep(3000);

        //Am I broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The Link is broken");
        }
        else {
            System.out.println("The Link is not broken");
        }
        driver.navigate().back();

        //Duplicate Link
        WebElement homeLink2 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink2.click();

        driver.navigate().back();

        //Count page links
        List<WebElement> countFullPageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countFullPageLinks.size();
        System.out.println("Full Page Links: "+ pageLinkCount);

        //count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List <WebElement> countLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Layout Links: "+ countLayoutLinks.size());
    }

}