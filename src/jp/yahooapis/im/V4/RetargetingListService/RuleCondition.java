
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}RuleType" minOccurs="0"/>
 *         &lt;element name="compareOperator" type="{http://im.yahooapis.jp/V4}CompareOperator" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleCondition", propOrder = {
    "type",
    "compareOperator",
    "value"
})
public class RuleCondition {

    protected RuleType type;
    protected CompareOperator compareOperator;
    protected String value;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setType(RuleType value) {
        this.type = value;
    }

    /**
     * Gets the value of the compareOperator property.
     * 
     * @return
     *     possible object is
     *     {@link CompareOperator }
     *     
     */
    public CompareOperator getCompareOperator() {
        return compareOperator;
    }

    /**
     * Sets the value of the compareOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompareOperator }
     *     
     */
    public void setCompareOperator(CompareOperator value) {
        this.compareOperator = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
