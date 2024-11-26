package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName News
 */
@TableName(value ="News")
@Data
public class News implements Serializable {
    /**
     * 
     */
    private Integer newsid;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String content;

    private Date date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}