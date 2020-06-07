package mmt.login;

import net.thucydides.core.annotations.Step;

public class LoginToHisAccount {

    LoginForm loginForm;

    @Step
    public void launchApplication() {
        loginForm.open();
    }

    @Step
    public void openLoginSection() {
        loginForm.OpenLoginSection();
    }

    @Step
    public void enterInUserNameSection() {
        loginForm.enterUserName();
        loginForm.clickContinue();
    }
    @Step
    public void enterInPasswordSection() {
        loginForm.enterPassword();
        loginForm.clickLogin();
        loginForm.dismissPhoneAlert();
    }
}
