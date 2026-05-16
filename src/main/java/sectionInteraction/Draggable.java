package sectionInteraction;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Draggable extends MainInterface {

    public Draggable(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() throws InterruptedException {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='draggable/default.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Wait
//        WebDriverWait wait = new WebDriverWait(super.driver, Duration.ofSeconds(10));
//        wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Drag me around']/parent::div"))
//        );

        // Default
        WebElement defaultElement = super.driver.findElement(By.id("draggable"));
        actions.clickAndHold(defaultElement).moveByOffset(100, 100).release().perform();

        // Constrained
        super.changeExercise("draggable", 2, "default");

        WebElement dragVertically = super.driver.findElement(By.id("draggable"));
        actions.clickAndHold(dragVertically).moveByOffset(0, -100).release().perform();

        WebElement dragHorizontally = super.driver.findElement(By.id("draggable2"));
        actions.clickAndHold(dragHorizontally).moveByOffset(100, 0).release().perform();

        WebElement dragContained = super.driver.findElement(By.id("draggable3"));
        actions.clickAndHold(dragContained).moveByOffset(600, 50).release().perform();

        WebElement dragContained2 = super.driver.findElement(By.id("draggable5"));
        actions.clickAndHold(dragContained2).moveByOffset(-5, 50).release().perform();

        // Cursor
        super.changeExercise("draggable", 3, "default");

        WebElement cursorCenter = super.driver.findElement(By.id("draggable"));
        actions.clickAndHold(cursorCenter).moveByOffset(100, 100).release().perform();

        WebElement cursorCorner = super.driver.findElement(By.id("draggable2"));
        actions.clickAndHold(cursorCorner).moveByOffset(200, 200).release().perform();

        WebElement cursorBottom = super.driver.findElement(By.id("draggable3"));
        actions.clickAndHold(cursorBottom).moveByOffset(300, 300).release().perform();

        // Events
        super.changeExercise("draggable", 4, "default");

        WebElement dragWithEvent = super.driver.findElement(By.id("draggable"));
        actions.clickAndHold(dragWithEvent).moveByOffset(100, 100).release().perform();
        actions.clickAndHold(dragWithEvent).moveByOffset(100, 100).release().perform();
        actions.clickAndHold(dragWithEvent).moveByOffset(-50, -50).release().perform();

        // Sortable
        super.changeExercise("draggable", 5, "default");

        WebElement dragWithSort1 = super.driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 1']"));
        actions.clickAndHold(dragWithSort1).moveByOffset(0, 75).pause(2000).release().perform(); // 30px per item + 15px for activating the sort

        // Exit last iFrame
        super.exitIframe();
    }
}
