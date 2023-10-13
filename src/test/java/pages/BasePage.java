package pages;

import base.TestUtil;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends TestUtil {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public abstract boolean isAt();
}
