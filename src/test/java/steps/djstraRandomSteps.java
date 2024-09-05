package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class djstraRandomSteps extends BaseClass{

    private final By toggle = By.xpath("//div[contains(@class,'peer-checked:bg-color-secondary')]");
    private final By refresh = By.xpath("//img[contains(@src,'/refresh.svg')]");
    private final By calRanBtn = By.xpath("//button[normalize-space()='Calculate Random']");


    @And("I want click on enable random mode")
    public void iWantClickOnEnableRandomMode() throws InterruptedException {
        Thread.sleep(3000);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(toggle).click();
    }

    @And("I want to click on Calculate Random button")
    public void iWantToClickOnCalculateRandomButton() throws InterruptedException {
        Thread.sleep(3000);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(calRanBtn).click();
        Thread.sleep(5000);

    }

    @And("I want to click on Refresh button")
    public void iWantToClickOnRefreshButton() throws InterruptedException {
        Thread.sleep(3000);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(refresh).click();
        Thread.sleep(3000);
    }

    @And("I want verify page change to random mode")
    public void iWantVerifyPageChangeToRandomMode() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       boolean val = dr.findElement(calRanBtn).isDisplayed();
       Assert.assertTrue(val);

    }


    @Then("I want to verify results dislpayed")
    public void iWantToVerifyResultsDislpayed() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        boolean val = dr.findElement(resultValue).isDisplayed();
        Assert.assertTrue(val);

    }
}
