package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public static WebDriver dr = null;

    public final By resultValue = By.xpath("(//p[@class='text-sm text-[#5A5B5D]'])[1]");
}
