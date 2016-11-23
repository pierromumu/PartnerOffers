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
                test.OffersComService service = new test.OffersComService();
                test.OffersCom port = service.getOffersComPort();
                // TODO process result here
                java.lang.String result = port.getOffers();

                out.println("Offres :"+"<br/>");
                test.Offer[] converted = new com.google.gson.Gson().fromJson(result, test.Offer[].class);
                for (test.Offer o : converted){
                    out.println(o.toString()+"<br/>");
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
            <%-- end web service invocation --%>
        </body>
    </html>
</f:view>
