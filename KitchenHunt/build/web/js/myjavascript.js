/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function signUp(frm1) {

    var a;

    var name = frm1["signup_name"].value;
    var mobile = frm1["signup_mobile"].value;
    var email = frm1["signup_email"].value;
    var password = frm1["signup_password"].value;
    var confirmpassword = frm1["signup_confirmpassword"].value;
    //var captcha = frm1["captcha"].value;


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
                //document.getElementById('loading').innerHTML ='';

                if (res == 'The email address entered already exists.') {
                    document.getElementById('msg_email').innerHTML = 'The email address entered already exists';
                    document.getElementById("idemail").style.border = 'red solid 1px';
                } else if (res == 'Error2') {
                    alert("The password you entered does not match with the confirm password");
                } else if (res == 'Error1') {
                    alert("The email address entered already exists.");
                } else if (res == 'success') {
                    alert("Registration Successful...!");
                    reloadPage();
                } else {
                    alert("nope");
                }
            }
        }

        a.open("POST", "SignUp", true);
        a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        a.send("name=" + name + "&email=" + email + "&mobile=" + mobile + "&password=" + password + "&confirmpassword=" + confirmpassword);

    }
}


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
                    //alert("Registration Successful...! Please check your email.");
                    reloadPage();
                } else {
                    alert("Incorrect email address or password.");
                }
            }
        }

        a.open("POST", "SignIn", true);
        a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        a.send("email=" + email + "&password=" + password);

    }
}

function reloadPage()
{
    window.location.reload()
}

function enable() {
    document.getElementById("profile_name").disabled = false;
    document.getElementById("profile_address").disabled = false;
    document.getElementById("profile_telephone").disabled = false;
    document.getElementById("btn_edit").style.display = "none";
    document.getElementById("btn_update").style.display = "block";
}

function update(frm1) {

    var a;

    var name = frm1["profile_name"].value;
    var address = frm1["profile_address"].value;
    var telephone = frm1["profile_telephone"].value;


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

                if (res == 'Error') {
                    alert("Error");
                } else if (res == 'success') {
                    //alert("Updated successfully...");
                    reloadPage();
                } else {
                    //alert("Incorrect email address or password.");
                }
            }
        }

        a.open("POST", "UpdateProfile", true);
        a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        a.send("name=" + name + "&address=" + address + "&mobile=" + telephone);

    }
}