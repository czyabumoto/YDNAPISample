
package jp.yahooapis.im.V4.BulkService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CAMPAIGN"/>
 *     &lt;enumeration value="AD_GROUP"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="TARGET"/>
 *     &lt;enumeration value="MEDIA"/>
 *     &lt;enumeration value="TARGET_LIST"/>
 *     &lt;enumeration value="SEARCH_KW_LIST"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityType")
@XmlEnum
public enum EntityType {

    CAMPAIGN,
    AD_GROUP,
    AD,
    TARGET,
    MEDIA,
    TARGET_LIST,
    SEARCH_KW_LIST,
    ALL;

    public String value() {
        return name();
    }

    public static EntityType fromValue(String v) {
        return valueOf(v);
    }

}
