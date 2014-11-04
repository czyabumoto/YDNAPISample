
package jp.yahooapis.im.V4.PlacementUrlListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnknownDomainFlg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnknownDomainFlg">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRUE"/>
 *     &lt;enumeration value="FALSE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnknownDomainFlg")
@XmlEnum
public enum UnknownDomainFlg {

    TRUE,
    FALSE;

    public String value() {
        return name();
    }

    public static UnknownDomainFlg fromValue(String v) {
        return valueOf(v);
    }

}
