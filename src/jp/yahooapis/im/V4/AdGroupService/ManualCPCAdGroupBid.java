
package jp.yahooapis.im.V4.AdGroupService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManualCPCAdGroupBid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManualCPCAdGroupBid">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}AdGroupBid">
 *       &lt;sequence>
 *         &lt;element name="maxCpc" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManualCPCAdGroupBid", propOrder = {
    "maxCpc"
})
public class ManualCPCAdGroupBid
    extends AdGroupBid
{

    protected Long maxCpc;

    /**
     * Gets the value of the maxCpc property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxCpc() {
        return maxCpc;
    }

    /**
     * Sets the value of the maxCpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxCpc(Long value) {
        this.maxCpc = value;
    }

}
