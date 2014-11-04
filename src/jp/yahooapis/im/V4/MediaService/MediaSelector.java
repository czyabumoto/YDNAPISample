
package jp.yahooapis.im.V4.MediaService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaSelector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaSelector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mediaIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userStatuses" type="{http://im.yahooapis.jp/V4}UserStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approvalStatuses" type="{http://im.yahooapis.jp/V4}MediaApprovalStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://im.yahooapis.jp/V4}Paging" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaSelector", propOrder = {
    "accountId",
    "mediaIds",
    "userStatuses",
    "approvalStatuses",
    "paging"
})
public class MediaSelector {

    protected long accountId;
    @XmlElement(type = Long.class)
    protected List<Long> mediaIds;
    protected List<UserStatus> userStatuses;
    protected List<MediaApprovalStatus> approvalStatuses;
    protected Paging paging;

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
     * Gets the value of the userStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserStatus }
     * 
     * 
     */
    public List<UserStatus> getUserStatuses() {
        if (userStatuses == null) {
            userStatuses = new ArrayList<UserStatus>();
        }
        return this.userStatuses;
    }

    /**
     * Gets the value of the approvalStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaApprovalStatus }
     * 
     * 
     */
    public List<MediaApprovalStatus> getApprovalStatuses() {
        if (approvalStatuses == null) {
            approvalStatuses = new ArrayList<MediaApprovalStatus>();
        }
        return this.approvalStatuses;
    }

    /**
     * Gets the value of the paging property.
     * 
     * @return
     *     possible object is
     *     {@link Paging }
     *     
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Sets the value of the paging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Paging }
     *     
     */
    public void setPaging(Paging value) {
        this.paging = value;
    }

}
