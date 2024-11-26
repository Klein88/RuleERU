package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName EPRDeclaration1
 */
@TableName(value ="EPRDeclaration1")
@Data
public class Eprdeclaration1 implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer eprdeclarationid;

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
    private Integer brandcount;

    /**
     * 
     */
    private String brandenglishname;

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
    private String registrationnumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}