<%@page contentType="text/html"%> 
<%@page pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<c:set var="title" value="Request Booking" scope="page"/> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>${title}</title> 
    </head> 
    <body> 
        <h1>${title}</h1> 
        <f:view> 
            <!-- Show error messages --> 
            <h:messages showSummary="true" showDetail="false" 
                        style="color: red; 
                        font-family: 'New Century Schoolbook', serif; 
                        font-style: oblique" 
                        id="errors"/> 
            
            <h:form id="enterBookingDetails">
                <h:panelGrid columns="2">
                    <h:outputLabel for="contactName" value="Contact name: "/>
                    <h:inputText id="contactName" 
                                 value="#{BookingBean.contactName}" 
                                 required="true" />
                    <h:outputLabel for="customerName" value="Customer name:" />
                    <h:inputText id="customerName"
                                 value="#{BookingBean.customerName}"
                                 required="true"/>
                    <h:outputLabel for="pickupDate" value="Date and Time for pick up: "/>
                    <h:panelGroup>
                        <h:inputText id="pickupDate"
                                     value="#{BookingBean.pickupDate}" 
                                     required="true" >
                            <f:convertDateTime type="date" pattern="dd/MM/yyyy HH:mm"/>
                        </h:inputText>
                        <h:outputText value=" (dd/mm/yyyy hh:mm)"/>
                    </h:panelGroup>
                    <h:outputLabel for="dropoffDate" value="Date and Time for pick up: "/>
                    <h:panelGroup>
                        <h:inputText id="dropoffDate"
                                     value="#{BookingBean.dropoffDate}" 
                                     required="true" >
                            <f:convertDateTime type="date" pattern="dd/MM/yyyy HH:mm"/>
                        </h:inputText>
                        <h:outputText value=" (dd/mm/yyyy hh:mm)"/>
                    </h:panelGroup>
                    <h:outputLabel for="type" value="Booking type"/>
                    <h:selectOneMenu id="type" value="#{BookingBean.selectedBookingType}" 
                        validator="#{BookingBean.validateBookingType}">
                        <f:selectItems value="#{BookingBean.bookingTypes}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Pickup address: "/>
                    <h:panelGroup>
                        <h:panelGrid columns="1">
                            <h:outputLabel for="pickupStreet" value="Street number and name: "/>
                            <h:panelGroup>
                                <h:inputText id="pickupStreetNumber"
                                             value="#{BookingBean.pickupStreetNumber}"
                                             required="true"
                                             size="4"/>
                                &nbsp;&nbsp;
                                <h:inputText id="pickupStreet"
                                             value="#{BookingBean.pickupStreet}"
                                             required="true"/>
                            </h:panelGroup>
                            <h:outputLabel for="postCode" value="Post code and suburb: "/>
                            <h:panelGroup>
                                <h:inputText id="postCode"
                                             value="#{BookingBean.pickupPostCode}"
                                             required="true"
                                             size="5"/>
                                &nbsp;&nbsp;     
                                <h:inputText id="suburb"
                                             value="#{BookingBean.pickupSuburb}"
                                             required="true"/>
                            </h:panelGroup>
                            <h:outputLabel for="city" value="City:"/>
                            <h:inputText id="city"
                                         value="#{BookingBean.pickupCity}"
                                         required="true"/>
                            <h:outputLabel for="countryState" value="State and Country:"/>
                            <h:panelGroup>
                                <h:inputText id="countryState"
                                             value="#{BookingBean.pickupCountryState}"
                                             required="true"
                                             size="6"/>
                                &nbsp;&nbsp;
                                <h:inputText id="country"
                                             value="#{BookingBean.pickupCountry}"
                                             required="true"/>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGroup>
                    <h:outputText value="Dropoff address: "/>
                    <h:panelGroup>
                        <h:panelGrid columns="1">
                            <h:outputLabel for="dropStreet" value="Street number and name: "/>
                            <h:panelGroup>
                                <h:inputText id="dropStreetNumber"
                                             value="#{BookingBean.dropoffStreetNumber}"
                                             size="4"/>
                                &nbsp;&nbsp;
                                <h:inputText id="dropStreet"
                                             value="#{BookingBean.dropoffStreet}"/>
                            </h:panelGroup>
                            <h:outputLabel for="dropPostCode" value="Post code and suburb: "/>
                            <h:panelGroup>
                                <h:inputText id="dropPostCode"
                                             value="#{BookingBean.dropoffPostCode}"
                                             size="5"/>
                                &nbsp;&nbsp;     
                                <h:inputText id="dropSuburb"
                                             value="#{BookingBean.dropoffSuburb}"/>
                            </h:panelGroup>
                            <h:outputLabel for="dropCity" value="City:"/>
                            <h:inputText id="dropCity"
                                         value="#{BookingBean.dropoffCity}"/>
                            <h:outputLabel for="dropCountryState" value="State and Country:"/>
                            <h:panelGroup>
                                <h:inputText id="dropCountryState"
                                             value="#{BookingBean.dropoffCountryState}"
                                             size="6"/>
                                &nbsp;&nbsp;
                                <h:inputText id="dropCountry"
                                             value="#{BookingBean.dropoffCountry}"/>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGroup>
                    <h:commandButton id="submit" value="Continue" 
                                     action="#{BookingBean.continueBooking}"/>
                </h:panelGrid>
            </h:form> 
        </f:view> 
    </body> 
</html>