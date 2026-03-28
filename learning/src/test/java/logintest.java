import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;
public class logintest {

    @Test
    public void login() throws InterruptedException
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(false)
            .setArgs(Arrays.asList("--start-maximized"))); // Start browser window maximized
        
        // Remove Playwright's default viewport restriction so it takes up the full browser window
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        
        // --- Added Logging ---
        // 1. Log to your standard Java output console
        System.out.println("Test Status: Navigating to Google...");
        
        // 2. Listen to all messages from the browser's DevTools console and print them
        page.onConsoleMessage(msg -> System.out.println("Browser Console: " + msg.text()));
        // ---------------------
        
        page.navigate("https://www.google.com/?zx=1774724063202&no_sw_cr=1");
        System.out.println("Test Status: Saved page snapshot.");
page.screenshot(new Page.ScreenshotOptions()
  .setPath(Paths.get("Screenshot","fullpage.png"))
  .setFullPage(true));


        Thread.sleep(3000);
        browser.close();
        

    }
}
