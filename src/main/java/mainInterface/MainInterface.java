package mainInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainInterface {

    public WebDriver driver;

    public static WebDriver initSuite() {
        WebDriverManager.chromedriver().setup();

        WebDriver suiteDriver = new ChromeDriver();

        suiteDriver.manage().window().maximize();
        suiteDriver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");

        return suiteDriver;
    }

    public static void changeTab(WebDriver driver, String originalWindow) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void closeExercisesSetTab(WebDriver driver, String originalWindow) {
        System.out.println("------------------------------- Set done: " + driver.getTitle() + "-------------------------------");

        driver.close();

        driver.switchTo().window(originalWindow);
    }

    public MainInterface(String startPage, WebDriver driver) {
        this.driver = driver;
        final String originalWindow = driver.getWindowHandle();

        WebElement setLink = driver.findElement(By.xpath("//a[@href='" + startPage + "']"));
        setLink.click();

        Actions actions = new Actions(driver);
        actions.pause(1500).perform();

        changeTab(driver, originalWindow);
    }

    public void enterIframe(By iFrameLocator) {
        WebElement iframe = driver.findElement(iFrameLocator);

        driver.switchTo().frame(iframe);
    }

    public void exitIframe() {
        driver.switchTo().defaultContent();
    }

    public void changeExercise(String exerciseId, int exerciseNumber, String iframePrefix) {
        exitIframe();
        WebElement constrained = driver.findElement(By.xpath("//a[@href='#example-1-tab-" + exerciseNumber + "']"));
        constrained.click();
        enterIframe(By.xpath("//iframe[@src='" + exerciseId + "/" + iframePrefix + exerciseNumber + ".html']"));
    }
}
