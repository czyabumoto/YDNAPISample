
package jp.yahooapis.im.V4.RetargetingListService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogicalOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LogicalOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="AND"/>
 *     &lt;enumeration value="NOTIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LogicalOperator")
@XmlEnum
public enum LogicalOperator {

    OR,
    AND,
    NOTIN;

    public String value() {
        return name();
    }

    public static LogicalOperator fromValue(String v) {
        return valueOf(v);
    }

}
