
package jp.yahooapis.im.V4.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FrequencyLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FrequencyLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN"/>
 *     &lt;enumeration value="AD_GROUP"/>
 *     &lt;enumeration value="AD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FrequencyLevel")
@XmlEnum
public enum FrequencyLevel {

    CAMPAIGN,
    AD_GROUP,
    AD;

    public String value() {
        return name();
    }

    public static FrequencyLevel fromValue(String v) {
        return valueOf(v);
    }

}
