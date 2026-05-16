package sectionWidget;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Accordion extends MainInterface {
    public Accordion(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='accordion/defult1.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultTab1 = super.driver.findElement(By.id("ui-id-1"));
        WebElement defaultTab2 = super.driver.findElement(By.id("ui-id-3"));
        WebElement defaultTab3 = super.driver.findElement(By.id("ui-id-5"));
        WebElement defaultTab4 = super.driver.findElement(By.id("ui-id-7"));
        WebElement defaultContent1 = super.driver.findElement(By.cssSelector("#ui-id-2 > p"));
        WebElement defaultContent2 = super.driver.findElement(By.cssSelector("#ui-id-4 > p"));
        WebElement defaultContent3 = super.driver.findElement(By.cssSelector("#ui-id-6 > p"));
        WebElement defaultContent4 = super.driver.findElement(By.cssSelector("#ui-id-8 > p"));

        defaultTab2.click();
        actions.pause(500).perform();
        System.out.println("Content 1.2: " + defaultContent2.getText());

        defaultTab3.click();
        actions.pause(500).perform();
        System.out.println("Content 1.3: " + defaultContent3.getText());

        defaultTab4.click();
        actions.pause(500).perform();
        System.out.println("Content 1.4: " + defaultContent4.getText());

        defaultTab1.click();
        actions.pause(500).perform();
        System.out.println("Content 1.1: " + defaultContent1.getText());

        // Customize icons
        super.changeExercise("accordion", 2, "defult");

        WebElement customizeTab1 = super.driver.findElement(By.id("ui-id-1"));
        WebElement customizeTab2 = super.driver.findElement(By.id("ui-id-3"));
        WebElement customizeTab3 = super.driver.findElement(By.id("ui-id-5"));
        WebElement customizeTab4 = super.driver.findElement(By.id("ui-id-7"));
        WebElement customizeContent1 = super.driver.findElement(By.cssSelector("#ui-id-2 > p"));
        WebElement customizeContent2 = super.driver.findElement(By.cssSelector("#ui-id-4 > p"));
        WebElement customizeContent3 = super.driver.findElement(By.cssSelector("#ui-id-6 > p"));
        WebElement customizeContent4 = super.driver.findElement(By.cssSelector("#ui-id-8 > p"));
        WebElement customizeButton = super.driver.findElement(By.id("toggle"));

        customizeButton.click();
        actions.pause(500).perform();
        customizeButton.click();

        customizeTab2.click();
        actions.pause(500).perform();
        System.out.println("Content 2.2: " + customizeContent2.getText());

        customizeTab3.click();
        actions.pause(500).perform();
        System.out.println("Content 2.3: " + customizeContent3.getText());

        customizeTab4.click();
        actions.pause(500).perform();
        System.out.println("Content 2.4: " + customizeContent4.getText());

        customizeTab1.click();
        actions.pause(500).perform();
        System.out.println("Content 2.1: " + customizeContent1.getText());

        // Fill space
        super.changeExercise("accordion", 3, "defult");

        WebElement fillTab1 = super.driver.findElement(By.id("ui-id-1"));
        WebElement fillTab2 = super.driver.findElement(By.id("ui-id-3"));
        WebElement fillTab3 = super.driver.findElement(By.id("ui-id-5"));
        WebElement fillTab4 = super.driver.findElement(By.id("ui-id-7"));
        WebElement fillContent1 = super.driver.findElement(By.cssSelector("#ui-id-2 > p"));
        WebElement fillContent2 = super.driver.findElement(By.cssSelector("#ui-id-4 > p"));
        WebElement fillContent3 = super.driver.findElement(By.cssSelector("#ui-id-6 > p"));
        WebElement fillContent4 = super.driver.findElement(By.cssSelector("#ui-id-8 > p"));
        WebElement fillResize = super.driver.findElement(By.cssSelector(".ui-resizable-se"));

        actions.clickAndHold(fillResize).moveByOffset(400, 200).release().perform();

        fillTab2.click();
        actions.pause(500).perform();
        System.out.println("Content 3.2: " + fillContent2.getText());

        fillTab3.click();
        actions.pause(500).perform();
        System.out.println("Content 3.3: " + fillContent3.getText());

        fillTab4.click();
        actions.pause(500).perform();
        System.out.println("Content 3.4: " + fillContent4.getText());

        fillTab1.click();
        actions.pause(500).perform();
        System.out.println("Content 3.1: " + fillContent1.getText());

        // Exit last iFrame
        super.exitIframe();
    }
}
