
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimilarityTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimilarityTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}TargetList">
 *       &lt;sequence>
 *         &lt;element name="targetListId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimilarityTargetList", propOrder = {
    "targetListId"
})
public class SimilarityTargetList
    extends TargetList
{

    protected Long targetListId;

    /**
     * Gets the value of the targetListId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTargetListId() {
        return targetListId;
    }

    /**
     * Sets the value of the targetListId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTargetListId(Long value) {
        this.targetListId = value;
    }

}
