
package jp.yahooapis.im.V4.PlacementUrlListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UrlList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="placementUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeFlg" type="{http://im.yahooapis.jp/V4}UrlActiveFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UrlList", propOrder = {
    "placementUrl",
    "activeFlg"
})
public class UrlList {

    protected String placementUrl;
    protected UrlActiveFlg activeFlg;

    /**
     * Gets the value of the placementUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacementUrl() {
        return placementUrl;
    }

    /**
     * Sets the value of the placementUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacementUrl(String value) {
        this.placementUrl = value;
    }

    /**
     * Gets the value of the activeFlg property.
     * 
     * @return
     *     possible object is
     *     {@link UrlActiveFlg }
     *     
     */
    public UrlActiveFlg getActiveFlg() {
        return activeFlg;
    }

    /**
     * Sets the value of the activeFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link UrlActiveFlg }
     *     
     */
    public void setActiveFlg(UrlActiveFlg value) {
        this.activeFlg = value;
    }

}
