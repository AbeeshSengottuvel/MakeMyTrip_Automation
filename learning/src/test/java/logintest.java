import java.util.Arrays;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class logintest {

    @Test
    public void login() throws InterruptedException
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setArgs(Arrays.asList("--start-maximized")) // Note the 's' in Arrays
        .setHeadless(false));
        
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        
        assertThat(page.getByAltText("Welcome to the-internet")).hasText("Welcome to the-internet");

        Thread.sleep(10000);

        page.close();
        browser.close();

    }
}
