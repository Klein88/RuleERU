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
 * @TableName Products
 */
@TableName(value ="Products")
@Data
public class Products implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer productid;

    /**
     * 
     */
    private Integer companyid;

    /**
     * 
     */
    private String productname;

    /**
     * 
     */
    private String productdescription;

    /**
     * 
     */
    private BigDecimal productprice;

    /**
     * 
     */
    private String productcategory;

    /**
     * 
     */
    private String productorigin;

    /**
     * 
     */
    private Date manufacturedate;

    /**
     * 
     */
    private Date expirydate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}