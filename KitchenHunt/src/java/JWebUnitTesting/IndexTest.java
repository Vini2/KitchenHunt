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
package JWebUnitTesting;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import org.junit.*;

public class IndexTest {
	
    @Before
    public void prepare() {
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
    
    
    public static void main(String[] args) {
        IndexTest test = new IndexTest();
        test.prepare();
        test.testIndexSearch();
    }
    
}

