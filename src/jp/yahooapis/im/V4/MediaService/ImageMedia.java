
package jp.yahooapis.im.V4.MediaService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImageMedia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageMedia">
 *   &lt;complexContent>
 *     &lt;extension base="{http://im.yahooapis.jp/V4}Media">
 *       &lt;sequence>
 *         &lt;element name="mediaFileType" type="{http://im.yahooapis.jp/V4}MediaFileType" minOccurs="0"/>
 *         &lt;element name="mediaAdFormat" type="{http://im.yahooapis.jp/V4}MediaAdFormat" minOccurs="0"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="downloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageMedia", propOrder = {
    "mediaFileType",
    "mediaAdFormat",
    "fileSize",
    "width",
    "height",
    "downloadUrl",
    "data"
})
public class ImageMedia
    extends Media
{

    protected MediaFileType mediaFileType;
    protected MediaAdFormat mediaAdFormat;
    protected Long fileSize;
    protected Long width;
    protected Long height;
    protected String downloadUrl;
    protected byte[] data;

    /**
     * Gets the value of the mediaFileType property.
     * 
     * @return
     *     possible object is
     *     {@link MediaFileType }
     *     
     */
    public MediaFileType getMediaFileType() {
        return mediaFileType;
    }

    /**
     * Sets the value of the mediaFileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaFileType }
     *     
     */
    public void setMediaFileType(MediaFileType value) {
        this.mediaFileType = value;
    }

    /**
     * Gets the value of the mediaAdFormat property.
     * 
     * @return
     *     possible object is
     *     {@link MediaAdFormat }
     *     
     */
    public MediaAdFormat getMediaAdFormat() {
        return mediaAdFormat;
    }

    /**
     * Sets the value of the mediaAdFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaAdFormat }
     *     
     */
    public void setMediaAdFormat(MediaAdFormat value) {
        this.mediaAdFormat = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFileSize(Long value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWidth(Long value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHeight(Long value) {
        this.height = value;
    }

    /**
     * Gets the value of the downloadUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Sets the value of the downloadUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadUrl(String value) {
        this.downloadUrl = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = ((byte[]) value);
    }

}
