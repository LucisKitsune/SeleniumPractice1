package sectionWidget;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tooltip extends MainInterface {
    public Tooltip(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='tooltip/defult1.html']"));

        // Default
        WebElement defaultElement1 = super.driver.findElement(By.xpath("//a[text()='Tooltips']"));

        System.out.println("Tooltip 1.1: " + defaultElement1.getAttribute("title"));

        WebElement defaultElement2 = super.driver.findElement(By.xpath("//a[text()='ThemeRoller']"));

        System.out.println("Tooltip 1.2: " + defaultElement2.getAttribute("title"));

        WebElement defaultElement3 = super.driver.findElement(By.id("age"));
        defaultElement3.sendKeys("No che");

        System.out.println("Tooltip 1.3: " + defaultElement3.getAttribute("title"));

        // Custom animations
        super.changeExercise("tooltip", 2, "defult");

        WebElement customElement1 = super.driver.findElement(By.id("show-option"));

        System.out.println("Tooltip 2.1: " + customElement1.getAttribute("title"));

        WebElement customElement2 = super.driver.findElement(By.id("hide-option"));

        System.out.println("Tooltip 2.2: " + customElement2.getAttribute("title"));

        WebElement customElement3 = super.driver.findElement(By.id("open-event"));

        System.out.println("Tooltip 2.3: " + customElement3.getAttribute("title"));

        // Exit last iFrame
        super.exitIframe();
    }
}
