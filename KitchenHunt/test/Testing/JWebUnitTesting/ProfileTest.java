/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.JWebUnitTesting;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.*;

/**
 *
 * @author User
 */
public class ProfileTest {
    
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);    // use HtmlUnit
        setBaseUrl("http://www.kitchenhuntr.com");
    }
    
    @Test
    public void testUpdateProfile() {

        beginAt("index.jsp"); //Open the browser on http://www.kitchenhuntr.com/index.jsp
        assertTitleEquals("Kitchen Hunt");    // we should be on the Kitchen Hunt
// fill out the form. we should not be logged in
        assertFormPresent("signup_form");
        assertFormElementPresent("signup_name");
        assertFormElementPresent("signup_email");
        assertFormElementPresent("signup_mobile");
        setTextField("signup_name", "Vijini Mallawaarachchi");
        setTextField("signup_email", "viji.mallawaarachchi@gmail.com");
        setTextField("signup_mobile", "0719479919");
        
        assertFormElementEquals("signup_name", "Vijini Mallawaarachchi");
        assertFormElementEquals("signup_email", "viji.mallawaarachchi@gmail.com");
        assertFormElementEquals("signup_mobile", "0719479919");
        
        assertTitleEquals("Kitchen Hunt");

    }
    
    
    public static void main(String[] args) {
        ProfileTest test = new ProfileTest();
        test.prepare();
        test.testUpdateProfile();
    }
}
