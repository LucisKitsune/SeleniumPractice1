package sectionAlert;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Alert extends MainInterface {
    public Alert(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='alert/simple-alert.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Simple alert
        WebElement simpleButton = super.driver.findElement(By.tagName("button"));
        simpleButton.click();

        org.openqa.selenium.Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple alert text: " + simpleAlert.getText());
        simpleAlert.accept();

        // Input alert
        super.exitIframe();
        WebElement constrained = driver.findElement(By.xpath("//a[@href='#example-1-tab-2']"));
        constrained.click();
        enterIframe(By.xpath("//iframe[@src='alert/input-alert.html']"));

        WebElement inputButton = super.driver.findElement(By.tagName("button"));
        inputButton.click();

        org.openqa.selenium.Alert inputAlert = driver.switchTo().alert();
        inputAlert.sendKeys("Kike Templos");
        inputAlert.accept();

        // Exit last iFrame
        super.exitIframe();
    }
}
