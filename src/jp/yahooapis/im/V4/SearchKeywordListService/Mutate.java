
package jp.yahooapis.im.V4.SearchKeywordListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operations" type="{http://im.yahooapis.jp/V4}SearchKeywordListOperation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operations"
})
@XmlRootElement(name = "mutate")
public class Mutate {

    @XmlElement(required = true)
    protected SearchKeywordListOperation operations;

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link SearchKeywordListOperation }
     *     
     */
    public SearchKeywordListOperation getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchKeywordListOperation }
     *     
     */
    public void setOperations(SearchKeywordListOperation value) {
        this.operations = value;
    }

}
