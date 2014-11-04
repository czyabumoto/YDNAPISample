
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsPreset.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsPreset">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsPreset")
@XmlEnum
public enum IsPreset {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static IsPreset fromValue(String v) {
        return valueOf(v);
    }

}
