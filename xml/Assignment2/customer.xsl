<?xml version="1.0" encoding="UTF-16" ?>

<!--
    Document   : customer.xsl
    Created on : 14. October 2006, 22:54
    Authors    : Thorsten Keck, 5742722
                         Fernando Mendoza, 5746078
                         Efthimios Toulas, 5744148
    Description: 
			- A table containing all information about customers. Information in this table
			  should be sorted by surname then firstName then customer number.
			- Total number of customers in the online purchase database.
			- Total number of customers for each of the 5 groups grouped by membership.
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo pu c p"
	xmlns:pu="http://swin.edu.au/theffe/purchase"
	xmlns:c="http://swin.edu.au/theffe/customer"
	xmlns:p="http://swin.edu.au/theffe/product"
	xmlns:date="java.util.Date">

    <xsl:output method="xml"
	     omit-xml-declaration="no"
	     encoding="UTF-16"
	     version="1.0"
	     indent="yes"/>

    <xsl:template match="/">
		<fo:root>
			<!-- Page type and margins -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" 
						page-height="297mm" page-width="210mm"
        				margin-top="10mm" margin-bottom="10mm"
        				margin-left="25mm" margin-right="25mm">
					<fo:region-body margin-top="15mm" margin-bottom="20mm"/>
					<fo:region-before extent="20mm"/>
					<fo:region-after extent="20mm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>

			<!-- Document -->
			<fo:page-sequence master-reference="simpleA4">
				<!-- header -->
				<fo:static-content flow-name="xsl-region-before">
					<xsl:call-template name="display-header-footer"/>
				</fo:static-content>
			
				<!-- footer -->
				<fo:static-content flow-name="xsl-region-after">
					<xsl:call-template name="display-header-footer"/>
					<fo:block text-align="right" font-size="10">
						<xsl:text>Page </xsl:text><fo:page-number/>
					</fo:block>
				</fo:static-content>
			
				<!-- body -->
				<fo:flow flow-name="xsl-region-body">
					<!-- heading -->
					<fo:block font-size="18pt" font-weight="bold" space-after="7mm">Customers Overview</fo:block>					

					<!-- total member counts -->
					<fo:block font-size="12pt" space-after="10mm">
						<xsl:call-template name="display-customer-counts"/>
					</fo:block>					

					<!-- customer details -->
					<fo:block font-size="12pt">
						<fo:block font-size="18pt" font-weight="bold" space-after="7mm">Customer Details</fo:block>
						<xsl:call-template name="display-all-details"/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
    </xsl:template>

	<!-- display header and footer data -->
	<xsl:template name="display-header-footer">
		<fo:block text-align="center" font-family="monospace" font-size="8pt">Confidential Personal Information</fo:block>
		<fo:block text-align="center" font-family="monospace" font-size="8pt"><xsl:value-of select="date:new()"/></fo:block>
	</xsl:template>

	<!-- count customers -->
	<xsl:template name="display-customer-counts">
		<fo:table table-layout="fixed">
			<fo:table-column column-width="6cm"/>
			<fo:table-column column-width="3cm"/>
			<fo:table-body>								
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total Customers:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer)"/></fo:block></fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total Platinum Customers:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer[c:membership='platinum'])"/></fo:block></fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total Gold Customers:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer[c:membership='gold'])"/></fo:block></fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total Silver Customers:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer[c:membership='silver'])"/></fo:block></fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total Bronze Customers:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer[c:membership='bronze'])"/></fo:block></fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell><fo:block font-weight="bold">Total with no membership:</fo:block></fo:table-cell>
					<fo:table-cell><fo:block><xsl:value-of select="count(//c:customer[c:membership='no membership'])"/></fo:block></fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>

	<!-- display all details now -->
	<xsl:template name="display-all-details">
		<xsl:for-each select="//c:customer">
			<xsl:sort select="c:name/c:lastname"/>
			<xsl:sort select="c:name/c:firstname"/>
			<xsl:sort select="@id"/>
		<fo:block space-after="5mm" widows="5">
			<fo:table table-layout="fixed" border-style="solid">
				<fo:table-column column-width="6cm"/>
				<fo:table-column column-width="8cm"/>
				<fo:table-body padding="10">
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Title</fo:block></fo:table-cell>
							<fo:table-cell><fo:block><xsl:value-of select="c:name/c:title"/></fo:block></fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Surname</fo:block></fo:table-cell>
							<fo:table-cell><fo:block><xsl:value-of select="c:name/c:lastname"/></fo:block></fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Firstname</fo:block></fo:table-cell>
								<fo:table-cell><fo:block>
									<xsl:for-each select="c:name/c:firstname">
										<xsl:value-of select="."/><xsl:text> </xsl:text>
									</xsl:for-each>
								</fo:block></fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Customer ID</fo:block></fo:table-cell>
							<fo:table-cell><fo:block><xsl:value-of select="@id"/></fo:block></fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Membership</fo:block></fo:table-cell>
							<fo:table-cell><fo:block><xsl:value-of select="c:membership"/></fo:block></fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Address</fo:block></fo:table-cell>
							<fo:table-cell>
								<fo:block><xsl:value-of select="c:address/c:number"/><xsl:text> </xsl:text><xsl:value-of select="c:address/c:street"/></fo:block>
								<fo:block><xsl:value-of select="c:address/c:suburb"/><xsl:text> </xsl:text><xsl:value-of select="c:address/c:postcode"/><xsl:text>, </xsl:text><xsl:value-of select="c:address/c:state"/></fo:block>
								<fo:block><xsl:value-of select="c:address/c:country"/></fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Phone</fo:block></fo:table-cell>
							<fo:table-cell>
								<xsl:for-each select="c:phone">
									<xsl:sort select="@type"/>
									<xsl:call-template name="display-contact-info">
										<xsl:with-param name="c:contactinfo" select="."/>
									</xsl:call-template>
								</xsl:for-each>
							</fo:table-cell>
						</fo:table-row>
						<xsl:if test="c:email">
						<fo:table-row>
							<fo:table-cell><fo:block font-weight="bold">Email</fo:block></fo:table-cell>
							<fo:table-cell>
								<xsl:for-each select="c:email">
									<xsl:sort select="@type"/>
									<xsl:call-template name="display-contact-info">
										<xsl:with-param name="c:contactinfo" select="."/>
									</xsl:call-template>
								</xsl:for-each>
							</fo:table-cell>
						</fo:table-row>
					</xsl:if>
				</fo:table-body>
			</fo:table>
		</fo:block>	
		</xsl:for-each>
	</xsl:template>

    <!-- display contact information like phone and email -->
	<xsl:template name="display-contact-info">
		<xsl:param name="c:contactinfo"/>
			<fo:block><xsl:value-of select="$c:contactinfo/@type"/><xsl:text>: </xsl:text><xsl:value-of select="$c:contactinfo"/></fo:block>
	</xsl:template>

</xsl:stylesheet>
