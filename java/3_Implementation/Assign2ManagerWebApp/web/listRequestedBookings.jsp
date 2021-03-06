<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<c:set var="title" value="Requested Bookings List" scope="page"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
           <jsp:include page="includes/headerFaces.html" />
    </head>
    <body>
  <jsp:include page="includes/topPageFaces.html" />
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>${title}</h1>
            <h:form>
                <h:dataTable id="requestedBookingsTable" value="#{listRequestedBookingsBean.requestedBookings}" var="rowItem">
                     <h:column>
                        <f:facet name="header">
                            <h:outputText value="Booking ID"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.id}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Contact Name"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.contactName}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Customer Name"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.customerName}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Pickup Date"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.pickupDate}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Pickup Time"/>
                        </f:facet>
                        h:outputText value="#-bracket-rowItem.pickupTime-bracket-"/
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Booking Type"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.bookingType.description}"/>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="action"/>
                        </f:facet>
                        <h:commandButton id="submit" value="process"
                                       action="#{listRequestedBookingsBean.selectProcessBooking}"/>
                    </h:column>

                </h:dataTable>
            </h:form>
        </f:view>
 <jsp:include page="includes/bottomPage.html" />
    </body>
</html>
