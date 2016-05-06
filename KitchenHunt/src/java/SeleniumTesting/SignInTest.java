/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SeleniumTesting;

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
	public void successfulLoginTest(){
		
		//Open firefox
		      WebDriver driver = new FirefoxDriver();
		
		//Go to the page specified
		driver.get("http://localhost:8080/KitchenHunt/index.jsp");
		
		//Get the html element with given id and set the value
                driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
                driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='signin_form']/div[1]/input")).sendKeys("viji.mallawaarachchi@gmail.com");
		driver.findElement(By.xpath("//*[@id='signin_form']/div[2]/input")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id='signin_form']/div[4]/input")).click();
//		String s = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a/div")).getText();
//		
//		System.out.println(s + " ==== ");
//		
//                Assert.assertTrue(s.equals("Vijini Mallawaarachchi"));
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
				
	}
        
        public static void main(String[] args) {
            SignInTest st = new SignInTest();
            st.successfulLoginTest();
    }
    
}
