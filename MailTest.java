package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailTest {
    private WebDriver driver;
    private String baseUrl;
    private String searchWord;
    private String  Login;
    private String  Password;
    private String Contact;
    private String Subject;
    private String Body;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://mail.google.com";
        Login = "qamanualtest1@gmail.com";
        Password = "autotest2";
        Contact = "bloodseeker100500@gmail.com";
        Subject = "Test mail";
        Body = "Hello! This is test mail";
    }

    @Test
    public void MailTest() throws Exception {
       driver.get(baseUrl);
       driver.findElement(By.xpath(".//*[@id='Email']")).clear();
       driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(Login);
       driver.findElement(By.xpath(".//*[@id='next']")).click();
       Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='Passwd']")).clear();
        driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys(Password);
        driver.findElement(By.xpath(".//*[@id='signIn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@class='T-I J-J5-Ji T-I-KE L3']")).click();
        Thread.sleep(1000);
        /*  driver.switchTo().activeElement().clear();
         driver.switchTo().activeElement().sendKeys(Contact);
         driver.switchTo().activeElement().sendKeys(Keys.ENTER);
         driver.switchTo().activeElement().sendKeys(Keys.TAB);
         driver.switchTo().activeElement().clear();
                                                                как вариант через табуляцию
         driver.switchTo().activeElement().sendKeys(Subject);
         driver.switchTo().activeElement().sendKeys(Keys.TAB);
         driver.switchTo().activeElement().clear();
         driver.switchTo().activeElement().sendKeys(Body);*/
         driver.findElement(By.xpath(".//*[@id=':9s']")).sendKeys(Contact);
         driver.findElement(By.xpath(".//*[@id=':9c']")).sendKeys(Subject);
         driver.findElement(By.xpath(".//*[@id=':ae']")).sendKeys(Body);
         driver.findElement(By.xpath(".//*[@id=':92']")).click();
          driver.findElement(By.linkText("Отправленные")).click();
        Thread.sleep(1500);
       assertEquals("Result", "Письмо отправлено. Просмотреть сообщение", driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div/div[3]/div/div/div[@class='vh']")).getText());

    }

    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }


}

