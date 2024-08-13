package com.xceptance.loadtest.posters.models.components.plp;

import org.junit.Assert;

import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;
import com.xceptance.loadtest.api.util.DataUtils;
import com.xceptance.loadtest.posters.utils.PageState;

/**
 * Product listing page item count.
 * 
 * @author Xceptance Software Technologies
 */
public class ItemCount implements Component
{
	public static final ItemCount instance = new ItemCount();

    @Override
    public LookUpResult locate()
    {
        //return Page.find().byId("totalProductCount");
      //  return Page.find().byCss("span.count-value");
    	 return Page.find().byCss("div[class='template-search__header page-width'] p[role='status']");
    }

    @Override
    public boolean exists()
    {
        return locate().exists();
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getItemCount()
    {
    	if(PageState.hasProducts())
    	{
    		return PageState.getProductCount();
    		//return 0;
    	}
    	else if (exists())
        {
            final String content = locate().first().getTextContent();
            
            if (content != null)
            {
               String countContent = content.split(" ")[0];
               if(isInteger(countContent)) {
               return DataUtils.toInt(countContent);
               //return 0;
            }
               else {
            	   return 0;
               }
        }
        }
        
        return 0;
    }

}