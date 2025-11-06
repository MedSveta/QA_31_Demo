package experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        // driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(3);
        driver.navigate().to("https://demoqa.com/elements");
        pause(3);
        driver.navigate().back();
        pause(3);
        driver.navigate().refresh();
        pause(3);
        // driver.close();// закрывает одно активное окно
        driver.quit(); // закрывает браузер
    }

    public void pause(int time) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
