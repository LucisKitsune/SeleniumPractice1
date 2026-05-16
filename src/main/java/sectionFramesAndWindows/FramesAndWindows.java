package sectionFramesAndWindows;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class FramesAndWindows extends MainInterface {
    private String originalPage;

    public FramesAndWindows(String startPage, String originalPage, WebDriver driver) {
        super(startPage, driver);

        this.originalPage = originalPage;
    }

    private void changeToTabWindow(String originalWindow) {
        List<String> protectedWindows = Arrays.asList(originalWindow, this.originalPage);

        for (String handle : super.driver.getWindowHandles()) {
            if (!protectedWindows.contains(handle)) {
                super.driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void initTests() {
        // Enter iFrame
        super.enterIframe(By.xpath("//iframe[@src='frames-windows/defult1.html']"));

        // Actions
        Actions actions = new Actions(super.driver);

        // Default
        final String originalWindow = super.driver.getWindowHandle();

        WebElement defaultLink = super.driver.findElement(By.xpath("//a[text()='New Browser Tab']"));
        defaultLink.click();

        actions.pause(1000).perform();

        changeToTabWindow(originalWindow);

        System.out.println("New tab: " + super.driver.getTitle());

        super.driver.close();

        super.driver.switchTo().window(originalWindow);

        // Open separate window
        super.changeExercise("frames-windows", 2, "defult");

        WebElement separateLink = super.driver.findElement(By.xpath("//a[text()='Open New Seprate Window']"));
        separateLink.click();

        actions.pause(1000).perform();

        changeToTabWindow(originalWindow);

        System.out.println("New window: " + super.driver.getTitle());

        super.driver.close();

        super.driver.switchTo().window(originalWindow);

        // Frameset
        super.changeExercise("frames-windows", 3, "defult");

        WebElement frameSetLink = super.driver.findElement(By.xpath("//a[@href='frameset.html']"));
        frameSetLink.click();

        actions.pause(1000).perform();

        changeToTabWindow(originalWindow);

        System.out.println("New frameset: " + super.driver.getTitle());

        WebElement frameSetElement = super.driver.findElement(By.tagName("frameset"));

        JavascriptExecutor js = (JavascriptExecutor) super.driver;

        js.executeScript(
                "arguments[0].setAttribute('rows', '30%,70%');",
                frameSetElement
        );

        super.enterIframe(By.name("topFrame"));

        WebElement frameSetH2_1 = super.driver.findElement(By.tagName("h2"));
        WebElement frameSetP_1 = super.driver.findElement(By.tagName("p"));

        System.out.println("Top frame content: " + frameSetH2_1.getText() + "\n" + frameSetP_1.getText());

        super.exitIframe();

        super.enterIframe(By.name("contentFrame"));

        WebElement frameSetH2_2 = super.driver.findElement(By.tagName("h2"));
        WebElement frameSetP_2 = super.driver.findElement(By.tagName("p"));

        System.out.println("Content frame content: " + frameSetH2_2.getText() + "\n" + frameSetP_2.getText());

        super.exitIframe();

        super.driver.close();

        super.driver.switchTo().window(originalWindow);

        // Open multiple windows
        super.changeExercise("frames-windows", 4, "defult");

        WebElement multipleLink = super.driver.findElement(By.xpath("//a[text()='Open multiple pages']"));
        multipleLink.click();

        int i = 1;
        List<String> protectedWindows = Arrays.asList(originalWindow, this.originalPage);

        for (String handle : super.driver.getWindowHandles()) {
            if (!protectedWindows.contains(handle)) {
                super.driver.switchTo().window(handle);
                System.out.println("New window " + i++ + ": " + super.driver.getTitle());
                super.driver.close();
            }
        }

        super.driver.switchTo().window(originalWindow);

        // Exit last iFrame
        super.exitIframe();
    }
}
