
package jp.yahooapis.im.V4.AdGroupTargetService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GeoTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeoTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}TargetList">
 *       &lt;sequence>
 *         &lt;element name="targets" type="{http://im.yahooapis.jp/V4}GeoTarget" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoTargetList", propOrder = {
    "targets"
})
public class GeoTargetList
    extends TargetList
{

    protected List<GeoTarget> targets;

    /**
     * Gets the value of the targets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeoTarget }
     * 
     * 
     */
    public List<GeoTarget> getTargets() {
        if (targets == null) {
            targets = new ArrayList<GeoTarget>();
        }
        return this.targets;
    }

}
