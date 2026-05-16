package sectionInteraction;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Resizable extends MainInterface {

    public Resizable(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='resizable/default.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultSideSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-e"));
        WebElement defaultBottomSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-s"));
        WebElement defaultIconSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-se"));

        actions.clickAndHold(defaultSideSource).moveByOffset(100, 0).release().pause(300).perform();
        actions.clickAndHold(defaultBottomSource).moveByOffset(0, 100).release().pause(300).perform();
        actions.clickAndHold(defaultIconSource).moveByOffset(150, 150).release().pause(300).perform();

        // Animate
        super.changeExercise("resizable", 2, "default");

        WebElement animateSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-se"));
        actions.clickAndHold(animateSource).moveByOffset(450, 200).pause(300).release().pause(600).perform();

        // Contain resize area
        super.changeExercise("resizable", 3, "default");

        WebElement containSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-se"));
        actions.clickAndHold(containSource).moveByOffset(250, 250).release().perform();

        // Helper
        super.changeExercise("resizable", 4, "default");

        WebElement helperSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-se"));
        actions.clickAndHold(helperSource).moveByOffset(450, 200).pause(300).release().pause(300).perform();

        // Max/Min size
        super.changeExercise("resizable", 5, "default");

        WebElement maxMinSource = super.driver.findElement(By.cssSelector("#resizable > .ui-resizable-se"));
        actions.clickAndHold(maxMinSource).moveByOffset(250, 250).release().pause(300).build().perform();
        actions.clickAndHold(maxMinSource).moveByOffset(-300, -300).release().pause(300).build().perform();

        // Exit last iFrame
        super.exitIframe();
    }
}
