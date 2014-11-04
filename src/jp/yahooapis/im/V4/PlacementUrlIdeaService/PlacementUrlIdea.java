
package jp.yahooapis.im.V4.PlacementUrlIdeaService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementUrlIdea complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlacementUrlIdea">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteCategory" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adFormat" type="{http://im.yahooapis.jp/V4}AdFormat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="desktopReaches" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="desktopAdRequests" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="smartPhoneReaches" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="smartPhoneAdRequests" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tabletReaches" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tabletAdRequests" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementUrlIdea", propOrder = {
    "searchUrl",
    "keyword",
    "siteCategory",
    "adFormat",
    "desktopReaches",
    "desktopAdRequests",
    "smartPhoneReaches",
    "smartPhoneAdRequests",
    "tabletReaches",
    "tabletAdRequests"
})
public class PlacementUrlIdea {

    protected String searchUrl;
    protected String keyword;
    protected List<String> siteCategory;
    protected List<AdFormat> adFormat;
    protected Long desktopReaches;
    protected Long desktopAdRequests;
    protected Long smartPhoneReaches;
    protected Long smartPhoneAdRequests;
    protected Long tabletReaches;
    protected Long tabletAdRequests;

    /**
     * Gets the value of the searchUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchUrl() {
        return searchUrl;
    }

    /**
     * Sets the value of the searchUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchUrl(String value) {
        this.searchUrl = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyword(String value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the siteCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSiteCategory() {
        if (siteCategory == null) {
            siteCategory = new ArrayList<String>();
        }
        return this.siteCategory;
    }

    /**
     * Gets the value of the adFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdFormat }
     * 
     * 
     */
    public List<AdFormat> getAdFormat() {
        if (adFormat == null) {
            adFormat = new ArrayList<AdFormat>();
        }
        return this.adFormat;
    }

    /**
     * Gets the value of the desktopReaches property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDesktopReaches() {
        return desktopReaches;
    }

    /**
     * Sets the value of the desktopReaches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDesktopReaches(Long value) {
        this.desktopReaches = value;
    }

    /**
     * Gets the value of the desktopAdRequests property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDesktopAdRequests() {
        return desktopAdRequests;
    }

    /**
     * Sets the value of the desktopAdRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDesktopAdRequests(Long value) {
        this.desktopAdRequests = value;
    }

    /**
     * Gets the value of the smartPhoneReaches property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSmartPhoneReaches() {
        return smartPhoneReaches;
    }

    /**
     * Sets the value of the smartPhoneReaches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSmartPhoneReaches(Long value) {
        this.smartPhoneReaches = value;
    }

    /**
     * Gets the value of the smartPhoneAdRequests property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSmartPhoneAdRequests() {
        return smartPhoneAdRequests;
    }

    /**
     * Sets the value of the smartPhoneAdRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSmartPhoneAdRequests(Long value) {
        this.smartPhoneAdRequests = value;
    }

    /**
     * Gets the value of the tabletReaches property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTabletReaches() {
        return tabletReaches;
    }

    /**
     * Sets the value of the tabletReaches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTabletReaches(Long value) {
        this.tabletReaches = value;
    }

    /**
     * Gets the value of the tabletAdRequests property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTabletAdRequests() {
        return tabletAdRequests;
    }

    /**
     * Sets the value of the tabletAdRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTabletAdRequests(Long value) {
        this.tabletAdRequests = value;
    }

}
