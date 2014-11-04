
package jp.yahooapis.im.V4.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ruleConditions" type="{http://im.yahooapis.jp/V4}RuleCondition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rule", propOrder = {
    "ruleConditions"
})
public class Rule {

    protected List<RuleCondition> ruleConditions;

    /**
     * Gets the value of the ruleConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruleConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleCondition }
     * 
     * 
     */
    public List<RuleCondition> getRuleConditions() {
        if (ruleConditions == null) {
            ruleConditions = new ArrayList<RuleCondition>();
        }
        return this.ruleConditions;
    }

}
