
package jp.yahooapis.im.V4.AccountService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountOperation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}Operation">
 *       &lt;sequence>
 *         &lt;element name="operand" type="{http://im.yahooapis.jp/V4}Account"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountOperation", propOrder = {
    "operand"
})
public class AccountOperation
    extends Operation
{

    @XmlElement(required = true)
    protected Account operand;

    /**
     * Gets the value of the operand property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getOperand() {
        return operand;
    }

    /**
     * Sets the value of the operand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setOperand(Account value) {
        this.operand = value;
    }

}
