package com.xceptance.loadtest.posters.flows;

import com.xceptance.loadtest.api.flows.Flow;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.actions.catalog.ClickACategory;
import com.xceptance.loadtest.posters.actions.catalog.ClickATopCategory;
import com.xceptance.loadtest.posters.models.pages.catalog.ProductListingPage;

/**
 * Opens a (top) category.
 * 
 * @author Xceptance Software Technologies
 */
public class NavigateCategoriesFlow extends Flow
{
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean execute() throws Throwable
    {
        if (Context.configuration().topCategoryBrowsing.random())
        {
            new ClickATopCategory().run();

            // In case this is does not really end up somewhere useful, open a category
            if (ProductListingPage.instance.is() == false)
            {
                new ClickACategory().run();
            }
        }
        else
        {
            new ClickACategory().run();
        }

        return true;
    }
}