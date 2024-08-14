package com.xceptance.loadtest.posters.models.components.general;
 
import org.htmlunit.html.HtmlElement;

import org.openqa.selenium.By;
 
import com.xceptance.loadtest.api.hpu.LookUpResult;

import com.xceptance.loadtest.api.models.components.Component;
 
/**

* User menu component.

* 

* @author Xceptance Software Technologies

*/

public class UserMenu implements Component

{

	public static final UserMenu instance = new UserMenu();
 
    @Override

    public LookUpResult locate()

    {

        //return Header.instance.locate().byCss("#userMenu");

//    	return Header.instance.locate().byCss("div.user");header__icons

       return Header.instance.locate().byCss("div.header__icons");

       // return true;

    }
 
    @Override

    public boolean exists()

    {

        return locate().exists();

    }
 
    public LookUpResult getLoginLink()

    {

        //return locate().byCss("a.goToLogin");

        return locate().byCss("a.header__icon.header__icon--account");

    }

    public LookUpResult getCreateAccountLink()

    {

    	//return locate().byCss("a.goToRegistration");

//    	return locate().byCss("a.create-button");

    	return locate().byCss("a.header__icon.header__icon--account");

    	//return locate().byCss("a[href='/account/register']");

    }
 
    public LookUpResult getMyAccountLink()

    {

        //return locate().byCss("a.goToAccountOverview");

//        return locate().byCss("link[rel='alternate'][hreflang='x-default'][href='https://quickstart-etg-demo.myshopify.com/account']");

//    	return locate().byCss("div.customer");

    	return locate().byCss("h1.customer__title");


    }
 
    public LookUpResult getLogoutLink()

    {

        //return locate().byCss("a.goToLogout");

        return locate().byCss("a[href='/account/logout']");

    }

    public boolean isLoggedIn()

    {

        return getLogoutLink().exists();

    }
 
    public boolean isNotLoggedIn()

    {

        return !isLoggedIn();

    }

    public String getAccountLink()

    {

       String url = locate().byCss("a.header__icon.header__icon--account").asserted("Expected account url").single().getAttribute("href");   	

        return url;

    }

}

 