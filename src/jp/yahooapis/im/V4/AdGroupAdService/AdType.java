
package jp.yahooapis.im.V4.AdGroupAdService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT_LONG_AD1"/>
 *     &lt;enumeration value="TEXT_LONG_AD2"/>
 *     &lt;enumeration value="TEXT_SHORT_AD1"/>
 *     &lt;enumeration value="TEXT_SHORT_AD2"/>
 *     &lt;enumeration value="POS_AD"/>
 *     &lt;enumeration value="NONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdType")
@XmlEnum
public enum AdType {

    @XmlEnumValue("TEXT_LONG_AD1")
    TEXT_LONG_AD_1("TEXT_LONG_AD1"),
    @XmlEnumValue("TEXT_LONG_AD2")
    TEXT_LONG_AD_2("TEXT_LONG_AD2"),
    @XmlEnumValue("TEXT_SHORT_AD1")
    TEXT_SHORT_AD_1("TEXT_SHORT_AD1"),
    @XmlEnumValue("TEXT_SHORT_AD2")
    TEXT_SHORT_AD_2("TEXT_SHORT_AD2"),
    POS_AD("POS_AD"),
    NONE("NONE");
    private final String value;

    AdType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdType fromValue(String v) {
        for (AdType c: AdType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
