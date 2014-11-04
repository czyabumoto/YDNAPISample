
package jp.yahooapis.im.V4.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Combination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Combination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="logicalOperator" type="{http://im.yahooapis.jp/V4}LogicalOperator" minOccurs="0"/>
 *         &lt;element name="targetLists" type="{http://im.yahooapis.jp/V4}TargetListData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Combination", propOrder = {
    "logicalOperator",
    "targetLists"
})
public class Combination {

    protected LogicalOperator logicalOperator;
    protected List<TargetListData> targetLists;

    /**
     * Gets the value of the logicalOperator property.
     * 
     * @return
     *     possible object is
     *     {@link LogicalOperator }
     *     
     */
    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    /**
     * Sets the value of the logicalOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalOperator }
     *     
     */
    public void setLogicalOperator(LogicalOperator value) {
        this.logicalOperator = value;
    }

    /**
     * Gets the value of the targetLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetListData }
     * 
     * 
     */
    public List<TargetListData> getTargetLists() {
        if (targetLists == null) {
            targetLists = new ArrayList<TargetListData>();
        }
        return this.targetLists;
    }

}
