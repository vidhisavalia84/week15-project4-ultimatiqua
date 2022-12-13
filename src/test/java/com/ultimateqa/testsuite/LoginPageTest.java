package com.ultimateqa.testsuite;

import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
LoginPage loginPage;
@BeforeMethod(alwaysRun = true)
public void inIt(){
    loginPage=new LoginPage();
}
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldDNavigateToLoginPageSuccessfully(){
    //Thread.sleep(2000);
        loginPage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getWelcomeText(),"Welcome Back!","User is not navigated successfully");
    }
    @Test(groups ={"smoke","regression"} )
    public void VerifyUserShouldNotLoginWithInvalidDataAndVerifyErrorMessage() {
        loginPage.clickOnSignInLink();
        loginPage.enterEmailId("Admin123@gmail.com");
        loginPage.enterPassword("abc123");
        loginPage.clickOnLoginButton();
        //Verify  error message
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.");
    }
}
