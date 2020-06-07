package mmt.login;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ApplicationConstants;

@DefaultUrl("https://www.makemytrip.com/")
public class LoginForm extends PageObject {

    @FindBy(css = ".whiteText.latoBold p")
    private WebElement LOGIN_SECTION;
    @FindBy(css = "input#username")
    private WebElement USERNAME;
    @FindBy(css = "[data-cy='continueBtn']")
    private WebElement CONTINUE;
    @FindBy(css = "input#password")
    private WebElement PASSWORD;
    @FindBy(css = ".capText.font16")
    private WebElement LOGIN;
    @FindBy(css = ".crossIcon.popupCrossIcon.popupSprite")
    private WebElement dismissPhoneAlert;



    public void OpenLoginSection() {
        LOGIN_SECTION.click();
    }

    public void enterUserName() {
        USERNAME.click();
        USERNAME.sendKeys(ApplicationConstants.userName);
    }
    public void clickContinue(){
        CONTINUE.click();
    }
    public void enterPassword() {
        PASSWORD.click();
        PASSWORD.sendKeys(ApplicationConstants.passWord);
    }
    public void clickLogin(){
        LOGIN.click();
    }

    public void dismissPhoneAlert() {
        waitFor(dismissPhoneAlert);
        dismissPhoneAlert.click();
    }
}
