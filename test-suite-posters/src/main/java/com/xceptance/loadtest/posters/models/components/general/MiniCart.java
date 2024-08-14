package com.xceptance.loadtest.posters.models.components.general;

import org.htmlunit.html.HtmlElement;
import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.api.util.DataUtils;

/**
 * Mini cart component.
 * 
 * @author Xceptance Software Technologies
 */
public class MiniCart implements Component
{
	public static final MiniCart instance = new MiniCart();

    @Override
    public LookUpResult locate()
    {
        //return Header.instance.locate().byCss("#cart-icon-bubble");
    	return Header.instance.locate().byCss("#cart-icon-bubble");
    }

    @Override
    public boolean exists()
    {
        return locate().exists();
    }

    public boolean isEmpty()
    {
        return getQuantity() == 0;
    }

    public int getLineItemCount()
    {
        return Context.get().data.cartLineItemCount;
    }

    public LookUpResult getQuantityElement()
    {
        //return locate().byCss(".cartMiniProductCounter > .value");
        //return locate().byCss("span.minicart-quantity");
        return locate().byCss("div[class='cart-count-bubble'] span[class='visually-hidden']");
    }
    public LookUpResult getIsEmptyCart()
    {
        //return locate().byCss(".cartMiniProductCounter > .value");
        //return locate().byCss("span.minicart-quantity");
        return locate().byCss("a#cart-icon-bubble.header__icon--cart .icon-cart-empty");
    }


    public int getQuantity()
    {
    	LookUpResult quantityElement = getQuantityElement();
    	System.out.println("minicartquantity" + quantityElement);
        if (quantityElement.getIsEmptyCart()) {
            // Handle case where element is not found (e.g., return 0 if the cart is empty)
            return 0;
        }
        else {
        return DataUtils.toInt(quantityElement.asserted().first().getTextContent());
        //return DataUtils.toInt(getQuantityElement().asserted().first().getTextContent());
        }
    }

    public void updateQuantity(final int newCartQuantity)
    {
        final HtmlElement qty = getQuantityElement().first();
        qty.setTextContent(String.valueOf(newCartQuantity));
        System.out.println("minicart............." + qty);

        Context.get().data.cartQuantityCount = newCartQuantity;
    }
    public LookUpResult getViewCartLinkIsNotEmpty()
    {
        //return locate().byCss(".cartMiniProductCounter > .value");
        //return locate().byCss("span.minicart-quantity");
        return locate().byCss("div.view-cart > a.button--secondary");
    }
    public LookUpResult getViewCartLinkEmpty()
    {
        //return locate().byCss(".cartMiniProductCounter > .value");
        //return locate().byCss("span.minicart-quantity");
        return locate().byCss(".drawer__footer .view-cart a.button--secondary");
    }

    public LookUpResult getViewCartLink()
    {
        return locate().byCss("#CartDrawer");
    }
}