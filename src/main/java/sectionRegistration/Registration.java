package sectionRegistration;

import mainInterface.MainInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Registration extends MainInterface {
    public Registration(String startPage, WebDriver driver) { super(startPage, driver); }

    public void initTests() {
        // Actions
        Actions actions = new Actions(super.driver);

        WebElement submit = super.driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();

        WebElement name = super.driver.findElement(By.name("name"));
        name.sendKeys("Juan Gabriel");

        WebElement lastName = super.driver.findElement(By.xpath("//label[text()='Last Name:']/following-sibling::input"));
        lastName.sendKeys("Aguilera Valadez");

        WebElement maritalStatus = super.driver.findElement(By.xpath("//label[contains(normalize-space(), 'Single')]/input"));
        maritalStatus.click();

        WebElement hobby = super.driver.findElement(By.xpath("//label[contains(normalize-space(), 'Reading')]/input"));
        hobby.click();

        WebElement country = super.driver.findElement(By.xpath("//label[text()='Country:']/following-sibling::select"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("India"); // Wacala

        List<WebElement> dateOfBirthSelects = super.driver.findElements(By.xpath("//label[text()='Date of Birth:']/following-sibling::div/select"));
        Select month = new Select(dateOfBirthSelects.get(0));
        Select day = new Select(dateOfBirthSelects.get(1));
        Select year = new Select(dateOfBirthSelects.get(2));

        month.selectByVisibleText("1");
        day.selectByVisibleText("1");
        year.selectByVisibleText("2014");

        WebElement phone = super.driver.findElement(By.name("phone"));
        phone.sendKeys("01 800 6969 6969");

        WebElement username = super.driver.findElement(By.name("username"));
        username.sendKeys("elAnoAno69");

        WebElement email = super.driver.findElement(By.name("email"));
        email.sendKeys("juanga@noanoa.com");

        WebElement about = super.driver.findElement(By.cssSelector("input[type='file']"));
        about.sendKeys("/home/lucis_kitsune/Downloads/LoQueSeVeNoSePregunta.txt");

        WebElement file = super.driver.findElement(By.tagName("textarea"));
        file.sendKeys("Lo que se ve, no se pregunta.");

        WebElement password = super.driver.findElement(By.name("password"));
        password.sendKeys("hartodelavagina");

        WebElement confirmPassword = super.driver.findElement(By.name("c_password"));
        confirmPassword.sendKeys("hartodelavagina");

        actions.pause(1000).perform();
        submit.click();
    }
}
