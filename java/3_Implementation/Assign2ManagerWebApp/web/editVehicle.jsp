<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Edit Vehicle</title>
         <jsp:include page="includes/headerFaces.html" />
    </head>
    <body>
         <jsp:include page="includes/topPageFaces.html" />
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h2>Edit vehicle</h2>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Vehicle Id" />
                    <h:outputText value="#{editVehicle.id}" />
                    <h:outputText value="Colour:"/>
                    <h:inputText id="colour" label="#{editVehicle.colour}" value="#{editVehicle.colour}" title="Colour" />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" label="#{editVehicle.name}" value="#{editVehicle.name}" title="Name" />
                    <h:outputText value="Year:"/>
                    <h:inputText id="year" value="#{editVehicle.year}" title="Year" />
                    <h:outputText value="Vehicle Type" />
                    <h:selectOneMenu value="#{editVehicle.vehicleTypeCode}">
                        <f:selectItems value="#{editVehicle.typeSelectItemList}" />        
                    </h:selectOneMenu>
                    <h:outputText value="Vehicle License" />
                    <h:selectOneMenu value="#{editVehicle.vehicleLicenseID}" >
                        <f:selectItems value="#{editVehicle.licenseSelectItemList}"  />
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:commandButton action="#{editVehicle.saveVehicle}" value="save"/> - <h:commandButton action="#{editVehicle.deleteVehicle}" value="delete"/>
                - <h:commandButton action="cancel" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
         <jsp:include page="includes/bottomPage.html" />
    </body>
</html>
