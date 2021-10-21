package com.qtest.automation.getpageobjects;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.qtest.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static org.testng.Assert.fail;

public class GetPage extends BaseUi{

    protected WebDriver driver;
    String pageName;


    public GetPage(WebDriver driver, String pageName) {
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

    protected List<String> windowsHandler(){
        String mainWindow = driver.getWindowHandle();
        Set<String> childWindowList = driver.getWindowHandles();
        List<String> Titles = new ArrayList<>();
        Iterator<String> I1 = childWindowList.iterator();

        while (I1.hasNext()) {
            String childWindow = I1.next();
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                wait.waitForPageToLoadCompletely();
                String title = driver.switchTo().window(childWindow).getTitle();
                Titles.add(title);
                driver.close();
            }

        }
        wait.hardWait(1);
        driver.switchTo().window(mainWindow);
        return Titles;
    }

    public void popUpHandler(String popUpBtn){
        logInfo("Activating pop up handler");
        try {
            element(popUpBtn).click();
            logInfo("Pop Up Successfully Handled");
        }
        catch(Exception e){
            logInfo("Pop Up didn't arise");
        }
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

    protected List<WebElement> elements(String elementToken) {
        return elements(elementToken, "");
    }

    protected List<WebElement> elements(String elementToken, String replacement) {
        return wait.waitForElementsToBeVisible(driver.findElements(getLocator(
                elementToken, replacement)));
    }

    protected List<WebElement> elementsHiddens(String elementToken, String replacement) {
        return (driver.findElements(getLocator(
                elementToken, replacement)));
    }

    protected boolean contains(String elementToken, Object value){
        List<String> listElements = new ArrayList<>();
        int len = elements(elementToken).size();
        for(int i=0;i<len;i++){
            listElements.add((elements(elementToken).get(i).getText()).trim());
        }
        return listElements.contains(value);
    }

    protected List<String> getElements(String elementToken){
        List<String> listElements = new ArrayList<>();
        int len = elements(elementToken).size();
        for(int i=0;i<len;i++){
            String ele = (elements(elementToken).get(i).getText()).trim();
            listElements.add(ele);
        }
        return listElements;
    }

    protected List<String> getElementsHiddens(String elementToken){
        List<String> listElements = new ArrayList<>();
        int len = elementsHiddens(elementToken,"").size();
        for(int i=0;i<len;i++){
            String ele = (elementsHiddens(elementToken,"").get(i).getText()).trim();
            if (!ele.isEmpty()){
                listElements.add(ele);
            }
        }
        return listElements;
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
