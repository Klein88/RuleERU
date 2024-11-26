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
 * @TableName VatPayment
 */
@TableName(value ="VatPayment")
@Data
public class Vatpayment implements Serializable {
    /**
     * 
     */
    @TableId
    private String vatpaymentid;

    /**
     * 
     */
    private String taxNumber;

    /**
     * 
     */
    private BigDecimal paymentAmount;

    /**
     * 
     */
    private String paymentMethod;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String additionalInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}