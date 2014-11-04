
package jp.yahooapis.im.V4.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDateRangeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportDateRangeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUSTOM_DATE"/>
 *     &lt;enumeration value="YESTERDAY"/>
 *     &lt;enumeration value="LAST_7_DAYS"/>
 *     &lt;enumeration value="LAST_WEEK"/>
 *     &lt;enumeration value="LAST_BUSINESS_WEEK"/>
 *     &lt;enumeration value="LAST_14_DAYS"/>
 *     &lt;enumeration value="LAST_30_DAYS"/>
 *     &lt;enumeration value="THIS_MONTH"/>
 *     &lt;enumeration value="LAST_MONTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportDateRangeType")
@XmlEnum
public enum ReportDateRangeType {

    CUSTOM_DATE,
    YESTERDAY,
    LAST_7_DAYS,
    LAST_WEEK,
    LAST_BUSINESS_WEEK,
    LAST_14_DAYS,
    LAST_30_DAYS,
    THIS_MONTH,
    LAST_MONTH;

    public String value() {
        return name();
    }

    public static ReportDateRangeType fromValue(String v) {
        return valueOf(v);
    }

}
