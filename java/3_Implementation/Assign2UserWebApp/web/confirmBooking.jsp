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
                    <h:outputLabel for="type" value="Booking type: "/>
                    <h:outputText id="type" value="#{BookingBean.selectedBookingTypeName}"/>
                    <h:outputText value="Pickup address: "/>
                    <h:panelGroup>
                        <h:panelGrid columns="1">
                            <h:outputLabel for="pickupStreet" value="Street number and name: "/>
                            <h:panelGroup>
                                <h:outputText id="pickupStreetNumber"
                                             value="#{BookingBean.pickupStreetNumber}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="pickupStreet"
                                             value="#{BookingBean.pickupStreet}"/>
                            </h:panelGroup>
                            <h:outputLabel for="pickupPostCode" value="Post code and suburb: "/>
                            <h:panelGroup>
                                <h:outputText id="PickupPostCode"
                                             value="#{BookingBean.pickupPostCode}"/>
                                &nbsp;&nbsp;     
                                <h:outputText id="pickupSuburb"
                                             value="#{BookingBean.pickupSuburb}"/>
                            </h:panelGroup>
                            <h:outputLabel for="pickupCity" value="City:"/>
                            <h:outputText id="pickupCity"
                                         value="#{BookingBean.pickupCity}"/>
                            <h:outputLabel for="pickupCountryState" value="State and Country:"/>
                            <h:panelGroup>
                                <h:outputText id="pickupCountryState"
                                             value="#{BookingBean.pickupCountryState}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="pickupCountry"
                                             value="#{BookingBean.pickupCountry}"/>
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