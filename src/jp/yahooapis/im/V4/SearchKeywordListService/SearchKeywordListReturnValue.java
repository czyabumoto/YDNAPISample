
package jp.yahooapis.im.V4.SearchKeywordListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchKeywordListReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchKeywordListReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V4}SearchKeywordListValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchKeywordListReturnValue", propOrder = {
    "values"
})
public class SearchKeywordListReturnValue
    extends ListReturnValue
{

    protected List<SearchKeywordListValues> values;

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchKeywordListValues }
     * 
     * 
     */
    public List<SearchKeywordListValues> getValues() {
        if (values == null) {
            values = new ArrayList<SearchKeywordListValues>();
        }
        return this.values;
    }

}
