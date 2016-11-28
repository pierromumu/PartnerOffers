/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("partnerrest")
public class PartnerRest {
    @Context
    private UriInfo context;

    /** Creates a new instance of PartnerRest */
    public PartnerRest() {
    }

    /**
     * Retrieves representation of an instance of test.PartnerRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getOffers() {

        ManageOffer MO2 = new ManageOffer(2);
        List<Offer> temp = MO2.listOffers();

        return new Gson().toJson(temp);
    }

    /**
     * PUT method for updating or creating an instance of PartnerRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
