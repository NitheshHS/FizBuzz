package playwritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class BrowserContextUtil {

    public Page launchNewBrowserContext(Browser browser){
        BrowserContext context = browser.newContext();
        return context.newPage();
    }
}
