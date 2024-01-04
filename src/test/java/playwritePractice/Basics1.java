package playwritePractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenSize;
import org.testng.annotations.Test;

import javax.naming.Context;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Basics1 {
    TraceViewer traceViewer=new TraceViewer();
    BrowserContextUtil browserContextUtil=new BrowserContextUtil();
    @Test
    public void launchBrowser() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(setHeadLess(false));
        /*create context to trace*/
        BrowserContext context = traceViewer.createTraceViewer(browser, true, true, true);
        Page page = context.newPage();
        page.navigate("https://www.flipkart.com/");
        System.out.println(page.url());
        System.out.println(page.title());
        Locator closeBtn = page.getByText("✕");
        if(closeBtn.isVisible()) closeBtn.click();
        /*stop trace*/
        traceViewer.stopTrace("LoginTrace_UI");
        page.close();
        playwright.close();

    }

    @Test
    public void multiplePageContext(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(setHeadLess(false));

        /*Launch Flipkart*/
        Page page1 = browserContextUtil.launchNewBrowserContext(browser);
        page1.navigate("https://www.flipkart.com/");
        System.out.println(page1.url());

        /*Launch Myntra*/
        Page page2 = browserContextUtil.launchNewBrowserContext(browser);
        page2.navigate("https://www.orangehrm.com/");
        System.out.println(page2.url());

        browser.contexts().stream().forEach(pages->pages.pages());
        //browser.close();

    }

    public BrowserType.LaunchOptions setHeadLess(boolean isHeadless) {
        return new BrowserType.LaunchOptions().setHeadless(isHeadless).setArgs(List.of("--start-maximized"));
    }

    @Test
    public void locatorTest() throws IOException {
        Browser browser = Playwright.create().chromium().launch(setHeadLess(false));
        BrowserContext context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setSources(true)
                .setSnapshots(true)
                .setScreenshots(true));
        Page page = context.newPage();
        browser.startTracing(page);
        page.navigate("https://demo.opencart.com/");
        Locator desktop = page.locator("//a[text()='Desktops']");
        System.out.println(desktop.textContent());
        Locator Currency = page.locator("form#form-currency span:has-text('Currency')");
        System.out.println(Currency.textContent());
        Currency.click();
        Locator listOfCurrency = page.locator("form#form-currency ul li a.dropdown-item");
        listOfCurrency.allTextContents().forEach(System.out::println);
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("./trace.zip")));
        browser.close();
    }


}
