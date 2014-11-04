
package jp.yahooapis.im.V4.CampaignService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FrequencyCap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FrequencyCap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://im.yahooapis.jp/V4}FrequencyLevel" minOccurs="0"/>
 *         &lt;element name="timeUnit" type="{http://im.yahooapis.jp/V4}FrequencyTimeUnit" minOccurs="0"/>
 *         &lt;element name="impression" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FrequencyCap", propOrder = {
    "level",
    "timeUnit",
    "impression"
})
public class FrequencyCap {

    protected FrequencyLevel level;
    protected FrequencyTimeUnit timeUnit;
    protected Long impression;

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyLevel }
     *     
     */
    public FrequencyLevel getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyLevel }
     *     
     */
    public void setLevel(FrequencyLevel value) {
        this.level = value;
    }

    /**
     * Gets the value of the timeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link FrequencyTimeUnit }
     *     
     */
    public FrequencyTimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * Sets the value of the timeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyTimeUnit }
     *     
     */
    public void setTimeUnit(FrequencyTimeUnit value) {
        this.timeUnit = value;
    }

    /**
     * Gets the value of the impression property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImpression() {
        return impression;
    }

    /**
     * Sets the value of the impression property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImpression(Long value) {
        this.impression = value;
    }

}
