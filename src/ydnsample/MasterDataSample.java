package ydnsample;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.MasterDataService.ChildDataValues;
import jp.yahooapis.im.V4.MasterDataService.Master;
import jp.yahooapis.im.V4.MasterDataService.MasterDataPage;
import jp.yahooapis.im.V4.MasterDataService.MasterDataSelector;
import jp.yahooapis.im.V4.MasterDataService.MasterDataServiceInterface;
import jp.yahooapis.im.V4.MasterDataService.MasterDataServiceService;
import jp.yahooapis.im.V4.MasterDataService.Error;
import jp.yahooapis.im.V4.MasterDataService.MasterDataValues;
import jp.yahooapis.im.V4.error.impl.MasterDataServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for MasterDataService.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class MasterDataSample {
    /**
     * main method for MasterDataSample
     * @param args command line arguments
     */
    public static void main(String[] args){

        try{

            long accountId = SoapUtils.getAccountId();

            //=================================================================
            // MasterDataService
            //=================================================================
            MasterDataServiceInterface masterDataService = SoapUtils.createServiceInterface(MasterDataServiceInterface.class, MasterDataServiceService.class);

            //-----------------------------------------------
            // MasterDataService::getInterestCategory
            //-----------------------------------------------
            //request
            MasterDataSelector getInterestCategorySelector = new MasterDataSelector();
            getInterestCategorySelector.setAccountId(accountId);

            //call API
            System.out.println("############################################");
            System.out.println("MasterDataService::getInterestCategory");
            System.out.println("############################################");
            Holder<MasterDataPage> getInterestCategoryPageHolder = new Holder<MasterDataPage>();
            Holder<List<Error>> getInterestCategoryErrorHolder = new Holder<List<Error>>();
            masterDataService.getInterestCategory(getInterestCategorySelector, getInterestCategoryPageHolder, getInterestCategoryErrorHolder);

            //if error
            if(getInterestCategoryErrorHolder.value != null && getInterestCategoryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new MasterDataServiceErrorEntityFactory( getInterestCategoryErrorHolder.value), true);
            }

            //response
            if(getInterestCategoryPageHolder.value != null){
                MasterDataPage page = getInterestCategoryPageHolder.value;
                if(page.getValues() != null && page.getValues().size() > 0){
                    List<MasterDataValues> values = page.getValues();
                    for(int i=0; i<values.size(); i++){
                        if(values.get(i).isOperationSucceeded()){
                            displayMaster(values.get(i).getMaster());
                        }else{
                            SoapUtils.displayErrors(new MasterDataServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

            //-----------------------------------------------
            // MasterDataService::getSiteCategory
            //-----------------------------------------------
            //request
            MasterDataSelector getSiteCategorySelector = new MasterDataSelector();
            getSiteCategorySelector.setAccountId(accountId);

            //call API
            System.out.println("############################################");
            System.out.println("MasterDataService::getSiteCategory");
            System.out.println("############################################");
            Holder<MasterDataPage>getSiteCategoryPageHolder = new Holder<MasterDataPage>();
            Holder<List<Error>> getSiteCategoryErrorHolder = new Holder<List<Error>>();
            masterDataService.getSiteCategory(getSiteCategorySelector, getSiteCategoryPageHolder, getSiteCategoryErrorHolder);

            //if error
            if(getSiteCategoryErrorHolder.value != null && getSiteCategoryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors( new MasterDataServiceErrorEntityFactory(getSiteCategoryErrorHolder.value), true);
            }

            //response
            if(getSiteCategoryPageHolder.value != null){
                MasterDataPage page = getSiteCategoryPageHolder.value;
                if(page.getValues() != null && page.getValues().size() > 0){
                    List<MasterDataValues> values = page.getValues();
                    for(int i=0; i<values.size(); i++){
                        if(values.get(i).isOperationSucceeded()){
                            displayMaster(values.get(i).getMaster());
                        }else{
                            SoapUtils.displayErrors(new MasterDataServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * display Master entity to stdout.
     * @param master Master entity for display
     */
    private static void displayMaster(Master master){
        System.out.println("name = " + master.getName());
        if(master.getChild() != null && master.getChild().size() > 0){
            List<ChildDataValues> child = master.getChild();
            for(int j=0; j<child.size(); j++){
                System.out.println("child----------");
                System.out.println("child/code = " + child.get(j).getCode());
                System.out.println("child/name = " + child.get(j).getName());
                System.out.println("child/fullName = " + child.get(j).getFullName());
                System.out.println("child/categoryType = " + child.get(j).getCategoryType());
            }
        }
        
        System.out.println("----------");
    }
}
