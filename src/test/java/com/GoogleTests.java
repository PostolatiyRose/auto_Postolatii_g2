package com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class GoogleTests {

    public WebDriver webDriver;

    @Test
    public void googleTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://www.google.com/");
        String title = webDriver.getTitle();
        Assert.assertEquals("Google", title);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).isDisplayed();
//        Assert.assertEquals("Google", tagName);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Acapulco");
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).submit();

        String text = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/a/h3")).getText();
        Assert.assertEquals("Acapulco Resort Convention SPA Hotel", text);


        String link = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/a/div/cite")).getText();
        Assert.assertEquals("https://www.acapulco.com.tr › ...", link);
        webDriver.quit();
    }

    @Test
    public void seleniumTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://www.acapulco.com.tr");

        String h2 = webDriver.findElement(By.xpath("/html/body/section[1]/div[4]/div[1]/a[1]")).getText();
        Assert.assertEquals("REZERVASYON",h2);


        String h22 = webDriver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[1]/a/h2")).getText();
        Assert.assertEquals("OTELİMİZ", h22);

        webDriver.findElement(By.xpath("/html/body/section[1]/div[4]/div[1]/a[2]/img")).click();
        webDriver.findElement(By.xpath("//*[@id=\"myNav\"]/div/div[1]/div/div[2]/a[3]")).click();
        webDriver.quit();
    }
}


