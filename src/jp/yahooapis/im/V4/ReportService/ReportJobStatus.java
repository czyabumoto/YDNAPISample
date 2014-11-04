
package jp.yahooapis.im.V4.ReportService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCEPTED"/>
 *     &lt;enumeration value="IN_PROGRESS"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="CANCELED"/>
 *     &lt;enumeration value="FAILED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportJobStatus")
@XmlEnum
public enum ReportJobStatus {

    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELED,
    FAILED;

    public String value() {
        return name();
    }

    public static ReportJobStatus fromValue(String v) {
        return valueOf(v);
    }

}
