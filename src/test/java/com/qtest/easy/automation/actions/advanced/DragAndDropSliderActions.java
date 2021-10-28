package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDropSliderActions extends GetPage {
    public DragAndDropSliderActions(WebDriver driver) {
        super(driver, "advanced/DragAndDropSlider");
    }

    public void dragAndDropSliderActionsClick(){
        logInfo("Clicking on Drag and Drop Slider");
        wait.waitForElementToBeClickable(element("dragDropBtn"));
        element("dragDropBtn").click();
        logInfo("Successfully Clicked on Drag and Drop Slider");
    }

    public void verifyDragAndDropSliderPage(){
        logInfo("Verifying Drag and Drop Slider Page");

        String expectedUrl = "drag-drop-range-sliders-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Drag and Drop Slider Page");
    }

    public void dragAndDropSlider(){
        // 4 xOffset = 1 slide approx for some points, starting is 51 range for 1 xOffset but in headless mode it's different
        logInfo("Verifying Functionality of Drag and Drop Slider");
        Actions drag = new Actions(driver);

        drag.dragAndDropBy(element("firstSlider"),0,0).perform();

        drag.dragAndDropBy(element("secondSlider"),100,0).perform();

        drag.dragAndDropBy(element("thirdSlider"),-100,0).perform();

        logInfo("Successfully Verified Functionality for Drag and Drop Slider");
        wait.hardWait(2);
    }

    public void clickAndHoldSlider(){
        // 4 xOffset = 1 slide approx for some points, starting is 51 range for 1 xOffset but in headless mode it's different
        logInfo("Verifying Functionality of Click and Hold Slider");

        Actions click = new Actions(driver);
        click.moveToElement(element("fourthSlider")).clickAndHold().moveByOffset(0,0).release().perform();

        click.moveToElement(element("fifthSlider")).clickAndHold().moveByOffset(100,0).release().perform();

        click.moveToElement(element("sixthSlider")).clickAndHold().moveByOffset(-100,0).release().perform();

        logInfo("Successfully Verified Functionality for Click and Hold Slider");
        wait.hardWait(1);
    }
}
