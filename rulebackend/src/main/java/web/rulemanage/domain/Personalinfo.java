package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName PersonalInfo
 */
@TableName(value ="PersonalInfo")
@Data
public class Personalinfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer userid;

    /**
     * 
     */
    private String personalname;

    /**
     * 
     */
    private String personaltel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}