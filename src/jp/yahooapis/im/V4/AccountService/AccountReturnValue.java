
package jp.yahooapis.im.V4.AccountService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://im.yahooapis.jp/V4}AccountValues" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountReturnValue", propOrder = {
    "values"
})
public class AccountReturnValue
    extends ListReturnValue
{

    protected AccountValues values;

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link AccountValues }
     *     
     */
    public AccountValues getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountValues }
     *     
     */
    public void setValues(AccountValues value) {
        this.values = value;
    }

}
