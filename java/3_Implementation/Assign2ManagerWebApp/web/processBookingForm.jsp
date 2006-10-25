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
            <h2>Booking Details</h2>
            <h:form id="processBooking">
                <h:panelGrid columns="2">
                    <h:outputLabel for="selectedBooking" value="ID input: "/>
                    <h:inputText id="selectedBooking" 
                                 value="#{processBookingBean.selectedBooking}" 
                                 required="true" />
                </h:panelGrid>
            </h:form>
        </f:view>
        

    </body>
</html>
