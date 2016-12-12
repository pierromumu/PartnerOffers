
package test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
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

    private final static QName _GetOffersResponse_QNAME = new QName("http://test/", "getOffersResponse");
    private final static QName _GetOffers_QNAME = new QName("http://test/", "getOffers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOffers }
     * 
     */
    public GetOffers createGetOffers() {
        return new GetOffers();
    }

    /**
     * Create an instance of {@link GetOffersResponse }
     * 
     */
    public GetOffersResponse createGetOffersResponse() {
        return new GetOffersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOffersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test/", name = "getOffersResponse")
    public JAXBElement<GetOffersResponse> createGetOffersResponse(GetOffersResponse value) {
        return new JAXBElement<GetOffersResponse>(_GetOffersResponse_QNAME, GetOffersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOffers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test/", name = "getOffers")
    public JAXBElement<GetOffers> createGetOffers(GetOffers value) {
        return new JAXBElement<GetOffers>(_GetOffers_QNAME, GetOffers.class, null, value);
    }

}
