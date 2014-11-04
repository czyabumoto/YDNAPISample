
package jp.yahooapis.im.V4.MediaService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaFileType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediaFileType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JPEG"/>
 *     &lt;enumeration value="GIF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MediaFileType")
@XmlEnum
public enum MediaFileType {

    JPEG,
    GIF;

    public String value() {
        return name();
    }

    public static MediaFileType fromValue(String v) {
        return valueOf(v);
    }

}
