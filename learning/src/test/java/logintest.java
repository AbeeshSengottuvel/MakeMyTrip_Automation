import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class logintest {

    @Test
    public void login() throws InterruptedException
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        
        Page page = browser.newPage();
        page.navigate("https://www.google.com/");
        

    }
}
