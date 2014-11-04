
package jp.yahooapis.im.V4.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FrequencyTimeUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FrequencyTimeUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DAY"/>
 *     &lt;enumeration value="WEEK"/>
 *     &lt;enumeration value="MONTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FrequencyTimeUnit")
@XmlEnum
public enum FrequencyTimeUnit {

    DAY,
    WEEK,
    MONTH;

    public String value() {
        return name();
    }

    public static FrequencyTimeUnit fromValue(String v) {
        return valueOf(v);
    }

}
