
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenderTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenderTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}TargetType"/>
 *         &lt;element name="gender" type="{http://im.yahooapis.jp/V4}Gender"/>
 *         &lt;element name="estimateFlg" type="{http://im.yahooapis.jp/V4}EstimateFlg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenderTarget", propOrder = {
    "type",
    "gender",
    "estimateFlg"
})
public class GenderTarget {

    @XmlElement(required = true)
    protected TargetType type;
    @XmlElement(required = true)
    protected Gender gender;
    protected EstimateFlg estimateFlg;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setType(TargetType value) {
        this.type = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the estimateFlg property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateFlg }
     *     
     */
    public EstimateFlg getEstimateFlg() {
        return estimateFlg;
    }

    /**
     * Sets the value of the estimateFlg property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateFlg }
     *     
     */
    public void setEstimateFlg(EstimateFlg value) {
        this.estimateFlg = value;
    }

}
