package com.qtest.easy.automation.tests.advanced;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class DragAndDropSlider extends Advanced{

    @Test(priority = 1)
    public void TC_280_verify_drag_drop_slider_click(){
        logger = extent.createTest("TC_280_verify_drag_drop_slider_click");
        dragAndDropSliderActions.dragAndDropSliderActionsClick();
        dragAndDropSliderActions.verifyDragAndDropSliderPage();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 2)
    public void TC_281_drag_and_drop_slider(){
        logger = extent.createTest("TC_281_drag_and_drop_slider1");
        dragAndDropSliderActions.dragAndDropSlider();
        logger.log(Status.PASS,"Test Case Passed");
    }

    @Test(priority = 3)
    public void TC_282_click_and_hold_slider(){
        logger = extent.createTest("TC_282_click_and_hold_slider");
        dragAndDropSliderActions.clickAndHoldSlider();
        logger.log(Status.PASS,"Test Case Passed");
    }
}
