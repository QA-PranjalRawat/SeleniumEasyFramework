package com.qtest.easy.automation.actions.advanced;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;


public class DragAndDropActions extends GetPage {
    public DragAndDropActions(WebDriver driver) {
        super(driver, "advanced/DragAndDrop");
    }

    public void dragAndDropClick(){
        logInfo("Clicking on Drag and Drop");

        wait.waitForElementToBeClickable(element("dragDropBtn"));
        element("dragDropBtn").click();
        logInfo("Successfully Clicked on Drag and Drop");
    }

    public void verifyDragAndDropPage(){
        logInfo("Verifying Drag and Drop Page");

        String expectedUrl = "drag-and-drop-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully verified Drag and Drop Page");
    }

    public void itemToDragAndDrop(){
        logInfo("Verifying the Functionality of Drag and Drop");

//       Since currently the drag and drop method is not working with html5 so the drag and drop method can't be used thus we use a Javascript workaround'

//        Actions drag = new Actions(driver);
//        drag.dragAndDrop(element("item1"),element("dropZone")).perform();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", element("item1"), element("dropZone"));

        List dragged = getElements("droppedList");
        Assert.assertTrue(dragged.contains("undefined"));
        System.out.println(dragged);
        wait.hardWait(1);
    }
}
