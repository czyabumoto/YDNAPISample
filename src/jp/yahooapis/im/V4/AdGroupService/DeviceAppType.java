
package jp.yahooapis.im.V4.AdGroupService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceAppType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceAppType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APP"/>
 *     &lt;enumeration value="WEB"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceAppType")
@XmlEnum
public enum DeviceAppType {

    APP,
    WEB,
    NONE;

    public String value() {
        return name();
    }

    public static DeviceAppType fromValue(String v) {
        return valueOf(v);
    }

}
