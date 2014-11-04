
package jp.yahooapis.im.V4.AdGroupAdService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdStyle">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="IMAGE"/>
 *     &lt;enumeration value="ANIMATION_IMAGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdStyle")
@XmlEnum
public enum AdStyle {

    TEXT,
    IMAGE,
    ANIMATION_IMAGE;

    public String value() {
        return name();
    }

    public static AdStyle fromValue(String v) {
        return valueOf(v);
    }

}
