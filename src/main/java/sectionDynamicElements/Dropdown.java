package sectionDynamicElements;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class Dropdown extends MainInterface {
    public Dropdown(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='dropdown/default.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Select country
        WebElement selectElement = super.driver.findElement(By.tagName("select"));
        selectElement.click();

        Select select = new Select(selectElement);
        select.selectByVisibleText("Mexico");

        actions.pause(500).perform();

        selectElement.click();
        select.selectByVisibleText("Thailand");

        // Enter country
        exitIframe();
        WebElement constrained = driver.findElement(By.xpath("//a[@href='#example-1-tab-2']"));
        constrained.click();
        enterIframe(By.xpath("//iframe[@src='dropdown/default1.html']"));

        WebElement enterSelectElement = super.driver.findElement(By.id("combobox"));

        enterSelectElement.click();
        enterSelectElement.sendKeys("mex", Keys.ENTER);

        actions.pause(500).perform();

        enterSelectElement.click();
        enterSelectElement.sendKeys("thai", Keys.ENTER);

        // Exit last iFrame
        super.exitIframe();
    }
}
