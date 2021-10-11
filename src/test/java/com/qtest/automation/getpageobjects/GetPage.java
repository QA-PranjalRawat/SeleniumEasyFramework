package com.qtest.automation.getpageobjects;

import org.openqa.selenium.*;

import static com.qtest.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static org.testng.Assert.fail;

public class GetPage extends BaseUi{

    protected WebDriver driver;
    String pageName;


    protected GetPage(WebDriver driver, String pageName) {
        super(driver,pageName);
        this.driver = driver;
        this.pageName = pageName;
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void alertHandlerAccept(){
        driver.switchTo().alert().accept();
    }
    protected void alertHandlerDismiss(){
        driver.switchTo().alert().dismiss();
    }
    protected void promptAlertHandler(String promptMessage){
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(promptMessage);
        promptAlert.accept();
    }


    protected WebElement element(String elementToken) {
        return element(elementToken, "");
    }
    protected WebElement element(String elementToken, String replacement)
            throws NoSuchElementException {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(driver
                    .findElement(getLocator(elementToken,replacement)));
        } catch (NoSuchElementException excp) {
            excp.printStackTrace();
            fail("FAILED: Element "+ elementToken + " not found on the " + this.pageName + " !!!");
        }
        return elem;
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);

        if(locator[2].contains("$")){
            locator[2] = locator[2].replace("$", replacement);
        }

        return getLocators(locator[1].trim(), locator[2].trim());
    }

    private By getLocators(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case xpath:
                return By.xpath(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }



}
