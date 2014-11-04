
package jp.yahooapis.im.V4.MasterDataService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MasterDataValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MasterDataValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="master" type="{http://im.yahooapis.jp/V4}Master" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MasterDataValues", propOrder = {
    "master"
})
public class MasterDataValues
    extends ReturnValue
{

    protected Master master;

    /**
     * Gets the value of the master property.
     * 
     * @return
     *     possible object is
     *     {@link Master }
     *     
     */
    public Master getMaster() {
        return master;
    }

    /**
     * Sets the value of the master property.
     * 
     * @param value
     *     allowed object is
     *     {@link Master }
     *     
     */
    public void setMaster(Master value) {
        this.master = value;
    }

}
