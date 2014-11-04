
package jp.yahooapis.im.V4.SearchKeywordListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchKeywordListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchKeywordListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="searchKeywordList" type="{http://im.yahooapis.jp/V4}SearchKeywordList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchKeywordListValues", propOrder = {
    "searchKeywordList"
})
public class SearchKeywordListValues
    extends ReturnValue
{

    protected SearchKeywordList searchKeywordList;

    /**
     * Gets the value of the searchKeywordList property.
     * 
     * @return
     *     possible object is
     *     {@link SearchKeywordList }
     *     
     */
    public SearchKeywordList getSearchKeywordList() {
        return searchKeywordList;
    }

    /**
     * Sets the value of the searchKeywordList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchKeywordList }
     *     
     */
    public void setSearchKeywordList(SearchKeywordList value) {
        this.searchKeywordList = value;
    }

}
