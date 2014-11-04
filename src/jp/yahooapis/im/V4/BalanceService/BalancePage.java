
package jp.yahooapis.im.V4.BalanceService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalancePage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalancePage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}Page">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V4}BalanceValues" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalancePage", propOrder = {
    "values"
})
public class BalancePage
    extends Page
{

    protected BalanceValues values;

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceValues }
     *     
     */
    public BalanceValues getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceValues }
     *     
     */
    public void setValues(BalanceValues value) {
        this.values = value;
    }

}
