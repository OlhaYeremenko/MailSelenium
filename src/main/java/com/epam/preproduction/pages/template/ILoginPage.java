package com.epam.preproduction.pages.template;

public interface ILoginPage {

	AbstractPage inputUserName(String username);

	AbstractPage inputPassword(String password);

	AbstractPage submitLogin();

}
