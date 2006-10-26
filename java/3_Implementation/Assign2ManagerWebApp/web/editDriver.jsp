<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Edit Driver" scope="page"/> 
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
            
            <h:form id="enterDriverDetails">
                <h:panelGrid columns="2">
                    <h:panelGroup>
                        <h:outputLabel for="username" value="Username: "/>
                        <h:outputText id="username" 
                                      value="#{EditDriverManagedBean.username}" 
                        />
                    </h:panelGroup>
                    <h:outputText value=""/>
                    
                    <h:panelGroup>
                        <h:outputLabel for="firstName" value="First Name: "/>
                        <h:inputText id="firstName" 
                                     value="#{EditDriverManagedBean.firstName}" 
                                     required="true" />
                    </h:panelGroup>     
                    <h:panelGroup>    
                        <h:outputLabel for="lastName" value="Last Name: "/>
                        <h:inputText id="lastName" 
                                     value="#{EditDriverManagedBean.lastName}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value="Address: "/>
                    <h:panelGrid columns="2">
                        <h:outputLabel for="street" value="Street: "/>
                        <h:inputText id="street" 
                                     value="#{EditDriverManagedBean.street}" 
                                     required="true" />
                        <h:outputLabel for="streetNumber" value="Number: "/>                
                        <h:inputText id="streetNumber" 
                                     value="#{EditDriverManagedBean.streetNumber}" 
                                     required="true" />
                        <h:outputLabel for="postCode" value="Postcode: "/>
                        <h:inputText id="postCode" 
                                     value="#{EditDriverManagedBean.postCode}" 
                                     required="true" />
                        <h:outputLabel for="suburb" value="Suburb: "/>
                        <h:inputText id="suburb" 
                                     value="#{EditDriverManagedBean.suburb}" 
                                     required="true" />
                        <h:outputLabel for="city" value="City: "/>
                        <h:inputText id="city" 
                                     value="#{EditDriverManagedBean.city}" 
                                     required="true" />
                        <h:outputLabel for="state" value="State: "/>
                        <h:inputText id="state" 
                                     value="#{EditDriverManagedBean.countryState}" 
                                     required="true" />
                        <h:outputLabel for="country" value="Country: "/>
                        <h:inputText id="country" 
                                     value="#{EditDriverManagedBean.country}" 
                                     required="true" />
                        <h:outputLabel for="phone" value="Phone Number: "/>
                        <h:inputText id="phone" 
                                     value="#{EditDriverManagedBean.phoneNumber}" 
                                     required="true" />
                    </h:panelGrid>
                    
                    <h:commandButton id="submit" value="Save" 
                                     action="#{EditDriverManagedBean.EditDriver}"/>
                    <h:commandButton id="cancel" value="Cancel" 
                                     action="#{EditDriverManagedBean.CancelEditDriver}"/>
                    <h:commandButton id="delete" value="Delete Driver" 
                                     action="#{EditDriverManagedBean.DeleteDriver}"/>
                    <h:commandButton id="chPassword" value="Change Password" 
                                     action="#{EditDriverManagedBean.ChangePassword}"/>
                    
                    
                </h:panelGrid>
                
            </h:form>
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
        
        
        
        
        
    </body>
</html>
