package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class WindowPopupModelActions extends GetPage {

    public WindowPopupModelActions(WebDriver driver) {
        super(driver, "basic/WindowPopupModel");
    }

    public void windowPopupModelClick() {
        logInfo("Clicking on Window Popup Model");

        wait.waitForElementToBeClickable(element("windowPopupClick"));
        element("windowPopupClick").click();

        logInfo("Successfully Clicked on Window Popup Model");
    }

    public void verifyWindowPopupModelPage() {
        logInfo("Verifying Window Popup Model Page");

        String expectedUrl = "window-popup-modal-demo.html";
        String actualUrl = getCurrentURL();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        logInfo("Successfully Verified Window Popup Model Page");
    }

    public void singleWindowPopup() {
        logInfo("Performing Single window popup operation");

        logInfo("Clicking on Follow on Twitter");
        element("followOnTwitter").click();

        List<String> twitterTitle = windowsHandler();
        Assert.assertTrue(twitterTitle.get(0).contains("Twitter"));

        logInfo("Twitter Window Popup Successfully Handled");


        logInfo("Clicking on Like us on Facebook");
        element("likeOnFacebook").click();

        List<String> facebookTitle = windowsHandler();
        Assert.assertTrue(facebookTitle.get(0).contains("Facebook"));

        logInfo("Facebook Window Popup Successfully Handled");

        logInfo("Successfully Verified Single Window Popup");
        wait.hardWait(1);

    }

    public void multipleWindowModal(){
        logInfo("Performing Multi Window Modal Operation");

        logInfo("Clicking on Follow Twitter & Facebook");
        element("twoWindows").click();

        List<String> twoWindows = windowsHandler();
        Assert.assertTrue(twoWindows.get(0).contains("Facebook"));
        Assert.assertTrue(twoWindows.get(1).contains("Twitter"));

        logInfo("Twitter & Facebook windows successfully handled");

        logInfo("Clicking on Follow All");
        element("threeWindows").click();

        List<String> threeWindows = windowsHandler();
        Assert.assertTrue(threeWindows.get(0).contains("Google"));
        Assert.assertTrue(threeWindows.get(1).contains("Twitter"));
        Assert.assertTrue(threeWindows.get(2).contains("Facebook"));

        logInfo("Google, Twitter & Facebook windows successfully handled");

        logInfo("Successfully Verified Multi Window Modal");
        wait.hardWait(1);
    }
}
