
package jp.yahooapis.im.V4.ReportDefinitionService;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ReportDefinitionServiceInterface", targetNamespace = "http://im.yahooapis.jp/V4")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReportDefinitionServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V4")
        ReportDefinitionSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionPage> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param error
     * @param operations
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V4")
        ReportDefinitionOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

    /**
     * 
     * @param rval
     * @param reportType
     * @param accountId
     * @param error
     * @param lang
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "getReportFields", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.GetReportFields")
    @ResponseWrapper(localName = "getReportFieldsResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.ReportDefinitionService.GetReportFieldsResponse")
    public void getReportFields(
        @WebParam(name = "accountId", targetNamespace = "http://im.yahooapis.jp/V4")
        long accountId,
        @WebParam(name = "reportType", targetNamespace = "http://im.yahooapis.jp/V4")
        ReportType reportType,
        @WebParam(name = "lang", targetNamespace = "http://im.yahooapis.jp/V4")
        ReportLang lang,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<ReportDefinitionFieldValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
