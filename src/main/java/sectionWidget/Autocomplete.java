package sectionWidget;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Autocomplete extends MainInterface {
    public Autocomplete(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='autocomplete/defult1.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultInput = super.driver.findElement(By.id("tags"));
        defaultInput.sendKeys("c");
        actions.pause(500).perform();

        WebElement defaultOption = super.driver.findElement(By.xpath("//li[text()='ColdFusion']"));
        defaultOption.click();

        // Multiple values
        super.changeExercise("autocomplete", 2, "defult");

        WebElement multipleInput = super.driver.findElement(By.id("tags"));
        multipleInput.sendKeys("j");
        actions.pause(500).perform();

        WebElement multipleOption1 = super.driver.findElement(By.xpath("//li[text()='Java']"));
        multipleOption1.click();

        multipleInput.sendKeys("j");
        actions.pause(500).perform();

        WebElement multipleOption2 = super.driver.findElement(By.xpath("//li[text()='JavaScript']"));
        multipleOption2.click();

        multipleInput.sendKeys("j");
        actions.pause(500).perform();

        WebElement multipleOption3 = super.driver.findElement(By.xpath("//li[text()='Clojure']"));
        multipleOption3.click();

        // Categories
        super.changeExercise("autocomplete", 3, "defult");

        WebElement categoriesInput = super.driver.findElement(By.id("search"));
        categoriesInput.sendKeys("a");
        actions.pause(500).perform();

        WebElement categoriesOption1 = super.driver.findElement(By.xpath("//li[text()='annk K12']"));
        categoriesOption1.click();
        actions.pause(500).perform();

        categoriesInput.clear();
        categoriesInput.sendKeys("a");
        actions.pause(500).perform();

        WebElement categoriesOption2 = super.driver.findElement(By.xpath("//li[text()='andreas johnson']"));
        categoriesOption2.click();

        // Exit last iFrame
        super.exitIframe();
    }
}
