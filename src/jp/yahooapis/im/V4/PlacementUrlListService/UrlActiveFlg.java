
package jp.yahooapis.im.V4.PlacementUrlListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrlActiveFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrlActiveFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAUSED"/>
 *     &lt;enumeration value="ACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UrlActiveFlg")
@XmlEnum
public enum UrlActiveFlg {

    PAUSED,
    ACTIVE;

    public String value() {
        return name();
    }

    public static UrlActiveFlg fromValue(String v) {
        return valueOf(v);
    }

}
