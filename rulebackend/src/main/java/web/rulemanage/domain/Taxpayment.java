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
 * @TableName TaxPayment
 */
@TableName(value ="TaxPayment")
@Data
public class Taxpayment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer taxpaymentid;

    /**
     * 
     */
    private String companyname;

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
    private BigDecimal amountdue;

    /**
     * 
     */
    private String currency;

    /**
     * 
     */
    private String declarationcycle;

    /**
     * 
     */
    private Date declarationperiod;

    /**
     * 
     */
    private Date duedate;

    /**
     * 
     */
    private Integer paymentstatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}