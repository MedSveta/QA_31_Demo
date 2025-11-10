package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test
    public void selectorsHomePageNext(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement footer = driver.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        WebElement divElements = driver.findElement(By.cssSelector(".card-up"));
        divElements.click();
        WebElement radioButton = driver.findElement(By.cssSelector("#item-2"));
        radioButton.click();
        WebElement radioButtonYes = driver.findElement(By.id("yesRadio"));
        //radioButtonYes.click();
        WebElement radioButtonYesLabel = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        radioButtonYesLabel.click();
        pause(3);
        driver.navigate().back();
        driver.navigate().back();
        WebElement divWidgets = driver.findElement(By
                .cssSelector("div[class='category-cards'] [class='card mt-4 top-card']:nth-child(4)"));
        divWidgets.click();
        pause(3);
        driver.navigate().back();
        pause(3);
        hideBanner();
        hideFooter();
        WebElement divBookStore = driver.findElement(By
                .cssSelector("div[class='category-cards'] [class='card mt-4 top-card']:last-child"));
        divBookStore.click();

        pause(3);
        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
