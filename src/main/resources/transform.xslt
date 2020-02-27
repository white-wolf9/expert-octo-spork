<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        
           
            <AdjustLocationInventory>
                <xsl:attribute name="EnterpriseCode">APMDT</xsl:attribute>
                <xsl:attribute name="Node"><xsl:value-of select='/Main/N1_Parent/N1_3'/></xsl:attribute>   
     
            <Source>
                <xsl:attribute name="LocationId"><xsl:value-of select='/Main/N1_Parent/N1_4'/></xsl:attribute>      
            
            <Inventory>
                <xsl:attribute name="FifoNo"><xsl:value-of select='/Main/W15_Parent/W15_1'/></xsl:attribute>   
                <xsl:attribute name="InventoryStatus">N</xsl:attribute>
                <xsl:attribute name="Quantity"><xsl:value-of select='/Main/W19_Parent/W19_2'/></xsl:attribute>
            
            <InventoryItem>
                <xsl:attribute name="ItemID"><xsl:value-of select='/Main/W19_Parent/W19_6'/></xsl:attribute>   
                <xsl:attribute name="ProductClass">G001</xsl:attribute>
                <xsl:attribute name="UnitOfMeasure">EACH</xsl:attribute>
            </InventoryItem>
            </Inventory>
            </Source>
            <Audit>
                <xsl:attribute name="DocumentType"></xsl:attribute>   
                <xsl:attribute name="ReasonCode">OTHER</xsl:attribute>
            </Audit>
            </AdjustLocationInventory>
              
           
    </xsl:template>
</xsl:stylesheet>