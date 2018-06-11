
package si.feri.aiv.clansoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.feri.aiv.clansoap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VrniOsebo_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "vrniOsebo");
    private final static QName _IzbrisiOseboResponse_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "izbrisiOseboResponse");
    private final static QName _SpremeniResponse_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "spremeniResponse");
    private final static QName _VrniVseOsebeResponse_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "vrniVseOsebeResponse");
    private final static QName _Spremeni_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "spremeni");
    private final static QName _VrniOseboResponse_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "vrniOseboResponse");
    private final static QName _DodajOseboResponse_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "dodajOseboResponse");
    private final static QName _IzbrisiOsebo_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "izbrisiOsebo");
    private final static QName _VrniVseOsebe_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "vrniVseOsebe");
    private final static QName _DodajOsebo_QNAME = new QName("http://ClanSoap.aiv.feri.si/", "dodajOsebo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.feri.aiv.clansoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DodajOsebo }
     * 
     */
    public DodajOsebo createDodajOsebo() {
        return new DodajOsebo();
    }

    /**
     * Create an instance of {@link IzbrisiOsebo }
     * 
     */
    public IzbrisiOsebo createIzbrisiOsebo() {
        return new IzbrisiOsebo();
    }

    /**
     * Create an instance of {@link DodajOseboResponse }
     * 
     */
    public DodajOseboResponse createDodajOseboResponse() {
        return new DodajOseboResponse();
    }

    /**
     * Create an instance of {@link VrniVseOsebe }
     * 
     */
    public VrniVseOsebe createVrniVseOsebe() {
        return new VrniVseOsebe();
    }

    /**
     * Create an instance of {@link Spremeni }
     * 
     */
    public Spremeni createSpremeni() {
        return new Spremeni();
    }

    /**
     * Create an instance of {@link VrniOseboResponse }
     * 
     */
    public VrniOseboResponse createVrniOseboResponse() {
        return new VrniOseboResponse();
    }

    /**
     * Create an instance of {@link VrniOsebo }
     * 
     */
    public VrniOsebo createVrniOsebo() {
        return new VrniOsebo();
    }

    /**
     * Create an instance of {@link IzbrisiOseboResponse }
     * 
     */
    public IzbrisiOseboResponse createIzbrisiOseboResponse() {
        return new IzbrisiOseboResponse();
    }

    /**
     * Create an instance of {@link SpremeniResponse }
     * 
     */
    public SpremeniResponse createSpremeniResponse() {
        return new SpremeniResponse();
    }

    /**
     * Create an instance of {@link VrniVseOsebeResponse }
     * 
     */
    public VrniVseOsebeResponse createVrniVseOsebeResponse() {
        return new VrniVseOsebeResponse();
    }

    /**
     * Create an instance of {@link OsebaClan }
     * 
     */
    public OsebaClan createOsebaClan() {
        return new OsebaClan();
    }

    /**
     * Create an instance of {@link Meritev }
     * 
     */
    public Meritev createMeritev() {
        return new Meritev();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniOsebo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "vrniOsebo")
    public JAXBElement<VrniOsebo> createVrniOsebo(VrniOsebo value) {
        return new JAXBElement<VrniOsebo>(_VrniOsebo_QNAME, VrniOsebo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzbrisiOseboResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "izbrisiOseboResponse")
    public JAXBElement<IzbrisiOseboResponse> createIzbrisiOseboResponse(IzbrisiOseboResponse value) {
        return new JAXBElement<IzbrisiOseboResponse>(_IzbrisiOseboResponse_QNAME, IzbrisiOseboResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpremeniResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "spremeniResponse")
    public JAXBElement<SpremeniResponse> createSpremeniResponse(SpremeniResponse value) {
        return new JAXBElement<SpremeniResponse>(_SpremeniResponse_QNAME, SpremeniResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseOsebeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "vrniVseOsebeResponse")
    public JAXBElement<VrniVseOsebeResponse> createVrniVseOsebeResponse(VrniVseOsebeResponse value) {
        return new JAXBElement<VrniVseOsebeResponse>(_VrniVseOsebeResponse_QNAME, VrniVseOsebeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Spremeni }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "spremeni")
    public JAXBElement<Spremeni> createSpremeni(Spremeni value) {
        return new JAXBElement<Spremeni>(_Spremeni_QNAME, Spremeni.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniOseboResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "vrniOseboResponse")
    public JAXBElement<VrniOseboResponse> createVrniOseboResponse(VrniOseboResponse value) {
        return new JAXBElement<VrniOseboResponse>(_VrniOseboResponse_QNAME, VrniOseboResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajOseboResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "dodajOseboResponse")
    public JAXBElement<DodajOseboResponse> createDodajOseboResponse(DodajOseboResponse value) {
        return new JAXBElement<DodajOseboResponse>(_DodajOseboResponse_QNAME, DodajOseboResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IzbrisiOsebo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "izbrisiOsebo")
    public JAXBElement<IzbrisiOsebo> createIzbrisiOsebo(IzbrisiOsebo value) {
        return new JAXBElement<IzbrisiOsebo>(_IzbrisiOsebo_QNAME, IzbrisiOsebo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseOsebe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "vrniVseOsebe")
    public JAXBElement<VrniVseOsebe> createVrniVseOsebe(VrniVseOsebe value) {
        return new JAXBElement<VrniVseOsebe>(_VrniVseOsebe_QNAME, VrniVseOsebe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajOsebo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ClanSoap.aiv.feri.si/", name = "dodajOsebo")
    public JAXBElement<DodajOsebo> createDodajOsebo(DodajOsebo value) {
        return new JAXBElement<DodajOsebo>(_DodajOsebo_QNAME, DodajOsebo.class, null, value);
    }

}
