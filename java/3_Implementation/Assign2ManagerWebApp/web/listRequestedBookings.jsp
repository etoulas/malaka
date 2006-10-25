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
    </head>
    <body>

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
                    <!--
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Edit"/>
                        </f:facet>
                        <h:commandLink action="#{listVehicles.selectEditVehicle}" value="Edit"  ></h:commandLink>
                    </h:column>
                    -->
                </h:dataTable>
            </h:form>
        </f:view>

    </body>
</html>
