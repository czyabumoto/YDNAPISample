
package jp.yahooapis.im.V4.SearchKeywordListService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SearchKeywordListService", targetNamespace = "http://im.yahooapis.jp/V4", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V4.6/SearchKeywordListService?wsdl")
public class SearchKeywordListService
    extends Service
{

    private final static URL SEARCHKEYWORDLISTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = jp.yahooapis.im.V4.SearchKeywordListService.SearchKeywordListService.class.getResource(".");
            url = new URL(baseUrl, "https://sandbox.im.yahooapis.jp/services/V4.6/SearchKeywordListService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://sandbox.im.yahooapis.jp/services/V4.6/SearchKeywordListService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SEARCHKEYWORDLISTSERVICE_WSDL_LOCATION = url;
    }

    public SearchKeywordListService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SearchKeywordListService() {
        super(SEARCHKEYWORDLISTSERVICE_WSDL_LOCATION, new QName("http://im.yahooapis.jp/V4", "SearchKeywordListService"));
    }

    /**
     * 
     * @return
     *     returns SearchKeywordListServiceInterface
     */
    @WebEndpoint(name = "SearchKeywordListService")
    public SearchKeywordListServiceInterface getSearchKeywordListService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "SearchKeywordListService"), SearchKeywordListServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SearchKeywordListServiceInterface
     */
    @WebEndpoint(name = "SearchKeywordListService")
    public SearchKeywordListServiceInterface getSearchKeywordListService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "SearchKeywordListService"), SearchKeywordListServiceInterface.class, features);
    }

}
