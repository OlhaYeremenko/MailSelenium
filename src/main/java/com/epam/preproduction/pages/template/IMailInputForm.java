package com.epam.preproduction.pages.template;

public interface IMailInputForm {

	AbstractPage inputSenderReceiver(String email);

	AbstractPage inputSubject(String subject);

	AbstractPage inputContent(String text);

	AbstractPage saveAndExit();

	AbstractPage sendMail();

}
