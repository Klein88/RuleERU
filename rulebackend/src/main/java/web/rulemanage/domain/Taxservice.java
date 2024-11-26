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
 * @TableName TaxService
 */
@TableName(value ="TaxService")
@Data
public class Taxservice implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer taxserviceid;

    /**
     * 
     */
    private String taxtype;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private String servicetype;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String vatnumber;

    /**
     * 
     */
    private String serviceprogress;

    /**
     * 
     */
    private BigDecimal taxrate;

    /**
     * 
     */
    private Integer servicesummit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}