
package jp.yahooapis.im.V4.BulkService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessingItemsCount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessingItemsCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campaignCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupAdCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupTargetCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mediaCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupAdErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adGroupTargetErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mediaErrorCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessingItemsCount", propOrder = {
    "campaignCount",
    "adGroupCount",
    "adGroupAdCount",
    "adGroupTargetCount",
    "mediaCount",
    "campaignErrorCount",
    "adGroupErrorCount",
    "adGroupAdErrorCount",
    "adGroupTargetErrorCount",
    "mediaErrorCount"
})
public class ProcessingItemsCount {

    protected Long campaignCount;
    protected Long adGroupCount;
    protected Long adGroupAdCount;
    protected Long adGroupTargetCount;
    protected Long mediaCount;
    protected Long campaignErrorCount;
    protected Long adGroupErrorCount;
    protected Long adGroupAdErrorCount;
    protected Long adGroupTargetErrorCount;
    protected Long mediaErrorCount;

    /**
     * Gets the value of the campaignCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignCount() {
        return campaignCount;
    }

    /**
     * Sets the value of the campaignCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignCount(Long value) {
        this.campaignCount = value;
    }

    /**
     * Gets the value of the adGroupCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupCount() {
        return adGroupCount;
    }

    /**
     * Sets the value of the adGroupCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupCount(Long value) {
        this.adGroupCount = value;
    }

    /**
     * Gets the value of the adGroupAdCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupAdCount() {
        return adGroupAdCount;
    }

    /**
     * Sets the value of the adGroupAdCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupAdCount(Long value) {
        this.adGroupAdCount = value;
    }

    /**
     * Gets the value of the adGroupTargetCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupTargetCount() {
        return adGroupTargetCount;
    }

    /**
     * Sets the value of the adGroupTargetCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupTargetCount(Long value) {
        this.adGroupTargetCount = value;
    }

    /**
     * Gets the value of the mediaCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMediaCount() {
        return mediaCount;
    }

    /**
     * Sets the value of the mediaCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMediaCount(Long value) {
        this.mediaCount = value;
    }

    /**
     * Gets the value of the campaignErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignErrorCount() {
        return campaignErrorCount;
    }

    /**
     * Sets the value of the campaignErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignErrorCount(Long value) {
        this.campaignErrorCount = value;
    }

    /**
     * Gets the value of the adGroupErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupErrorCount() {
        return adGroupErrorCount;
    }

    /**
     * Sets the value of the adGroupErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupErrorCount(Long value) {
        this.adGroupErrorCount = value;
    }

    /**
     * Gets the value of the adGroupAdErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupAdErrorCount() {
        return adGroupAdErrorCount;
    }

    /**
     * Sets the value of the adGroupAdErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupAdErrorCount(Long value) {
        this.adGroupAdErrorCount = value;
    }

    /**
     * Gets the value of the adGroupTargetErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdGroupTargetErrorCount() {
        return adGroupTargetErrorCount;
    }

    /**
     * Sets the value of the adGroupTargetErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdGroupTargetErrorCount(Long value) {
        this.adGroupTargetErrorCount = value;
    }

    /**
     * Gets the value of the mediaErrorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMediaErrorCount() {
        return mediaErrorCount;
    }

    /**
     * Sets the value of the mediaErrorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMediaErrorCount(Long value) {
        this.mediaErrorCount = value;
    }

}
