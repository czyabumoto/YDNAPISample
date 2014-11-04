
package jp.yahooapis.im.V4.SearchKeywordListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchKeywordList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchKeywordList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="searchKeywordListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="searchKeywordListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchKeywordListDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliveryStatus" type="{http://im.yahooapis.jp/V4}DeliveryStatus" minOccurs="0"/>
 *         &lt;element name="searchKeyword" type="{http://im.yahooapis.jp/V4}SearchKeyword" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchKeywordList", propOrder = {
    "accountId",
    "searchKeywordListId",
    "searchKeywordListName",
    "searchKeywordListDescription",
    "deliveryStatus",
    "searchKeyword"
})
public class SearchKeywordList {

    protected long accountId;
    protected Long searchKeywordListId;
    protected String searchKeywordListName;
    protected String searchKeywordListDescription;
    protected DeliveryStatus deliveryStatus;
    protected List<SearchKeyword> searchKeyword;

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
     * Gets the value of the searchKeywordListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSearchKeywordListId() {
        return searchKeywordListId;
    }

    /**
     * Sets the value of the searchKeywordListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSearchKeywordListId(Long value) {
        this.searchKeywordListId = value;
    }

    /**
     * Gets the value of the searchKeywordListName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchKeywordListName() {
        return searchKeywordListName;
    }

    /**
     * Sets the value of the searchKeywordListName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchKeywordListName(String value) {
        this.searchKeywordListName = value;
    }

    /**
     * Gets the value of the searchKeywordListDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchKeywordListDescription() {
        return searchKeywordListDescription;
    }

    /**
     * Sets the value of the searchKeywordListDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchKeywordListDescription(String value) {
        this.searchKeywordListDescription = value;
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
     * Gets the value of the searchKeyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchKeyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchKeyword }
     * 
     * 
     */
    public List<SearchKeyword> getSearchKeyword() {
        if (searchKeyword == null) {
            searchKeyword = new ArrayList<SearchKeyword>();
        }
        return this.searchKeyword;
    }

}
