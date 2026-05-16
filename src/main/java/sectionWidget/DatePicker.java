package sectionWidget;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DatePicker extends MainInterface {
    public DatePicker(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='datepicker/defult1.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        WebElement defaultInput = super.driver.findElement(By.id("datepicker"));
        defaultInput.click();
        actions.pause(500).perform();

        defaultInput.sendKeys("02/18/1994");
        actions.pause(500).perform();

        // Animations
        super.changeExercise("datepicker", 2, "defult");

        WebElement animationsInput = super.driver.findElement(By.id("datepicker"));
        WebElement animationsDropdown = super.driver.findElement(By.id("anim"));
        Select animationsSelect = new Select(animationsDropdown);

        animationsSelect.selectByContainsVisibleText("Blind (UI Effect)");
        actions.pause(500).perform();

        animationsInput.click();
        actions.pause(500).perform();

        animationsInput.sendKeys("02/18/1994");
        actions.pause(500).perform();

        // Display Month & year
        super.changeExercise("datepicker", 3, "defult");

        WebElement displayInput = super.driver.findElement(By.id("datepicker"));
        displayInput.click();
        actions.pause(500).perform();

        WebElement displayYear = super.driver.findElement(By.cssSelector(".ui-datepicker-year"));
        Select displayYearSelect = new Select(displayYear);

        displayYearSelect.selectByVisibleText("2018");
        actions.pause(500).perform();

        WebElement displayMonth = super.driver.findElement(By.cssSelector(".ui-datepicker-month"));
        Select displayMonthSelect = new Select(displayMonth);

        displayMonthSelect.selectByVisibleText("Dec");
        actions.pause(500).perform();

        WebElement displayDay = super.driver.findElement(By.xpath("//a[text()='25']"));
        displayDay.click();
        actions.pause(500).perform();

        // Format date
        super.changeExercise("datepicker", 4, "defult");

        WebElement formatInput = super.driver.findElement(By.id("datepicker"));
        WebElement formatDropdown = super.driver.findElement(By.id("format"));
        Select formatSelect = new Select(formatDropdown);

        formatSelect.selectByVisibleText("Short - d M, y");
        actions.pause(500).perform();

        formatInput.click();
        actions.pause(500).perform();

        WebElement formatPrevArrow = super.driver.findElement(By.cssSelector(".ui-datepicker-prev"));
        formatPrevArrow.click();
        actions.pause(500).perform();

        // Redrawing
        formatPrevArrow = super.driver.findElement(By.cssSelector(".ui-datepicker-prev"));
        formatPrevArrow.click();
        actions.pause(500).perform();

        WebElement formatDay = super.driver.findElement(By.xpath("//a[text()='13']"));
        formatDay.click();
        actions.pause(500).perform();

        // Exit last iFrame
        super.exitIframe();
    }
}
