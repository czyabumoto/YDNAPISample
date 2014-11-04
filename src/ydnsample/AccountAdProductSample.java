package ydnsample;

import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProduct;
import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProductPage;
import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProductSelector;
import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProductService;
import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProductServiceInterface;
import jp.yahooapis.im.V4.AccountAdProductService.AccountAdProductValues;
import jp.yahooapis.im.V4.AccountAdProductService.AdProduct;
import jp.yahooapis.im.V4.AccountAdProductService.Error;
import jp.yahooapis.im.V4.error.impl.AccountAdProductServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;


/**
 * Sample Program for AccountService.
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AccountAdProductSample {

    /**
     * main method for AccountSample
     * @param args command line arguments
     */
    public static void main(String[] args) {

        try{
            long accountId = SoapUtils.getAccountId();

            //=================================================================
            // AccountAdProductService
            //=================================================================
            AccountAdProductServiceInterface accountService =  SoapUtils.createServiceInterface(AccountAdProductServiceInterface.class, AccountAdProductService.class);

            //-----------------------------------------------
            // AccountAdProductService::get
            //-----------------------------------------------
            //request
            AccountAdProductSelector accountAdProductSelector = new AccountAdProductSelector();
            accountAdProductSelector.getAccountIds().add(accountId);

            //call API
            System.out.println("############################################");
            System.out.println("AccountAdProductService::get");
            System.out.println("############################################");

            Holder<AccountAdProductPage> accountAdProductPageHolder = new Holder<AccountAdProductPage>();
            Holder<List<Error>> accountAdProductErrorHolder = new Holder<List<Error>>();
            accountService.get(accountAdProductSelector, accountAdProductPageHolder, accountAdProductErrorHolder);

            //if error
            if(accountAdProductErrorHolder.value != null && accountAdProductErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new AccountAdProductServiceErrorEntityFactory(accountAdProductErrorHolder.value), true);
            }

            //response
            if(accountAdProductPageHolder.value != null){
                AccountAdProductPage accountAdProductPage = accountAdProductPageHolder.value;
                if(accountAdProductPage.getValues() != null && accountAdProductPage.getValues().size() > 0){
                    for(int i=0; i< accountAdProductPage.getValues().size(); i++){
                        List<AccountAdProductValues> values = accountAdProductPage.getValues();
                        if(values.get(i).isOperationSucceeded()){
                            //display response
                            displayAccountAdProduct(values.get(i).getAccountAdProduct());
                        }else{
                            //if error
                            SoapUtils.displayErrors(new AccountAdProductServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * display accountAdProduct entity to stdout.
     * @param accountAdProduct accountAdProduct entity for display.
     */
    private static void displayAccountAdProduct(AccountAdProduct accountAdProduct){
    	System.out.println("accountId = " + accountAdProduct.getAccountId());

    	List<AdProduct> adProducts = accountAdProduct.getAdProduct();
        for (AdProduct adProduct : adProducts){
        	System.out.println("  adProduct code = " + adProduct.getAdProductType());
        	System.out.println("  adProduct status = " + adProduct.getStatus());
        	System.out.println("  =========");
        }
        System.out.println("---------");
    }

}
