package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName TaxRefund
 */
@TableName(value ="TaxRefund")
@Data
public class Taxrefund implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer taxrefundid;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private String vatnumber;

    /**
     * 
     */
    private String declarationtype;

    /**
     * 
     */
    private String declarationcycle;

    /**
     * 
     */
    private Date declarationdate;

    /**
     * 
     */
    private BigDecimal refundamount;

    /**
     * 
     */
    private Integer operation;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}