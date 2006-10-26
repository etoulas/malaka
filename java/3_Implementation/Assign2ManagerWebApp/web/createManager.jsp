<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Create Manager" scope="page"/> 
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
            
            <h:form id="enterManagerDetails">
                <h:panelGrid columns="2">
                    <h:panelGroup>
                        <h:outputLabel for="firstName" value="First Name: "/>
                        <h:inputText id="firstName" 
                                     value="#{CreateUserManagedBean.firstName}" 
                                     required="true" />
                    </h:panelGroup>     
                    <h:panelGroup>    
                        <h:outputLabel for="lastName" value="Last Name: "/>
                        <h:inputText id="lastName" 
                                     value="#{CreateUserManagedBean.lastName}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value="Address: "/>
                    <h:panelGrid columns="2">
                        <h:outputLabel for="street" value="Street: "/>
                        <h:inputText id="street" 
                                     value="#{CreateUserManagedBean.street}" 
                                     required="true" />
                        <h:outputLabel for="streetNumber" value="Number: "/>                
                        <h:inputText id="streetNumber" 
                                     value="#{CreateUserManagedBean.streetNumber}" 
                                     required="true" />
                        <h:outputLabel for="postCode" value="Postcode: "/>
                        <h:inputText id="postCode" 
                                     value="#{CreateUserManagedBean.postCode}" 
                                     required="true" />
                        <h:outputLabel for="suburb" value="Suburb: "/>
                        <h:inputText id="suburb" 
                                     value="#{CreateUserManagedBean.suburb}" 
                                     required="true" />
                        <h:outputLabel for="city" value="City: "/>
                        <h:inputText id="city" 
                                     value="#{CreateUserManagedBean.city}" 
                                     required="true" />
                        <h:outputLabel for="state" value="State: "/>
                        <h:inputText id="state" 
                                     value="#{CreateUserManagedBean.countryState}" 
                                     required="true" />
                        <h:outputLabel for="country" value="Country: "/>
                        <h:inputText id="country" 
                                     value="#{CreateUserManagedBean.country}" 
                                     required="true" />
                        <h:outputLabel for="phone" value="Phone Number: "/>
                        <h:inputText id="phone" 
                                     value="#{CreateUserManagedBean.phoneNumber}" 
                                     required="true" />
                    </h:panelGrid>
                    <h:panelGroup>
                        <h:outputLabel for="username" value="Username: "/>
                        <h:inputText id="username" 
                                     value="#{CreateUserManagedBean.username}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value=""/>
                    <h:panelGroup>
                        <h:outputLabel for="password" value="Password: "/>                
                        <h:inputSecret id="password" 
                                       value="#{CreateUserManagedBean.password}" 
                                       required="true" />
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:outputLabel for="repPassword" value="Repeat Password: "/>                
                        <h:inputSecret id="repPassword" 
                                       value="#{CreateUserManagedBean.repPassword}" 
                                       required="true" />
                    </h:panelGroup>
                    <h:commandButton id="submit" value="Continue" 
                                     action="#{CreateUserManagedBean.CreateManager}"/>
                </h:panelGrid>
            </h:form>
            <h:outputLink id="cancel" value="manageManagers.jsp" title="Cancel"/>
            
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
        
        <jsp:include page="includes/bottomPage.html" />
        
        
        
    </body>
</html>
