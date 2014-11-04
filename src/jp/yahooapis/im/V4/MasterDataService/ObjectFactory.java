
package jp.yahooapis.im.V4.MasterDataService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jp.yahooapis.im.V4.MasterDataService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ApiExceptionFault_QNAME = new QName("http://im.yahooapis.jp/V4", "ApiExceptionFault");
    private final static QName _RequestHeader_QNAME = new QName("http://im.yahooapis.jp/V4", "RequestHeader");
    private final static QName _ResponseHeader_QNAME = new QName("http://im.yahooapis.jp/V4", "ResponseHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jp.yahooapis.im.V4.MasterDataService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SoapHeader }
     * 
     */
    public SoapHeader createSoapHeader() {
        return new SoapHeader();
    }

    /**
     * Create an instance of {@link GetInterestCategory }
     * 
     */
    public GetInterestCategory createGetInterestCategory() {
        return new GetInterestCategory();
    }

    /**
     * Create an instance of {@link GetInterestCategoryResponse }
     * 
     */
    public GetInterestCategoryResponse createGetInterestCategoryResponse() {
        return new GetInterestCategoryResponse();
    }

    /**
     * Create an instance of {@link MasterDataSelector }
     * 
     */
    public MasterDataSelector createMasterDataSelector() {
        return new MasterDataSelector();
    }

    /**
     * Create an instance of {@link Master }
     * 
     */
    public Master createMaster() {
        return new Master();
    }

    /**
     * Create an instance of {@link ChildDataValues }
     * 
     */
    public ChildDataValues createChildDataValues() {
        return new ChildDataValues();
    }

    /**
     * Create an instance of {@link MasterDataValues }
     * 
     */
    public MasterDataValues createMasterDataValues() {
        return new MasterDataValues();
    }

    /**
     * Create an instance of {@link GetSiteCategory }
     * 
     */
    public GetSiteCategory createGetSiteCategory() {
        return new GetSiteCategory();
    }

    /**
     * Create an instance of {@link GetSiteCategoryResponse }
     * 
     */
    public GetSiteCategoryResponse createGetSiteCategoryResponse() {
        return new GetSiteCategoryResponse();
    }

    /**
     * Create an instance of {@link MasterDataPage }
     * 
     */
    public MasterDataPage createMasterDataPage() {
        return new MasterDataPage();
    }

    /**
     * Create an instance of {@link ErrorDetail }
     * 
     */
    public ErrorDetail createErrorDetail() {
        return new ErrorDetail();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link SoapResponseHeader }
     * 
     */
    public SoapResponseHeader createSoapResponseHeader() {
        return new SoapResponseHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V4", name = "ApiExceptionFault")
    public JAXBElement<String> createApiExceptionFault(String value) {
        return new JAXBElement<String>(_ApiExceptionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V4", name = "RequestHeader")
    public JAXBElement<SoapHeader> createRequestHeader(SoapHeader value) {
        return new JAXBElement<SoapHeader>(_RequestHeader_QNAME, SoapHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponseHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://im.yahooapis.jp/V4", name = "ResponseHeader")
    public JAXBElement<SoapResponseHeader> createResponseHeader(SoapResponseHeader value) {
        return new JAXBElement<SoapResponseHeader>(_ResponseHeader_QNAME, SoapResponseHeader.class, null, value);
    }

}
