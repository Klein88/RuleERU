package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName TaxCalculationDetails
 */
@TableName(value ="TaxCalculationDetails")
@Data
public class Taxcalculationdetails implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer calculationdetailid;

    /**
     * 
     */
    private Integer declarationdetailid;

    /**
     * 
     */
    private BigDecimal taxablesalesamount;

    /**
     * 
     */
    private BigDecimal taxrate;

    /**
     * 
     */
    private BigDecimal netcostamount;

    /**
     * 
     */
    private BigDecimal netsalesamount;

    /**
     * 
     */
    private BigDecimal outputvat;

    /**
     * 
     */
    private BigDecimal importvat;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}