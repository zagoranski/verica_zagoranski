
package si.feri.aiv.clansoap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for osebaClan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="osebaClan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datumVpisa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meritve" type="{http://ClanSoap.aiv.feri.si/}meritev" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="priimek" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osebaClan", propOrder = {
    "datum",
    "datumVpisa",
    "id",
    "ime",
    "mail",
    "meritve",
    "priimek",
    "sifra",
    "spol"
})
public class OsebaClan {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datum;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumVpisa;
    protected int id;
    protected String ime;
    protected String mail;
    @XmlElement(nillable = true)
    protected List<Meritev> meritve;
    protected String priimek;
    protected String sifra;
    protected String spol;

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the datumVpisa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVpisa() {
        return datumVpisa;
    }

    /**
     * Sets the value of the datumVpisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVpisa(XMLGregorianCalendar value) {
        this.datumVpisa = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the meritve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meritve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeritve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Meritev }
     * 
     * 
     */
    public List<Meritev> getMeritve() {
        if (meritve == null) {
            meritve = new ArrayList<Meritev>();
        }
        return this.meritve;
    }

    /**
     * Gets the value of the priimek property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriimek() {
        return priimek;
    }

    /**
     * Sets the value of the priimek property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriimek(String value) {
        this.priimek = value;
    }

    /**
     * Gets the value of the sifra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the spol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpol() {
        return spol;
    }

    /**
     * Sets the value of the spol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpol(String value) {
        this.spol = value;
    }

}
