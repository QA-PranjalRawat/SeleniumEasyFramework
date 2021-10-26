package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DragAndDrop extends Advanced{

    @Test(priority = 1)
    public void TC_290_verify_drag_and_drop_click(){
        logger = extent.createTest("TC_290_verify_drag_and_drop_click");
        dragAndDropActions.dragAndDropClick();
        dragAndDropActions.verifyDragAndDropPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_291_item_to_drag_and_drop(){
        logger = extent.createTest("TC_291_item_to_drag_and_drop");
        dragAndDropActions.itemToDragAndDrop();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
