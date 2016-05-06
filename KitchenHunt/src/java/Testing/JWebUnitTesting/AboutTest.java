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
public class AboutTest {
    
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);    // use HtmlUnit
        setBaseUrl("http://localhost:8080/KitchenHunt");
    }

    @Test
    public void testLink() {
        beginAt("about.jsp");                       // start at about.jsp
        assertTitleEquals("Kitchen Hunt - About");          // the home page should be titled "Home"
        assertLinkPresent("idindex");           // there should be a "Get Started" link
        clickLink("idindex");                   // click the link
        assertTitleEquals("Kitchen Hunt"); // we should now be on the search page
    }
    
    public static void main(String[] args) {
        
        AboutTest test = new AboutTest();
        test.prepare();
        test.testLink();
        
    }
}
