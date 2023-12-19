package playwriteAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class LaunchBrowserTests {
    @Test
    public void launchBrowser(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(setHeadLess(false));
        Page page = browser.newPage();
        page.navigate("https://www.amazon.in/");
        System.out.println(page.url());
        System.out.println(page.title());
        System.out.println(page.getByTestId("nav-logo-sprites").isVisible());
        page.close();
        playwright.close();
    }

    public BrowserType.LaunchOptions setHeadLess(boolean isHeadless){
       return new BrowserType.LaunchOptions().setHeadless(isHeadless);
    }
}
