
package jp.yahooapis.im.V4.MediaService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IMAGE"/>
 *     &lt;enumeration value="ANIMATION_IMAGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MediaType")
@XmlEnum
public enum MediaType {

    IMAGE,
    ANIMATION_IMAGE;

    public String value() {
        return name();
    }

    public static MediaType fromValue(String v) {
        return valueOf(v);
    }

}
