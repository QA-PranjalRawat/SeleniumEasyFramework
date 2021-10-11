package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RadioButttonActions extends GetPage {

    public RadioButttonActions(WebDriver driver) {
        super(driver,"basic/RadioButton");
    }

    public void clickOnRadioButton(){
        logInfo("Clicking on Radio Buttons Demo");

        wait.waitForElementToBeClickable(element("radioButtonClick"));
        element("radioButtonClick").click();

        logInfo("Successfully clicked on Radio Buttons Demo");
        wait.hardWait(1);
    }

    public void verifyRadioButton(){
        logInfo("Verifying Radio Buttons Demo Page");

        String ExpectedTitle = "Radio buttons demo";
        wait.waitForPageTitleToContain(ExpectedTitle);
        String ActualTitle = getPageTitle();


        Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
        logInfo("Radio Buttons Page Verified Successfully");
        wait.hardWait(1);
    }

    public void radioButtonDemo(){
        logInfo("Selecting Male value button");
        element("singleMaleRadio").click();

        logInfo("Retrieving get checked value");
        element("singleGetCheckedValueButton").click();

        logInfo("Verifying Checked Value");
        String maleValue = element("singleCheckedValue").getText();
        Assert.assertTrue(maleValue.contains("Male"));

        logInfo("Successfully Verified Male Radio Button");
        wait.hardWait(1);


        logInfo("Selecting Female value button");
        element("singleFemaleRadio").click();

        logInfo("Retrieving get checked value");
        element("singleGetCheckedValueButton").click();

        logInfo("Verifying Checked Value");
        String femaleValue = element("singleCheckedValue").getText();
        Assert.assertTrue(femaleValue.contains("Female"));

        logInfo("Successfully Verified Female Radio Button");
        wait.hardWait(1);
    }

    public void groupRadioButtonDemo(){
        refreshPage();
        logInfo("Verifying Male and 0 - 5 Age Group");
        logInfo("Selecting Male value button");
        element("groupMaleRadio").click();

        logInfo("Selecting 0 - 5 Age Group");
        element("groupAge0to5").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String male0to5 = element("groupValue").getText();
        Assert.assertTrue(male0to5.contains("Male"));
        Assert.assertTrue(male0to5.contains("0 - 5"));

        logInfo("Successfully Verified Male and 0 - 5 Age Group");
        wait.hardWait(1);



        refreshPage();
        logInfo("Verifying Male and 5 - 15 Age Group");
        logInfo("Selecting Male value button");
        element("groupMaleRadio").click();

        logInfo("Selecting 5 - 15 Age Group");
        element("groupAge5to15").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String male5to15 = element("groupValue").getText();
        Assert.assertTrue(male5to15.contains("Male"));
        Assert.assertTrue(male5to15.contains("5 - 15"));

        logInfo("Successfully Verified Male and 5 - 15 Age Group");
        wait.hardWait(1);


        refreshPage();
        logInfo("Verifying Male and 15 - 50 Age Group");
        logInfo("Selecting Male value button");
        element("groupMaleRadio").click();

        logInfo("Selecting 15 - 50 Age Group");
        element("groupAge15to50").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String male15to50 = element("groupValue").getText();
        Assert.assertTrue(male15to50.contains("Male"));
        Assert.assertTrue(male15to50.contains("15 - 50"));

        logInfo("Successfully Verified Male and 15 - 50 Age Group");
        wait.hardWait(1);


        refreshPage();
        logInfo("Verifying Female and 0 - 5 Age Group");
        logInfo("Selecting Female value button");
        element("groupFemaleRadio").click();

        logInfo("Selecting 0 - 5 Age Group");
        element("groupAge0to5").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String Female0to5 = element("groupValue").getText();
        Assert.assertTrue(Female0to5.contains("Female"));
        Assert.assertTrue(Female0to5.contains("0 - 5"));

        logInfo("Successfully Verified Female and 0 - 5 Age Group");
        wait.hardWait(1);


        refreshPage();
        logInfo("Verifying Female and 5 - 15 Age Group");
        logInfo("Selecting Female value button");
        element("groupFemaleRadio").click();

        logInfo("Selecting 5 - 15 Age Group");
        element("groupAge5to15").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String Female5to15 = element("groupValue").getText();
        Assert.assertTrue(Female5to15.contains("Female"));
        Assert.assertTrue(Female5to15.contains("5 - 15"));

        logInfo("Successfully Verified Female and 5 - 15 Age Group");
        wait.hardWait(1);


        refreshPage();
        logInfo("Verifying Female and 15 - 50 Age Group");
        logInfo("Selecting Female value button");
        element("groupFemaleRadio").click();

        logInfo("Selecting 15 - 50 Age Group");
        element("groupAge15to50").click();

        logInfo("Retrieving Get Values");
        element("groupGetValuesButton").click();

        logInfo("Verifying Get Values");
        String Female15to50 = element("groupValue").getText();
        Assert.assertTrue(Female15to50.contains("Female"));
        Assert.assertTrue(Female15to50.contains("15 - 50"));

        logInfo("Successfully Verified Female and 15 - 50 Age Group");
        wait.hardWait(1);
    }


}
