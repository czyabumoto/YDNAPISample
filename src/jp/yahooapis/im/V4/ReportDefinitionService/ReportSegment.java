
package jp.yahooapis.im.V4.ReportDefinitionService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportSegment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportSegment">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DAY"/>
 *     &lt;enumeration value="WEEK"/>
 *     &lt;enumeration value="MONTH"/>
 *     &lt;enumeration value="DEVICE"/>
 *     &lt;enumeration value="DEVICE_AND_CARRIER"/>
 *     &lt;enumeration value="DELIVER"/>
 *     &lt;enumeration value="HOUROFDAY"/>
 *     &lt;enumeration value="MEDIA"/>
 *     &lt;enumeration value="AD_STYLE"/>
 *     &lt;enumeration value="AGE"/>
 *     &lt;enumeration value="GENDER"/>
 *     &lt;enumeration value="LOCATION"/>
 *     &lt;enumeration value="SITE_CATEGORY"/>
 *     &lt;enumeration value="INTEREST_CATEGORY"/>
 *     &lt;enumeration value="SEARCH_KEYWORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportSegment")
@XmlEnum
public enum ReportSegment {

    DAY,
    WEEK,
    MONTH,
    DEVICE,
    DEVICE_AND_CARRIER,
    DELIVER,
    HOUROFDAY,
    MEDIA,
    AD_STYLE,
    AGE,
    GENDER,
    LOCATION,
    SITE_CATEGORY,
    INTEREST_CATEGORY,
    SEARCH_KEYWORD;

    public String value() {
        return name();
    }

    public static ReportSegment fromValue(String v) {
        return valueOf(v);
    }

}
