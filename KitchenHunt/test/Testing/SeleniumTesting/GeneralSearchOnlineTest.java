/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.SeleniumTesting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author User
 */
public class GeneralSearchOnlineTest {

    @Test
    public void successfulLSearchTest() throws InterruptedException {

        //Open firefox
        WebDriver driver = new FirefoxDriver();

        //Go to the page specified
        driver.get("http://www.kitchenhuntr.com/KitchenHunt/index.jsp");
        //Click on get started button
        driver.findElement(By.xpath("//*[@id=\"getStarted\"]/button")).click();
        //Enter recipe name
        driver.findElement(By.xpath("//*[@id=\"tags\"]")).sendKeys("Strawberry Milkshake");
        //Click on search button
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/form[1]/div[2]/button")).click();
        Thread.sleep(2000);
        
        //Get recipe name
        String name = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/h2")).getText();
        System.out.println("Entered recipe name = Strawberry Milkshake");
        System.out.println("Returned recipe name = " + name);
        //Check
        Assert.assertTrue(name.equals("Strawberry Milkshake"));
        
    }

    public static void main(String[] args) throws InterruptedException {
        GeneralSearchOnlineTest test = new GeneralSearchOnlineTest();
        test.successfulLSearchTest();
    }

}
