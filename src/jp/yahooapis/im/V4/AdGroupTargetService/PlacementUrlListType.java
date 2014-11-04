
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementUrlListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlacementUrlListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WHITE_LIST"/>
 *     &lt;enumeration value="BLACK_LIST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlacementUrlListType")
@XmlEnum
public enum PlacementUrlListType {

    WHITE_LIST,
    BLACK_LIST;

    public String value() {
        return name();
    }

    public static PlacementUrlListType fromValue(String v) {
        return valueOf(v);
    }

}
