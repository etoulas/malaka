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
                <h1>All Our Products By Category</h1>
                
                
                <table border="1">
                    <TR>
                        <TH>Manufacturer</TH> 
                        <TH>Number</TH> 
                        <TH>Name</TH> 
                        <TH>Description</TH>
                        <TH>Unit Price</TH> 
                    </TR>
                    <xsl:for-each select="/pu:purchase/p:products/p:product">
                        <TR>
                            <TD>
                                <xsl:value-of select="p:manufacturer" /> 
                            </TD>
                            <TD>
                                <xsl:value-of select="@id" /> 
                            </TD>
                            <TD>
                                <xsl:value-of select="p:name" /> 
                            </TD>
                            <TD>
                                <xsl:value-of select="p:description" /> 
                            </TD>
                            <TD>
                                <xsl:value-of select="p:unitprice" />
                                <xsl:text> </xsl:text>
                                <xsl:value-of select="p:unitprice/@currency" />
                            </TD>
                            
                        </TR>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
</xsl:stylesheet>
