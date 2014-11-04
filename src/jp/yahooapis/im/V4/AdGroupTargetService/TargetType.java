
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD_SCHEDULE_TARGET"/>
 *     &lt;enumeration value="GEO_TARGET"/>
 *     &lt;enumeration value="AGE_TARGET"/>
 *     &lt;enumeration value="GENDER_TARGET"/>
 *     &lt;enumeration value="INTEREST_CATEGORY"/>
 *     &lt;enumeration value="SITE_CATEGORY"/>
 *     &lt;enumeration value="SITE_RETARGETING"/>
 *     &lt;enumeration value="SEARCH_TARGET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetType")
@XmlEnum
public enum TargetType {

    AD_SCHEDULE_TARGET,
    GEO_TARGET,
    AGE_TARGET,
    GENDER_TARGET,
    INTEREST_CATEGORY,
    SITE_CATEGORY,
    SITE_RETARGETING,
    SEARCH_TARGET;

    public String value() {
        return name();
    }

    public static TargetType fromValue(String v) {
        return valueOf(v);
    }

}
