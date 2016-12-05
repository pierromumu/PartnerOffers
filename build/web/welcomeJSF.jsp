<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>

            <%-- start web service invocation --%>
            <%
            try {
                out.println("Offers from  SOAP & REST"+"<br/>");

                test.OffersSoapWSService service = new test.OffersSoapWSService();
                test.OffersSoapWS port = service.getOffersSoapWSPort();
                java.lang.String result = port.getOffers();
                java.util.List<test.Offer> convertedSoap = java.util.Arrays.asList(new com.google.gson.Gson().fromJson(result, test.Offer[].class));

                com.sun.jersey.api.client.Client cl = com.sun.jersey.api.client.Client.create();
                com.sun.jersey.api.client.WebResource r = cl.resource("http://localhost:8080/PartnerOffers/resources/partnerrest");
                java.lang.String resuRest = r.get(java.lang.String.class);
                java.util.List<test.Offer> convertedRest = java.util.Arrays.asList(new com.google.gson.Gson().fromJson(resuRest, test.Offer[].class));

                java.util.List<test.Offer> convertedConcat = new java.util.ArrayList<test.Offer>(convertedSoap);
                convertedConcat.addAll(convertedRest);
                
                test.SortedOffersList s = new test.SortedOffersList(convertedConcat);
                s.sortListByPay();

                java.util.Iterator<test.Offer> i = s.getOffers().iterator();
		while (i.hasNext()) {
			out.println("&emsp;"+"→ "+i.next().toString()+"<br/>");
		}
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
            <%-- end web service invocation --%>
            
        </body>
    </html>
</f:view>
