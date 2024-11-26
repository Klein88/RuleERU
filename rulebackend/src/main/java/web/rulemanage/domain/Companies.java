package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName Companies
 */
@TableName(value ="Companies")
@Data
public class Companies implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer companyid;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String companyaddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}