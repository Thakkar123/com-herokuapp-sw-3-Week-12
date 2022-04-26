package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String BaseUrl = "http://the-internet.herokuapp.com/login";
    @Before

    public void setUp()
    {
        openBrowser(BaseUrl);
    }
    //  Verifying user should be able to login with valid credentials
    @Test
        public void userShouldLoginSuccessfullyWithValidCredentials(){

        //sending email field
        sendTextToElement(By.id("username"),"tomsmith");
        //sending password field
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //clicking loginButton
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        verifyElements("ErrorMessage","Secure Area",By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
    }

    // Verifying error message with invalid user name and valid password
    @Test
    public void verifyTheUsernameErrorMessage(){

        clickOnElement(By.id("username"));
        //sending password field
        clickOnElement(By.name("password"));
        //clicking on Login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']\n"));
        verifyElements("Error message text not displayed","Your username is invalid!\n" +
                "×",By.xpath("//div[@id='flash']"));
    }
    @Test
    // Verifying error message with valid user name and invalid password
    public void verifyThePasswordErrorMessage(){

        sendTextToElement(By.id("username"),"tomsmith");
        //sending password field
        sendTextToElement(By.name("password"),"SuperSecretPassword");
        //clicking on Login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        verifyElements("Password is not valid","Your password is invalid!\n" +
                "×",By.xpath("//div[@id='flash']"));
    }

    @After
    public void tearDown()
    {
      // closeBrowser();
    }
}
