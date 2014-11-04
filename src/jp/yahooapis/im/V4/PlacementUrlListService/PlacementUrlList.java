
package jp.yahooapis.im.V4.PlacementUrlListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementUrlList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementUrlList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="urlListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="urlListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isUnknownDomain" type="{http://im.yahooapis.jp/V4}UnknownDomainFlg" minOccurs="0"/>
 *         &lt;element name="urls" type="{http://im.yahooapis.jp/V4}UrlList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementUrlList", propOrder = {
    "accountId",
    "urlListId",
    "urlListName",
    "description",
    "isUnknownDomain",
    "urls"
})
public class PlacementUrlList {

    protected long accountId;
    protected Long urlListId;
    protected String urlListName;
    protected String description;
    protected UnknownDomainFlg isUnknownDomain;
    protected List<UrlList> urls;

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
     * Gets the value of the urlListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUrlListId() {
        return urlListId;
    }

    /**
     * Sets the value of the urlListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUrlListId(Long value) {
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
     * Gets the value of the isUnknownDomain property.
     * 
     * @return
     *     possible object is
     *     {@link UnknownDomainFlg }
     *     
     */
    public UnknownDomainFlg getIsUnknownDomain() {
        return isUnknownDomain;
    }

    /**
     * Sets the value of the isUnknownDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnknownDomainFlg }
     *     
     */
    public void setIsUnknownDomain(UnknownDomainFlg value) {
        this.isUnknownDomain = value;
    }

    /**
     * Gets the value of the urls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UrlList }
     * 
     * 
     */
    public List<UrlList> getUrls() {
        if (urls == null) {
            urls = new ArrayList<UrlList>();
        }
        return this.urls;
    }

}
