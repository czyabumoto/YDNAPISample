
package jp.yahooapis.im.V4.DictionaryService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoryChildValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryChildValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reachDesktop" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reachSmartphone" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="reachTablet" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryChildValues", propOrder = {
    "code",
    "name",
    "fullName",
    "reachDesktop",
    "reachSmartphone",
    "reachTablet"
})
public class CategoryChildValues {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String fullName;
    protected long reachDesktop;
    protected long reachSmartphone;
    protected long reachTablet;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the reachDesktop property.
     * 
     */
    public long getReachDesktop() {
        return reachDesktop;
    }

    /**
     * Sets the value of the reachDesktop property.
     * 
     */
    public void setReachDesktop(long value) {
        this.reachDesktop = value;
    }

    /**
     * Gets the value of the reachSmartphone property.
     * 
     */
    public long getReachSmartphone() {
        return reachSmartphone;
    }

    /**
     * Sets the value of the reachSmartphone property.
     * 
     */
    public void setReachSmartphone(long value) {
        this.reachSmartphone = value;
    }

    /**
     * Gets the value of the reachTablet property.
     * 
     */
    public long getReachTablet() {
        return reachTablet;
    }

    /**
     * Sets the value of the reachTablet property.
     * 
     */
    public void setReachTablet(long value) {
        this.reachTablet = value;
    }

}
