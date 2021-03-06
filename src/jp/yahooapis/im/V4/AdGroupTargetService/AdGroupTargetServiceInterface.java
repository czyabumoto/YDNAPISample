
package jp.yahooapis.im.V4.AdGroupTargetService;

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
@WebService(name = "AdGroupTargetServiceInterface", targetNamespace = "http://im.yahooapis.jp/V4")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AdGroupTargetServiceInterface {


    /**
     * 
     * @param selector
     * @param rval
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.AdGroupTargetService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.AdGroupTargetService.GetResponse")
    public void get(
        @WebParam(name = "selector", targetNamespace = "http://im.yahooapis.jp/V4")
        AdGroupTargetSelector selector,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<AdGroupTargetPage> rval,
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
    @RequestWrapper(localName = "mutate", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.AdGroupTargetService.Mutate")
    @ResponseWrapper(localName = "mutateResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.AdGroupTargetService.MutateResponse")
    public void mutate(
        @WebParam(name = "operations", targetNamespace = "http://im.yahooapis.jp/V4")
        AdGroupTargetOperation operations,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<AdGroupTargetReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
