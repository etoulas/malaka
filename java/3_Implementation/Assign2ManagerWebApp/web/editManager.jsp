<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Edit Manager" scope="page"/> 
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
                        <h:outputLabel for="username" value="Username: "/>
                        <h:outputText id="username" 
                                      value="#{EditManagerManagedBean.username}" 
                        />
                    </h:panelGroup>
                    <h:outputText value=""/>
                    
                    <h:panelGroup>
                        <h:outputLabel for="firstName" value="First Name: "/>
                        <h:inputText id="firstName" 
                                     value="#{EditManagerManagedBean.firstName}" 
                                     required="true" />
                    </h:panelGroup>     
                    <h:panelGroup>    
                        <h:outputLabel for="lastName" value="Last Name: "/>
                        <h:inputText id="lastName" 
                                     value="#{EditManagerManagedBean.lastName}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value="Address: "/>
                    <h:panelGrid columns="2">
                        <h:outputLabel for="street" value="Street: "/>
                        <h:inputText id="street" 
                                     value="#{EditManagerManagedBean.street}" 
                                     required="true" />
                        <h:outputLabel for="streetNumber" value="Number: "/>                
                        <h:inputText id="streetNumber" 
                                     value="#{EditManagerManagedBean.streetNumber}" 
                                     required="true" />
                        <h:outputLabel for="postCode" value="Postcode: "/>
                        <h:inputText id="postCode" 
                                     value="#{EditManagerManagedBean.postCode}" 
                                     required="true" />
                        <h:outputLabel for="suburb" value="Suburb: "/>
                        <h:inputText id="suburb" 
                                     value="#{EditManagerManagedBean.suburb}" 
                                     required="true" />
                        <h:outputLabel for="city" value="City: "/>
                        <h:inputText id="city" 
                                     value="#{EditManagerManagedBean.city}" 
                                     required="true" />
                        <h:outputLabel for="state" value="State: "/>
                        <h:inputText id="state" 
                                     value="#{EditManagerManagedBean.countryState}" 
                                     required="true" />
                        <h:outputLabel for="country" value="Country: "/>
                        <h:inputText id="country" 
                                     value="#{EditManagerManagedBean.country}" 
                                     required="true" />
                        <h:outputLabel for="phone" value="Phone Number: "/>
                        <h:inputText id="phone" 
                                     value="#{EditManagerManagedBean.phoneNumber}" 
                                     required="true" />
                    </h:panelGrid>
                    
                    <h:commandButton id="submit" value="Save" 
                                     action="#{EditManagerManagedBean.EditManager}"/>
                    <h:commandButton id="cancel" value="Cancel" 
                                     action="#{EditManagerManagedBean.CancelEditManager}"/>
                    <h:commandButton id="delete" value="Delete Manager" 
                                     action="#{EditManagerManagedBean.DeleteManager}"/>
                    <h:commandButton id="chPassword" value="Change Password" 
                                     action="#{EditManagerManagedBean.ChangePassword}"/>
                    
                    
                </h:panelGrid>
                
            </h:form>
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
        
        
        
        
        
    </body>
</html>
