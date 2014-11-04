package ydnsample;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.PlacementUrlIdeaService.AdFormat;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.Error;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdea;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdeaPage;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdeaSelector;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdeaService;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdeaServiceInterface;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.PlacementUrlIdeaValues;
import jp.yahooapis.im.V4.PlacementUrlIdeaService.SelectConditions;
import jp.yahooapis.im.V4.PlacementUrlListService.Operator;
import jp.yahooapis.im.V4.PlacementUrlListService.Paging;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlList;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListOperation;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListPage;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListReturnValue;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListSelector;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListService;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListServiceInterface;
import jp.yahooapis.im.V4.PlacementUrlListService.PlacementUrlListValues;
import jp.yahooapis.im.V4.PlacementUrlListService.UrlActiveFlg;
import jp.yahooapis.im.V4.PlacementUrlListService.UrlList;
import jp.yahooapis.im.V4.error.impl.PlacementUrlIdeaServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.PlacementUrlListServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;


/**
 * Sample Program for PlacementUrlIdeaService,PlacementUrlListService. Copyright (C) 2013 Yahoo
 * Japan Corporation. All Rights Reserved.
 */
public class PlacementUrlSample {

  /**
   * main method for AdSample
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {
    try {
      long accountId = SoapUtils.getAccountId();
      long placementUrlListId = 0;
      List<String> placementUrls = new ArrayList<String>();


      // =================================================================
      // PlacementUrlIdeaService
      // =================================================================
      PlacementUrlIdeaServiceInterface placementUrlIdeaService =
          SoapUtils.createServiceInterface(PlacementUrlIdeaServiceInterface.class,
              PlacementUrlIdeaService.class);

      // -----------------------------------------------
      // PlacementUrlIdeaService::get
      // -----------------------------------------------
      // request
      PlacementUrlIdeaSelector selector = new PlacementUrlIdeaSelector();
      List<SelectConditions> selectConditionsList = selector.getConditions();
      SelectConditions selectConditions = new SelectConditions();
      selectConditions.setKeyword("iphone");
      selectConditions.setSiteCategory("TC-SC-16777217");
      selectConditionsList.add(selectConditions);
      selector.getConditions().addAll(selectConditionsList);

      // call API
      System.out.println("############################################");
      System.out.println("PlacementUrlIdeaService::get");
      System.out.println("############################################");
      Holder<PlacementUrlIdeaPage> placementUrlIdeaValueHolder = new Holder<PlacementUrlIdeaPage>();
      Holder<List<Error>> placementUrlIdeaErrorHolder = new Holder<List<Error>>();
      placementUrlIdeaService.get(selector, placementUrlIdeaValueHolder,
          placementUrlIdeaErrorHolder);

      // if error
      if (placementUrlIdeaErrorHolder.value != null && placementUrlIdeaErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PlacementUrlIdeaServiceErrorEntityFactory(
            placementUrlIdeaErrorHolder.value), true);
      }

      // response
      if (placementUrlIdeaValueHolder.value != null) {
        for (PlacementUrlIdeaValues values : placementUrlIdeaValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            // display response
            displayPlacementUrlIdea(values.getPlacementUrlIdea());
            if (!"UNKNOWN_URL".equals(values.getPlacementUrlIdea().getSearchUrl())) {
              placementUrls.add(values.getPlacementUrlIdea().getSearchUrl());
            }
          } else {
            // if error
            SoapUtils.displayErrors(
                new PlacementUrlIdeaServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }

      // =================================================================
      // PlacementUrlListService
      // =================================================================
      PlacementUrlListServiceInterface placementUrlListService =
          SoapUtils.createServiceInterface(PlacementUrlListServiceInterface.class,
              PlacementUrlListService.class);

      // -----------------------------------------------
      // PlacementUrlListService::mutate(ADD)
      // -----------------------------------------------
      List<UrlList> addUrlList = new ArrayList<UrlList>();
      int index = 0;
      for (String placementUrl : placementUrls) {
        if (index == 1000) {
          break;
        }
        UrlList urlList = new UrlList();
        urlList.setPlacementUrl(placementUrl);
        urlList.setActiveFlg(UrlActiveFlg.ACTIVE);
        addUrlList.add(urlList);
        index++;
      }

      PlacementUrlList addPlacementUrlList = new PlacementUrlList();
      addPlacementUrlList.setAccountId(accountId);
      addPlacementUrlList.setUrlListName("SamplePlacementUrlList_CreateOn_"
          + SoapUtils.getCurrentTimestamp());
      addPlacementUrlList.setDescription("SamplePlacementUrlListDescription_CreateOn_"
          + SoapUtils.getCurrentTimestamp());
      addPlacementUrlList.getUrls().addAll(addUrlList);

      PlacementUrlListOperation addSearchKeywordListOperation = new PlacementUrlListOperation();
      addSearchKeywordListOperation.setAccountId(accountId);
      addSearchKeywordListOperation.setOperator(Operator.ADD);
      addSearchKeywordListOperation.getOperand().add(addPlacementUrlList);

      // call API
      System.out.println("############################################");
      System.out.println("PlacementUrlListService::mutate(ADD)");
      System.out.println("############################################");
      Holder<PlacementUrlListReturnValue> addPlacementUrlListReturnValueHolder =
          new Holder<PlacementUrlListReturnValue>();
      Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>> addPlacementUrlListErrorHolder =
          new Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>>();
      placementUrlListService.mutate(addSearchKeywordListOperation,
          addPlacementUrlListReturnValueHolder, addPlacementUrlListErrorHolder);

      // if error
      if (addPlacementUrlListErrorHolder.value != null
          && addPlacementUrlListErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(
            addPlacementUrlListErrorHolder.value), true);
      }

      // response
      if (addPlacementUrlListReturnValueHolder.value != null) {
        for (PlacementUrlListValues values : addPlacementUrlListReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            // display response
            displayPlacementUrlList(values.getUrlList());
            placementUrlListId = values.getUrlList().getUrlListId();
          } else {
            // if error
            SoapUtils.displayErrors(
                new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }

      // -----------------------------------------------
      // PlacementUrlListService::get
      // -----------------------------------------------
      PlacementUrlListSelector placementUrlListSelector = new PlacementUrlListSelector();
      placementUrlListSelector.setAccountId(accountId);
      placementUrlListSelector.getUrlListIds().add(placementUrlListId);
      Paging paging = new Paging();
      paging.setStartIndex(1);
      paging.setNumberResults(20);
      placementUrlListSelector.setPaging(paging);

      // call API
      System.out.println("############################################");
      System.out.println("PlacementUrlListService::get");
      System.out.println("############################################");
      Holder<PlacementUrlListPage> getPlacementUrlListPageHolder =
          new Holder<PlacementUrlListPage>();
      Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>> getPlacementUrlListErrorHolder =
          new Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>>();
      placementUrlListService.get(placementUrlListSelector, getPlacementUrlListPageHolder,
          getPlacementUrlListErrorHolder);

      // if error
      if (getPlacementUrlListErrorHolder.value != null
          && getPlacementUrlListErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(
            getPlacementUrlListErrorHolder.value), true);
      }

      // response
      if (getPlacementUrlListErrorHolder.value != null) {
        for (PlacementUrlListValues values : getPlacementUrlListPageHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            displayPlacementUrlList(values.getUrlList());
          } else {
            SoapUtils.displayErrors(
                new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }


      // -----------------------------------------------
      // PlacementUrlListService::mutate(SET)
      // -----------------------------------------------
      PlacementUrlList setPlacementUrlList = new PlacementUrlList();
      setPlacementUrlList.setAccountId(accountId);
      setPlacementUrlList.setUrlListId(placementUrlListId);
      setPlacementUrlList.setUrlListName("SamplePlacementUrlList_UpdateOn_"
          + SoapUtils.getCurrentTimestamp());
      setPlacementUrlList.setDescription("SamplePlacementUrlListDescription_UpdateOn_"
          + SoapUtils.getCurrentTimestamp());
      if (placementUrls.size() > 0) {
        UrlList urlList = new UrlList();
        urlList.setPlacementUrl(placementUrls.get(0));
        setPlacementUrlList.getUrls().add(urlList);
      }
      PlacementUrlListOperation setPlacementUrlListOperation = new PlacementUrlListOperation();
      setPlacementUrlListOperation.setAccountId(accountId);
      setPlacementUrlListOperation.setOperator(Operator.SET);
      setPlacementUrlListOperation.getOperand().add(setPlacementUrlList);
      // call API
      System.out.println("############################################");
      System.out.println("PlacementUrlListService::mutate(SET)");
      System.out.println("############################################");
      Holder<PlacementUrlListReturnValue> setPlacementUrlListReturnValueHolder =
          new Holder<PlacementUrlListReturnValue>();
      Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>> setPlacementUrlListErrorHolder =
          new Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>>();
      placementUrlListService.mutate(setPlacementUrlListOperation,
          setPlacementUrlListReturnValueHolder, setPlacementUrlListErrorHolder);

      // if error
      if (setPlacementUrlListErrorHolder.value != null
          && setPlacementUrlListErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(
            setPlacementUrlListErrorHolder.value), true);
      }

      // response
      if (setPlacementUrlListReturnValueHolder.value != null) {
        for (PlacementUrlListValues values : setPlacementUrlListReturnValueHolder.value.getValues()) {
          if (values.isOperationSucceeded()) {
            displayPlacementUrlList(values.getUrlList());
          } else {
            SoapUtils.displayErrors(
                new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }


      // -----------------------------------------------
      // PlacementUrlListService::mutate(REMOVE)
      // -----------------------------------------------
      PlacementUrlList removePlacementUrlList = new PlacementUrlList();
      removePlacementUrlList.setAccountId(accountId);
      removePlacementUrlList.setUrlListId(placementUrlListId);

      PlacementUrlListOperation removePlacementUrlListOperation = new PlacementUrlListOperation();
      removePlacementUrlListOperation.setAccountId(accountId);
      removePlacementUrlListOperation.setOperator(Operator.REMOVE);
      removePlacementUrlListOperation.getOperand().add(removePlacementUrlList);
      // call API
      System.out.println("############################################");
      System.out.println("PlacementUrlListService::mutate(REMOVE)");
      System.out.println("############################################");
      Holder<PlacementUrlListReturnValue> removePlacementUrlListReturnValueHolder =
          new Holder<PlacementUrlListReturnValue>();
      Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>> removePlacementUrlListErrorHolder =
          new Holder<List<jp.yahooapis.im.V4.PlacementUrlListService.Error>>();
      placementUrlListService.mutate(removePlacementUrlListOperation,
          removePlacementUrlListReturnValueHolder, removePlacementUrlListErrorHolder);

      // if error
      if (removePlacementUrlListErrorHolder.value != null
          && removePlacementUrlListErrorHolder.value.size() > 0) {
        SoapUtils.displayErrors(new PlacementUrlListServiceErrorEntityFactory(
            removePlacementUrlListErrorHolder.value), true);
      }

      // response
      if (removePlacementUrlListReturnValueHolder.value != null) {
        for (PlacementUrlListValues values : removePlacementUrlListReturnValueHolder.value
            .getValues()) {
          if (values.isOperationSucceeded()) {
            displayPlacementUrlList(values.getUrlList());
          } else {
            SoapUtils.displayErrors(
                new PlacementUrlListServiceErrorEntityFactory(values.getError()), true);
          }
        }
      }



    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * display PlacementUrlList entity to stdout.
   * 
   * @param placementUrlList PlacementUrlList entity for display.
   */
  private static void displayPlacementUrlList(PlacementUrlList placementUrlList) {
    System.out.println("accountId = " + placementUrlList.getAccountId());
    System.out.println("urlListId = " + placementUrlList.getUrlListId());
    System.out.println("urlListName = " + placementUrlList.getUrlListName());
    System.out.println("description = " + placementUrlList.getDescription());
    System.out.println("isUnknownDomain = " + placementUrlList.getIsUnknownDomain().toString());
    for (UrlList urlList : placementUrlList.getUrls()) {
      System.out.println("urlList / placementUrl = " + urlList.getPlacementUrl());
      System.out.println("urlList / activeFlg = " + urlList.getActiveFlg());
    }

    System.out.println("---------");
  }

  /**
   * display PlacementUrlIdea entity to stdout.
   * 
   * @param placementUrlIdea PlacementUrlIdea entity for display.
   */
  private static void displayPlacementUrlIdea(PlacementUrlIdea placementUrlIdea) {
    System.out.println("keyword = " + placementUrlIdea.getKeyword());
    for (String siteCategory : placementUrlIdea.getSiteCategory()) {
      System.out.println("siteCategory = " + siteCategory);
    }
    System.out.println("desktopAdRequests = " + placementUrlIdea.getDesktopAdRequests());
    System.out.println("desktopReaches = " + placementUrlIdea.getDesktopReaches());
    System.out.println("smartPhoneAdRequests = " + placementUrlIdea.getSmartPhoneAdRequests());
    System.out.println("smartPhoneReaches = " + placementUrlIdea.getSmartPhoneReaches());
    System.out.println("tabletAdRequests = " + placementUrlIdea.getTabletAdRequests());
    System.out.println("tabletReaches = " + placementUrlIdea.getTabletReaches());
    for (AdFormat adFormat : placementUrlIdea.getAdFormat()) {
      System.out.println("adFormat = " + adFormat.getType());
    }
    System.out.println("searchUrl = " + placementUrlIdea.getSearchUrl());
    System.out.println("---------");
  }
}
