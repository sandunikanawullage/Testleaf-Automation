import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void TextBoxTesting(){

        //Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Sandunika Hiroshini");

        //append country to this city
        WebElement appendCity = driver.findElement(By.id("j_idt88:j_idt91"));
        appendCity.sendKeys(" India");

        //Verify the Text box is enabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is textbox enabled? " + enabled);

        //Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed text
        WebElement typedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = typedText.getAttribute("value");
        System.out.println("The Retrieved Text is: " + value);

        //Type E mail and tab control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("sandunika@123gmail.com" + Keys.TAB + "Confirmed control moved to next element");

    }
}
