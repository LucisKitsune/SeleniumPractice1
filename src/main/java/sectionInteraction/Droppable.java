package sectionInteraction;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Droppable extends MainInterface {
    public Droppable(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='droppable/default.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultSource = super.driver.findElement(By.id("draggable"));
        WebElement defaultTarget = super.driver.findElement(By.id("droppable"));
        actions.dragAndDrop(defaultSource, defaultTarget).perform();

        // Accept
        super.changeExercise("droppable", 2, "default");

        WebElement acceptNonValidSource = super.driver.findElement(By.id("draggable-nonvalid"));
        WebElement acceptSource = super.driver.findElement(By.id("draggable"));
        WebElement acceptTarget = super.driver.findElement(By.id("droppable"));

        actions.dragAndDropBy(acceptNonValidSource, 0, 300)
                .dragAndDrop(acceptSource, acceptTarget)
                .build().perform();

        // Prevent propagation
        super.changeExercise("droppable", 3, "default");

        WebElement preventSource = super.driver.findElement(By.id("draggable"));
        WebElement preventTarget = super.driver.findElement(By.id("droppable"));
        WebElement preventInnerTarget = super.driver.findElement(By.id("droppable-inner"));
        WebElement preventTarget2 = super.driver.findElement(By.id("droppable2"));
        WebElement preventInnerTarget2 = super.driver.findElement(By.id("droppable2-inner"));

        actions.dragAndDrop(preventSource, preventTarget)
                .dragAndDrop(preventSource, preventInnerTarget)
                .dragAndDrop(preventSource, preventInnerTarget2)
                .dragAndDrop(preventSource, preventTarget2)
                .dragAndDropBy(preventSource, 0, -50)
                .build().perform();

        // Revert draggable position
        super.changeExercise("droppable", 4, "default");

        WebElement revertSource = super.driver.findElement(By.id("draggable"));
        WebElement revertSource2 = super.driver.findElement(By.id("draggable2"));
        WebElement revertTarget = super.driver.findElement(By.id("droppable"));

        actions.dragAndDrop(revertSource, revertTarget)
                .pause(600)
                .dragAndDropBy(revertSource2, 200, 200)
                .pause(600)
                .dragAndDrop(revertSource2, revertTarget)
                .build().perform();

        // Shopping cart demo
        super.changeExercise("droppable", 5, "default");

        WebElement cartSourceProduct = super.driver.findElement(By.xpath("//li[text()='Lolcat Shirt']"));
        WebElement cartTarget = super.driver.findElement(By.tagName("ol"));
        WebElement cartProductSection2 = super.driver.findElement(By.xpath("//a[text()='Bags']"));
        WebElement cartSourceProduct2 = super.driver.findElement(By.xpath("//li[text()='Zebra Striped']"));
        WebElement cartProductSection3 = super.driver.findElement(By.xpath("//a[text()='Gadgets']"));
        WebElement cartSourceProduct3 = super.driver.findElement(By.xpath("//li[text()='iPhone']"));

        actions.clickAndHold(cartSourceProduct).moveToElement(cartTarget).moveByOffset(75, 0).release().perform();
        cartProductSection2.click();
        actions.pause(600).perform();
        actions.clickAndHold(cartSourceProduct2).moveToElement(cartTarget).moveByOffset(75, 0).release().perform();
        cartProductSection3.click();
        actions.pause(600).perform();
        actions.clickAndHold(cartSourceProduct3).moveToElement(cartTarget).moveByOffset(75, 0).release().perform();

        // Exit last iFrame
        super.exitIframe();
    }
}
