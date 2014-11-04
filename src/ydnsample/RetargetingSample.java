package ydnsample;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.RetargetingListService.Combination;
import jp.yahooapis.im.V4.RetargetingListService.CombinationTargetList;
import jp.yahooapis.im.V4.RetargetingListService.CompareOperator;
import jp.yahooapis.im.V4.RetargetingListService.IsOpen;
import jp.yahooapis.im.V4.RetargetingListService.IsPreset;
import jp.yahooapis.im.V4.RetargetingListService.LogicalOperator;
import jp.yahooapis.im.V4.RetargetingListService.Operator;
import jp.yahooapis.im.V4.RetargetingListService.Paging;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingList;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListOperation;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListPage;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListReturnValue;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListSelector;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListServiceInterface;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListServiceService;
import jp.yahooapis.im.V4.RetargetingListService.RetargetingListValues;
import jp.yahooapis.im.V4.RetargetingListService.Rule;
import jp.yahooapis.im.V4.RetargetingListService.RuleCondition;
import jp.yahooapis.im.V4.RetargetingListService.RuleTargetList;
import jp.yahooapis.im.V4.RetargetingListService.RuleType;
import jp.yahooapis.im.V4.RetargetingListService.SimilarityTargetList;
import jp.yahooapis.im.V4.RetargetingListService.TargetListData;
import jp.yahooapis.im.V4.RetargetingListService.TargetListType;
import jp.yahooapis.im.V4.RetargetingTagService.Error;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTag;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTagPage;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTagSelector;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTagService;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTagServiceInterface;
import jp.yahooapis.im.V4.RetargetingTagService.RetargetingTagValues;
import jp.yahooapis.im.V4.error.impl.RetargetingListServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.RetargetingTagServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for RetargetingTagService,RetargetingListService.
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class RetargetingSample {

    /**
     * main method for RetargetingSample
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            long accountId = SoapUtils.getAccountId();
            
            //=================================================================
            // RetargetingTagService
            //=================================================================
            RetargetingTagServiceInterface retargetingTagService = SoapUtils.createServiceInterface(RetargetingTagServiceInterface.class,RetargetingTagService.class);
            
            
            //-----------------------------------------------
            // RetargetingTagService::get
            //-----------------------------------------------
            //request
            RetargetingTagSelector retargetingTagSelector = new RetargetingTagSelector();
            retargetingTagSelector.setAccountId(accountId);
            
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingTagService::get");
            System.out.println("############################################");
            Holder<RetargetingTagPage> retargetingTagPageHolder = new Holder<RetargetingTagPage>();
            Holder<List<Error>> getRetargetingTagErrorHolder = new Holder<List<Error>>();
            retargetingTagService.get(retargetingTagSelector, retargetingTagPageHolder, getRetargetingTagErrorHolder);
            
            //if error
            if(getRetargetingTagErrorHolder.value != null && getRetargetingTagErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(getRetargetingTagErrorHolder.value), true);
            }
            
            //response
            String retargetingTagId = null;
            if(retargetingTagPageHolder.value != null){
                RetargetingTagPage retargetingTagPage = retargetingTagPageHolder.value;
                if(retargetingTagPage.getValues() != null && retargetingTagPage.getValues().size() > 0){
                    for (RetargetingTagValues value : retargetingTagPage.getValues()) {
                        if(value.isOperationSucceeded()){
                            retargetingTagId = value.getRetargetingTag().getRetargetingTagId();
                            displayRetargetingTag(value.getRetargetingTag());
                        }else{
                          //if error
                          SoapUtils.displayErrors(new RetargetingTagServiceErrorEntityFactory(value.getError()), true);
                        }
                    }
                }
            }
            
            //=================================================================
            // RetargetingListService
            //=================================================================
            RetargetingListServiceInterface retargetingListService = SoapUtils.createServiceInterface(RetargetingListServiceInterface.class, RetargetingListServiceService.class);
            
            //-----------------------------------------------
            // RetargetingListService::mutate(ADD) - Rule
            //-----------------------------------------------
            //request
            RuleCondition addRuleCondition1_1 = new RuleCondition();
            addRuleCondition1_1.setType(RuleType.LABEL);
            addRuleCondition1_1.setCompareOperator(CompareOperator.END_WITH);
            addRuleCondition1_1.setValue("SampleLabel1");
            
            RuleCondition addRuleCondition1_2 = new RuleCondition();
            addRuleCondition1_2.setType(RuleType.URL);
            addRuleCondition1_2.setCompareOperator(CompareOperator.EQUAL);
            addRuleCondition1_2.setValue("sampleurl2.aaa");
            
            RuleCondition addRuleCondition2_1 = new RuleCondition();
            addRuleCondition2_1.setType(RuleType.LABEL);
            addRuleCondition2_1.setCompareOperator(CompareOperator.INCLUDED);
            addRuleCondition2_1.setValue("SampleLabel3");
            
            RuleCondition addRuleCondition2_2 = new RuleCondition();
            addRuleCondition2_2.setType(RuleType.URL);
            addRuleCondition2_2.setCompareOperator(CompareOperator.NOT_END_WITH);
            addRuleCondition2_2.setValue("sampleurl4.bbb");
            
            Rule addRule = new Rule();
            addRule.getRuleConditions().addAll(Arrays.asList(addRuleCondition1_1,addRuleCondition1_2,addRuleCondition2_1,addRuleCondition2_2));
            
            RuleTargetList addRuleTargetList = new RuleTargetList();
            addRuleTargetList.setTargetListType(TargetListType.RULE);
            addRuleTargetList.setRetargetingTagId(retargetingTagId);
            addRuleTargetList.setIsPreset(IsPreset.TRUE);
            addRuleTargetList.setIsOpen(IsOpen.TRUE);
            addRuleTargetList.setReachPeriod((long)7);
            addRuleTargetList.getRules().add(addRule);
            
            RetargetingList addRuleRetargetingListOperand = new RetargetingList();
            addRuleRetargetingListOperand.setAccountId(accountId);
            addRuleRetargetingListOperand.setTargetListName("SampleRule_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addRuleRetargetingListOperand.setDescription("SampleRulet_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addRuleRetargetingListOperand.setTargetList(addRuleTargetList);
            
            RetargetingListOperation addRuleRetargetingListOperation = new RetargetingListOperation();
            addRuleRetargetingListOperation.setOperator(Operator.ADD);
            addRuleRetargetingListOperation.setAccountId(accountId);
            addRuleRetargetingListOperation.setTargetListType(TargetListType.RULE);
            List<RetargetingList> ruleTargetListOperand = addRuleRetargetingListOperation.getOperand();
            ruleTargetListOperand.add(addRuleRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(ADD) - Rule");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> addRuleRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> addRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(addRuleRetargetingListOperation, addRuleRetargetingListReturnValueHolder, addRuleRetargetingListErrorHolder);
            
            // if error
            if(addRuleRetargetingListErrorHolder.value != null && addRuleRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(addRuleRetargetingListErrorHolder.value), true);
            }
            
            long ruleTargetListId = -1;
            if(addRuleRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = addRuleRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            ruleTargetListId = values.getRetargetingList().getTargetListId();
                            displayRetargetingList(values.getRetargetingList());
                        }else{
                           //if error
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::mutate(ADD) - Combination
            //-----------------------------------------------
            //request
            Combination addCombination = new Combination();
            addCombination.setLogicalOperator(LogicalOperator.AND);
            TargetListData targetListData = new TargetListData();
            targetListData.setTargetListId(ruleTargetListId);
            addCombination.getTargetLists().add(targetListData);
            
            CombinationTargetList addCombinationTargetList = new CombinationTargetList();
            addCombinationTargetList.setTargetListType(TargetListType.COMBINATION);
            addCombinationTargetList.getCombinations().addAll(Arrays.asList(addCombination));
            
            RetargetingList addCombinationRetargetingListOperand = new RetargetingList();
            addCombinationRetargetingListOperand.setAccountId(accountId);
            addCombinationRetargetingListOperand.setTargetListName("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addCombinationRetargetingListOperand.setDescription("SampleCombination_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addCombinationRetargetingListOperand.setTargetList(addCombinationTargetList);
            
            RetargetingListOperation addCombinationRetargetingListOperation = new RetargetingListOperation();
            addCombinationRetargetingListOperation.setOperator(Operator.ADD);
            addCombinationRetargetingListOperation.setAccountId(accountId);
            addCombinationRetargetingListOperation.setTargetListType(TargetListType.COMBINATION);
            addCombinationRetargetingListOperation.getOperand().add(addCombinationRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(ADD) - Combination");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> addCombinationRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> addCombinationRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(addCombinationRetargetingListOperation, addCombinationRetargetingListReturnValueHolder, addCombinationRetargetingListErrorHolder);
            
            //if error
            if(addCombinationRetargetingListErrorHolder.value != null && addCombinationRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(addCombinationRetargetingListErrorHolder.value), true);
            }

            long combinationTargetListId = -1;
            //response
            if(addCombinationRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = addCombinationRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            combinationTargetListId = values.getRetargetingList().getTargetListId();
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::mutate(ADD) - Similarity
            //-----------------------------------------------
            //get targetingListId of DefaultTargetList
            //request
            RetargetingListSelector getDefaultRetargetingListSelector = new RetargetingListSelector();
            getDefaultRetargetingListSelector.setAccountId(accountId);
            getDefaultRetargetingListSelector.getTargetListTypes().add(TargetListType.DEFAULT_LIST);
            Paging getDefaultRetargetingListPaging = new Paging();
            getDefaultRetargetingListPaging.setStartIndex(1);
            getDefaultRetargetingListPaging.setNumberResults(20);
            getDefaultRetargetingListSelector.setPaging(getDefaultRetargetingListPaging);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::get DefaultTargetList");
            System.out.println("############################################");
            Holder<RetargetingListPage> getDefaultRetargetingListPageHolder = new Holder<RetargetingListPage>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> getDefaultRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.get(getDefaultRetargetingListSelector, getDefaultRetargetingListPageHolder, getDefaultRetargetingListErrorHolder);
            
            //if error
            if(getDefaultRetargetingListErrorHolder.value != null && getDefaultRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(getDefaultRetargetingListErrorHolder.value), true);
            }
            
            //response
            long defaultTargetListId = -1;
            if(getDefaultRetargetingListPageHolder.value != null){
                RetargetingListPage getDefaultRetargetingListPage = getDefaultRetargetingListPageHolder.value;
                if(getDefaultRetargetingListPage.getValues() != null){
                    for (RetargetingListValues values : getDefaultRetargetingListPage.getValues()) {
                        if(values.isOperationSucceeded()){
                            defaultTargetListId = values.getRetargetingList().getTargetListId();
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //request
            SimilarityTargetList addSimilarityTargetList = new SimilarityTargetList();
            addSimilarityTargetList.setTargetListType(TargetListType.SIMILARITY);
            addSimilarityTargetList.setTargetListId(defaultTargetListId);
            
            RetargetingList addSimilarityRetargetingListOperand = new RetargetingList();
            addSimilarityRetargetingListOperand.setAccountId(accountId);
            addSimilarityRetargetingListOperand.setTargetListName("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addSimilarityRetargetingListOperand.setDescription("SampleSimilarity_CreateOn_" + SoapUtils.getCurrentTimestamp());
            addSimilarityRetargetingListOperand.setTargetList(addSimilarityTargetList);
            
            RetargetingListOperation addSimilarityRetargetingListOperation = new RetargetingListOperation();
            addSimilarityRetargetingListOperation.setOperator(Operator.ADD);
            addSimilarityRetargetingListOperation.setAccountId(accountId);
            addSimilarityRetargetingListOperation.setTargetListType(TargetListType.SIMILARITY);
            List<RetargetingList> similarityTargetListOperand = addSimilarityRetargetingListOperation.getOperand();
            similarityTargetListOperand.add(addSimilarityRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(ADD) - Similarity");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> addSimilarityRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> addSimilarityRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(addSimilarityRetargetingListOperation, addSimilarityRetargetingListReturnValueHolder, addSimilarityRetargetingListErrorHolder);
            
            // if error
            if(addSimilarityRetargetingListErrorHolder.value != null && addSimilarityRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(addSimilarityRetargetingListErrorHolder.value), true);
            }
            
            long similarityTargetListId = -1;
            if(addSimilarityRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = addSimilarityRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            similarityTargetListId = values.getRetargetingList().getTargetListId();
                            displayRetargetingList(values.getRetargetingList());
                        }else{
                           //if error
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::get
            //-----------------------------------------------
            //request
            RetargetingListSelector retargetingListSelector = new RetargetingListSelector();
            retargetingListSelector.setAccountId(accountId);
            retargetingListSelector.getTargetListTypes().addAll(Arrays.asList(TargetListType.COMBINATION,TargetListType.RULE,TargetListType.DEFAULT_LIST,TargetListType.SIMILARITY));
            retargetingListSelector.getTargetListIds().addAll(Arrays.asList(ruleTargetListId,combinationTargetListId,similarityTargetListId));
            Paging paging = new Paging();
            paging.setStartIndex(1);
            paging.setNumberResults(20);
            retargetingListSelector.setPaging(paging);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::get");
            System.out.println("############################################");
            Holder<RetargetingListPage> retargetingListPageHolder = new Holder<RetargetingListPage>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> getRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.get(retargetingListSelector, retargetingListPageHolder, getRetargetingListErrorHolder);
            
            //if error
            if(getRetargetingListErrorHolder.value != null && getRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(getRetargetingListErrorHolder.value), true);
            }
            
            //response
            if(retargetingListPageHolder.value != null){
                RetargetingListPage retargetingListPage = retargetingListPageHolder.value;
                if(retargetingListPage.getValues() != null){
                    for (RetargetingListValues values : retargetingListPage.getValues()) {
                        if(values.isOperationSucceeded()){
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::mutate(SET) - Rule
            //-----------------------------------------------
            //request
            RuleCondition setRuleCondition1_1 = new RuleCondition();
            setRuleCondition1_1.setType(RuleType.LABEL);
            setRuleCondition1_1.setCompareOperator(CompareOperator.END_WITH);
            setRuleCondition1_1.setValue("SampleLabel1");
            RuleCondition setRuleCondition1_2 = new RuleCondition();
            setRuleCondition1_2.setType(RuleType.URL);
            setRuleCondition1_2.setCompareOperator(CompareOperator.EQUAL);
            setRuleCondition1_2.setValue("sampleurl2.aaa");
            RuleCondition setRuleCondition2_1 = new RuleCondition();
            setRuleCondition2_1.setType(RuleType.LABEL);
            setRuleCondition2_1.setCompareOperator(CompareOperator.INCLUDED);
            setRuleCondition2_1.setValue("SampleLabel3");
            Rule setRule = new Rule();
            setRule.getRuleConditions().addAll(Arrays.asList(setRuleCondition1_1,setRuleCondition1_2,setRuleCondition2_1));
            
            RuleTargetList setRuleTargetList = new RuleTargetList();
            setRuleTargetList.setTargetListType(TargetListType.RULE);
            setRuleTargetList.getRules().add(setRule);
            
            RetargetingList setRuleRetargetingListOperand = new RetargetingList();
            setRuleRetargetingListOperand.setAccountId(accountId);
            setRuleRetargetingListOperand.setTargetListId(ruleTargetListId);
            setRuleRetargetingListOperand.setTargetListName("SampleRule_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            setRuleRetargetingListOperand.setDescription("SampleRulet_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            setRuleRetargetingListOperand.setTargetList(setRuleTargetList);
            
            RetargetingListOperation setRuleRetargetingListOperation = new RetargetingListOperation();
            setRuleRetargetingListOperation.setOperator(Operator.SET);
            setRuleRetargetingListOperation.setAccountId(accountId);
            setRuleRetargetingListOperation.setTargetListType(TargetListType.RULE);
            setRuleRetargetingListOperation.getOperand().add(setRuleRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(SET) - Rule");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> setRuleRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> setRuleRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(setRuleRetargetingListOperation, setRuleRetargetingListReturnValueHolder, setRuleRetargetingListErrorHolder);
            
            //if error
            if(setRuleRetargetingListErrorHolder.value != null && setRuleRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(setRuleRetargetingListErrorHolder.value), true);
            }
            
            //response
            if(setRuleRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = setRuleRetargetingListReturnValueHolder.value;
                if(returnValue != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            displayRetargetingList(values.getRetargetingList());
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }

            //-----------------------------------------------
            // RetargetingListService::mutate(SET) - Combination
            //-----------------------------------------------
            //request
            Combination setCombination = new Combination();
            setCombination.setLogicalOperator(LogicalOperator.OR);
            TargetListData setTargetListData = new TargetListData();
            setTargetListData.setTargetListId(ruleTargetListId);
            setCombination.getTargetLists().add(setTargetListData);
            
            CombinationTargetList setCombinationTargetList = new CombinationTargetList();
            setCombinationTargetList.setTargetListType(TargetListType.COMBINATION);
            setCombinationTargetList.getCombinations().add(setCombination);
            
            RetargetingList setCombinationRetargetingListOperand = new RetargetingList();
            setCombinationRetargetingListOperand.setAccountId(accountId);
            setCombinationRetargetingListOperand.setTargetListId(combinationTargetListId);
            setCombinationRetargetingListOperand.setTargetListName("SampleCombination_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            setCombinationRetargetingListOperand.setDescription("SampleCombination_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            setCombinationRetargetingListOperand.setTargetList(setCombinationTargetList);
            
            RetargetingListOperation setCombinationRetargetingListOperation = new RetargetingListOperation();
            setCombinationRetargetingListOperation.setOperator(Operator.SET);
            setCombinationRetargetingListOperation.setAccountId(accountId);
            setCombinationRetargetingListOperation.setTargetListType(TargetListType.COMBINATION);
            setCombinationRetargetingListOperation.getOperand().add(setCombinationRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(SET) - Combination");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> setCombinationRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> setCombinationRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(setCombinationRetargetingListOperation, setCombinationRetargetingListReturnValueHolder, setCombinationRetargetingListErrorHolder);
            
            //if error
            if(setCombinationRetargetingListErrorHolder.value != null && setCombinationRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(setCombinationRetargetingListErrorHolder.value), true);
            }
            
            //response
            if(setCombinationRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = setCombinationRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::mutate(SET) - Similarity
            //-----------------------------------------------
            //request
            RetargetingList setSimilarityRetargetingListOperand = new RetargetingList();
            setSimilarityRetargetingListOperand.setAccountId(accountId);
            setSimilarityRetargetingListOperand.setTargetListId(similarityTargetListId);
            setSimilarityRetargetingListOperand.setTargetListName("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            setSimilarityRetargetingListOperand.setDescription("SampleSimilarity_UpdateOn_" + SoapUtils.getCurrentTimestamp());
            
            RetargetingListOperation setSimilaritRetargetingListOperation = new RetargetingListOperation();
            setSimilaritRetargetingListOperation.setOperator(Operator.SET);
            setSimilaritRetargetingListOperation.setAccountId(accountId);
            setSimilaritRetargetingListOperation.setTargetListType(TargetListType.SIMILARITY);
            setSimilaritRetargetingListOperation.getOperand().add(setSimilarityRetargetingListOperand);
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(SET) - Similarity");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> setSimilaritRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> setSimilaritRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(setSimilaritRetargetingListOperation, setSimilaritRetargetingListReturnValueHolder, setSimilaritRetargetingListErrorHolder);
            
            //if error
            if(setSimilaritRetargetingListErrorHolder.value != null && setSimilaritRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(setSimilaritRetargetingListErrorHolder.value), true);
            }
            
            //response
            if(setSimilaritRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = setSimilaritRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for (RetargetingListValues values : returnValue.getValues()) {
                        if(values.isOperationSucceeded()){
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
            
            //-----------------------------------------------
            // RetargetingListService::mutate(REMOVE)
            //-----------------------------------------------
            RetargetingList removeRetargetingListOperand1 = new RetargetingList();
            removeRetargetingListOperand1.setAccountId(accountId);
            removeRetargetingListOperand1.setTargetListId(combinationTargetListId);
            
            RetargetingList removeRetargetingListOperand2 = new RetargetingList();
            removeRetargetingListOperand2.setAccountId(accountId);
            removeRetargetingListOperand2.setTargetListId(ruleTargetListId);
            
            RetargetingList removeRetargetingListOperand3 = new RetargetingList();
            removeRetargetingListOperand3.setAccountId(accountId);
            removeRetargetingListOperand3.setTargetListId(similarityTargetListId);

            RetargetingListOperation removeRetargetingListOperation = new RetargetingListOperation();
            removeRetargetingListOperation.setOperator(Operator.REMOVE);
            removeRetargetingListOperation.setAccountId(accountId);
            removeRetargetingListOperation.getOperand().addAll(Arrays.asList(removeRetargetingListOperand1,removeRetargetingListOperand2,removeRetargetingListOperand3));
            
            //call API
            System.out.println("############################################");
            System.out.println("RetargetingListService::mutate(REMOVE)");
            System.out.println("############################################");
            Holder<RetargetingListReturnValue> removeRetargetingListReturnValueHolder = new Holder<RetargetingListReturnValue>();
            Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>> removeRetargetingListErrorHolder = new Holder<List<jp.yahooapis.im.V4.RetargetingListService.Error>>();
            retargetingListService.mutate(removeRetargetingListOperation, removeRetargetingListReturnValueHolder, removeRetargetingListErrorHolder);
            
            //if error
            if(removeRetargetingListErrorHolder.value != null && removeRetargetingListErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(removeRetargetingListErrorHolder.value), true);
            }
            
            //response
            if(removeRetargetingListReturnValueHolder.value != null){
                RetargetingListReturnValue returnValue = removeRetargetingListReturnValueHolder.value;
                if(returnValue.getValues() != null){
                    for(RetargetingListValues values : returnValue.getValues()){
                        if(values.isOperationSucceeded()){
                            displayRetargetingList(values.getRetargetingList());
                        //if error
                        }else{
                            SoapUtils.displayErrors(new RetargetingListServiceErrorEntityFactory(values.getError()), true);
                        }
                    }
                }
            }
          
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * display RetargetingList entity to stdout.
     * @param retargetingList RetargetingList entity for display.
     */
    private static void displayRetargetingList(RetargetingList retargetingList){
        System.out.println("accountId = " + retargetingList.getAccountId());
        System.out.println("targetListId = " + retargetingList.getTargetListId());
        System.out.println("targetListName = " + retargetingList.getTargetListName());
        System.out.println("description = " + retargetingList.getDescription());
        System.out.println("reach = " + retargetingList.getReach());
        System.out.println("deliveryStatus = " + retargetingList.getDeliveryStatus());
        if(retargetingList.getTargetList() != null){
            System.out.println("targetList---------");
            System.out.println("targetList/targetListType = " + retargetingList.getTargetList().getTargetListType());
            if(retargetingList.getTargetList() instanceof RuleTargetList){
                RuleTargetList ruleTargetList = (RuleTargetList)retargetingList.getTargetList();
                System.out.println("targetList/retargetingTagId = " + ruleTargetList.getRetargetingTagId());
                System.out.println("targetList/isPreset = " + ruleTargetList.getIsPreset());
                if(ruleTargetList.getRules() != null && ruleTargetList.getRules().size() > 0) {
                    for(int i=0; i<ruleTargetList.getRules().size(); i++){
                        List<Rule> rules = ruleTargetList.getRules();
                        for (int j=0; j<rules.get(i).getRuleConditions().size(); j++) {
                            RuleCondition condition = rules.get(i).getRuleConditions().get(j);
                            System.out.println("targetList/rule" + i + "/ruleCondition" + j +"/type = " + condition.getType());
                            System.out.println("targetList/rule" + i + "/ruleCondition" + j +"/compareOperator = " + condition.getCompareOperator());
                            System.out.println("targetList/rule" + i + "/ruleCondition" + j +"/value = " + condition.getValue());
                        }
                    }
                }
            }else if(retargetingList.getTargetList() instanceof CombinationTargetList){
                CombinationTargetList combinationTargetList = (CombinationTargetList)retargetingList.getTargetList();
                if(combinationTargetList.getCombinations() != null && combinationTargetList.getCombinations().size() > 0) {
                    for(int i=0; i<combinationTargetList.getCombinations().size(); i++){
                        Combination combination = combinationTargetList.getCombinations().get(i);
                        System.out.println("targetList/combination" + i + "/logicalOperator = " + combination.getLogicalOperator());
                        for(int j=0; j<combination.getTargetLists().size(); j++) {
                            TargetListData targetListData = combination.getTargetLists().get(j);
                            System.out.println("targetList/combination" + i + "/targetLists" + j + "/targetListId = " + targetListData.getTargetListId());
                            System.out.println("targetList/combination" + i + "/targetLists" + j + "/targetListName = " + targetListData.getTargetListName());
                        }
                    }
                }
            }else if(retargetingList.getTargetList() instanceof SimilarityTargetList){
                SimilarityTargetList similarityTargetList = (SimilarityTargetList)retargetingList.getTargetList();
                System.out.println("targetList/targetListId = " + similarityTargetList.getTargetListId());
            }
        }

        System.out.println("---------");
    }

    /**
     * display RetargetingTag entity to stdout.
     * @param retargetingTag RetargetingTag entity for display.
     */
    private static void displayRetargetingTag(RetargetingTag retargetingTag) {
        System.out.println("retargetingTagId = " + retargetingTag.getRetargetingTagId());
        System.out.println("accountId = " + retargetingTag.getAccountId());
        System.out.println("approvalStatus = " + retargetingTag.getApprovalStatus());

        System.out.println("---------");
        
    }
}
