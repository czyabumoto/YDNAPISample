
package jp.yahooapis.im.V4.AdGroupAdService;

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
@WebServiceClient(name = "AdGroupAdServiceService", targetNamespace = "http://im.yahooapis.jp/V4", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V4.6/AdGroupAdService?wsdl")
public class AdGroupAdServiceService
    extends Service
{

    private final static URL ADGROUPADSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdServiceService.class.getResource(".");
            url = new URL(baseUrl, "https://sandbox.im.yahooapis.jp/services/V4.6/AdGroupAdService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://sandbox.im.yahooapis.jp/services/V4.6/AdGroupAdService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ADGROUPADSERVICESERVICE_WSDL_LOCATION = url;
    }

    public AdGroupAdServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdGroupAdServiceService() {
        super(ADGROUPADSERVICESERVICE_WSDL_LOCATION, new QName("http://im.yahooapis.jp/V4", "AdGroupAdServiceService"));
    }

    /**
     * 
     * @return
     *     returns AdGroupAdServiceInterface
     */
    @WebEndpoint(name = "AdGroupAdService")
    public AdGroupAdServiceInterface getAdGroupAdService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "AdGroupAdService"), AdGroupAdServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdGroupAdServiceInterface
     */
    @WebEndpoint(name = "AdGroupAdService")
    public AdGroupAdServiceInterface getAdGroupAdService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "AdGroupAdService"), AdGroupAdServiceInterface.class, features);
    }

}
