<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>New Vehicle</title>
         <jsp:include page="includes/headerFaces.html" />
    </head>
    <body>
        <jsp:include page="includes/topPageFaces.html" />
        <h2>List All Vehicles</h2>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h:form>
                <h:dataTable id="vehicleList" value="#{listVehicles.listAllVehicles}" var="rowItem">
                     <h:column>
                        <f:facet name="header">
                            <h:outputText value="Name"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.name}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Edit"/>
                        </f:facet>
                        <h:commandLink action="#{listVehicles.selectEditVehicle}" value="Edit"  ></h:commandLink>
                    </h:column>
                </h:dataTable>
            </h:form>
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
    </body>
</html>
