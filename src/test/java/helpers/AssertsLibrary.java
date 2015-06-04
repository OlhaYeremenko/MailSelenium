package helpers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import adstractElements.AbstractPage;
import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.yandexLoginLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;
import yandex.MessageMailPage;

public class AssertsLibrary {
	public static final void assertLoginTitleAndUserName(WebDriver driver) {
		assertThat(driver.findElement(By.xpath(yandexMailPageLibrary.LOGIN_TITLE_XPATH))
						.getText(), containsString(yandexLoginLibrary.USERNAME));
	}

	public static final void assertYandexMailTitle(WebDriver driver) {
		assertThat(driver.getTitle(), containsString("Yandex.Mail"));
	}	
	public static final void assertSentAndDraftLetter(WebDriver driver, MessageMailPage mailPage) {
  
		assertThat(driver.findElement(By.xpath(yandexMailPageLibrary.TO_XPATH)).getAttribute("value"),containsString(yandexLoginLibrary.USERNAME));// containsString(yandexLoginLibrary.USERNAME));
   
    assertThat(mailPage.getSubjectField().getAttribute("value"), containsString(yandexMailPageLibrary.SUBJECT_CONTENT));
  
    assertThat(mailPage.getTextField().getAttribute("value"), containsString(yandexMailPageLibrary.BODY_CONTENT));
	}
	
	
//	public static final void assertThatLetterNoInDraft(WebDriver driver, AbstractPage page) {
//	  assertThat(page.getDriver().findElement(By.xpath(yandexMailPageLibrary.VERIFY_BODY_IN_DRAFT)).getText(),is(not(containsString(yandexMailPageLibrary.BODY_CONTENT))));
//	}	
	
	
	
	
	public static final void assertThatLetterInSentYandex(WebDriver driver, AbstractPage page) {
     assertThat(page.getDriver().findElement(By.xpath(yandexMailPageLibrary.VERIFY_SUBJECT_IN_SENT)).getAttribute("title"),containsString(yandexMailPageLibrary.SUBJECT_CONTENT));
	}	
	
//	public static final void assertLogOut(WebDriver driver, AbstractPage page) {
//		assertThat(page.getDriver().findElement(By.xpath(yandexMailPageLibrary.VERIFY_BODY_IN_DRAFT)).getText(),is(not(	yandexMailPageLibrary.LOGO_PIC_XPATH)));
//	}

	
	////google///
	public static final void assertGmailMailTitle(WebDriver driver) {
		assertThat(driver.getTitle(), containsString("Google"));
	}
	
	public static final void assertIUAMailTitle(WebDriver driver) {
		assertThat(driver.getTitle(), containsString("i.ua"));
	}
	
	public static final void assertThatLetterInSentGmail(WebDriver driver, AbstractPage sentPage) {
		 assertThat(sentPage.getDriver().findElement(By.xpath(gmailPageLibrary.DRAFTS_LETTER_XPATH)).getText(),is(not(containsString(gmailPageLibrary.FORM_SUBJ))));
	}
}
