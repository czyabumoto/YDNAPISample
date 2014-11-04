
package jp.yahooapis.im.V4.BulkService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediaApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPROVED"/>
 *     &lt;enumeration value="REVIEW"/>
 *     &lt;enumeration value="PRE_DISAPPROVED"/>
 *     &lt;enumeration value="POST_DISAPPROVED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MediaApprovalStatus")
@XmlEnum
public enum MediaApprovalStatus {

    APPROVED,
    REVIEW,
    PRE_DISAPPROVED,
    POST_DISAPPROVED;

    public String value() {
        return name();
    }

    public static MediaApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}
