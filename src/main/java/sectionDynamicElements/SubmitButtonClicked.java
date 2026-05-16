package sectionDynamicElements;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SubmitButtonClicked extends MainInterface {
    public SubmitButtonClicked(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='submit/default.html']"));

        // Starts with
        WebElement startsInput = super.driver.findElement(By.cssSelector("input[type='text']"));
        WebElement startsSubmit = super.driver.findElement(By.id("submit"));

        startsInput.sendKeys("starts");
        startsSubmit.click();

        // Ends with
        super.changeExercise("submit", 2, "default");

        WebElement endsInput = super.driver.findElement(By.cssSelector("input[type='text']"));
        WebElement endsSubmit = super.driver.findElement(By.name("submit"));

        endsInput.sendKeys("ends");
        endsSubmit.click();

        // Complete id dynamic
        super.changeExercise("submit", 3, "default");

        WebElement completeInput = super.driver.findElement(By.cssSelector("input[type='text']"));
        WebElement completeSubmit = super.driver.findElement(By.name("submit"));

        completeInput.sendKeys("complete");
        completeSubmit.click();

        // Exit last iFrame
        super.exitIframe();
    }
}
