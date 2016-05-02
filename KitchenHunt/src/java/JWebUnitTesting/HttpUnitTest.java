/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JWebUnitTesting;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;

/**
 *
 * @author User
 */
public class HttpUnitTest {

    public static void main(String[] args) {
        try {
            WebConversation wc = new WebConversation();
            GetMethodWebRequest request = new GetMethodWebRequest("http://httpunit.sourceforge.net/index.html");
            wc.setProxyServer("", 80);
            com.meterware.httpunit.WebResponse response = wc.getResponse(request);
            WebLink httpunitLink = response.getFirstMatchingLink(WebLink.MATCH_CONTAINED_TEXT, "Cookbook");
            response = httpunitLink.click();
            System.out.println("Test successful !!");
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }
}
