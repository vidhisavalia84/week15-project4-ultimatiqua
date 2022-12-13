package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement signInLink;
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
            WebElement welcomeBackText;
    @FindBy(id ="user[email]")
            WebElement emailField;
    @FindBy(id = "user[password]")
            WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
            WebElement signInButton;
    @FindBy(xpath = "//li[contains(text(),\"Invalid email or password.\")]")
    WebElement errorMessage;

    public void clickOnSignInLink() {
        Reporter.log("Click on sign in link"+signInLink.toString());
        clickOnElement(signInLink);
       // CustomListeners.test.log(Status.PASS,"Click on sign link");
    }


    public String getWelcomeText(){
        Reporter.log("Get welcome text"+welcomeBackText.toString());
        String message = getTextFromElement(welcomeBackText);
       // CustomListeners.test.log(Status.PASS,"welcome text");
        return message;
    }

    public void enterEmailId(String email){
        Reporter.log("Enter email"+email.toString()+"address");
        sendTextToElement(emailField, email);
       // CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    public void enterPassword(String password){
        Reporter.log("Enter password"+password.toString());
        sendTextToElement(passwordField, password);
       // CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnLoginButton(){
        Reporter.log("Click On Sign in button "+signInButton.toString());
        clickOnElement(signInButton);
       // CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    public String getErrorMessage(){
        Reporter.log("Get error message "+errorMessage.toString());
        return getTextFromElement(errorMessage);
        //CustomListeners.test.log(Status.PASS,"Get errorMessage");
        //return message;
    }

}
