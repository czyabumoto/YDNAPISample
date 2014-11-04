
package jp.yahooapis.im.V4.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Campaign complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Campaign">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="campaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userStatus" type="{http://im.yahooapis.jp/V4}UserStatus" minOccurs="0"/>
 *         &lt;element name="servingStatus" type="{http://im.yahooapis.jp/V4}CampaignServingStatus" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="budget" type="{http://im.yahooapis.jp/V4}Budget" minOccurs="0"/>
 *         &lt;element name="biddingStrategy" type="{http://im.yahooapis.jp/V4}BiddingStrategy" minOccurs="0"/>
 *         &lt;element name="adProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="frequencyCap" type="{http://im.yahooapis.jp/V4}FrequencyCap" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Campaign", propOrder = {
    "accountId",
    "campaignId",
    "campaignName",
    "userStatus",
    "servingStatus",
    "startDate",
    "endDate",
    "budget",
    "biddingStrategy",
    "adProductType",
    "frequencyCap"
})
public class Campaign {

    protected long accountId;
    protected Long campaignId;
    protected String campaignName;
    protected UserStatus userStatus;
    protected CampaignServingStatus servingStatus;
    protected String startDate;
    protected String endDate;
    protected Budget budget;
    protected BiddingStrategy biddingStrategy;
    protected String adProductType;
    protected FrequencyCap frequencyCap;

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
     * Gets the value of the campaignId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignId() {
        return campaignId;
    }

    /**
     * Sets the value of the campaignId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignId(Long value) {
        this.campaignId = value;
    }

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatus }
     *     
     */
    public UserStatus getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatus }
     *     
     */
    public void setUserStatus(UserStatus value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the servingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CampaignServingStatus }
     *     
     */
    public CampaignServingStatus getServingStatus() {
        return servingStatus;
    }

    /**
     * Sets the value of the servingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CampaignServingStatus }
     *     
     */
    public void setServingStatus(CampaignServingStatus value) {
        this.servingStatus = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the budget property.
     * 
     * @return
     *     possible object is
     *     {@link Budget }
     *     
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * Sets the value of the budget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Budget }
     *     
     */
    public void setBudget(Budget value) {
        this.budget = value;
    }

    /**
     * Gets the value of the biddingStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link BiddingStrategy }
     *     
     */
    public BiddingStrategy getBiddingStrategy() {
        return biddingStrategy;
    }

    /**
     * Sets the value of the biddingStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiddingStrategy }
     *     
     */
    public void setBiddingStrategy(BiddingStrategy value) {
        this.biddingStrategy = value;
    }

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
     * Gets the value of the frequencyCap property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyCap }
     *     
     */
    public FrequencyCap getFrequencyCap() {
        return frequencyCap;
    }

    /**
     * Sets the value of the frequencyCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyCap }
     *     
     */
    public void setFrequencyCap(FrequencyCap value) {
        this.frequencyCap = value;
    }

}
