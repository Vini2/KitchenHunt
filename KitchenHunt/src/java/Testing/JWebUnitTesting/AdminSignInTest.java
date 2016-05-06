/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.JWebUnitTesting;

import JWebUnitTesting.*;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.*;

/**
 *
 * @author User
 */
public class AdminSignInTest {

    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);    // use HtmlUnit
        setBaseUrl("http://localhost:8080/KitchenHunt");
    }

    @Test
    public void testSignIn() {

        beginAt("admin_signin.jsp"); //Open the browser on http://localhost:8080/KitchenHunt/admin_signin.jsp
        assertTitleEquals("Kitchen Hunt - Admin Sign In");    // we should be on the Kitchen Hunt - Admin Sign In page

        // fill out the form
        //assertLinkNotPresent("Logout");		// we should not be logged in
        assertFormPresent("login_form");
        assertFormElementPresent("signin_email");
        assertFormElementPresent("signin_password");
        setTextField("signin_email", "viji.mallawaarachchi@gmail.com");
        setTextField("signin_password", "123");
        
        assertFormElementEquals("signin_email", "viji.mallawaarachchi@gmail.co");
        assertFormElementEquals("signin_password", "123");
        
        submit();

        // now that we have filled out the form,
        assertTitleEquals("Kitchen Hunt - Admin Sign In");

    }

    public static void main(String[] args) {

        AdminSignInTest test = new AdminSignInTest();
        test.prepare();
        test.testSignIn();

    }

}
