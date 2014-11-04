
package jp.yahooapis.im.V4.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuleTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}TargetList">
 *       &lt;sequence>
 *         &lt;element name="retargetingTagId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPreset" type="{http://im.yahooapis.jp/V4}IsPreset" minOccurs="0"/>
 *         &lt;element name="isOpen" type="{http://im.yahooapis.jp/V4}IsOpen" minOccurs="0"/>
 *         &lt;element name="reachPeriod" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="rules" type="{http://im.yahooapis.jp/V4}Rule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuleTargetList", propOrder = {
    "retargetingTagId",
    "isPreset",
    "isOpen",
    "reachPeriod",
    "rules"
})
public class RuleTargetList
    extends TargetList
{

    protected String retargetingTagId;
    protected IsPreset isPreset;
    protected IsOpen isOpen;
    protected Long reachPeriod;
    protected List<Rule> rules;

    /**
     * Gets the value of the retargetingTagId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetargetingTagId() {
        return retargetingTagId;
    }

    /**
     * Sets the value of the retargetingTagId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetargetingTagId(String value) {
        this.retargetingTagId = value;
    }

    /**
     * Gets the value of the isPreset property.
     * 
     * @return
     *     possible object is
     *     {@link IsPreset }
     *     
     */
    public IsPreset getIsPreset() {
        return isPreset;
    }

    /**
     * Sets the value of the isPreset property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsPreset }
     *     
     */
    public void setIsPreset(IsPreset value) {
        this.isPreset = value;
    }

    /**
     * Gets the value of the isOpen property.
     * 
     * @return
     *     possible object is
     *     {@link IsOpen }
     *     
     */
    public IsOpen getIsOpen() {
        return isOpen;
    }

    /**
     * Sets the value of the isOpen property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsOpen }
     *     
     */
    public void setIsOpen(IsOpen value) {
        this.isOpen = value;
    }

    /**
     * Gets the value of the reachPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReachPeriod() {
        return reachPeriod;
    }

    /**
     * Sets the value of the reachPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReachPeriod(Long value) {
        this.reachPeriod = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rule }
     * 
     * 
     */
    public List<Rule> getRules() {
        if (rules == null) {
            rules = new ArrayList<Rule>();
        }
        return this.rules;
    }

}
