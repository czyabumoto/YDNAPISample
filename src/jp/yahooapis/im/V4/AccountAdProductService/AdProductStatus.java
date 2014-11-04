
package jp.yahooapis.im.V4.AccountAdProductService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdProductStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdProductStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OPEN"/>
 *     &lt;enumeration value="SHUT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdProductStatus")
@XmlEnum
public enum AdProductStatus {

    OPEN,
    SHUT;

    public String value() {
        return name();
    }

    public static AdProductStatus fromValue(String v) {
        return valueOf(v);
    }

}
