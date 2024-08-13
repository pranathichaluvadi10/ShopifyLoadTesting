package com.xceptance.loadtest.posters.actions.account;

import com.xceptance.loadtest.api.actions.PageAction;
import com.xceptance.loadtest.api.validators.Validator;
import com.xceptance.loadtest.posters.models.pages.account.MyAccountPage;
import com.xceptance.loadtest.posters.models.pages.general.GeneralPages;

/**
 * Opens the account page.
 *
 * @author Xceptance Software Technologies
 */
public class GoToMyAccount extends PageAction<GoToMyAccount>
{
    @Override
    protected void doExecute() throws Exception
    {
        loadPageByClick(GeneralPages.instance.user.getMyAccountLink().asserted().first());
    }

    @Override
    protected void postValidate() throws Exception
    {
        Validator.validatePageSource();

        MyAccountPage.instance.validate();
    }
}
