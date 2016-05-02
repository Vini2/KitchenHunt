/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function signIn(frm1) {

    var a;

    var email = frm1["signin_email"].value;
    var password = frm1["signin_password"].value;


    if (window.XMLHttpRequest) {
        a = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        a = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("Browser does not support AJAX");
    }

    if (a != null) {
        a.onreadystatechange = function () {
            if (a.readyState === 4) {
                var res = a.responseText;

                if (res == 'The email address entered already exists.') {
                    alert("The email address entered already exists.");

                } else if (res == 'Error1') {
                    alert("Invalid email or password.");
                } else if (res == 'Error2') {
                    alert("Invalid email or password.");
                } else if (res == 'Error3') {
                    alert("Your account is inactive. Please contact the administrator");
                } else if (res == 'success') {
                    
                    var newURL = window.location.protocol + "//"  + window.location.host + "";
                    
                    var pathArray = window.location.pathname.split( '/' );
                    
                    newURL = newURL + pathArray[0] + "/" + pathArray[1] + "/admin_home.jsp";
                    
                    //alert(newURL);
                    window.location = newURL;
                } else {
                    alert("Incorrect email address or password.");
                }
            }
        }

        a.open("POST", "AdminSignIn", true);
        a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        a.send("email=" + email + "&password=" + password);

    }
}
