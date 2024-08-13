package com.xceptance.loadtest.posters.models.components.checkout;

import com.xceptance.loadtest.api.hpu.HPU;
import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;

/**
 * Indicator component for checkout progress (a bread crumb).
 *  
 * @author Xceptance Software Technologies
 */
public class CheckoutProgressIndicator implements Component
{
    public final static CheckoutProgressIndicator instance = new CheckoutProgressIndicator();

    @Override
    public LookUpResult locate()
    {
        //return Page.find().byId("breadcrumbCheckout");
        return Page.find().byId("checkout-main");
    }

    @Override
    public boolean exists()
    {
        return locate().exists();
    }
    
    public boolean isStepAvailable(String stepText)
    {
    	//return HPU.find().in(locate().single()).byXPath("./ul/li/a[contains(text(), '" + stepText + "')]").exists();
    	return HPU.find().in(locate().single()).byCss("#dwfrm_shipping").exists();
    }
}