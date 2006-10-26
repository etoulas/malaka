<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:set var="title" value="Change Password" scope="page"/> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>${title}</title> 
        <jsp:include page="includes/headerFaces.html" />
    </head> 
    <body>
        <jsp:include page="includes/topPageFaces.html" />
        <h1>${title} for User <h:outputText value="#{ChangePasswordManagedBean.username}"/></h1> 
        <f:view>
            <h:messages showSummary="true" showDetail="false" 
                        style="color: red; 
                        font-family: 'New Century Schoolbook', serif; 
                        font-style: oblique" 
                        id="errors"/> 
            
            <h:form id="changePassword">
                <h:panelGrid columns="2">
                    <h:outputLabel for="password" value="Password: "/>
                    <h:inputText id="password" 
                                 value="#{ChangePasswordManagedBean.password}" 
                                 required="true" />
                    <h:outputLabel for="repPassword" value="Repeat Password: "/>
                    <h:inputText id="repPassword" 
                                 value="#{ChangePasswordManagedBean.repPassword}" 
                                 required="true" />
                    
                    <h:commandButton id="change" value="Change" 
                                     action="#{ChangePasswordManagedBean.SavePassword}"/>
                    <h:commandButton id="cancel" value="Cancel" 
                                     action="#{ChangePasswordManagedBean.CancelSavePassword}"/>
                    
                    
                </h:panelGrid>
                
                
                
            </h:form>
        </f:view>
        <jsp:include page="includes/bottomPage.html" />
        
        
        
        
        
    </body>
</html>
