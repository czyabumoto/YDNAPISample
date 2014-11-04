package ydnsample;


import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.ReportDefinitionService.Error;
import jp.yahooapis.im.V4.ReportDefinitionService.Operator;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportAddTemplate;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDateRangeType;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinition;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionField;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionFieldValue;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionOperation;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionReturnValue;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionServiceInterface;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionServiceService;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionValues;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDownloadEncode;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportDownloadFormat;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportLang;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportSegment;
import jp.yahooapis.im.V4.ReportDefinitionService.ReportType;
import jp.yahooapis.im.V4.ReportService.ReportClosedDateSelector;
import jp.yahooapis.im.V4.ReportService.ReportClosedDateValue;
import jp.yahooapis.im.V4.ReportService.ReportDownloadUrl;
import jp.yahooapis.im.V4.ReportService.ReportDownloadUrlPage;
import jp.yahooapis.im.V4.ReportService.ReportDownloadUrlSelector;
import jp.yahooapis.im.V4.ReportService.ReportDownloadUrlValues;
import jp.yahooapis.im.V4.ReportService.ReportJobStatus;
import jp.yahooapis.im.V4.ReportService.ReportOperation;
import jp.yahooapis.im.V4.ReportService.ReportPage;
import jp.yahooapis.im.V4.ReportService.ReportRecord;
import jp.yahooapis.im.V4.ReportService.ReportReturnValue;
import jp.yahooapis.im.V4.ReportService.ReportSelector;
import jp.yahooapis.im.V4.ReportService.ReportServiceInterface;
import jp.yahooapis.im.V4.ReportService.ReportServiceService;
import jp.yahooapis.im.V4.ReportService.ReportValues;
import jp.yahooapis.im.V4.error.impl.ReportDefinitionServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.ReportServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for Report Download.
 * Copyright (C) 2013 Yahoo Japan Corporation. All Rights Reserved.
 */
public class ReportDownloadSample {

    /**
     * main method for ReportDownloadSample
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            //=================================================================
            // ReportDefinitionService
            //=================================================================
            ReportDefinitionServiceInterface reportDefinitionService = SoapUtils.createServiceInterface(ReportDefinitionServiceInterface.class, ReportDefinitionServiceService.class);
            //-----------------------------------------------
            // call ReportDefinitionService::getReportFields
            //-----------------------------------------------
            //call API
            System.out.println("############################################");
            System.out.println("ReportDefinitionService::getReportFields");
            System.out.println("############################################");
            Holder<ReportDefinitionFieldValue> fieldsValueHolder = new Holder<ReportDefinitionFieldValue>();
            Holder<List<Error>> fieldsErrorHolder = new Holder<List<Error>>();
            reportDefinitionService.getReportFields(SoapUtils.getAccountId(), ReportType.ACCOUNT, ReportLang.EN, fieldsValueHolder, fieldsErrorHolder);
            
            //if error
            if(fieldsErrorHolder.value != null && fieldsErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(fieldsErrorHolder.value), true);
            }
            
            //response
            if(fieldsValueHolder.value != null){
                List<ReportDefinitionField> fields = fieldsValueHolder.value.getField();
                for (ReportDefinitionField reportDefinitionField : fields) {
                    System.out.println("fieldName        = " + reportDefinitionField.getFieldName());
                    System.out.println("displayFieldName = " + reportDefinitionField.getDisplayFieldName());
                    System.out.println("xmlAttributeName = " + reportDefinitionField.getXmlAttributeName());
                    System.out.println("---------");
                }
            }
            
            //-----------------------------------------------
            // call ReportDefinitionService::mutate(ADD)
            //-----------------------------------------------
            //request
            ReportDefinitionOperation reportDefinitionOperation = new ReportDefinitionOperation();
            reportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
            reportDefinitionOperation.setOperator(Operator.ADD);
            
            ReportDefinition reportDefinition = new ReportDefinition();
            reportDefinition.setAccountId(SoapUtils.getAccountId());
            reportDefinition.setReportType(ReportType.ACCOUNT);
            reportDefinition.setReportName("TEST_ACCOUNT_REPORT");
            reportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
            //fileds
            reportDefinition.getFields().addAll(Arrays.asList("ACCOUNTNAME","ACCOUNTID","DAY","DEVICE","IMPRESSIONS","CLICKS","CTR","AVERAGEPOSITION","COST","AVERAGECPC","TOTALCONVERSIONS","TOTALCONVERSIONRATE","COSTTOTALCONVERSIONS"));
            
            //segments
            reportDefinition.getSegments().addAll(Arrays.asList(ReportSegment.DAY,ReportSegment.DEVICE));
            reportDefinition.setFormat(ReportDownloadFormat.CSV);
            reportDefinition.setEncode(ReportDownloadEncode.SJIS);
            reportDefinition.setLang(ReportLang.JA);
            
            reportDefinitionOperation.setOperand(reportDefinition);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportDefinitionService::mutate(ADD)");
            System.out.println("############################################");
            Holder<ReportDefinitionReturnValue> reportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
            Holder<List<Error>> reportDefinitionError = new Holder<List<Error>>();
            reportDefinitionService.mutate(reportDefinitionOperation, reportDefinitinonReturnValue, reportDefinitionError);
            
            //if error
            if(reportDefinitionError.value != null && reportDefinitionError.value.size() > 0){
                SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(reportDefinitionError.value), true);
            }
            
            //response
            long reportId = 0;
            String downloadFileName = null;
            if(reportDefinitinonReturnValue.value != null){
                ReportDefinitionReturnValue returnValue = reportDefinitinonReturnValue.value;
                for (ReportDefinitionValues values : returnValue.getValues()) {
                    if(values.isOperationSucceeded()){
                        ReportDefinition addReportDefinition = values.getReportDefinition();
                        // reportId
                        reportId = addReportDefinition.getReportId();
                        //filename
                        downloadFileName = "Report_" + addReportDefinition.getReportType() + "_" + reportId + "." + addReportDefinition.getFormat().toString().toLowerCase();
                        
                        displayReportDefintion(addReportDefinition);
                        
                    }else{
                        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(values.getError()), true);
                    }
                }
            }
            
            //-----------------------------------------------
            // call ReportDefinitionService::mutate(ADD) REACH_FREQUENCY
            //-----------------------------------------------
            //request
            ReportDefinitionOperation addFrequencyReportDefinitionOperation = new ReportDefinitionOperation();
            addFrequencyReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
            addFrequencyReportDefinitionOperation.setOperator(Operator.ADD);
            
            ReportDefinition addFrequencyReportDefinition = new ReportDefinition();
            addFrequencyReportDefinition.setAccountId(SoapUtils.getAccountId());
            addFrequencyReportDefinition.setReportType(ReportType.REACH_FREQUENCY);
            addFrequencyReportDefinition.setReportName("TEST_REACH_FREQUENCY_REPORT");
            addFrequencyReportDefinition.setDateRangeType(ReportDateRangeType.YESTERDAY);
            
            //segments
            addFrequencyReportDefinition.getSegments().add(ReportSegment.WEEK);
            addFrequencyReportDefinition.setSort("+FREQUENCYCOUNT");
            addFrequencyReportDefinition.setFormat(ReportDownloadFormat.CSV);
            addFrequencyReportDefinition.setEncode(ReportDownloadEncode.SJIS);
            addFrequencyReportDefinition.setLang(ReportLang.EN);
            addFrequencyReportDefinition.setAddTemplate(ReportAddTemplate.YES);
            
            addFrequencyReportDefinitionOperation.setOperand(addFrequencyReportDefinition);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportDefinitionService::mutate(ADD) REACH_FREQUENCY");
            System.out.println("############################################");
            Holder<ReportDefinitionReturnValue> addFrequencyReportDefinitinonReturnValue = new Holder<ReportDefinitionReturnValue>();
            Holder<List<Error>> addFrequencyReportDefinitionError = new Holder<List<Error>>();
            reportDefinitionService.mutate(addFrequencyReportDefinitionOperation, addFrequencyReportDefinitinonReturnValue, addFrequencyReportDefinitionError);
            
            //if error
            if(addFrequencyReportDefinitionError.value != null && addFrequencyReportDefinitionError.value.size() > 0){
                SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(addFrequencyReportDefinitionError.value), true);
            }
            
            //response
            long frequencyReportId = 0;
            if(addFrequencyReportDefinitinonReturnValue.value != null){
                ReportDefinitionReturnValue returnValue = addFrequencyReportDefinitinonReturnValue.value;
                for (ReportDefinitionValues values : returnValue.getValues()) {
                    if(values.isOperationSucceeded()){
                        ReportDefinition addReportDefinition = values.getReportDefinition();
                        // reportId
                        frequencyReportId = addReportDefinition.getReportId();
                        displayReportDefintion(addReportDefinition);
                    }else{
                        SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(values.getError()), true);
                    }
                }
            }
            
            //=================================================================
            // ReportService
            //=================================================================
            ReportServiceInterface reportService = SoapUtils.createServiceInterface(ReportServiceInterface.class, ReportServiceService.class);
            //-----------------------------------------------
            // call ReportService::getClosedDate;
            //-----------------------------------------------
            ReportClosedDateSelector getClosedDateSelector = new ReportClosedDateSelector();
            getClosedDateSelector.setAccountId(SoapUtils.getAccountId());
           
            //call API
            System.out.println("############################################");
            System.out.println("ReportService::getClosedDate");
            System.out.println("############################################");
            Holder<ReportClosedDateValue> getClosedDateValueHolder = new Holder<ReportClosedDateValue>();
            Holder<List<jp.yahooapis.im.V4.ReportService.Error>> getClosedDateErrorHolder = new Holder<List<jp.yahooapis.im.V4.ReportService.Error>>();
            reportService.getClosedDate(getClosedDateSelector, getClosedDateValueHolder, getClosedDateErrorHolder);
            
            //if error
            if(getClosedDateErrorHolder.value != null && getClosedDateErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getClosedDateErrorHolder.value), true);
            }

            //response
            if(getClosedDateValueHolder.value != null){
                ReportClosedDateValue getReportClosedDateValue = getClosedDateValueHolder.value;
                if(getReportClosedDateValue.isOperationSucceeded()){
                    System.out.println("closedDate = " + getReportClosedDateValue.getClosedDate());
                    System.out.println("-----------------");
                }else{
                    SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getReportClosedDateValue.getError()), true);
                }
            }
            
            //-----------------------------------------------
            // call ReportService::mutate(ADD)
            //-----------------------------------------------
            //request
            ReportRecord addReportRecord = new ReportRecord();
            addReportRecord.setAccountId(SoapUtils.getAccountId());
            addReportRecord.setReportId(reportId);
            ReportOperation addReportOperation = new ReportOperation();
            addReportOperation.setOperator(jp.yahooapis.im.V4.ReportService.Operator.ADD);
            addReportOperation.setAccountId(SoapUtils.getAccountId());
            addReportOperation.getOperand().add(addReportRecord);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportService::mutate(ADD)");
            System.out.println("############################################");
            Holder<ReportReturnValue> addReportReturnValueHolder = new Holder<ReportReturnValue>();
            Holder<List<jp.yahooapis.im.V4.ReportService.Error>> addReportError = new Holder<List<jp.yahooapis.im.V4.ReportService.Error>>(); 
            reportService.mutate(addReportOperation, addReportReturnValueHolder, addReportError);

            //if error
            if(addReportError.value != null && addReportError.value.size() > 0){
                SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(addReportError.value), true);
            }
            
            //response
            long reportJobId = 0;
            if(addReportReturnValueHolder.value != null){
                ReportReturnValue returnValue = addReportReturnValueHolder.value;
                for (ReportValues values : returnValue.getValues()) {
                    if(values.isOperationSucceeded()){
                        reportJobId = values.getReportRecord().getReportJobId();
                        displayReportRecord(values.getReportRecord());
                    }else{
                        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(values.getError()), true);
                    }
                }
            }
            
            //-----------------------------------------------
            // call ReportService::get
            //-----------------------------------------------
            //request
            ReportSelector reportSelector = new ReportSelector();
            reportSelector.setAccountId(SoapUtils.getAccountId());
            reportSelector.getReportJobIds().add(reportJobId);
            
            //call 30sec sleep * 30 = 15minute
            for(int i=0; i<30; i++){
                //sleep 30 second.
                System.out.println("\n***** sleep 30 seconds for Report Download Job *****\n");
                Thread.sleep(30000);
                
                //call API
                System.out.println("############################################");
                System.out.println("ReportService::get");
                System.out.println("############################################");
                Holder<ReportPage> getReportPageHolder = new Holder<ReportPage>();
                Holder<List<jp.yahooapis.im.V4.ReportService.Error>> getReportError = new Holder<List<jp.yahooapis.im.V4.ReportService.Error>>();
                reportService.get(reportSelector, getReportPageHolder, getReportError);
                
                //if error
                if(getReportError.value != null && getReportError.value.size() > 0){
                    SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getReportError.value), true);
                }
                
                //response
                if(getReportPageHolder.value != null){
                    ReportPage reportPage = getReportPageHolder.value;
                    if(reportPage.getValues().size() > 0){
                        ReportValues values = reportPage.getValues().get(0);
                        if(values.isOperationSucceeded()){
                            displayReportRecord(values.getReportRecord());
                        }else{
                            SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(values.getError()), true);
                            System.exit(0);
                        }
                        
                        if(values.getReportRecord().getStatus() == ReportJobStatus.COMPLETED){
                            break;
                        }else{
                            if(values.getReportRecord().getStatus() == ReportJobStatus.ACCEPTED 
                                  || values.getReportRecord().getStatus() == ReportJobStatus.IN_PROGRESS){
                                continue;
                            }else{
                                System.out.println("Error : Job Status failed.");
                                System.exit(0);

                            }
                        }
                    }else{
                        System.out.println("Report job in process on long time. please wait.");
                        System.exit(0);
                    }
                    
                }
            }
            
            //-----------------------------------------------
            // call ReportService::getDownloadUrl
            //-----------------------------------------------
            //request
            ReportDownloadUrlSelector urlSelector = new ReportDownloadUrlSelector();
            urlSelector.setAccountId(SoapUtils.getAccountId());
            urlSelector.getReportJobIds().add(reportJobId);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportService::getDownloadUrl");
            System.out.println("############################################");
            Holder<ReportDownloadUrlPage> getUrlPageHolder = new Holder<ReportDownloadUrlPage>();
            Holder<List<jp.yahooapis.im.V4.ReportService.Error>> getUrlError = new Holder<List<jp.yahooapis.im.V4.ReportService.Error>>();
            reportService.getDownloadUrl(urlSelector, getUrlPageHolder, getUrlError);
            
            //if error
            if(getUrlError.value != null && getUrlError.value.size() > 0){
                SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(getUrlError.value), true);
            }
            
            //response
            String downloadURLStr = null;
            if(getUrlPageHolder.value != null){
                ReportDownloadUrlPage downloadUrlPage = getUrlPageHolder.value;
                for (ReportDownloadUrlValues values : downloadUrlPage.getValues()) {
                    if(values.isOperationSucceeded()){
                        downloadURLStr = values.getReportDownloadUrl().getDownloadUrl();
                        displayReportDownloadUrl(values.getReportDownloadUrl());
                    }else{
                        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(values.getError()), true);
                    }
                }
            }
            
            //-----------------------------------------------
            // download report
            //-----------------------------------------------
            SoapUtils.download(downloadURLStr, downloadFileName);

            //-----------------------------------------------
            // call ReportService::mutate(REMOVE)
            //-----------------------------------------------
            //request
            ReportRecord removeReportRecord = new ReportRecord();
            removeReportRecord.setAccountId(SoapUtils.getAccountId());
            removeReportRecord.setReportJobId(reportJobId);
            ReportOperation removeReportOperation = new ReportOperation();
            removeReportOperation.setOperator(jp.yahooapis.im.V4.ReportService.Operator.REMOVE);
            removeReportOperation.setAccountId(SoapUtils.getAccountId());
            removeReportOperation.getOperand().add(removeReportRecord);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportService::mutate(REMOVE)");
            System.out.println("############################################");
            Holder<ReportReturnValue> removeReportReturnValueHolder = new Holder<ReportReturnValue>();
            Holder<List<jp.yahooapis.im.V4.ReportService.Error>> removeReportError = new Holder<List<jp.yahooapis.im.V4.ReportService.Error>>();
            reportService.mutate(removeReportOperation, removeReportReturnValueHolder, removeReportError);
            
            //if error
            if(removeReportError.value != null && removeReportError.value.size() > 0){
                SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(removeReportError.value), true);
            }
            
            //response
            if(removeReportReturnValueHolder.value != null){
                ReportReturnValue returnValue = removeReportReturnValueHolder.value;
                for (ReportValues values : returnValue.getValues()) {
                    if(values.isOperationSucceeded()){
                        displayReportRecord(values.getReportRecord());
                    }else{
                        SoapUtils.displayErrors(new ReportServiceErrorEntityFactory(values.getError()), true);
                    }
                }
            }
            
            //-----------------------------------------------
            // call ReportDefinitionService::mutate(REMOVE)
            //-----------------------------------------------
            //request
            ReportDefinition removeReportDefinition = new ReportDefinition();
            removeReportDefinition.setAccountId(SoapUtils.getAccountId());
            removeReportDefinition.setReportId(reportId);
            
            ReportDefinitionOperation removeReportDefinitionOperation = new ReportDefinitionOperation();
            removeReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
            removeReportDefinitionOperation.setOperator(Operator.REMOVE);
            removeReportDefinitionOperation.setOperand(removeReportDefinition);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportDefinitionService::mutate(REMOVE)");
            System.out.println("############################################");
            Holder<ReportDefinitionReturnValue> removeReportDefintionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
            Holder<List<Error>> removeReportDefintionErrorHolder = new Holder<List<Error>>();
            reportDefinitionService.mutate(removeReportDefinitionOperation, removeReportDefintionReturnValueHolder, removeReportDefintionErrorHolder);
            
            //if error
            if(removeReportDefintionErrorHolder.value != null && removeReportDefintionErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(removeReportDefintionErrorHolder.value), true);
            }
            
            //reponse
            if(removeReportDefintionReturnValueHolder.value != null){
                List<ReportDefinitionValues> values = removeReportDefintionReturnValueHolder.value.getValues();
                if(values.get(0).isOperationSucceeded()){
                    displayReportDefintion(values.get(0).getReportDefinition());
                }else{
                    SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(values.get(0).getError()), true);
                }
            }
            
            //-----------------------------------------------
            // call ReportDefinitionService::mutate(REMOVE) REACH_FREQUENCY
            //-----------------------------------------------
            //request
            ReportDefinition removeFrequencyReportDefinition = new ReportDefinition();
            removeFrequencyReportDefinition.setAccountId(SoapUtils.getAccountId());
            removeFrequencyReportDefinition.setReportId(frequencyReportId);
            
            ReportDefinitionOperation removeFrequencyReportDefinitionOperation = new ReportDefinitionOperation();
            removeFrequencyReportDefinitionOperation.setAccountId(SoapUtils.getAccountId());
            removeFrequencyReportDefinitionOperation.setOperator(Operator.REMOVE);
            removeFrequencyReportDefinitionOperation.setOperand(removeFrequencyReportDefinition);
            
            //call API
            System.out.println("############################################");
            System.out.println("ReportDefinitionService::mutate(REMOVE) REACH_FREQUENCY");
            System.out.println("############################################");
            Holder<ReportDefinitionReturnValue> removeFrequencyReportDefintionReturnValueHolder = new Holder<ReportDefinitionReturnValue>();
            Holder<List<Error>> removeFrequencyReportDefintionErrorHolder = new Holder<List<Error>>();
            reportDefinitionService.mutate(removeFrequencyReportDefinitionOperation, removeFrequencyReportDefintionReturnValueHolder, removeFrequencyReportDefintionErrorHolder);
            
            //if error
            if(removeFrequencyReportDefintionErrorHolder.value != null && removeFrequencyReportDefintionErrorHolder.value.size() > 0){
                SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(removeFrequencyReportDefintionErrorHolder.value), true);
            }
            
            //reponse
            if(removeFrequencyReportDefintionReturnValueHolder.value != null){
                List<ReportDefinitionValues> values = removeFrequencyReportDefintionReturnValueHolder.value.getValues();
                if(values.get(0).isOperationSucceeded()){
                    displayReportDefintion(values.get(0).getReportDefinition());
                }else{
                    SoapUtils.displayErrors(new ReportDefinitionServiceErrorEntityFactory(values.get(0).getError()), true);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    /**
     * display ReportDownloadUrl entity to stdout.* 
     * @param downloadUrl ReportDownloadUrl
     */
    private static void displayReportDownloadUrl(ReportDownloadUrl downloadUrl) {
        //display response
        System.out.println("accountId = " + downloadUrl.getAccountId());
        System.out.println("reportId = " + downloadUrl.getReportId());
        System.out.println("reportJobId = " + downloadUrl.getReportJobId());
        System.out.println("reportName = " + downloadUrl.getReportName());
        System.out.println("requestTime = " + downloadUrl.getRequestTime());
        System.out.println("completeTime = " + downloadUrl.getCompleteTime());
        System.out.println("status = " + downloadUrl.getStatus());
        System.out.println("---------");
        
    }


    /**
     * display ReportRecord entity to stdout.
     * @param reportRecord ReportRecord entity for display.
     */  
    private static void displayReportRecord(ReportRecord reportRecord) {
        System.out.println("accountId = " + reportRecord.getAccountId());
        System.out.println("reportId = " + reportRecord.getReportId());
        System.out.println("reportJobId = " + reportRecord.getReportJobId());
        System.out.println("reportName = " + reportRecord.getReportName());
        System.out.println("requestTime = " + reportRecord.getRequestTime());
        System.out.println("status = " + reportRecord.getStatus());
        System.out.println("---------");
        
    }

    /**
     * display ReportDefintion entity to stdout.
     * @param reportDefinition ReportDefintion entity for display.
     */    
    private static void displayReportDefintion(ReportDefinition reportDefinition){
        //display response
        System.out.println("accountId = " + reportDefinition.getAccountId());
        System.out.println("reportId = " + reportDefinition.getReportId());
        System.out.println("reportName = " + reportDefinition.getReportName());
        System.out.println("reportType = " + reportDefinition.getReportType());
        System.out.println("dateRangeType = " + reportDefinition.getDateRangeType());
        System.out.println("fields = " + SoapUtils.arrayToLine(reportDefinition.getFields().toArray()));
        System.out.println("segments = " + SoapUtils.arrayToLine(reportDefinition.getSegments().toArray()));
        System.out.println("sort = " + reportDefinition.getSort());
        System.out.println("format = " + reportDefinition.getFormat());
        System.out.println("encode = " + reportDefinition.getEncode());
        System.out.println("lang = " + reportDefinition.getLang());
        System.out.println("---------");
    }
}
