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
 * @TableName Documents
 */
@TableName(value ="Documents")
@Data
public class Documents implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer documentid;

    /**
     * 
     */
    private String documenttitle;

    /**
     * 
     */
    private String documentcontent;

    /**
     * 
     */
    private Object documentcategory;

    /**
     * 
     */
    private Integer documentreadCount;

    /**
     * 
     */
    private Date documentcreated;

    /**
     * 
     */
    private Date documentupdated;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}