
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Age.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Age">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GT_RANGE12_14"/>
 *     &lt;enumeration value="GT_RANGE15_17"/>
 *     &lt;enumeration value="GT_RANGE18_19"/>
 *     &lt;enumeration value="GT_RANGE20_21"/>
 *     &lt;enumeration value="GT_RANGE22_29"/>
 *     &lt;enumeration value="GT_RANGE30_39"/>
 *     &lt;enumeration value="GT_RANGE40_49"/>
 *     &lt;enumeration value="GT_RANGE50_59"/>
 *     &lt;enumeration value="GT_RANGE60_69"/>
 *     &lt;enumeration value="GT_RANGE70_UL"/>
 *     &lt;enumeration value="GT_UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Age")
@XmlEnum
public enum Age {

    @XmlEnumValue("GT_RANGE12_14")
    GT_RANGE_12_14("GT_RANGE12_14"),
    @XmlEnumValue("GT_RANGE15_17")
    GT_RANGE_15_17("GT_RANGE15_17"),
    @XmlEnumValue("GT_RANGE18_19")
    GT_RANGE_18_19("GT_RANGE18_19"),
    @XmlEnumValue("GT_RANGE20_21")
    GT_RANGE_20_21("GT_RANGE20_21"),
    @XmlEnumValue("GT_RANGE22_29")
    GT_RANGE_22_29("GT_RANGE22_29"),
    @XmlEnumValue("GT_RANGE30_39")
    GT_RANGE_30_39("GT_RANGE30_39"),
    @XmlEnumValue("GT_RANGE40_49")
    GT_RANGE_40_49("GT_RANGE40_49"),
    @XmlEnumValue("GT_RANGE50_59")
    GT_RANGE_50_59("GT_RANGE50_59"),
    @XmlEnumValue("GT_RANGE60_69")
    GT_RANGE_60_69("GT_RANGE60_69"),
    @XmlEnumValue("GT_RANGE70_UL")
    GT_RANGE_70_UL("GT_RANGE70_UL"),
    GT_UNKNOWN("GT_UNKNOWN");
    private final String value;

    Age(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Age fromValue(String v) {
        for (Age c: Age.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
