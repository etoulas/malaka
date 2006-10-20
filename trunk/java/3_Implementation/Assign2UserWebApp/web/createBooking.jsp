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
            
            <h:form id="vehicleSearchForm"> 
                <p>name <h:inputText value="#{CreateBookingManagedBean.contactName}" required="true" id="contactName"/></p> 
                <p>description <h:inputText value="#{CreateBookingManagedBean.customerName}" required="true" id="customerName"/></p> 
                <p>makeAndModel <h:inputText value="#{CreateBookingManagedBean.pickupDate}" required="true" id="pickupDate">
                    <f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
                </h:inputText> (dd/mm/yyyy)</p> 
                <h:commandButton id="submit" value="Request Booking" 
                                 action="#{CreateBookingManagedBean.createBooking}"/> 
            </h:form> 
        </f:view> 
    </body> 
</html>