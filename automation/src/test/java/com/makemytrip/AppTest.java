package com.makemytrip;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*; 

public class AppTest {

    @Test
    void myFirstTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.google.com");
            
            // Validation
            Assertions.assertEquals("Google", page.title());
            
            browser.close();
        }
    }
}