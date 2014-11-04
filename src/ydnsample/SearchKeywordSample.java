package ydnsample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.SearchKeywordIdeaService.Error;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdea;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdeaPage;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdeaSelector;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdeaService;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdeaServiceInterface;
import jp.yahooapis.im.V4.SearchKeywordIdeaService.SearchKeywordIdeaValues;
import jp.yahooapis.im.V4.SearchKeywordListService.Operator;
import jp.yahooapis.im.V4.SearchKeywordListService.Paging;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeyword;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordList;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListOperation;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListPage;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListReturnValue;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListSelector;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListService;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListServiceInterface;
import jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListValues;
import jp.yahooapis.im.V4.error.impl.SearchKeywordIdeaServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.SearchKeywordListServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for SearchKeywordIdeaService,SearchKeywordListService.
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class SearchKeywordSample {

    /**
     * main method for AdSample
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        try {
            long accountId = SoapUtils.getAccountId();
            long searchKeywordListId = 0;
            List<Long> searchKeywordIds = new ArrayList<Long>();
            
            
            //=================================================================
            // SearchKeywordIdeaService
            //=================================================================
            SearchKeywordIdeaServiceInterface searchKeywordIdeaService = SoapUtils.createServiceInterface(SearchKeywordIdeaServiceInterface.class, SearchKeywordIdeaService.class);
            
            //-----------------------------------------------
            // SearchKeywordIdeaService::get
            //-----------------------------------------------
            //request
            SearchKeywordIdeaSelector selector = new SearchKeywordIdeaSelector();
            selector.getKeywords().addAll(Arrays.asList("gizmo","vlookup"));
            
            //call API
            System.out.println("############################################");
            System.out.println("SearchKeywordIdeaService::get");
            System.out.println("############################################");
            Holder<SearchKeywordIdeaPage> searchKeywordIdeaValueHolder = new Holder<SearchKeywordIdeaPage>();
            Holder<List<Error>> searchKeywordIdeaErrorHolder = new Holder<List<Error>>();
            searchKeywordIdeaService.get(selector, searchKeywordIdeaValueHolder, searchKeywordIdeaErrorHolder);
            
            //if error
            if(searchKeywordIdeaErrorHolder.value != null && searchKeywordIdeaErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new SearchKeywordIdeaServiceErrorEntityFactory(searchKeywordIdeaErrorHolder.value), true);
            }
            
            //response
            if(searchKeywordIdeaValueHolder.value != null){
                for (SearchKeywordIdeaValues values : searchKeywordIdeaValueHolder.value.getValues()) {
                    if(values.isOperationSucceeded()){
                       //display response
                       displaySearchKeywordIdea(values.getSearchKeywordIdea());
                       searchKeywordIds.add(values.getSearchKeywordIdea().getSearchKeywordId());
                    }else{
                      //if error
                      SoapUtils.displayErrors(new SearchKeywordIdeaServiceErrorEntityFactory(values.getError()), true);
                    }
                }
                
            }

          //=================================================================
          // SearchKeywordListService
          //=================================================================
          SearchKeywordListServiceInterface searchKeywordListService = SoapUtils.createServiceInterface(SearchKeywordListServiceInterface.class, SearchKeywordListService.class);
          
          //-----------------------------------------------
          // SearchKeywordListService::mutate(ADD)
          //-----------------------------------------------
          List<SearchKeyword> addSearchKeywords = new ArrayList<SearchKeyword>();
          for (long searchKeywordId : searchKeywordIds) {
            SearchKeyword searchKeyword = new SearchKeyword();
            searchKeyword.setSearchKeywordId(searchKeywordId);
            addSearchKeywords.add(searchKeyword);
          }
          SearchKeywordList addSearchKeywordList = new SearchKeywordList();
          addSearchKeywordList.setAccountId(accountId);
          addSearchKeywordList.setSearchKeywordListName("SampleSearchKeywordList_CreateOn_" + SoapUtils.getCurrentTimestamp());
          addSearchKeywordList.setSearchKeywordListDescription("SampleSearchKeywordListDescription_CreateOn_" + SoapUtils.getCurrentTimestamp());
          addSearchKeywordList.getSearchKeyword().addAll(addSearchKeywords);
          
          SearchKeywordListOperation addSearchKeywordListOperation = new SearchKeywordListOperation();
          addSearchKeywordListOperation.setAccountId(accountId);
          addSearchKeywordListOperation.setOperator(Operator.ADD);
          addSearchKeywordListOperation.getOperand().add(addSearchKeywordList);
          
          //call API
          System.out.println("############################################");
          System.out.println("SearchKeywordListService::mutate(ADD)");
          System.out.println("############################################");
          Holder<SearchKeywordListReturnValue> addSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
          Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>> addSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>>();
          searchKeywordListService.mutate(addSearchKeywordListOperation, addSearchKeywordListReturnValueHolder, addSearchKeywordListErrorHolder);
          
          //if error
          if(addSearchKeywordListErrorHolder.value != null && addSearchKeywordListErrorHolder.value.size() > 0){
              SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(addSearchKeywordListErrorHolder.value), true);
          }
          
          //response
          if(addSearchKeywordListReturnValueHolder.value != null){
              for (SearchKeywordListValues values : addSearchKeywordListReturnValueHolder.value.getValues()) {
                if(values.isOperationSucceeded()){
                  // display response
                  displaySearchKeywordList(values.getSearchKeywordList());
                  searchKeywordListId = values.getSearchKeywordList().getSearchKeywordListId();
                }else{
                  //if error
                  SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(values.getError()), true);
                }
            }
          }
          
          //-----------------------------------------------
          // SearchKeywordListService::get
          //-----------------------------------------------
          SearchKeywordListSelector searchKeywordListSelector = new SearchKeywordListSelector();
          searchKeywordListSelector.setAccountId(accountId);
          searchKeywordListSelector.getSearchKeywordListIds().add(searchKeywordListId);
          Paging paging = new Paging();
          paging.setStartIndex(1);
          paging.setNumberResults(20);
          searchKeywordListSelector.setPaging(paging);
          
          //call API
          System.out.println("############################################");
          System.out.println("SearchKeywordListService::get");
          System.out.println("############################################");
          Holder<SearchKeywordListPage> getSearchKeywordListPageHolder = new Holder<SearchKeywordListPage>();
          Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>> getSearchKeywordListErrorHolder =  new Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>>();
          searchKeywordListService.get(searchKeywordListSelector,getSearchKeywordListPageHolder,getSearchKeywordListErrorHolder);
          
          // if error
          if(getSearchKeywordListErrorHolder.value != null && getSearchKeywordListErrorHolder.value.size() > 0){
              SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(getSearchKeywordListErrorHolder.value), true);
          }
          
          // response
          if(getSearchKeywordListPageHolder.value != null){
              for (SearchKeywordListValues values : getSearchKeywordListPageHolder.value.getValues()) {
                if(values.isOperationSucceeded()){
                    displaySearchKeywordList(values.getSearchKeywordList());
                }else{
                    SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(values.getError()), true);
                }
            }
          }
          
          
          //-----------------------------------------------
          // SearchKeywordListService::mutate(SET)
          //-----------------------------------------------
          SearchKeywordList setSearchKeywordList = new SearchKeywordList();
          setSearchKeywordList.setAccountId(accountId);
          setSearchKeywordList.setSearchKeywordListId(searchKeywordListId);
          setSearchKeywordList.setSearchKeywordListName("SampleSearchKeywordList_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          setSearchKeywordList.setSearchKeywordListDescription("SampleSearchKeywordListDescription_UpdateOn_" + SoapUtils.getCurrentTimestamp());
          if(searchKeywordIds.size() > 0){
              SearchKeyword searchKeyword = new SearchKeyword();
              searchKeyword.setSearchKeywordId(searchKeywordIds.get(0));
              setSearchKeywordList.getSearchKeyword().add(searchKeyword);
          }
          SearchKeywordListOperation setSearchKeywordListOperation = new SearchKeywordListOperation();
          setSearchKeywordListOperation.setAccountId(accountId);
          setSearchKeywordListOperation.setOperator(Operator.SET);
          setSearchKeywordListOperation.getOperand().add(setSearchKeywordList);
          //call API
          System.out.println("############################################");
          System.out.println("SearchKeywordListService::mutate(SET)");
          System.out.println("############################################");
          Holder<SearchKeywordListReturnValue> setSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
          Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>> setSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>>();
          searchKeywordListService.mutate(setSearchKeywordListOperation, setSearchKeywordListReturnValueHolder, setSearchKeywordListErrorHolder);
          
          //if error
          if(setSearchKeywordListErrorHolder.value != null && setSearchKeywordListErrorHolder.value.size() > 0){
              SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(setSearchKeywordListErrorHolder.value), true);
          }
          
          //response
          if(setSearchKeywordListReturnValueHolder.value != null){
              for (SearchKeywordListValues values : setSearchKeywordListReturnValueHolder.value.getValues()) {
                if(values.isOperationSucceeded()){
                    displaySearchKeywordList(values.getSearchKeywordList());
                }else{
                    SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(values.getError()), true);
                }
            }
          }
          
          
          //-----------------------------------------------
          // SearchKeywordListService::mutate(REMOVE)
          //-----------------------------------------------
          SearchKeywordList removeSearchKeywordList = new SearchKeywordList();
          removeSearchKeywordList.setAccountId(accountId);
          removeSearchKeywordList.setSearchKeywordListId(searchKeywordListId);
          
          SearchKeywordListOperation removeSearchKeywordListOperation = new SearchKeywordListOperation();
          removeSearchKeywordListOperation.setAccountId(accountId);
          removeSearchKeywordListOperation.setOperator(Operator.REMOVE);
          removeSearchKeywordListOperation.getOperand().add(removeSearchKeywordList);
          //call API
          System.out.println("############################################");
          System.out.println("SearchKeywordListService::mutate(REMOVE)");
          System.out.println("############################################");
          Holder<SearchKeywordListReturnValue> removeSearchKeywordListReturnValueHolder = new Holder<SearchKeywordListReturnValue>();
          Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>> removeSearchKeywordListErrorHolder = new Holder<List<jp.yahooapis.im.V4.SearchKeywordListService.Error>>();
          searchKeywordListService.mutate(removeSearchKeywordListOperation, removeSearchKeywordListReturnValueHolder, removeSearchKeywordListErrorHolder);
          
          // if error
          if(removeSearchKeywordListErrorHolder.value != null && removeSearchKeywordListErrorHolder.value.size() > 0){
              SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(removeSearchKeywordListErrorHolder.value), true);
          }
          
          //response
          if(removeSearchKeywordListReturnValueHolder.value != null){
              for (SearchKeywordListValues values : removeSearchKeywordListReturnValueHolder.value.getValues()) {
                if(values.isOperationSucceeded()){
                    displaySearchKeywordList(values.getSearchKeywordList());
                }else{
                    SoapUtils.displayErrors(new SearchKeywordListServiceErrorEntityFactory(values.getError()), true);
                }
              }
          }
          
          

        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    /**
     * display SearchKeywordList entity to stdout.
     * @param searchKeywordList SearchKeywordList entity for display.
     */
    private static void displaySearchKeywordList(SearchKeywordList searchKeywordList) {
        System.out.println("accountId = " + searchKeywordList.getAccountId());
        System.out.println("searchKeywordListId = " + searchKeywordList.getSearchKeywordListId());
        System.out.println("searchKeywordListName = " + searchKeywordList.getSearchKeywordListName());
        System.out.println("searchKeywordListDescription = " + searchKeywordList.getSearchKeywordListDescription());
        System.out.println("deliveryStatus = " + searchKeywordList.getDeliveryStatus());
        for (SearchKeyword searchKeyword : searchKeywordList.getSearchKeyword()) {
            System.out.println("searchKeyword / searchKeywordId = " + searchKeyword.getSearchKeywordId());
            System.out.println("searchKeyword / searchKeyword = " + searchKeyword.getSearchKeyword());
            System.out.println("searchKeyword / desktopSearchVolume" + searchKeyword.getDesktopSearchVolume());
            System.out.println("searchKeyword / smartPhoneSearchVolume" + searchKeyword.getSmartPhoneSearchVolume());
            System.out.println("searchKeyword / tabletSearchVolume" + searchKeyword.getTabletSearchVolume());
        }
        
        System.out.println("---------");
    }

    /**
     * display SearchKeywordIdea entity to stdout.
     * @param searchKeywordIdea SearchKeywordIdea entity for display.
     */
    private static void displaySearchKeywordIdea(SearchKeywordIdea searchKeywordIdea) {
        System.out.println("searchKeywordId = " + searchKeywordIdea.getSearchKeywordId());
        System.out.println("searchKeyword = " + searchKeywordIdea.getSearchKeyword());
        System.out.println("desktopSearchVolume" + searchKeywordIdea.getDesktopSearchVolume());
        System.out.println("smartPhoneSearchVolume" + searchKeywordIdea.getSmartPhoneSearchVolume());
        System.out.println("tabletSearchVolume" + searchKeywordIdea.getTabletSearchVolume());
        System.out.println("---------");
    }
}
