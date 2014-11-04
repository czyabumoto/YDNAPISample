
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiteRetargetingTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteRetargetingTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}TargetType"/>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetListStatus" type="{http://im.yahooapis.jp/V4}TargetListStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteRetargetingTarget", propOrder = {
    "type",
    "targetListId",
    "targetListName",
    "targetListStatus"
})
public class SiteRetargetingTarget {

    @XmlElement(required = true)
    protected TargetType type;
    protected long targetListId;
    protected String targetListName;
    protected TargetListStatus targetListStatus;

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
     * Gets the value of the targetListId property.
     * 
     */
    public long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     */
    public void setTargetListId(long value) {
        this.targetListId = value;
    }

    /**
     * Gets the value of the targetListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetListName() {
        return targetListName;
    }

    /**
     * Sets the value of the targetListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetListName(String value) {
        this.targetListName = value;
    }

    /**
     * Gets the value of the targetListStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TargetListStatus }
     *     
     */
    public TargetListStatus getTargetListStatus() {
        return targetListStatus;
    }

    /**
     * Sets the value of the targetListStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetListStatus }
     *     
     */
    public void setTargetListStatus(TargetListStatus value) {
        this.targetListStatus = value;
    }

}
