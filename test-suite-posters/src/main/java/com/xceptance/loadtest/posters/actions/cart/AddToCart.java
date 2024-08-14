package com.xceptance.loadtest.posters.actions.cart;

import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import org.htmlunit.WebResponse;
import org.htmlunit.util.NameValuePair;

import com.xceptance.loadtest.api.actions.AjaxAction;
import com.xceptance.loadtest.api.util.AjaxUtils;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.api.util.HttpRequest;
import com.xceptance.loadtest.posters.models.pages.catalog.ProductDetailPage;
import com.xceptance.loadtest.posters.models.pages.general.GeneralPages;

/**
 * Adds the product items of the current product page to the cart.
 * 
 * @author Xceptance Software Technologies
 */
public class AddToCart extends AjaxAction<AddToCart>
{
    private int previousCartQuantity;
    
    private String id;
    
    private String size;
    
    private String finish;
    
    private String productIdforValue;
    private String utf8;
    private String formType;
    private String title;

    @Override
    public void precheck()
    {
        // Retrieve current quantity
        previousCartQuantity = GeneralPages.instance.miniCart.getQuantity();

        // Retrieve PID
        id = ProductDetailPage.instance.getProductId();
        
        // Retrieve selected size
        size = ProductDetailPage.instance.getSelectedSize();
        System.out.println("hdidiw" + size);

       finish = ProductDetailPage.instance.getSelectedFinish();
        System.out.println("finish23" + finish);
        
        productIdforValue = ProductDetailPage.instance.getProductIdforValue();
      System.out.println("productIdforValue12" + productIdforValue);
//      
      utf8 = ProductDetailPage.instance.getUtf8();
      System.out.println("utf812" + utf8);
      
      formType = ProductDetailPage.instance.getFormType();
      System.out.println("title12" + formType);
      
      title = ProductDetailPage.instance.gettitle();
      System.out.println("title123" + title);
//      
      // Retrieve selected finish
        
      
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doExecute() throws Exception
    {
    	final List<NameValuePair> addToCartParams = new ArrayList<NameValuePair>();
        addToCartParams.add(new NameValuePair("id",  id));
        addToCartParams.add(new NameValuePair("quantity", "1"));
        addToCartParams.add(new NameValuePair("section-id", size));
        addToCartParams.add(new NameValuePair("sections_url", finish));
        addToCartParams.add(new NameValuePair("product_id", productIdforValue));
        addToCartParams.add(new NameValuePair("utf8", utf8));
        addToCartParams.add(new NameValuePair("formType", formType));
       // addToCartParams.add(new NameValuePair("title", title));
        HttpRequest req = new HttpRequest()
					.url("/cart/add")
                   .POST()          
				    .postParams(addToCartParams);
        WebResponse response1=req.fire();

        String url = "";
        
        if(response1.getStatusCode()==200)
        	   loadPage("https://quickstart-etg-demo.myshopify.com");
           else
        	 Assert.fail(response1.getStatusMessage());
        loadPageByUrlClick(url);
    	// Send add to cart request
    	//WebResponse response = new HttpRequest()
    		//.XHR()
    		//.GET()
    		//.url("/posters/addToCartSlider")
    		//.param("productId", productId)
    		//.param("finish", finish)
    		//.param("size", size)
    		//.assertJSONObject("Expected product information to be contained in add to cart response", true, json -> json.has("product"))
    		//.fire();
    	
    	// Safely convert the response to JSON
    	//JSONObject addToCartJson = AjaxUtils.convertToJson(response1.getContentAsString());
    	
    	//Assert.assertEquals("Cart quantity did not change",addToCartJson );

//        // Handle error in add to cart response
//    	if(!addToCartJson.has("error"))
//    	{
//    		
//    	}
//   	var error = addToCartJson.get("error").toString();
//    	boolean isError = Boolean.parseBoolean(error);
//    	if(!isError) {
//    		Context.get().data.totalAddToCartCount++;
//    	}
    	//Assert.assertEquals("Cart quantity did not change",error );
        // Validate the item count in the add to cart response (headerCartOverview = itemsInMiniCart)
        //Assert.assertTrue("Cart quantity did not change", addToCartJson.has("headerCartOverview") && (addToCartJson.getInt("headerCartOverview") > previousCartQuantity));
    	
        // Update the mini cart item count
    	//GeneralPages.instance.miniCart.updateQuantity(addToCartJson.getInt("headerCartOverview"));

    	// Increase total add to cart count if successful
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void postValidate() throws Exception
    {
    	// Nothing to validate
    }
}