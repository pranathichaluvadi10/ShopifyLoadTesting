package com.xceptance.loadtest.posters.models.pages.general;

import org.htmlunit.html.HtmlElement;

import com.xceptance.loadtest.api.models.pages.Page;
import com.xceptance.loadtest.posters.models.components.homepage.PromotedProducts;

/**
 * Represents the home page.
 * 
 * @author Xceptance Software Technologies
 */
public class HomePage extends GeneralPages
{
    public static final HomePage instance = new HomePage();

    public final PromotedProducts promotedProducts = PromotedProducts.instance;

    @Override
    public void validate()
    {
        super.validate();

        validate(has(promotedProducts));
    }

    @Override
    public boolean is()
    {
        return super.is() && matches(has(promotedProducts));
    }
    public String getToken()
    {
    	final HtmlElement  element = Page.find().byXPath("//input[@name='authenticity_token']").asserted("Expected single place order button").single();
      	 return element.getAttribute("value");
    }
}