
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetListData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetListData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetListData", propOrder = {
    "targetListId",
    "targetListName"
})
public class TargetListData {

    protected Long targetListId;
    protected String targetListName;

    /**
     * Gets the value of the targetListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetListId(Long value) {
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

}
