<?xml version="1.0" encoding="UTF-8" ?>

<!--
            Document   : product.xsl
            Created on : 14. October 2006, 22:55
            Authors    : Thorsten Keck, 5742722
                         Fernando Mendoza, 5746078
                         Efthimios Toulas, 5744148

-->


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:pu="http://swin.edu.au/theffe/purchase"
    xmlns:c="http://swin.edu.au/theffe/customer"
    xmlns:p="http://swin.edu.au/theffe/product"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://swin.edu.au/theffe/purchase purchase.xsd">
    
    <xsl:output method="html"/>
    
    <!-- TODO customize transformation rules 
    syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Product Homepage</title>
            </head>
            <body>
                <h1>All Our Products By Manufacturer</h1>
                <h2>Categories</h2> 
                <xsl:for-each select= "/pu:purchase/p:products/p:product/p:category[not(.=preceding::p:category)]">
                <xsl:sort select="(.)"/>
                <h3><xsl:value-of select="(.)"/></h3>
                <table border="3">
                <tr>
                    <th>Manufacturer</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Unit Price</th>
                </tr>
                <xsl:variable name="theCategory" select="(.)"/>
                <xsl:for-each select="/pu:purchase/p:products/p:product">
                <xsl:sort select="p:manufacturer"/>
                <xsl:sort select="@id"/>
                <xsl:if test="p:category = $theCategory">
                 <tr>
                    <td><xsl:value-of select="p:manufacturer"/></td>
                    <td><xsl:value-of select="@id"/></td>
                    <td><xsl:value-of select="p:name"/></td>
                    <td><xsl:value-of select="p:description"/></td>
                    <td><xsl:value-of select="p:unitprice"/></td>
                 </tr>
                </xsl:if>
                </xsl:for-each>
                <tr>
                    <td>The number of products is</td>
                    <td><xsl:value-of select="count(//p:product[p:category = $theCategory])"/></td>
                </tr>
                </table>
                </xsl:for-each>
           
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>
