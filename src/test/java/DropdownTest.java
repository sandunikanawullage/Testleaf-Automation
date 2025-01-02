import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void DropdownTesting() throws InterruptedException {

        //Select values in basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);


        //Get the number of dropdowns in menu
        List <WebElement> listOfOptions = select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in dropdown: " + size);

        for (WebElement element: listOfOptions) {
            System.out.println(element.getText());
        }

        //Use Sendkeys
        dropDown.sendKeys("Puppeteer");

        //Select values from bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id = 'j_idt87:country']"));
        dropDown2.click();
        List <WebElement> listOfDropdown2 = driver.findElements(By.xpath("//ul[@id = 'j_idt87:country_items']/li"));
        for (WebElement element:listOfDropdown2) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")){
                element.click();
                break;
            }

        }

    }

}
