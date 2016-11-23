/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.google.gson.Gson;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author pierre
 */

@WebService()
public class offersCom {

    @WebMethod(operationName = "getOffers")
    public String getOffers() {

        ManageOffer MO = new ManageOffer();
        List<Offer> temp = MO.listOffers();

        return new Gson().toJson(temp);
    }

}
