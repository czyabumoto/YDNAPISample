
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsOpen.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IsOpen">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IsOpen")
@XmlEnum
public enum IsOpen {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static IsOpen fromValue(String v) {
        return valueOf(v);
    }

}
