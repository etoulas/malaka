<%@page contentType="text/html"%> 
<%@page pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<c:set var="title" value="Confirm Booking" scope="page"/> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>${title}</title> 
    </head> 
    <body> 
        <h1>${title}</h1> 
        <f:view>    
            <h:form id="enterBookingDetails">
                <h:panelGrid columns="2">
                    <h:outputLabel for="contactName" value="Contact name: "/>
                    <h:outputText id="contactName" 
                                  value="#{BookingBean.contactName}" />
                    <h:outputLabel for="customerName" value="Customer name:" />
                    <h:outputText id="customerName"
                                  value="#{BookingBean.customerName}"/>
                    <h:outputLabel for="pickupDate" value="Date and Time for pick up: "/>
                    <h:outputText id="pickupDate"
                                  value="#{BookingBean.pickupDate}">
                        <f:convertDateTime type="date" pattern="dd/MM/yyyy HH:mm"/>
                    </h:outputText>
                    <h:outputText value="Pickup address: "/>
                    <h:panelGroup>
                        <h:panelGrid columns="1">
                            <h:outputLabel for="street" value="Street number and name: "/>
                            <h:panelGroup>
                                <h:outputText id="streetNumber"
                                             value="#{BookingBean.streetNumber}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="street"
                                             value="#{BookingBean.street}"/>
                            </h:panelGroup>
                            <h:outputLabel for="postCode" value="Post code and suburb: "/>
                            <h:panelGroup>
                                <h:outputText id="postCode"
                                             value="#{BookingBean.postCode}"/>
                                &nbsp;&nbsp;     
                                <h:outputText id="suburb"
                                             value="#{BookingBean.suburb}"/>
                            </h:panelGroup>
                            <h:outputLabel for="city" value="City:"/>
                            <h:outputText id="city"
                                         value="#{BookingBean.city}"/>
                            <h:outputLabel for="countryState" value="State and Country:"/>
                            <h:panelGroup>
                                <h:outputText id="countryState"
                                             value="#{BookingBean.countryState}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="country"
                                             value="#{BookingBean.country}"/>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:commandButton id="back" value="Back"
                            action="#{BookingBean.confirmBack}"/>
                        <h:commandButton id="submit" value="Confirm Booking" 
                                         action="#{BookingBean.confirmBooking}"/>
                    </h:panelGroup>
                </h:panelGrid>
            </h:form> 
        </f:view> 
    </body> 
</html>