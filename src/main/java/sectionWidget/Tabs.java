package sectionWidget;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tabs extends MainInterface {
    public Tabs(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='tabs/tabs1.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultTab1 = super.driver.findElement(By.xpath("//a[@href='#tabs-1']"));

        defaultTab1.click();
        actions.pause(500).scrollByAmount(0, -300).build().perform();

        WebElement defaultTab2 = super.driver.findElement(By.xpath("//a[@href='#tabs-2']"));

        defaultTab2.click();
        actions.pause(500).scrollByAmount(0, -400).build().perform();

        WebElement defaultTab3 = super.driver.findElement(By.xpath("//a[@href='#tabs-3']"));

        defaultTab3.click();
        actions.pause(500).scrollByAmount(0, -500).build().perform();

        // Exit last iFrame
        super.exitIframe();
    }
}
