package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName CompanyInfo
 */
@TableName(value ="CompanyInfo")
@Data
public class Companyinfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer userid;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String companytype;

    /**
     * 
     */
    private String companyaddress;

    /**
     * 
     */
    private String companytel;

    /**
     * 
     */
    private String companyregister;

    /**
     * 
     */
    private String companyphoto;

    /**
     * 
     */
    private String companynumber;

    /**
     * 
     */
    private String companystatue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}