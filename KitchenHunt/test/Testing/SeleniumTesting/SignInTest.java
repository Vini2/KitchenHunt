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
public class SignInTest {

    @Test
    public void successfulLoginTest() {

        //Open firefox
        WebDriver driver = new FirefoxDriver();

        //Go to the page specified
        driver.get("http://localhost:8080/KitchenHunt/index.jsp");

        //Click on My Kitchen link
        driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
        
        //Click on Sign In link
        driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[2]/a")).click();
        
        //Enter email
        driver.findElement(By.xpath("//*[@id='signin_form']/div[1]/input")).sendKeys("viji.mallawaarachchi@gmail.com");
        
        //Enter password
        driver.findElement(By.xpath("//*[@id='signin_form']/div[2]/input")).sendKeys("123");
        
        //Click Sign In button
        driver.findElement(By.xpath("//*[@id='signin_form']/div[4]/input")).click();

        //Get name of user logged in
        String name = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a")).getText();

        System.out.println("name = " + name);

        //Check
        Assert.assertTrue(name.equals("Vijini Mallawaarachchi"));

    }

    public static void main(String[] args) {
        SignInTest st = new SignInTest();
        st.successfulLoginTest();
    }

}
