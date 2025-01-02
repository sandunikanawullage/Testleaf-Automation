import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioAndCheckboxTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void RadioBtnTesting(){
        driver.get("https://www.leafground.com/radio.xhtml");

        //Find default selected button
        boolean chromeRadio = driver.findElement(By.id("j_idt87:console2:0")).isSelected();//isSelected working only with the input attribute
        boolean firefoxRadio = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadio = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadio = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadio){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio buttton: " + chromeText);
        } else if (firefoxRadio) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio buttton: " + firefoxText);
        } else if (safariRadio) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio buttton: " + safariText);
        } else if (edgeRadio) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio buttton: " + edgeText);
        }

        //Select the age group only if not selected
        WebElement ageGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = ageGroup.isSelected();

        if (!isChecked){
            //label xpath
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }

    }

    @Test
    public void CheckBoxTesting(){

        driver.get("https://www.leafground.com/checkbox.xhtml");

        //Select basic checkbox
        WebElement basicCheckbox = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']/div[2]"));
        basicCheckbox.click();

        //Select wanted checkboxes and verify those checkboxes selected status
        List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkboxList) {
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkboxList.size(); i++){
            boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i +"]")).isSelected();
            System.out.println("Checkbox  " +i+" selected status is :"+checkboxStatus);
        }

    }
}
