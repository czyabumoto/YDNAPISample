
package jp.yahooapis.im.V4.SearchKeywordListService;

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
@WebService(name = "SearchKeywordListServiceInterface", targetNamespace = "http://im.yahooapis.jp/V4")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SearchKeywordListServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.SearchKeywordListService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.SearchKeywordListService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V4")
        SearchKeywordListSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<SearchKeywordListPage> rval,
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.SearchKeywordListService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.SearchKeywordListService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V4")
        SearchKeywordListOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<SearchKeywordListReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
