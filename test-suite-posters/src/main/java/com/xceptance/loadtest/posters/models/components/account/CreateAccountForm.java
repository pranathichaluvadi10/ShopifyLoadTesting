package com.xceptance.loadtest.posters.models.components.account;
 
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlForm;
import com.xceptance.loadtest.api.data.Account;
import com.xceptance.loadtest.api.hpu.HPU;
import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;
import com.xceptance.loadtest.api.util.FormUtils;
 
/**
* Create account form component.
* 
* @author Xceptance Software Technologies
*/
public class CreateAccountForm implements Component
{
	public static final CreateAccountForm instance = new CreateAccountForm();
 
    @Override
    public LookUpResult locate()
    {
        //return Page.find().byId("formRegister");
//        return Page.find().byCss("form.registration");
    	  //return Page.find().byCss("div.customer.register");
    	  return Page.find().byId("create_customer");
    }
 
    @Override
    public boolean exists()
    {
        return locate().exists();
    }

    public HtmlElement getCreateAccountButton()
    {
    	//return locate().byCss("#btnRegister").asserted().single();
//    	return locate().byCss("form.registration>button.btncreate-account").asserted().single();
    	return locate().byCss("div.customer.register.section-template--17648079503600__main-padding form > button").asserted().single();
    }
 
    public void fillCreateAccountForm(final Account account)
    {
    	final HtmlForm form = locate().asserted().single();
 
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-lname"), account.lastname);
//        //FormUtils.setInputValue(HPU.find().in(form).byId("firstName"), account.firstname);
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-fname"), account.firstname);
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-phone"), account.phone);
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-email"), account.email);
//        //FormUtils.setInputValue(HPU.find().in(form).byId("password"), account.password);
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-password"), account.password);
//        FormUtils.setInputValue(HPU.find().in(form).byId("registration-form-password-confirm"), account.password);
    	  FormUtils.setInputValue(HPU.find().in(form).byId("RegisterForm-FirstName"), account.firstname);
    	  FormUtils.setInputValue(HPU.find().in(form).byId("RegisterForm-LastName"), account.lastname);
    	  FormUtils.setInputValue(HPU.find().in(form).byId("RegisterForm-email"), account.email);
    	  FormUtils.setInputValue(HPU.find().in(form).byId("RegisterForm-password"), account.password);
    }
    public String GetCsrf()
    {
    	 final HtmlElement  element = HPU.find().in(locate().single()).byXPath("(//input[@type='hidden'][@name='csrf_token'])[1]").first();
    	 return element.getAttribute("value");
    }
}
