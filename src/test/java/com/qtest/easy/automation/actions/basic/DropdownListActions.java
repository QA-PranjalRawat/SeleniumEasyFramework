package com.qtest.easy.automation.actions.basic;

import com.qtest.automation.getpageobjects.GetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class DropdownListActions extends GetPage {

    public DropdownListActions(WebDriver driver) {
        super(driver, "basic/DropdownList");
    }

    public void clickOnDropdownList(){
        logInfo("Clicking on Select Dropdown List");

        wait.waitForElementToBeClickable(element("dropdownListClick"));
        element("dropdownListClick").click();

        logInfo("Successfully clicked on Select Dropdown List");
        wait.hardWait(1);
    }

    public void verifyDropdownPage(){
        logInfo("Verifying Dropdown List Page");

        String ExpectedUrl = "basic-select-dropdown-demo.html";
        String ActualUrl = getCurrentURL();


        Assert.assertTrue(ActualUrl.contains(ExpectedUrl));
        logInfo("Dropdown List Page Verified Successfully");
        wait.hardWait(1);
    }

    public void singleSelectList(){
        logInfo("Processing Single Select List Demo");

        Select day = new Select(element("singleSelectList"));

        logInfo("Selecting Value from List");
        String value = "Tuesday";
        day.selectByValue(value);

        logInfo("Verifying Selected Day");
        String singleSelectedValue = element("singleSelectedValue").getText();
        Assert.assertTrue(singleSelectedValue.contains(value));

        logInfo("Successfully Verified Single Select List Demo");
        wait.hardWait(1);
    }


//    [California, Florida, New Jersey, New York, Ohio, Texas, Pennsylvania, Washington]
    public void multiSelectList(){
        refreshPage();

        logInfo("Selecting Multi Values from Dropdown List");

        Select city = new Select(element("multiSelectList"));

        logInfo("Selecting Florida, Index[7], Ohio, Texas");
        List<String> selectCity=new ArrayList<String>();
        selectCity.add("Florida");
        selectCity.add("Washington");
        selectCity.add("Ohio");
        selectCity.add("Texas");

        city.selectByVisibleText("Florida");
        city.selectByIndex(7);
        city.selectByValue("Ohio");
        city.selectByValue("Texas");

        logInfo("Verifying First Selected city value");
        element("multiFirstSelected").click();
        String firstMultiSelectedValue = element("multiSelectedValues").getText();

        try {
            Assert.assertTrue(firstMultiSelectedValue.contains("Florida"));
            logInfo("Successfully Verified First Multi Selected Value");
        }catch(AssertionError e) {
            String firstOption = city.getFirstSelectedOption().getText();
            Assert.assertTrue(firstOption.contains("Florida"));
            logFail("The First Selected value is providing wrong output because the event in the button using ctrlKey for multi select");
        }

        wait.hardWait(1);



        logInfo("Verifying All Selected city values");
        element("multiGetAllSelected").click();
        String AllMultiSelectedValue = element("multiSelectedValues").getText();
        try {
            Assert.assertTrue(AllMultiSelectedValue.contains("Florida"));
            Assert.assertTrue(AllMultiSelectedValue.contains("Washington"));
            Assert.assertTrue(AllMultiSelectedValue.contains("Ohio"));
            Assert.assertTrue(AllMultiSelectedValue.contains("Texas"));

            logInfo("Successfully Verified All Multi Selected Value");
        }catch(AssertionError e) {
            List<WebElement> selectedOptn = city.getAllSelectedOptions();

            for (WebElement item : selectedOptn)
                Assert.assertTrue(selectCity.contains(item.getText()));


            logFail("The Get all selected button is providing wrong output because the event in the button using ctrlKey for multiple selection");

        }

        wait.hardWait(1);

    }
}
