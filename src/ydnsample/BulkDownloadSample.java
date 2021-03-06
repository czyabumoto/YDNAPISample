package ydnsample;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.BulkService.ApprovalStatus;
import jp.yahooapis.im.V4.BulkService.BulkDownloadReturnValue;
import jp.yahooapis.im.V4.BulkService.BulkDownloadSelector;
import jp.yahooapis.im.V4.BulkService.BulkDownloadStatusPage;
import jp.yahooapis.im.V4.BulkService.BulkDownloadStatusSelector;
import jp.yahooapis.im.V4.BulkService.BulkDownloadType;
import jp.yahooapis.im.V4.BulkService.BulkDownloadValues;
import jp.yahooapis.im.V4.BulkService.BulkEncoding;
import jp.yahooapis.im.V4.BulkService.BulkLang;
import jp.yahooapis.im.V4.BulkService.BulkOutput;
import jp.yahooapis.im.V4.BulkService.BulkServiceInterface;
import jp.yahooapis.im.V4.BulkService.BulkServiceService;
import jp.yahooapis.im.V4.BulkService.DownloadBulkJob;
import jp.yahooapis.im.V4.BulkService.DownloadBulkJobStatus;
import jp.yahooapis.im.V4.BulkService.EntityType;
import jp.yahooapis.im.V4.BulkService.Error;
import jp.yahooapis.im.V4.BulkService.MediaApprovalStatus;
import jp.yahooapis.im.V4.BulkService.UserStatus;
import jp.yahooapis.im.V4.error.impl.BulkServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for Bulk Download.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class BulkDownloadSample {

    /**
     * main method for BulkDownloadSample
     * @param args command line arguments
     */
    public static void main(String[] args){

        try{

            long accountId = SoapUtils.getAccountId();

            //=================================================================
            // BulkService
            //=================================================================
            BulkServiceInterface bulkService = SoapUtils.createServiceInterface(BulkServiceInterface.class, BulkServiceService.class);

            //-----------------------------------------------
            // BulkService::getBulkDownload
            //-----------------------------------------------
            //request
            BulkDownloadSelector bulkDownloadSelector = new BulkDownloadSelector();
            bulkDownloadSelector.setAccountId(accountId);
            bulkDownloadSelector.getCampaignUserStatuses().add(UserStatus.ACTIVE);
            bulkDownloadSelector.getAdGroupUserStatuses().add(UserStatus.ACTIVE);
            bulkDownloadSelector.getAdGroupAdUserStatuses().add(UserStatus.ACTIVE);
            bulkDownloadSelector.getMediaUserStatuses().add(UserStatus.ACTIVE);
            bulkDownloadSelector.getAdGroupAdApprovalStatuses().add(ApprovalStatus.APPROVED);
            bulkDownloadSelector.getMediaApprovalStatuses().add(MediaApprovalStatus.APPROVED);
            bulkDownloadSelector.setEntityTypes(EntityType.ALL);
            bulkDownloadSelector.setDownloadType(BulkDownloadType.CAMPAIGN);
            bulkDownloadSelector.setLang(BulkLang.JA);
            bulkDownloadSelector.setEncoding(BulkEncoding.SJIS);
            bulkDownloadSelector.setOutput(BulkOutput.CSV);

            //call API
            System.out.println("############################################");
            System.out.println("BulkService::getBulkDownload");
            System.out.println("############################################");
            Holder<BulkDownloadReturnValue> bulkDownloadReturnValueHolder = new Holder<BulkDownloadReturnValue>();
            Holder<List<Error>> bulkDownloadError = new Holder<List<Error>>();
            bulkService.getBulkDownload(bulkDownloadSelector, bulkDownloadReturnValueHolder, bulkDownloadError);

            //if error
            if(bulkDownloadError.value != null && bulkDownloadError.value.size() > 0){
                SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadError.value), true);
            }

            //response
            long downloadBulkJobId = 0;
            String bulkDownloadFileName = null;
            List<BulkDownloadValues> bulkDownloadValues = bulkDownloadReturnValueHolder.value.getValues();
            if(bulkDownloadValues.get(0).isOperationSucceeded()){
                DownloadBulkJob downloadBulkJob = bulkDownloadValues.get(0).getDownloadBulkJob();
                //jobId
                downloadBulkJobId = downloadBulkJob.getDownloadBulkJobId();
                //filename
                if(bulkDownloadSelector.getOutput().equals(BulkOutput.ZIPPED_CSV)){
                    bulkDownloadFileName = "BulkDownload_" + bulkDownloadSelector.getDownloadType() + "_" + downloadBulkJobId + ".zip";
                }else{
                    bulkDownloadFileName = "BulkDownload_" + bulkDownloadSelector.getDownloadType() + "_" + downloadBulkJobId + ".csv";
                }
                //display response
                System.out.println("accountId = " + downloadBulkJob.getAccountId());
                System.out.println("downloadBulkJobId = " + downloadBulkJob.getDownloadBulkJobId());
                System.out.println("downloadBulkJobName = " + downloadBulkJob.getDownloadBulkJobName());
                System.out.println("downloadBulkUserName = " + downloadBulkJob.getDownloadBulkUserName());
                System.out.println("downloadBulkStartDate = " + downloadBulkJob.getDownloadBulkStartDate());
                System.out.println("downloadJobStatus = " + downloadBulkJob.getDownloadJobStatus());
                System.out.println("progress = " + downloadBulkJob.getProgress());
                System.out.println("---------");
            }else{
                SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadValues.get(0).getError()), true);
            }

            //-----------------------------------------------
            // BulkService::getBulkDownloadStatus
            //-----------------------------------------------
            //request
            BulkDownloadStatusSelector bulkDownloadStatusSelector = new BulkDownloadStatusSelector();
            bulkDownloadStatusSelector.setAccountId(accountId);
            bulkDownloadStatusSelector.getDownloadBulkJobIds().add(downloadBulkJobId);

            //call 30sec sleep * 30 = 15minute
            String bulkDownloadUrlStr = null;
            DownloadBulkJobStatus jobStatus = null;
            for(int i=0; i<30; i++){
                //sleep 30 second.
                System.out.println("\n***** sleep 30 seconds for Bulk Download Job *****\n");
                Thread.sleep(30000);
                //call API
                System.out.println("############################################");
                System.out.println("BulkService::getBulkDownloadStatus");
                System.out.println("############################################");
                Holder<BulkDownloadStatusPage> bulkDownloadStatusPageHolder = new Holder<BulkDownloadStatusPage>();
                Holder<List<Error>> bulkDownloadStatusError = new Holder<List<Error>>();
                bulkService.getBulkDownloadStatus(bulkDownloadStatusSelector, bulkDownloadStatusPageHolder, bulkDownloadStatusError);

                //if error
                if(bulkDownloadStatusError.value != null && bulkDownloadStatusError.value.size() > 0){
                    SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusError.value), true);
                }

                //response
                List<BulkDownloadValues> bulkDownloadStatusValues = bulkDownloadStatusPageHolder.value.getValues();
                if(bulkDownloadStatusValues.get(0).isOperationSucceeded()){
                    DownloadBulkJob downloadBulkJob = bulkDownloadStatusValues.get(0).getDownloadBulkJob();
                    //get url
                    bulkDownloadUrlStr = downloadBulkJob.getDownloadBulkDownloadUrl();
                    //status
                    jobStatus = downloadBulkJob.getDownloadJobStatus();
                    //display response
                    System.out.println("accountId = " + downloadBulkJob.getAccountId());
                    System.out.println("downloadBulkJobId = " + downloadBulkJob.getDownloadBulkJobId());
                    System.out.println("downloadBulkJobName = " + downloadBulkJob.getDownloadBulkJobName());
                    System.out.println("downloadBulkUserName = " + downloadBulkJob.getDownloadBulkUserName());
                    System.out.println("downloadBulkStartDate = " + downloadBulkJob.getDownloadBulkStartDate());
                    System.out.println("downloadJobStatus = " + downloadBulkJob.getDownloadJobStatus());
                    System.out.println("progress = " + downloadBulkJob.getProgress());
                    System.out.println("---------");

                    if(jobStatus.equals(DownloadBulkJobStatus.COMPLETED)){
                        break;
                    }else{
                        if(jobStatus.equals(DownloadBulkJobStatus.IN_PROGRESS)){
                            continue;
                        }else{
                            System.out.println("Error : Job Status failed.");
                            System.exit(0);
                        }
                    }

                }else{
                    SoapUtils.displayErrors(new BulkServiceErrorEntityFactory(bulkDownloadStatusValues.get(0).getError()), true);
                }
            }

            if(jobStatus != null && jobStatus.equals(DownloadBulkJobStatus.COMPLETED)){
                //-----------------------------------------------
                // download bulk
                //-----------------------------------------------
                SoapUtils.download(bulkDownloadUrlStr, bulkDownloadFileName);
            }else{
                System.out.println("BulkDownload job in process on long time. please wait.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
