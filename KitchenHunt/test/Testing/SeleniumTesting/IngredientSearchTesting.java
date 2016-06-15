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


/**
 *
 * @author User
 */
public class IngredientSearchTesting {

    @Test
    public void successfulLSearchTest() throws InterruptedException {

        //Open firefox
        WebDriver driver = new FirefoxDriver();

        //Go to the page specified
        driver.get("http://localhost:8080/KitchenHunt/index.jsp");

        //Click on get started button
        driver.findElement(By.xpath("//*[@id=\"getStarted\"]/button")).click();
        
        //Enter ingredient
        driver.findElement(By.xpath("//*[@id=\"recipe_inc_ing\"]")).sendKeys("strawberries");
        
        //Click on search button
        driver.findElement(By.xpath("//*[@id=\"testform\"]/button")).click();

        Thread.sleep(2000);
        
        
    }

    public static void main(String[] args) throws InterruptedException {
        IngredientSearchTesting test = new IngredientSearchTesting();
        test.successfulLSearchTest();
    }

}

