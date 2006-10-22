<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>New Vehicle</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>New vehicle</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Colour:"/>
                    <h:inputText id="colour" value="#{createVehicle.colour}" title="Colour" />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{createVehicle.name}" title="Name" />
                    <h:outputText value="Year:"/>
                    <h:inputText id="year" value="#{createVehicle.year}" title="Year" />
                    <h:outputText value="Vehicle Type" />
                    <h:selectOneMenu required="true" id="type" value="#{createVehicle.vehicleTypeCode}">
                        <f:selectItems value="#{createVehicle.typeSelectItemList}" />
                    </h:selectOneMenu>
                    <h:outputText value="Vehicle License" />
                    <h:selectOneMenu converter="javax.faces.Long" required="true" id="license" value="#{createVehicle.vehicleLicenseID}" >
                        <f:selectItems value="#{createVehicle.licenseSelectItemList}" />
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:commandLink action="#{createVehicle.addVehicle}" value="Create"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
