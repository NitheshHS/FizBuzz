package playwritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TraceViewer {
    private BrowserContext context = null;

    /**
     * Start tracing before creating / navigating a page.
     * @param browser
     * @param enableScreenshot
     * @param enableSnapshot
     */
    public BrowserContext createTraceViewer(Browser browser, Boolean enableScreenshot, Boolean enableSnapshot, boolean enableSource) {
        context = browser.newContext();
        context.tracing()
                .start(new Tracing.StartOptions()
                        .setScreenshots(enableScreenshot)
                        .setSnapshots(enableSnapshot)
                        .setSources(enableSource));
        return context;
    }

    /**
     *Stop tracing and export it into a zip archive.
     * @param tracePath
     */
    public void stopTrace(String tracePath) {
        try {
            context.tracing()
                    .stop(new Tracing.StopOptions().setPath(Paths.get("./"+tracePath+".zip")));
        }catch (Exception e){
            throw new RuntimeException("Browser context is null. Cannot store trace in this file: "+tracePath);
        }

    }
}
