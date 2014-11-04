
package jp.yahooapis.im.V4.BulkService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkDownloadSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkDownloadSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="campaignIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mediaIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="campaignUserStatuses" type="{http://im.yahooapis.jp/V4}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupUserStatuses" type="{http://im.yahooapis.jp/V4}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupAdUserStatuses" type="{http://im.yahooapis.jp/V4}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mediaUserStatuses" type="{http://im.yahooapis.jp/V4}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adGroupAdApprovalStatuses" type="{http://im.yahooapis.jp/V4}ApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mediaApprovalStatuses" type="{http://im.yahooapis.jp/V4}MediaApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entityTypes" type="{http://im.yahooapis.jp/V4}EntityType" minOccurs="0"/>
 *         &lt;element name="downloadBulkJob" type="{http://im.yahooapis.jp/V4}DownloadBulkJob" minOccurs="0"/>
 *         &lt;element name="downloadType" type="{http://im.yahooapis.jp/V4}BulkDownloadType" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://im.yahooapis.jp/V4}BulkLang" minOccurs="0"/>
 *         &lt;element name="output" type="{http://im.yahooapis.jp/V4}BulkOutput"/>
 *         &lt;element name="encoding" type="{http://im.yahooapis.jp/V4}BulkEncoding"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkDownloadSelector", propOrder = {
    "accountId",
    "campaignIds",
    "adGroupIds",
    "adIds",
    "mediaIds",
    "campaignUserStatuses",
    "adGroupUserStatuses",
    "adGroupAdUserStatuses",
    "mediaUserStatuses",
    "adGroupAdApprovalStatuses",
    "mediaApprovalStatuses",
    "entityTypes",
    "downloadBulkJob",
    "downloadType",
    "lang",
    "output",
    "encoding"
})
public class BulkDownloadSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> campaignIds;
    @XmlElement(type = Long.class)
    protected List<Long> adGroupIds;
    @XmlElement(type = Long.class)
    protected List<Long> adIds;
    @XmlElement(type = Long.class)
    protected List<Long> mediaIds;
    protected List<UserStatus> campaignUserStatuses;
    protected List<UserStatus> adGroupUserStatuses;
    protected List<UserStatus> adGroupAdUserStatuses;
    protected List<UserStatus> mediaUserStatuses;
    protected List<ApprovalStatus> adGroupAdApprovalStatuses;
    protected List<MediaApprovalStatus> mediaApprovalStatuses;
    protected EntityType entityTypes;
    protected DownloadBulkJob downloadBulkJob;
    protected BulkDownloadType downloadType;
    protected BulkLang lang;
    @XmlElement(required = true)
    protected BulkOutput output;
    @XmlElement(required = true)
    protected BulkEncoding encoding;

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
     * Gets the value of the campaignIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCampaignIds() {
        if (campaignIds == null) {
            campaignIds = new ArrayList<Long>();
        }
        return this.campaignIds;
    }

    /**
     * Gets the value of the adGroupIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdGroupIds() {
        if (adGroupIds == null) {
            adGroupIds = new ArrayList<Long>();
        }
        return this.adGroupIds;
    }

    /**
     * Gets the value of the adIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getAdIds() {
        if (adIds == null) {
            adIds = new ArrayList<Long>();
        }
        return this.adIds;
    }

    /**
     * Gets the value of the mediaIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getMediaIds() {
        if (mediaIds == null) {
            mediaIds = new ArrayList<Long>();
        }
        return this.mediaIds;
    }

    /**
     * Gets the value of the campaignUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campaignUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampaignUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getCampaignUserStatuses() {
        if (campaignUserStatuses == null) {
            campaignUserStatuses = new ArrayList<UserStatus>();
        }
        return this.campaignUserStatuses;
    }

    /**
     * Gets the value of the adGroupUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getAdGroupUserStatuses() {
        if (adGroupUserStatuses == null) {
            adGroupUserStatuses = new ArrayList<UserStatus>();
        }
        return this.adGroupUserStatuses;
    }

    /**
     * Gets the value of the adGroupAdUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupAdUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupAdUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getAdGroupAdUserStatuses() {
        if (adGroupAdUserStatuses == null) {
            adGroupAdUserStatuses = new ArrayList<UserStatus>();
        }
        return this.adGroupAdUserStatuses;
    }

    /**
     * Gets the value of the mediaUserStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaUserStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getMediaUserStatuses() {
        if (mediaUserStatuses == null) {
            mediaUserStatuses = new ArrayList<UserStatus>();
        }
        return this.mediaUserStatuses;
    }

    /**
     * Gets the value of the adGroupAdApprovalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adGroupAdApprovalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdGroupAdApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalStatus }
     * 
     * 
     */
    public List<ApprovalStatus> getAdGroupAdApprovalStatuses() {
        if (adGroupAdApprovalStatuses == null) {
            adGroupAdApprovalStatuses = new ArrayList<ApprovalStatus>();
        }
        return this.adGroupAdApprovalStatuses;
    }

    /**
     * Gets the value of the mediaApprovalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaApprovalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaApprovalStatus }
     * 
     * 
     */
    public List<MediaApprovalStatus> getMediaApprovalStatuses() {
        if (mediaApprovalStatuses == null) {
            mediaApprovalStatuses = new ArrayList<MediaApprovalStatus>();
        }
        return this.mediaApprovalStatuses;
    }

    /**
     * Gets the value of the entityTypes property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getEntityTypes() {
        return entityTypes;
    }

    /**
     * Sets the value of the entityTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setEntityTypes(EntityType value) {
        this.entityTypes = value;
    }

    /**
     * Gets the value of the downloadBulkJob property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadBulkJob }
     *     
     */
    public DownloadBulkJob getDownloadBulkJob() {
        return downloadBulkJob;
    }

    /**
     * Sets the value of the downloadBulkJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadBulkJob }
     *     
     */
    public void setDownloadBulkJob(DownloadBulkJob value) {
        this.downloadBulkJob = value;
    }

    /**
     * Gets the value of the downloadType property.
     * 
     * @return
     *     possible object is
     *     {@link BulkDownloadType }
     *     
     */
    public BulkDownloadType getDownloadType() {
        return downloadType;
    }

    /**
     * Sets the value of the downloadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkDownloadType }
     *     
     */
    public void setDownloadType(BulkDownloadType value) {
        this.downloadType = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link BulkLang }
     *     
     */
    public BulkLang getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkLang }
     *     
     */
    public void setLang(BulkLang value) {
        this.lang = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link BulkOutput }
     *     
     */
    public BulkOutput getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkOutput }
     *     
     */
    public void setOutput(BulkOutput value) {
        this.output = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link BulkEncoding }
     *     
     */
    public BulkEncoding getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkEncoding }
     *     
     */
    public void setEncoding(BulkEncoding value) {
        this.encoding = value;
    }

}
