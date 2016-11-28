/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class offersSoapWS {

    @WebMethod(operationName = "getOffers")
    public String getOffers() {

        ManageOffer MO1 = new ManageOffer(1);
        List<Offer> temp = MO1.listOffers();

        return new Gson().toJson(temp);
    }

}