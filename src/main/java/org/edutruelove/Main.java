package org.edutruelove;

import mainInterface.MainInterface;
import org.openqa.selenium.WebDriver;
import sectionAlert.Alert;
import sectionDynamicElements.Dropdown;
import sectionDynamicElements.SubmitButtonClicked;
import sectionFramesAndWindows.FramesAndWindows;
import sectionInteraction.*;
import sectionRegistration.Registration;
import sectionWidget.*;

public class Main {

    static void tests(WebDriver driver, String originalWindow) throws InterruptedException {
        // Interaction
        Draggable draggable = new Draggable("draggable.php", driver);
        draggable.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Droppable droppable = new Droppable("droppable.php", driver);
        droppable.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Resizable resizable = new Resizable("resizable.php", driver);
        resizable.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        // Widgets
        Accordion accordion = new Accordion("accordion.php", driver);
        accordion.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Autocomplete autocomplete = new Autocomplete("autocomplete.php", driver);
        autocomplete.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        DatePicker datePicker = new DatePicker("datepicker.php", driver);
        datePicker.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Tabs tabs = new Tabs("tabs.php", driver);
        tabs.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Tooltip tooltip = new Tooltip("tooltip.php", driver);
        tooltip.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        // Frames and Windows
        FramesAndWindows framesAndWindows = new FramesAndWindows("frames-and-windows.php", originalWindow, driver);
        framesAndWindows.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        // Dynamic Elements
        SubmitButtonClicked submitButtonClicked = new SubmitButtonClicked("submit_button_clicked.php", driver);
        submitButtonClicked.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        Dropdown dropdown = new Dropdown("dropdown.php", driver);
        dropdown.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        // Registration
        Registration registration = new Registration("registration.php", driver);
        registration.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        // Alert
        Alert alert = new Alert("alert.php", driver);
        alert.initTests();

        MainInterface.closeExercisesSetTab(driver, originalWindow);

        System.out.println("ALL SETS DONE!");
        driver.quit();
    }

    static void main() throws InterruptedException {
        WebDriver driver = MainInterface.initSuite();
        final String originalWindow = driver.getWindowHandle();

        tests(driver, originalWindow);
    }
}
