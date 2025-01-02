import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void ButtonTesting(){

        //Click and confirm title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual title same as expected title");
        }
        else {
            System.out.println("Title mismatch");
        }

        //Button enabled
        driver.navigate().back();

        boolean enabled = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
        System.out.println("Is button enabled? " + enabled);

        //Find the position of submit button
        //driver.navigate().back();

        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is: " + x + " and Y position is: " + y);

        //find the save button color
        WebElement btncolor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = btncolor.getCssValue("background-color");
        System.out.println("The color is: " + color);

        //Height nad the width of button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("The height: " + height + " and the width: " + width);

    }

}
