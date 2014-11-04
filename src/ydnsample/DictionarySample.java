package ydnsample;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.DictionaryService.Category;
import jp.yahooapis.im.V4.DictionaryService.CategoryChildValues;
import jp.yahooapis.im.V4.DictionaryService.CategoryPage;
import jp.yahooapis.im.V4.DictionaryService.CategorySelector;
import jp.yahooapis.im.V4.DictionaryService.CategoryValues;
import jp.yahooapis.im.V4.DictionaryService.DictionaryLang;
import jp.yahooapis.im.V4.DictionaryService.DictionaryService;
import jp.yahooapis.im.V4.DictionaryService.DictionaryServiceInterface;
import jp.yahooapis.im.V4.DictionaryService.DisapprovalReason;
import jp.yahooapis.im.V4.DictionaryService.DisapprovalReasonPage;
import jp.yahooapis.im.V4.DictionaryService.DisapprovalReasonSelector;
import jp.yahooapis.im.V4.DictionaryService.DisapprovalReasonValues;
import jp.yahooapis.im.V4.DictionaryService.Error;
import jp.yahooapis.im.V4.DictionaryService.GeographicLocation;
import jp.yahooapis.im.V4.DictionaryService.GeographicLocationPage;
import jp.yahooapis.im.V4.DictionaryService.GeographicLocationSelector;
import jp.yahooapis.im.V4.DictionaryService.GeographicLocationValues;
import jp.yahooapis.im.V4.error.impl.DictionaryServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;


public class DictionarySample {
    /**
     * main method for AccountSample
     * @param args command line arguments
     */
    public static void main(String[] args) {

        try{
            //=================================================================
            // DictionaryService
            //=================================================================
            DictionaryServiceInterface dictionaryService =  SoapUtils.createServiceInterface(DictionaryServiceInterface.class, DictionaryService.class);

            //-----------------------------------------------
            // DictionaryService::getDisapprovalReason
            //-----------------------------------------------
            //request
            DisapprovalReasonSelector disapprovalReasonSelector = new DisapprovalReasonSelector();
            disapprovalReasonSelector.setLang(DictionaryLang.JA);

            //call API
            System.out.println("############################################");
            System.out.println("DictionaryService::getDisapprovalReason");
            System.out.println("############################################");

            Holder<DisapprovalReasonPage> disapprovalReasonPageHolder = new Holder<DisapprovalReasonPage>();
            Holder<List<Error>> dictionaryErrorHolder = new Holder<List<Error>>();
            dictionaryService.getDisapprovalReason(disapprovalReasonSelector, disapprovalReasonPageHolder, dictionaryErrorHolder);

            //if error
            if(dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(dictionaryErrorHolder.value), true);
            }

            //response
            if(disapprovalReasonPageHolder.value != null){
                DisapprovalReasonPage disapprovalReasonPage = disapprovalReasonPageHolder.value;
                if(disapprovalReasonPage.getValues() != null && disapprovalReasonPage.getValues().size() > 0){
                    for(int i=0; i< disapprovalReasonPage.getValues().size(); i++){
                        List<DisapprovalReasonValues> values = disapprovalReasonPage.getValues();
                        if(values.get(i).isOperationSucceeded()){
                            //display response
                        	displayDisapprovalReason(values.get(i).getDisapprovalReason());
                        }else{
                            //if error
                            SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

            //-----------------------------------------------
            // DictionaryService::getGeographicLocation
            //-----------------------------------------------
            //request
            GeographicLocationSelector geographicLocationSelector = new GeographicLocationSelector();
            geographicLocationSelector.setLang(DictionaryLang.JA);

            //call API
            System.out.println("############################################");
            System.out.println("DictionaryService::getGeographicLocation");
            System.out.println("############################################");

            Holder<GeographicLocationPage> geographicLocationPageHolder = new Holder<GeographicLocationPage>();
            dictionaryErrorHolder = new Holder<List<Error>>();
            dictionaryService.getGeographicLocation(geographicLocationSelector, geographicLocationPageHolder, dictionaryErrorHolder);

            //if error
            if(dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(dictionaryErrorHolder.value), true);
            }

            //response
            if(geographicLocationPageHolder.value != null){
            	GeographicLocationPage geographicLocationPage = geographicLocationPageHolder.value;
                if(geographicLocationPage.getValues() != null && geographicLocationPage.getValues().size() > 0){
                    for(int i=0; i< geographicLocationPage.getValues().size(); i++){
                        List<GeographicLocationValues> values = geographicLocationPage.getValues();
                        if(values.get(i).isOperationSucceeded()){
                            //display response
                        	displayGeographicLocation(values.get(i).getGeographicLocation());
                        }else{
                            //if error
                            SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

            //-----------------------------------------------
            // DictionaryService::getInterestCategory
            //-----------------------------------------------
            //request
            CategorySelector categorySelector = new CategorySelector();
            categorySelector.setLang(DictionaryLang.JA);

            //call API
            System.out.println("############################################");
            System.out.println("DictionaryService::getInterestCategory");
            System.out.println("############################################");

            Holder<CategoryPage> categoryPageHolder = new Holder<CategoryPage>();
            dictionaryErrorHolder = new Holder<List<Error>>();
            dictionaryService.getInterestCategory(categorySelector, categoryPageHolder, dictionaryErrorHolder);

            //if error
            if(dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(dictionaryErrorHolder.value), true);
            }

            //response
            if(categoryPageHolder.value != null){
            	CategoryPage categoryPage = categoryPageHolder.value;
                if(categoryPage.getValues() != null && categoryPage.getValues().size() > 0){
                    for(int i=0; i< categoryPage.getValues().size(); i++){
                        List<CategoryValues> values = categoryPage.getValues();
                        if(values.get(i).isOperationSucceeded()){
                            //display response
                        	displayCategory(values.get(i).getCategory());
                        }else{
                            //if error
                            SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

            //-----------------------------------------------
            // DictionaryService::getSiteCategory
            //-----------------------------------------------
            //request
            categorySelector.setLang(DictionaryLang.JA);

            //call API
            System.out.println("############################################");
            System.out.println("DictionaryService::getSiteCategory");
            System.out.println("############################################");

            dictionaryErrorHolder = new Holder<List<Error>>();
            dictionaryService.getSiteCategory(categorySelector, categoryPageHolder, dictionaryErrorHolder);

            //if error
            if(dictionaryErrorHolder.value != null && dictionaryErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(dictionaryErrorHolder.value), true);
            }

            //response
            if(categoryPageHolder.value != null){
            	CategoryPage categoryPage = categoryPageHolder.value;
                if(categoryPage.getValues() != null && categoryPage.getValues().size() > 0){
                    for(int i=0; i< categoryPage.getValues().size(); i++){
                        List<CategoryValues> values = categoryPage.getValues();
                        if(values.get(i).isOperationSucceeded()){
                            //display response
                        	displayCategory(values.get(i).getCategory());
                        }else{
                            //if error
                            SoapUtils.displayErrors(new DictionaryServiceErrorEntityFactory(values.get(i).getError()), true);
                        }
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * display disapproval reason entity to stdout.
     * @param disapprovalReason disapproval reason entity for display.
     */
    private static void displayDisapprovalReason(DisapprovalReason disapprovalReason){
        System.out.println("disapprovalReasonCode = " + disapprovalReason.getDisapprovalReasonCode());
        System.out.println("lang = " + disapprovalReason.getLang());
        System.out.println("title = " + disapprovalReason.getTitle().toString());
        System.out.println("description = " + disapprovalReason.getDescription().toString());
        System.out.println("recommendation = " + disapprovalReason.getRecommendation().toString());
        System.out.println("---------");
    }

    /**
     * display geographic location entity to stdout.
     * @param geographicLocation account geographic location for display.
     */
    private static void displayGeographicLocation(GeographicLocation geographicLocation){
        System.out.println("code = " + geographicLocation.getCode());
        System.out.println("fullName = " + geographicLocation.getFullName());
        System.out.println("name = " + geographicLocation.getName());
        System.out.println("order = " + geographicLocation.getOrder());

    	List<GeographicLocation> childValues = geographicLocation.getChild();
        for (GeographicLocation childValue : childValues){
        	System.out.println("  child code = " + childValue.getCode());
        	System.out.println("  child fullName = " + childValue.getFullName());
        	System.out.println("  child name = " + childValue.getName());
        	System.out.println("  child order = " + childValue.getOrder());
        	System.out.println("  child parent = " + childValue.getParent());
        	System.out.println("  =========");
        }

        System.out.println("---------");
    }

    /**
     * display geographic location entity to stdout.
     * @param geographicLocation account geographic location for display.
     */
    private static void displayCategory(Category category){

    	System.out.println("name = " + category.getName());

    	List<CategoryChildValues> childValues = category.getChild();
        for (CategoryChildValues childValue : childValues){
        	System.out.println("  child code = " + childValue.getCode());
        	System.out.println("  child fullName = " + childValue.getFullName());
        	System.out.println("  child name = " + childValue.getName());
            System.out.println("  =========");
        }
        System.out.println("---------");
    }

}
