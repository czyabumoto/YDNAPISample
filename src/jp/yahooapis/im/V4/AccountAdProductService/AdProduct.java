
package jp.yahooapis.im.V4.AccountAdProductService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdProduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdProduct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://im.yahooapis.jp/V4}AdProductStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdProduct", propOrder = {
    "adProductType",
    "status"
})
public class AdProduct {

    protected String adProductType;
    protected AdProductStatus status;

    /**
     * Gets the value of the adProductType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdProductType() {
        return adProductType;
    }

    /**
     * Sets the value of the adProductType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdProductType(String value) {
        this.adProductType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AdProductStatus }
     *     
     */
    public AdProductStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdProductStatus }
     *     
     */
    public void setStatus(AdProductStatus value) {
        this.status = value;
    }

}
