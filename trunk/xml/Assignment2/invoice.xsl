<?xml version="1.0" encoding="UTF-8" ?>

<!--
    Document   : invoice.xsl
    Created on : 14. Oktober 2006, 22:54
    Author     : Thorsten
    Description:
        Purpose of transformation follows.
        
        
        ToDo: Restrict Description String to 25 characters !!!
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
    <xsl:template match="/pu:purchase/c:customers">
        
        <html>
            <head>
                <title>INVOICES</title>
                
                <!--       
                <script type="text/javascript" src="scripts.js">
                <xsl:text>  
                function produceDate() {
                var now = new Date(); // here i get the actual date
                var day = now.getDate();
                var month = now.getMonth();
                var year = now.getFullYear();
                var iDate = "" + day + "/" + month + "/" + year;
                return iDate;
                }
                
                function addDue(iDate) {
                
                return dueDate;
                }
                
                </xsl:text>
                </script>
                -->   
                
            </head>
            <body>
                
                <h1>INVOICES</h1>
                
                <xsl:for-each select="c:customer">
                    
                    <hr />
                    
                    <xsl:variable name="custId" select="@id"/>
                    
                    
                    <h2><xsl:text>Customer ID: </xsl:text><xsl:value-of select="$custId"/></h2>
                    
                    <xsl:call-template name="customer" >
                        <xsl:with-param name="custId" select="$custId" />
                    </xsl:call-template>
                    
                </xsl:for-each>
                
            </body>
        </html>
    </xsl:template>
    
    
    <xsl:template name="customer">
        <xsl:param name="custId" />
        
        <xsl:variable name="discount">
            <xsl:call-template name="calcDiscount">
                <xsl:with-param name="custId" select="$custId"/>
            </xsl:call-template>
        </xsl:variable>
        
        <xsl:variable name="discountFac" select="1 - $discount"/>
        
        <xsl:for-each select="self::node()[@id = $custId]/c:orders/c:order">
            
            <xsl:variable name="orderId" select="@id" />
            
            <h3><xsl:text>Order ID: </xsl:text><xsl:value-of select="$orderId"/></h3>
            
            <xsl:variable name="pAmount" select="count(self::node()[@id = $orderId]/c:orderedproducts/c:product)"/> 
            
            <xsl:variable name="totalIncl">
                <xsl:call-template name="total">
                    <xsl:with-param name="orderId" select="$orderId"/>
                    <xsl:with-param name="pAmount" select="$pAmount"/>
                </xsl:call-template>
            </xsl:variable>
            
            
            
            <table border="1">
                
                <tr> 
                    <td colspan="2"><xsl:call-template name="address" /> </td>
                    <td><xsl:call-template name="date" >
                            <xsl:with-param name="orderId" select="$orderId" /> 
                        </xsl:call-template>  
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><br/><br/><br/></td>
                </tr>
                <tr>
                    <td colspan="3"><xsl:call-template name="table" /></td>
                </tr>    
                <tr>
                    <td colspan="3"><br/><br/><br/></td>
                </tr>
                <tr>
                    
                    <xsl:variable name="discountTotal" select="format-number($totalIncl * $discountFac, '##.##')" />
                    
                    <td colspan="3">
                        <table border="0">
                            <tr>
                                <td><xsl:text>Total (GST inclusive):</xsl:text></td>
                                <td><xsl:value-of select="$totalIncl"/></td>    
                            </tr>
                            <tr>
                                <td><xsl:text>- Membership Discount (</xsl:text><xsl:value-of select="$discount * 100" /><xsl:text>%):</xsl:text></td>
                                <td><xsl:value-of select="$discountTotal"/></td>
                            </tr>
                            <tr>
                                <td><xsl:text>Total (GST exclusive):</xsl:text></td>
                                <td><xsl:value-of select="format-number($discountTotal div 11 * 10, '##.##')"/></td>
                            </tr>
                            <tr>
                                <td><xsl:text>Total GST amount:</xsl:text></td>
                                <td><xsl:value-of select="format-number($discountTotal div 11, '##.##')"/></td>
                            </tr>
                            
                        </table>
                        
                    </td>
                </tr>    
                
            </table>              
            
            
        </xsl:for-each>
    </xsl:template>    
    
    
    
    <xsl:template name="address">
        <xsl:value-of select="../../c:name/c:title"/><xsl:text>  </xsl:text>
        <xsl:value-of select="../../c:name/c:lastname"/><xsl:text>,  </xsl:text>
        <xsl:value-of select="../../c:name/c:firstname[position() =1]"/><br/>
        <xsl:value-of select="../../c:address/c:number"/><xsl:text>  </xsl:text>
        <xsl:value-of select="../../c:address/c:street"/><br/>
        <xsl:value-of select="../../c:address/c:suburb"/><br/>
        <xsl:value-of select="../../c:address/c:state"/><xsl:text>,  </xsl:text>
        <xsl:value-of select="../../c:address/c:postcode"/>
    </xsl:template>    
    
    
    
    <xsl:template name="date">
        <xsl:param name="orderId" />
        <!--    <xsl:variable name="date" select="19/10/2006"/> -->
        <xsl:text>Invoice date: </xsl:text><xsl:value-of select="c:date"/><br/>
        <xsl:text>Invoice number: i</xsl:text><xsl:value-of select="$orderId"/><br/>
        <xsl:text>Payment due: </xsl:text><xsl:value-of select="c:date"/><br/>
    </xsl:template>    
    
    
    <xsl:template name="table">
        <table border="1">
            <tr>
                <th>Product No</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Amount</th>
            </tr>
            <xsl:for-each select="c:orderedproducts/c:product">
                <xsl:variable name="id" select="c:id"/>
                <xsl:variable name="quantity" select="c:quantity"/>
                <xsl:variable name="price" select="/pu:purchase/p:products/p:product[@id = $id]/p:unitprice"/>
                <tr>
                    <td><xsl:value-of select="$id"/></td>
                    <td><xsl:value-of select="/pu:purchase/p:products/p:product[@id = $id]/p:name"/></td>
                    <td><xsl:value-of select="/pu:purchase/p:products/p:product[@id = $id]/p:description"/></td>
                    <td><xsl:value-of select="$quantity"/></td>
                    <td><xsl:value-of select="format-number(/pu:purchase/p:products/p:product[@id = $id]/p:unitprice, '##.##')"/></td>
                    <td><xsl:value-of select="format-number($quantity * $price, '##.##')"/></td>
                    <!--  <xsl:value-of select="price * quantity"/>  -->
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>    
    
    
    <xsl:template name="total">
        <xsl:param name="orderId" />
        <xsl:param name="pAmount" />
        <xsl:choose>
            <xsl:when test="$pAmount > 1">
                <xsl:variable name="sum">
                    <xsl:call-template name="total">
                        <xsl:with-param name="orderId" select="$orderId" />
                        <xsl:with-param name="pAmount" select="$pAmount - 1" />
                    </xsl:call-template>
                </xsl:variable>
                <xsl:variable name="prodId" select="c:orderedproducts/c:product[position() = $pAmount]/c:id" />
                <xsl:value-of select="$sum + /pu:purchase/p:products/p:product[@id = $prodId]/p:unitprice * c:orderedproducts/c:product[position() = $pAmount]/c:quantity"/> 
            </xsl:when>
            <xsl:when test="$pAmount = 1">
                <xsl:variable name="prodId" select="c:orderedproducts/c:product[position() = $pAmount]/c:id" />
                <xsl:value-of select="/pu:purchase/p:products/p:product[@id = $prodId]/p:unitprice * c:orderedproducts/c:product[position() = $pAmount]/c:quantity"/>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
        </xsl:choose> 
    </xsl:template>
    
    <xsl:template name="calcDiscount">
        <xsl:param name="custId" />
        <xsl:variable name="membership" select = "self::node()[@id = $custId]/c:membership" />
        <xsl:choose>
            <xsl:when test="$membership = 'platinum'">
                0.1
            </xsl:when>
            <xsl:when test="$membership = 'gold'">
                0.08
            </xsl:when>
            <xsl:when test="$membership = 'silver'">
                0.05
            </xsl:when>
            <xsl:when test="$membership = 'bronze'">
                0.03
            </xsl:when>
            <xsl:otherwise>
                0
            </xsl:otherwise>
        </xsl:choose> 
    </xsl:template>
    
    
</xsl:stylesheet>
