
package jp.yahooapis.im.V4.MediaService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaAdFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediaAdFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IAB_UAP_LEADER_BOARD"/>
 *     &lt;enumeration value="IAB_STANDARD_BANNER"/>
 *     &lt;enumeration value="IAB_UAP_MEDIUM_RECTANGLE"/>
 *     &lt;enumeration value="BANNER"/>
 *     &lt;enumeration value="IAB_UAP_WIDE_SKYSCRAPER"/>
 *     &lt;enumeration value="YJ_SMART_DOUBLE_BANNER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MediaAdFormat")
@XmlEnum
public enum MediaAdFormat {

    IAB_UAP_LEADER_BOARD,
    IAB_STANDARD_BANNER,
    IAB_UAP_MEDIUM_RECTANGLE,
    BANNER,
    IAB_UAP_WIDE_SKYSCRAPER,
    YJ_SMART_DOUBLE_BANNER;

    public String value() {
        return name();
    }

    public static MediaAdFormat fromValue(String v) {
        return valueOf(v);
    }

}
