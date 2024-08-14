package com.xceptance.loadtest.posters.actions.account;
 
import org.htmlunit.html.HtmlElement;
import org.openqa.selenium.By;
 
import com.xceptance.loadtest.api.actions.PageAction;
import com.xceptance.loadtest.api.models.pages.Page;
import com.xceptance.loadtest.api.validators.Validator;
import com.xceptance.loadtest.posters.models.pages.account.CreateAccountPage;
import com.xceptance.loadtest.posters.models.pages.general.GeneralPages;
 
/**
* Opens the account creation page.
*
* @author Xceptance Software Technologies
*/
public class GoToCreateRegister extends PageAction<GoToCreateAccount>
{
    @Override
    protected void doExecute() throws Exception
    {
//        loadPageByClick(GeneralPages.instance.user.getLoginLink().asserted().first());
//  loadPageByClick(GeneralPages.instance.user.getCreateAccountLink().asserted().first());
//    	loadPageByUrlClick("/account/login");
    	//loadPage("https://quickstart-etg-demo.myshopify.com/account/login");
    	HtmlElement elment = Page.find().byCss("a[href='/account/register']").asserted().single();
    	loadPageByClick(elment);
    
    }
 
    @Override
    protected void postValidate() throws Exception
    {
        Validator.validatePageSource();
 
        CreateAccountPage.instance.validate();
    }
}