package com.xceptance.loadtest.posters.models.components.general;

import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;

/**
 * Search component.
 * 
 * @author Xceptance Software Technologies
 */
public class Search implements Component
{
	public static final Search instance = new Search();

    @Override
    public LookUpResult locate()
    {
        //return Header.instance.locate().byCss("#header-menu-search");
        return Header.instance.locate().byCss(".header__search");
    }

    @Override
    public boolean exists()
    {
        return locate().exists();
    }
    
    public LookUpResult getSearchForm()
    {
    	//return locate().byCss("#searchForm");
    	//return locate().byCss("div.site-search");
    	return locate().byCss("details-modal .search-modal__form form");
    }

    public LookUpResult getSearchField()
    {
        //return getSearchForm().byCss("input#s");
        //return getSearchForm().byCss("input.search-field");
    	return getSearchForm().byCss(".search__input");
    }
    
    public LookUpResult getSearchButton()
    {
        //return getSearchForm().byCss("#btnSearch");
        //return getSearchForm().byCss("button.fa-search"); 
        return getSearchForm().byCss(".search__button.field__button"); 
    }
}