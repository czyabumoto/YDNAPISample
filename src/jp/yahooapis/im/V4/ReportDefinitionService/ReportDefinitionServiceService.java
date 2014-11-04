
package jp.yahooapis.im.V4.ReportDefinitionService;

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
@WebServiceClient(name = "ReportDefinitionServiceService", targetNamespace = "http://im.yahooapis.jp/V4", wsdlLocation = "https://sandbox.im.yahooapis.jp/services/V4.6/ReportDefinitionService?wsdl")
public class ReportDefinitionServiceService
    extends Service
{

    private final static URL REPORTDEFINITIONSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = jp.yahooapis.im.V4.ReportDefinitionService.ReportDefinitionServiceService.class.getResource(".");
            url = new URL(baseUrl, "https://sandbox.im.yahooapis.jp/services/V4.6/ReportDefinitionService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://sandbox.im.yahooapis.jp/services/V4.6/ReportDefinitionService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        REPORTDEFINITIONSERVICESERVICE_WSDL_LOCATION = url;
    }

    public ReportDefinitionServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReportDefinitionServiceService() {
        super(REPORTDEFINITIONSERVICESERVICE_WSDL_LOCATION, new QName("http://im.yahooapis.jp/V4", "ReportDefinitionServiceService"));
    }

    /**
     * 
     * @return
     *     returns ReportDefinitionServiceInterface
     */
    @WebEndpoint(name = "ReportDefinitionService")
    public ReportDefinitionServiceInterface getReportDefinitionService() {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "ReportDefinitionService"), ReportDefinitionServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReportDefinitionServiceInterface
     */
    @WebEndpoint(name = "ReportDefinitionService")
    public ReportDefinitionServiceInterface getReportDefinitionService(WebServiceFeature... features) {
        return super.getPort(new QName("http://im.yahooapis.jp/V4", "ReportDefinitionService"), ReportDefinitionServiceInterface.class, features);
    }

}
