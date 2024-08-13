package com.xceptance.loadtest.posters.models.components.general;

import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;

/**
 * Footer component.
 * 
 * @author Xceptance Software Technologies
 */
public class Footer implements Component
{
	public static final Footer instance = new Footer();

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