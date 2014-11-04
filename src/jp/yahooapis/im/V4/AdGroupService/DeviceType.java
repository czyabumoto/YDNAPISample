
package jp.yahooapis.im.V4.AdGroupService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DESKTOP"/>
 *     &lt;enumeration value="WAP_MOBILE"/>
 *     &lt;enumeration value="SMARTPHONE"/>
 *     &lt;enumeration value="TABLET"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceType")
@XmlEnum
public enum DeviceType {

    DESKTOP,
    WAP_MOBILE,
    SMARTPHONE,
    TABLET,
    NONE;

    public String value() {
        return name();
    }

    public static DeviceType fromValue(String v) {
        return valueOf(v);
    }

}
