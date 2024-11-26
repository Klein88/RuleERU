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
 * @TableName VATDeclarationDetails
 */
@TableName(value ="VATDeclarationDetails")
@Data
public class Vatdeclarationdetails implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer declarationdetailid;

    /**
     * 
     */
    private Integer declarationid;

    /**
     * 
     */
    private String vatdeclarationnumber;

    /**
     * 
     */
    private Date currentvatdeclarationperiod;

    /**
     * 
     */
    private String vatdeclarationcycle;

    /**
     * 
     */
    private BigDecimal applicabletaxrate;

    /**
     * 
     */
    private Date taxpaymentdeadline;

    /**
     * 
     */
    private String salesreportuploadplatform;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}