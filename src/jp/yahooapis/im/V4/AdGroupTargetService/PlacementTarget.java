
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}TargetType"/>
 *         &lt;element name="urlListId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="urlListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlListType" type="{http://im.yahooapis.jp/V4}PlacementUrlListType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementTarget", propOrder = {
    "type",
    "urlListId",
    "urlListName",
    "urlListType"
})
public class PlacementTarget {

    @XmlElement(required = true)
    protected TargetType type;
    protected long urlListId;
    protected String urlListName;
    @XmlElement(required = true)
    protected PlacementUrlListType urlListType;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Gets the value of the urlListId property.
     * 
     */
    public long getUrlListId() {
        return urlListId;
    }

    /**
     * Sets the value of the urlListId property.
     * 
     */
    public void setUrlListId(long value) {
        this.urlListId = value;
    }

    /**
     * Gets the value of the urlListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlListName() {
        return urlListName;
    }

    /**
     * Sets the value of the urlListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlListName(String value) {
        this.urlListName = value;
    }

    /**
     * Gets the value of the urlListType property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementUrlListType }
     *     
     */
    public PlacementUrlListType getUrlListType() {
        return urlListType;
    }

    /**
     * Sets the value of the urlListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementUrlListType }
     *     
     */
    public void setUrlListType(PlacementUrlListType value) {
        this.urlListType = value;
    }

}
