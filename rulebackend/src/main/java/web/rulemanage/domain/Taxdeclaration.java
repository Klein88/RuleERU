package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName TaxDeclaration
 */
@TableName(value ="TaxDeclaration")
@Data
public class Taxdeclaration implements Serializable {

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer declarationid;

    /**
     * 
     */
    private String vatnumber;

    /**
     * 
     */
    private BigDecimal taxrate;

    /**
     * 
     */
    private Date taxnumbereffectivedate;

    /**
     * 
     */
    private Date lastdeclarationdate;

    /**
     * 
     */
    private String gatewayid;

    /**
     * 
     */
    private String gatewaypassword;

    /**
     * 
     */
    private Date lastreporteddate;

    /**
     * 
     */
    private String mtdusername;

    /**
     * 
     */
    private String mtdpassword;

    /**
     * 
     */
    private String companyregistrationlocation;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String businesslicensenumber;

    /**
     * 
     */
    private Date companyestablishmentdate;

    /**
     * 
     */
    private String companyoperationaladdress;

    /**
     * 
     */
    private String postalcode;

    /**
     * 
     */
    private String companyphonenumber;

    /**
     * 
     */
    private String companycontactemail;

    /**
     * 
     */
    private String legalrepresentativename;

    /**
     * 
     */
    private String mainsalesplatform;

    /**
     * 
     */
    private String shopname;

    /**
     * 
     */
    private String informationlink;

    /**
     * 
     */
    private String shopbackendselleraddress;

    /**
     * 
     */
    private String shopbackendcompanyname;

    /**
     * 
     */
    private String mainbusinessscope;

    /**
     * 
     */
    private byte[] vatcertificate;

    /**
     * 
     */
    private byte[] vatdeclarationdocument;

    /**
     * 
     */
    private byte[] proxycommitmentdocument;

    /**
     * 
     */
    private byte[] companyregistrationproof;

    /**
     * 
     */
    private byte[] idcardfront;

    /**
     * 
     */
    private byte[] idcardback;

    /**
     * 
     */
    private byte[] signature;

    private Integer searchbyvatnumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}