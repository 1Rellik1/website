import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();



        driver.get("https://vk.com");
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("index_pass")));
        WebElement passwdField=driver.findElement(By.id("index_pass"));
        WebElement loginField=driver.findElement(By.id("index_email"));
        WebElement loginBtn=driver.findElement(By.id("index_login_button"));
        passwdField.sendKeys("pass");//пароль
        loginField.sendKeys("login");//логин
        loginBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("l_msg")));
        WebElement massenger = driver.findElement(By.id("l_msg"));
        massenger.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("im_dialogs_search")));
        WebElement search_line = driver.findElement(By.id("im_dialogs_search"));
        search_line.sendKeys("Имя");//название беседы или человека
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-list-id='числа id cr']")));//в коде вк найди id нужной беседы
        WebElement dialog = driver.findElement(By.cssSelector("li[data-list-id='числа id cr']"));
        dialog.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='textbox']")));
        WebElement textbox = driver.findElement(By.cssSelector("div[role='textbox']"));
        int i=0;
        while (i<20) {
            textbox.sendKeys("Го гулять");
            textbox.sendKeys(Keys.ENTER);
            i++;
            Thread.sleep(2000);
        }
//        WebElement sendmessage = driver.findElement(By.cssSelector("button[aria-label='Отправить']"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        sendmessage.click();
        Thread.sleep(1000);
        driver.quit();

    }
}
