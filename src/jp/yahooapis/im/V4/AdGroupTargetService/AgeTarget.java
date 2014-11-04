
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgeTarget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgeTarget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://im.yahooapis.jp/V4}TargetType"/>
 *         &lt;element name="age" type="{http://im.yahooapis.jp/V4}Age"/>
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
@XmlType(name = "AgeTarget", propOrder = {
    "type",
    "age",
    "estimateFlg"
})
public class AgeTarget {

    @XmlElement(required = true)
    protected TargetType type;
    @XmlElement(required = true)
    protected Age age;
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
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Age }
     *     
     */
    public Age getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Age }
     *     
     */
    public void setAge(Age value) {
        this.age = value;
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
