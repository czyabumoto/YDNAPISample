
package jp.yahooapis.im.V4.AdGroupTargetService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstimateFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAUSED"/>
 *     &lt;enumeration value="ACTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EstimateFlg")
@XmlEnum
public enum EstimateFlg {

    PAUSED,
    ACTIVE;

    public String value() {
        return name();
    }

    public static EstimateFlg fromValue(String v) {
        return valueOf(v);
    }

}
