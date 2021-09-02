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



        driver.get("https://vk.com/im?peers=176522155_c159_c165_35302391&sel=398426844");
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement passwdField=driver.findElement(By.id("pass"));
        WebElement loginField=driver.findElement(By.id("email"));
        WebElement loginBtn=driver.findElement(By.id("login_button"));
        passwdField.sendKeys("Pass Here");//пароль
        loginField.sendKeys("login here");//логин
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("l_msg")));
        WebElement massenger = driver.findElement(By.id("l_msg"));
        massenger.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("im_dialogs_search")));
        WebElement search_line = driver.findElement(By.id("im_dialogs_search"));
        search_line.sendKeys("Евгения");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-list-id='317787977cr']")));
        WebElement dialog = driver.findElement(By.cssSelector("li[data-list-id='317787977cr']"));
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
