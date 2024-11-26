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
 * @TableName WorkOrders
 */
@TableName(value ="WorkOrders")
@Data
public class Workorders implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer workorderid;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private String workordertheme;

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
    private Date creationdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}