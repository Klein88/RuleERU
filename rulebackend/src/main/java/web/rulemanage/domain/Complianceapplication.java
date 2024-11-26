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
 * @TableName ComplianceApplication
 */
@TableName(value ="ComplianceApplication")
@Data
public class Complianceapplication implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer applicationid;

    /**
     * 
     */
    private String filetype;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String productchinesename;

    /**
     * 
     */
    private String productenglishname;

    /**
     * 
     */
    private String trademark;

    /**
     * 
     */
    private Date applicationdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}