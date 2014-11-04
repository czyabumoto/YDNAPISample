
package jp.yahooapis.im.V4.PlacementUrlListService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementUrlListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementUrlListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="urlList" type="{http://im.yahooapis.jp/V4}PlacementUrlList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementUrlListValues", propOrder = {
    "urlList"
})
public class PlacementUrlListValues
    extends ReturnValue
{

    protected PlacementUrlList urlList;

    /**
     * Gets the value of the urlList property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementUrlList }
     *     
     */
    public PlacementUrlList getUrlList() {
        return urlList;
    }

    /**
     * Sets the value of the urlList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementUrlList }
     *     
     */
    public void setUrlList(PlacementUrlList value) {
        this.urlList = value;
    }

}
