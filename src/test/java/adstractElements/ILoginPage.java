package adstractElements;

public  interface ILoginPage {
    	  
	AbstractPage inputUserName(String username);

	AbstractPage inputPassword(String password);

	AbstractPage submitLogin();

}
