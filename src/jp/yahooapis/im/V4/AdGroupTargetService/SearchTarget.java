
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}TargetType"/>
 *         &lt;element name="searchKeywordListId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="searchKeywordListName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchKeywordListStatus" type="{http://im.yahooapis.jp/V4}SearchTargetListStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchTarget", propOrder = {
    "type",
    "searchKeywordListId",
    "searchKeywordListName",
    "searchKeywordListStatus"
})
public class SearchTarget {

    @XmlElement(required = true)
    protected TargetType type;
    protected long searchKeywordListId;
    protected String searchKeywordListName;
    protected SearchTargetListStatus searchKeywordListStatus;

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
     * Gets the value of the searchKeywordListId property.
     * 
     */
    public long getSearchKeywordListId() {
        return searchKeywordListId;
    }

    /**
     * Sets the value of the searchKeywordListId property.
     * 
     */
    public void setSearchKeywordListId(long value) {
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
     * Gets the value of the searchKeywordListStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SearchTargetListStatus }
     *     
     */
    public SearchTargetListStatus getSearchKeywordListStatus() {
        return searchKeywordListStatus;
    }

    /**
     * Sets the value of the searchKeywordListStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchTargetListStatus }
     *     
     */
    public void setSearchKeywordListStatus(SearchTargetListStatus value) {
        this.searchKeywordListStatus = value;
    }

}
