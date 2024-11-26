package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName Certifications
 */
@TableName(value ="Certifications")
@Data
public class Certifications implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer certificationid;

    /**
     * 
     */
    private Integer productid;

    /**
     * 
     */
    private String certificationname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}