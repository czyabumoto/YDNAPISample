
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryStatus" type="{http://im.yahooapis.jp/V4}DeliveryStatus" minOccurs="0"/>
 *         &lt;element name="reach" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="targetList" type="{http://im.yahooapis.jp/V4}TargetList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingList", propOrder = {
    "accountId",
    "targetListId",
    "targetListName",
    "description",
    "deliveryStatus",
    "reach",
    "targetList"
})
public class RetargetingList {

    protected long accountId;
    protected Long targetListId;
    protected String targetListName;
    protected String description;
    protected DeliveryStatus deliveryStatus;
    protected Long reach;
    protected TargetList targetList;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

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

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the deliveryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryStatus }
     *     
     */
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * Sets the value of the deliveryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryStatus }
     *     
     */
    public void setDeliveryStatus(DeliveryStatus value) {
        this.deliveryStatus = value;
    }

    /**
     * Gets the value of the reach property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReach() {
        return reach;
    }

    /**
     * Sets the value of the reach property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReach(Long value) {
        this.reach = value;
    }

    /**
     * Gets the value of the targetList property.
     * 
     * @return
     *     possible object is
     *     {@link TargetList }
     *     
     */
    public TargetList getTargetList() {
        return targetList;
    }

    /**
     * Sets the value of the targetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetList }
     *     
     */
    public void setTargetList(TargetList value) {
        this.targetList = value;
    }

}
