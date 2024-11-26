package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName PackagingSummaryDeclaration
 */
@TableName(value ="PackagingSummaryDeclaration")
@Data
public class Packagingsummarydeclaration implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer summaryid;

    /**
     * 
     */
    private String registrationcode;

    /**
     * 
     */
    private Integer declarationyear;

    /**
     * 
     */
    private String brandname;

    /**
     * 
     */
    private Integer declarationdataserialnumber;

    /**
     * 
     */
    private String packagingmaterial;

    /**
     * 
     */
    private BigDecimal predeclaredweight;

    /**
     * 
     */
    private BigDecimal actualpackagingweight;

    /**
     * 
     */
    private Integer eprdeclarationid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}