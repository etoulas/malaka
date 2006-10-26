<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Manage Managers" scope="page"/> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>${title}</title>
        <jsp:include page="includes/headerFaces.html" />
    </head> 
    <body>
        <jsp:include page="includes/topPageFaces.html" />
        <h1>${title}</h1> 
        <f:view>
            <h:messages showSummary="true" showDetail="false" 
                        style="color: red; 
                        font-family: 'New Century Schoolbook', serif; 
                        font-style: oblique" 
                        id="errors"/> 
            <h:form>
                <h:commandButton id="new" value="Create a new manager" 
                                 action="#{ListCustomersManagedBean.CreateManager}"/>
                
                <h:dataTable id="managerList" value="#{ListCustomersManagedBean.allManagers}" var="rowItem">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Username"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.username}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="First Name"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.firstName}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Last Name"/>
                        </f:facet>
                        <h:outputText value="#{rowItem.lastName}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Edit"/>
                        </f:facet>
                        <h:commandLink action="#{ListCustomersManagedBean.editSelectedManager}" value="Edit"  ></h:commandLink>
                    </h:column>
                </h:dataTable>
            </h:form>
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
    </body>
</html>

