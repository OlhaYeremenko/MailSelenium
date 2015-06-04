package xPathLlibrary;
 
public class Library {


	public static final class yandexLoginLibrary{
	public static final String URL = "https://mail.yandex.com/";
	public static final String USERNAME = "seleniumTestAccount@yandex.com";
	public static final String PASSWORD = "seleniumTestAccount1";
	public static final String USERNAME_INPUT_XPATH = "//input[@name='login']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@name='passwd']";
	public static final String SUBMIT_BTN_XPATH = "//div[@class='new-left']//button[@type='submit']";
	public static final String INBOX_MENU_XPATH ="//div[@class='block-messages-title']//label[contains(text(),'Inbox')]";
	}

public static final class yandexMailPageLibrary{
   public static final String SUBJECT_CONTENT="my subject is :" + yandexLoginLibrary.USERNAME;
   public static final String BODY_CONTENT ="body is :" + yandexLoginLibrary.USERNAME;	  
   public static final String COMPOSED_DRAFT_XPATH = "//div[@class='b-messages']/div[1]//span/span[contains(@class, 'firstline-wrapper')]";
   public static final String VERIFY_BODY_IN_DRAFT = " //div[@class='b-messages']/div[1]//span/span[contains(@class, 'firstline-wrapper')]/span[@class='b-messages__firstline']";
   public static final String VERIFY_SUBJECT_IN_SENT="//span[@class='b-messages__subject']";
   public static final String LOGIN_TITLE_XPATH = "//span[contains(@class, 'header-user-name')]";
   public static final String SENT_LINK_VERIFY="//div[@class='block-messages-title']//label[contains(text(),'Sent')]";
   public static final String DRAFTS_LINK_VERIFY="//div[@class='block-messages-title']//label[contains(text(),'Drafts')]";
   public static final String DRAFTS_MENU_XPATH="//a[contains(@title,'Drafts') and contains(text(),'Drafts') ]";//"//div[contains(@class,'b-layout__left')]//a[contains(@title,'Drafts') and contains(text(),'Drafts') ]";//"//a[contains(text(),'Drafts')]";//"//div[@class='block-app']//a[contains(@href, 'draft')]";   
   public static final String COMPOSE_BTN_XPATH = "//a[contains(@href, 'compose')]/img";//
   public static final String SENT_MENU_XPATH = "//div[@class='block-app']//a[contains(@href, 'sent')]";
   //.//*[@id='js-page']//form/table/tbody/tr[3]/td[2]/div[2]/div";//"
  // public static final String TO_XPATH =".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div";
  
     
   public static final String TO_XPATH =".//*[@id='js-page']//form/table/tbody/tr[3]/td[2]//input[@type='text']";//".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div[2]/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div";//"//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div/input";
   public static final String SUBJECT_XPATH = ".//input[@id='compose-subj']";
   public static final String BODY_XPATH = "//textarea[@id='compose-send']";
   public static final String SEND_BTN_XPATH = "//*[@id='compose-submit']";  
   public static final String CANCEL_BTN_XPATH ="//div[contains(@class, 'message__left')]//button[contains(@data-action, 'close')]";
   public static final String SAVE_AND_QUIT_BTN_XPATH ="//button[contains(@data-action, 'dialog.save')]";
   public static final String LOGOUT_BTN_XPATH = "//a[@class='b-mail-dropdown__item__content' and contains(text(), 'Log out')]";
   public static final String LOGO_PIC_XPATH = "//span[contains(@class, 'user-pic')]";
   public static final String USER_INFO_XPATH = "  //*[@id='nb-1']";
	
	}


public static final class gmailLoginLibrary{
public static final String URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl";
public static final String USERNAME = "seleniumyeremenko@gmail.com";
public static final String PASSWORD = "seleniumYeremenko1";


public static final String USERNAME_INPUT_XPATH = "//input[@id='Email']";
public static final String NEXT_BTN_XPATH = "//input[@id='next']";
public static final String PASSWORD_INPUT_XPATH = "//input[@id='Passwd']";
public static final String SUBMIT_XPATH = "//input[@id='signIn']";}


public static final class gmailPageLibrary {
    public static final String FORM_SUBJ = "my subject is :" + gmailLoginLibrary.USERNAME;
    public static final String FORM_TEXT = "body is :" + gmailLoginLibrary.USERNAME;	
    public static final String COMPOSE_BTN_XPATH = "//div[@role='button' and @gh and contains(@class, 'T')]";
    public static final String DRAFTS_LETTER_XPATH =  "//span[contains(text(),'my subject is :')]";
    public static final String SENT_MAIL_TAB_XPATH = ".//a[contains(@href,'#sent')]";//"//a[contains(@href, 'https://mail.google.com/mail/?pli=1#sent')]";
    public static final String DRAFTS_TAB_XPATH ="//a[contains(@href, '#drafts')]";// "//a[contains(@href, 'https://mail.google.com/mail/?pli=1#drafts')]";
    public static final String FORM_TO_XPATH = "//textarea[@name='to']";
    public static final String FORM_SUBJ_XPATH = "//input[@name='subjectbox']";
    public static final String FORM_TEXT_XPATH = "//div[@role='textbox']";
    public static final String FORM_SENDBTN_XPATH ="//tbody//div[count(div) = 2]/div[@role='button' and @data-tooltip]";// "//div[contains(@aria-label,'–û—Ç–ø—Ä–∞')]";//
    public static final String FORM_SAVE_AND_QUITBTN_XPATH = ".//img[3]";
    public static final String DRAFT_XPATH = "//tr//span[text()='" + FORM_TEXT + "']";
    public static final String DRAFT_FORM_TO_FIELD = "//form/div/div/span";
    public static final String USER_LOGO_PIC_XPATH ="//a[contains(@title,'¿ÍÍ‡ÛÌÚ')]";//"(//a[contains(@href, 'accounts.google.com')])";// "(//a[contains(@href, 'plus.google.com')])[3]";
    public static final String LOGOUT_BTN_XPATH = "//a[contains(@href, 'logout')]";
    public static final String LOGOUT_XPATH ="//div/a[@href='https://mail.google.com/mail/logout?hl=ru']";
}

public static final class iUALoginLibrary {
    public static final String URL = "http://mail.i.ua/";
    public static final String USERNAME = "seleniumTestAccount@i.ua";
    public static final String PASSWORD = "seleniumTest";
    public static final String USERNAME_INPUT_XPATH = "//input[@name='login']";
    public static final String PASSWORD_INPUT_XPATH = "//input[@name='pass']";
    public static final String SUBMIT_XPATH = "//div[@class='Right']//input[@type='submit']";

}
public static final class iUAPageLibrary {
    public static final String FORM_SUBJ = "my subject is :" + iUALoginLibrary.USERNAME;
    public static final String FORM_TEXT = "body is :" + iUALoginLibrary.USERNAME;	
    public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";
    public static final String SETTING= ".//*[contains (@class,'ho_settings')]";
    public static final String SENT_MAIL_TAB_XPATH = "//a[contains(@href, 'sent-mail')]";
    public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, 'drafts')]";
    public static final String FORM_TO_XPATH = "//textarea[@id='to']";
    public static final String FORM_SUBJ_XPATH = "//input[@name='subject']";
    public static final String FORM_TEXT_XPATH = "//textarea[@id='text']";
    public static final String FORM_SENDBTN_XPATH = "//div[@class='Left']/p[1]/input[@name='send']";
    public static final String FORM_SAVE_AND_QUITBTN_XPATH = "//div[@class='Left']/p[1]/input[@name='save_in_drafts']";
    public static final String DRAFT_XPATH = ".//*[@id='mesgList']//div[1]//span[3]/span";
    public static final String MAIN_PAGE_BUTTON_XPATH = "//li//a[contains (@href,'www.i.ua')]";
    public static final String LOGOUT_BTN_XPATH ="//a[contains (@href , 'logout') ]";// "//li[@class = 'right']/a[contains(@href, 'logout.php')]";
    public static final String IUA_LOGO= "//img[@alt = 'I.UA']";
}
}
