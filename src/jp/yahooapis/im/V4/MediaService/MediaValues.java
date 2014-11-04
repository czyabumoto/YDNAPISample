
package jp.yahooapis.im.V4.MediaService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="mediaRecord" type="{http://im.yahooapis.jp/V4}MediaRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaValues", propOrder = {
    "mediaRecord"
})
public class MediaValues
    extends ReturnValue
{

    protected MediaRecord mediaRecord;

    /**
     * Gets the value of the mediaRecord property.
     * 
     * @return
     *     possible object is
     *     {@link MediaRecord }
     *     
     */
    public MediaRecord getMediaRecord() {
        return mediaRecord;
    }

    /**
     * Sets the value of the mediaRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaRecord }
     *     
     */
    public void setMediaRecord(MediaRecord value) {
        this.mediaRecord = value;
    }

}
