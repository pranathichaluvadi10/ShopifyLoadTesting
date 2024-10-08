package com.xceptance.loadtest.posters.tests;

import com.xceptance.loadtest.api.tests.LoadTestCase;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.actions.account.Login;
import com.xceptance.loadtest.posters.actions.account.Logout;
import com.xceptance.loadtest.posters.actions.cart.ViewCart;
import com.xceptance.loadtest.posters.flows.AddToCartFlow;
import com.xceptance.loadtest.posters.flows.CheckoutFlow;
import com.xceptance.loadtest.posters.flows.CreateAccountFlow;
import com.xceptance.loadtest.posters.flows.RegisterCheckoutFlow;
import com.xceptance.loadtest.posters.flows.VisitFlow;
import com.xceptance.loadtest.posters.models.pages.cart.CartPage;

/**
 * Starts visit at landing page, creates a new account, adds products to the cart via searching or browsing,
 * and proceeds through checkout but abandons the checkout after the payment step.
 * 
 * @author Xceptance Software Technologies
 */
public class TRegisteredCheckout extends LoadTestCase
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void test() throws Throwable
    {
        // Mark test case to be used by a registered customer
        Context.requiresRegisteredAccount(true);

        // Start at the landing page
        new VisitFlow().run();

        // Attach an account to the Context, so it can be used in the following actions
        if (Context.get().data.attachAccount().get().isRegistered == false)
        {
            // Register user
            new CreateAccountFlow().run();

            // Fill form and login
            new Login(Context.get().data.getAccount().get()).run();
        }

        // Add items to the cart via browsing and searching the catalog
        new AddToCartFlow(Context.configuration().addToCartCount.value).run();
        //new AddToCartFlow(1).run();

        // View the cart if not just done
        if (!CartPage.instance.is())
        {
            new ViewCart().run();
        }

        // Validate that the cart is not empty
        CartPage.instance.validateIsNotEmpty();
        

        // Follow checkout steps (do not place final order but abandon checkout after payment)
        //new CheckoutFlow(false).run();
        new RegisterCheckoutFlow(false).run();
        
        // Logout from freshly created account, but login later during checkout again
        new Logout().run();
    }
}