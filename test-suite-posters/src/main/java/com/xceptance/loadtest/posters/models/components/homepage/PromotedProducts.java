package com.xceptance.loadtest.posters.models.components.homepage;
 
import javax.lang.model.element.Element;
 
import org.htmlunit.html.HtmlElement;
 
import com.xceptance.loadtest.api.hpu.HPU;
import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;
 
/**
* Promoted products component.
* 
* @author Xceptance Software Technologies
*/
public class PromotedProducts implements Component
{
	public static final PromotedProducts instance = new PromotedProducts();
 
    @Override
    public LookUpResult locate()
    {
    	return Page.find().byCss(".footer__content-top.page-width");
    }
 
    @Override
    public boolean exists()
    {
        return locate().exists();
    }
	
}