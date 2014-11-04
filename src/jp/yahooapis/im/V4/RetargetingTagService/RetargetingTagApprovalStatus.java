
package jp.yahooapis.im.V4.RetargetingTagService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetargetingTagApprovalStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RetargetingTagApprovalStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AVAILABLE"/>
 *     &lt;enumeration value="DISAPPROVED"/>
 *     &lt;enumeration value="DISAPPROVED_WITH_REVIEW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RetargetingTagApprovalStatus")
@XmlEnum
public enum RetargetingTagApprovalStatus {

    AVAILABLE,
    DISAPPROVED,
    DISAPPROVED_WITH_REVIEW;

    public String value() {
        return name();
    }

    public static RetargetingTagApprovalStatus fromValue(String v) {
        return valueOf(v);
    }

}
