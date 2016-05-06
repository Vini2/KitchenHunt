/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.SeleniumTesting;

import SeleniumTesting.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author User
 */
public class GeneralSearchTest {

    @Test
    public void successfulLSearchTest() {

        //Open firefox
        WebDriver driver = new FirefoxDriver();

        //Go to the page specified
        driver.get("http://localhost:8080/KitchenHunt/index.jsp");

        //Click on get started button
        driver.findElement(By.xpath("//*[@id=\"getStarted\"]/button")).click();
        
        //Enter recipe name
        driver.findElement(By.xpath("//*[@id=\"tags\"]")).sendKeys("Summer Fruit Salad");
        
        //Click on search button
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/form/div[2]/button")).click();

        //Get recipe name
        String name = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/h2")).getText();

        System.out.println("recipe name = " + name);
        
        //Check
        Assert.assertTrue(name.equals("Summer Fruit Salad"));
        
    }

    public static void main(String[] args) {
        GeneralSearchTest test = new GeneralSearchTest();
        test.successfulLSearchTest();
    }

}
