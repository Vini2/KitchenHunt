/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class IndexTest {
	
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);    // use HtmlUnit
        setBaseUrl("http://localhost:8080/KitchenHunt");
    }

    @Test
    public void testIndexSearch() {
        beginAt("index.jsp");                       // start at index.jsp
        assertTitleEquals("Kitchen Hunt");          // the home page should be titled "Home"
        assertLinkPresent("getStarted");           // there should be a "Get Started" link
        clickLink("getStarted");                   // click the link
        assertTitleEquals("Kitchen Hunt - Search"); // we should now be on the search page
    }
    
    @Test
    public void testWelcomeMessage() {
        beginAt("index.jsp");
        
        // check for presence of welcome message by text
        assertTextPresent("Welcome to Kitchen Hunt!");
        
        // check for presence of welcome message by element id
        assertElementPresent("welcomeMsg");
        
        // check for text within an element
        assertTextInElement("welcomeMsg", "Welcome to Kitchen Hunt!");
    }
    
    
    public static void main(String[] args) {
        IndexTest test = new IndexTest();
        test.prepare();
        test.testIndexSearch();
        test.testWelcomeMessage();
    }
    
}

