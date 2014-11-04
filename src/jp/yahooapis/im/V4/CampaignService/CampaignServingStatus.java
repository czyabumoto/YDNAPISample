
package jp.yahooapis.im.V4.CampaignService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CampaignServingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CampaignServingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SERVING"/>
 *     &lt;enumeration value="ENDED"/>
 *     &lt;enumeration value="PENDING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CampaignServingStatus")
@XmlEnum
public enum CampaignServingStatus {

    SERVING,
    ENDED,
    PENDING;

    public String value() {
        return name();
    }

    public static CampaignServingStatus fromValue(String v) {
        return valueOf(v);
    }

}
