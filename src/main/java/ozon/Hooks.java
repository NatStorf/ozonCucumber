package ozon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void beforeHook(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.timeout = 7000;
    }
    @After
    public void afterHook(){
        WebDriverRunner.closeWebDriver();
    }
}
