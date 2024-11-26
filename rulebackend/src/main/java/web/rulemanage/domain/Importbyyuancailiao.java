package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName ImportByYuancailiao
 */
@TableName(value ="ImportByYuancailiao")
@Data
public class Importbyyuancailiao implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String date;

    /**
     * 
     */
    private String importamount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}