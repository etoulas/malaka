<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<c:set var="title" value="Process Booking Form" scope="page"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

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
            
            <h:form id="processBooking">
                <h:panelGrid columns="2">
                    <h:outputLabel for="contactName" value="Contact name: "/>
                    <h:outputText id="contactName" 
                                  value="#{processBookingBean.contactName}" />
                    <h:outputLabel for="customerName" value="Customer name:" />
                    <h:outputText id="customerName"
                                  value="#{processBookingBean.customerName}"/>
                    <h:outputLabel for="pickupDate" value="Date and Time for pick up: "/>
                    <h:outputText id="pickupDate"
                                  value="#{processBookingBean.pickupDate}">
                        <f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
                    </h:outputText>
                    <h:outputText value="Pickup address: "/>
                    <h:panelGroup>
                        <h:panelGrid columns="1">
                            <h:outputLabel for="pickupStreet" value="Pickup Street number and name: "/>
                            <h:panelGroup>
                                <h:outputText id="pickupStreetNumber"
                                              value="#{processBookingBean.pickupStreetNumber}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="pickupStreet"
                                              value="#{processBookingBean.pickupStreet}"/>
                            </h:panelGroup>
                            <h:outputLabel for="pickupPostCode" value="Pickup Post code and suburb: "/>
                            <h:panelGroup>
                                <h:outputText id="pickupPostCode"
                                              value="#{processBookingBean.pickupPostCode}"/>
                                &nbsp;&nbsp;     
                                <h:outputText id="pickupSuburb"
                                              value="#{processBookingBean.pickupSuburb}"/>
                            </h:panelGroup>
                            <h:outputLabel for="pickupCity" value="Pickup City:"/>
                            <h:outputText id="pickupCity"
                                          value="#{processBookingBean.pickupCity}"/>
                            <h:outputLabel for="pickupCountryState" value="Pickup State and Country:"/>
                            <h:panelGroup>
                                <h:outputText id="pickupCountryState"
                                              value="#{processBookingBean.pickupCountryState}"/>
                                &nbsp;&nbsp;
                                <h:outputText id="pickupCountry"
                                              value="#{processBookingBean.pickupCountry}"/>
                            </h:panelGroup>
                            <h:outputLabel for="assignVehicle" value="Assign Vehicle and Driver:"/>
                            <h:panelGroup>
                                <h:outputLabel for="assignVehicle" value="Assign Vehicle and Driver: "/>
                                <h:selectOneMenu id="assignVehicle" value="#{processBookingBean.id}">
                                    <f:selectItems value="#{processBookingBean.vehicles}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:commandButton id="confirm" value="Next" 
                                         action="#{processBookingBean.assignDriverVehicle}"/>
                    </h:panelGroup>
                </h:panelGrid>
            </h:form>
        </f:view>
        
    </body>
</html>
