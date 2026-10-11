package SE.ChangeCokpitAutomation.Tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        String url = "https://www.google.com";

        System.out.println("URL = " + url);

        driver.get(url);

        System.out.println("Current URL = " + driver.getCurrentUrl());
        System.out.println("Title = " + driver.getTitle());

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.quit();
    }
}