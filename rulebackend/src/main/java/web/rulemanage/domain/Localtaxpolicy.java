package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName LocalTaxPolicy
 */
@TableName(value ="LocalTaxPolicy")
@Data
public class Localtaxpolicy implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer policyid;

    /**
     * 
     */
    private String region;

    /**
     * 
     */
    private String taxpolicydescription;

    /**
     * 
     */
    private String taxregulationdescription;

    /**
     * 
     */
    private Date effectivedate;

    /**
     * 
     */
    private Date expirydate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}