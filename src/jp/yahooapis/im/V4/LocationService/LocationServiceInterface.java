
package jp.yahooapis.im.V4.LocationService;

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
@WebService(name = "LocationServiceInterface", targetNamespace = "http://im.yahooapis.jp/V4")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LocationServiceInterface {


    /**
     * 
     * @param rval
     * @param accountId
     * @param error
     * @throws ApiException
     */
    @WebMethod
    @RequestWrapper(localName = "get", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.LocationService.Get")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "http://im.yahooapis.jp/V4", className = "jp.yahooapis.im.V4.LocationService.GetResponse")
    public void get(
        @WebParam(name = "accountId", targetNamespace = "http://im.yahooapis.jp/V4")
        long accountId,
        @WebParam(name = "rval", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<LocationReturnValue> rval,
        @WebParam(name = "error", targetNamespace = "http://im.yahooapis.jp/V4", mode = WebParam.Mode.OUT)
        Holder<List<Error>> error)
        throws ApiException
    ;

}
