
package jp.yahooapis.im.V4.RetargetingListService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CombinationTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CombinationTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}TargetList">
 *       &lt;sequence>
 *         &lt;element name="combinations" type="{http://im.yahooapis.jp/V4}Combination" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CombinationTargetList", propOrder = {
    "combinations"
})
public class CombinationTargetList
    extends TargetList
{

    protected List<Combination> combinations;

    /**
     * Gets the value of the combinations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the combinations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCombinations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Combination }
     * 
     * 
     */
    public List<Combination> getCombinations() {
        if (combinations == null) {
            combinations = new ArrayList<Combination>();
        }
        return this.combinations;
    }

}
