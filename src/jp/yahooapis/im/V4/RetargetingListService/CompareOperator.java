
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompareOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CompareOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EQUAL"/>
 *     &lt;enumeration value="INCLUDED"/>
 *     &lt;enumeration value="START_WITH"/>
 *     &lt;enumeration value="END_WITH"/>
 *     &lt;enumeration value="NOT_EQUAL"/>
 *     &lt;enumeration value="NOT_INCLUDED"/>
 *     &lt;enumeration value="NOT_START_WITH"/>
 *     &lt;enumeration value="NOT_END_WITH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CompareOperator")
@XmlEnum
public enum CompareOperator {

    EQUAL,
    INCLUDED,
    START_WITH,
    END_WITH,
    NOT_EQUAL,
    NOT_INCLUDED,
    NOT_START_WITH,
    NOT_END_WITH;

    public String value() {
        return name();
    }

    public static CompareOperator fromValue(String v) {
        return valueOf(v);
    }

}
