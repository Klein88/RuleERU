package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName ToDos
 */
@TableName(value ="ToDos")
@Data
public class Todos implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer todoid;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Date duedate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}