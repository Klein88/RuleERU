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
 * @TableName EUDeclarationOfConformity
 */
@TableName(value ="EUDeclarationOfConformity")
@Data
public class Eudeclarationofconformity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer declarationid;

    /**
     * 
     */
    private String manufacturername;

    /**
     * 
     */
    private String businessaddress;

    /**
     * 
     */
    private String authorizedrepresentative;

    /**
     * 
     */
    private String productserialnumber;

    /**
     * 
     */
    private String modelortypeidentification;

    /**
     * 
     */
    private String responsibilitystatement;

    /**
     * 
     */
    private String productidentification;

    /**
     * 
     */
    private String notifiedbodydetails;

    /**
     * 
     */
    private String legislationandstandards;

    /**
     * 
     */
    private String signatoryname;

    /**
     * 
     */
    private Date declarationdate;

    /**
     * 
     */
    private String supplementaryinformation;

    /**
     * 
     */
    private String importerresponsibility;

    /**
     * 
     */
    private String translationrequirement;

    /**
     * 
     */
    private byte[] signatorysignature;

    /**
     * 
     */
    private byte[] productimage;
    private Integer applicationid;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}