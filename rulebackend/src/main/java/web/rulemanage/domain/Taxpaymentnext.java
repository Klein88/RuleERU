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
 * @TableName TaxPaymentNext
 */
@TableName(value ="TaxPaymentNext")
@Data
public class Taxpaymentnext implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer taxpaymentnextid;

    /**
     * 
     */
    private String vatnumber;

    /**
     * 
     */
    private String salesplatform;

    /**
     * 
     */
    private BigDecimal taxablesales;

    /**
     * 
     */
    private BigDecimal taxrate;

    /**
     * 
     */
    private BigDecimal taxamount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}