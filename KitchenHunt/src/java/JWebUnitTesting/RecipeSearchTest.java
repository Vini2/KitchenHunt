/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JWebUnitTesting;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.*;
/**
 *
 * @author User
 */
public class RecipeSearchTest {
    
    @Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);    // use HtmlUnit
        setBaseUrl("http://localhost:8080/KitchenHunt");
    }

    @Test
    public void testContent() {
        beginAt("recipe_search.jsp");                   // start at recipe_search.jsp
        assertTitleEquals("Kitchen Hunt - Search");     // the page should be titled "Kitchen Hunt - Search"
    }
    
    public static void main(String[] args) {
        RecipeSearchTest test = new RecipeSearchTest();
        test.prepare();
        test.testContent();
    }
    
}
