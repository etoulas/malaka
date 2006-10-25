<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Create Customer" scope="page"/> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>${title}</title> 
    </head> 
    <body>
        <h1>${title}</h1> 
        <f:view>
            <h:messages showSummary="true" showDetail="false" 
                        style="color: red; 
                        font-family: 'New Century Schoolbook', serif; 
                        font-style: oblique" 
                        id="errors"/> 
            
            <h:form id="enterCustomerDetails">
                <h:panelGrid columns="2">
                    <h:panelGroup>
                        <h:outputLabel for="company" value="Company: "/>
                        <h:inputText id="company" 
                                     value="#{UserManagedBean.company}" 
                                     required="true" />
                    </h:panelGroup> 
                    <h:outputText value=""/>
                    <h:panelGroup>
                        <h:outputLabel for="firstName" value="First Name: "/>
                        <h:inputText id="firstName" 
                                     value="#{UserManagedBean.firstName}" 
                                     required="true" />
                    </h:panelGroup>     
                    <h:panelGroup>    
                        <h:outputLabel for="lastName" value="Last Name: "/>
                        <h:inputText id="lastName" 
                                     value="#{UserManagedBean.lastName}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value="Address: "/>
                    <h:panelGrid columns="2">
                        <h:outputLabel for="street" value="Street: "/>
                        <h:inputText id="street" 
                                     value="#{UserManagedBean.street}" 
                                     required="true" />
                        <h:outputLabel for="streetNumber" value="Number: "/>                
                        <h:inputText id="streetNumber" 
                                     value="#{UserManagedBean.streetNumber}" 
                                     required="true" />
                        <h:outputLabel for="postCode" value="Postcode: "/>
                        <h:inputText id="postCode" 
                                     value="#{UserManagedBean.postCode}" 
                                     required="true" />
                        <h:outputLabel for="suburb" value="Suburb: "/>
                        <h:inputText id="suburb" 
                                     value="#{UserManagedBean.suburb}" 
                                     required="true" />
                        <h:outputLabel for="city" value="City: "/>
                        <h:inputText id="city" 
                                     value="#{UserManagedBean.city}" 
                                     required="true" />
                        <h:outputLabel for="state" value="State: "/>
                        <h:inputText id="state" 
                                     value="#{UserManagedBean.countryState}" 
                                     required="true" />
                        <h:outputLabel for="country" value="Country: "/>
                        <h:inputText id="country" 
                                     value="#{UserManagedBean.country}" 
                                     required="true" />
                    </h:panelGrid>
                    <h:panelGroup>
                        <h:outputLabel for="username" value="Username: "/>
                        <h:inputText id="username" 
                                     value="#{UserManagedBean.username}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:outputText value=""/>
                    <h:panelGroup>
                        <h:outputLabel for="password" value="Password: "/>                
                        <h:inputSecret id="password" 
                                     value="#{UserManagedBean.password}" 
                                     required="true" />
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:outputLabel for="repPassword" value="Repeat Password: "/>                
                        <h:inputSecret id="repPassword" 
                                     value="#{UserManagedBean.repPassword}" 
                                     required="true" />
                        
                    </h:panelGroup>
                    <h:commandButton id="submit" value="Continue" 
                                     action="#{UserManagedBean.CreateCustomer}"/>
                    
                </h:panelGrid>
                
            </h:form>
        </f:view>
        
        
        
        
        
    </body>
</html>
