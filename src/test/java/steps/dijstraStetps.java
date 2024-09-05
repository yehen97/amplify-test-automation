package steps;

import actions.getProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class dijstraStetps extends BaseClass{



    //ids and xpath related
    private final By txtName = By.id("form name_name");
    private final By fromNode = By.xpath("//div[@id='fromNode']//div[contains(@class,'css-19bb58m')]");
    private final By toNode = By.xpath("//div[@id='toNode']//div[@class=' css-19bb58m']");
    private final By calculateBtn = By.xpath("//button[normalize-space()='Calculate']");
    private final By cleaBtn = By.xpath("//button[normalize-space()='Clear']");

    private final By errorMsg = By.xpath("//*[contains(text(),'Please ')]");



    //initialization of browser
    @Given("I want to open dijkstra page")
    public void iWantToOpenDijkstraPage() throws IOException {
        String exePath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        dr = new ChromeDriver();

        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.get(getProperties.getProperty("BaseURL"));

        dr.manage().window().maximize();
    }

   // closed the browser every testcase
    @After
    public void driverQuit() {
        dr.quit();
    }


    @And("I want to select from node as {string}")
    public void iWantToSelectFromNodeAs(String from) throws InterruptedException {

        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement dropdownToggle = dr.findElement(fromNode);
        dropdownToggle.click();


        Thread.sleep(3000);
        WebElement selector = dr.findElement(By.xpath("//div[normalize-space()='" + from + "']"));

        // Use Actions to click the desired option
        Actions actions = new Actions(dr);
        actions.moveToElement(selector).click().perform();

    }

    @And("I want to select To node as {string}")
    public void iWantToSelectToNodeAs(String to) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement dropdownToggle = dr.findElement(toNode);
        dropdownToggle.click();
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement selector = dr.findElement(By.xpath("//div[normalize-space()='" + to + "']"));

        // Use Actions to click the desired option
        Actions actions = new Actions(dr);
        actions.moveToElement(selector).click().perform();
    }

    @And("I want to click on Calculate button")
    public void iWantToClickOnCalculateButton() throws InterruptedException {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(calculateBtn).click();

        Thread.sleep(4000);
    }

    @Then("I want verify results are showing as {string}")
    public void iWantVerifyResultsAreShowingAs(String results) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(resultValue).isDisplayed();
        String txt = dr.findElement(resultValue).getText();
        System.out.println(txt);
        Assert.assertEquals(txt, "Total Distance: "+results);
           }

    @And("I want to click on Clear button")
    public void iWantToClickOnClearButton() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(cleaBtn).click();
    }

    @Then("I want verify nodes are cleared")
    public void iWantVerifyNodesAreCleared() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement node = dr.findElement(toNode);
        String val = node.getText();
        Assert.assertEquals(val,"");

        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement node2 = dr.findElement(fromNode);
        String val2 = node2.getText();
        Assert.assertEquals(val2,"");
    }

    @Then("I want verify error message as {string}")
    public void iWantVerifyErrorMessageAs(String message) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       String error = dr.findElement(errorMsg).getText();
       Assert.assertEquals(error,message);
    }


}
