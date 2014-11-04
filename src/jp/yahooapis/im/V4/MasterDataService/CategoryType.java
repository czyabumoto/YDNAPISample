
package jp.yahooapis.im.V4.MasterDataService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="MOBILE"/>
 *     &lt;enumeration value="SMARTPHONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CategoryType")
@XmlEnum
public enum CategoryType {

    PC,
    MOBILE,
    SMARTPHONE;

    public String value() {
        return name();
    }

    public static CategoryType fromValue(String v) {
        return valueOf(v);
    }

}
