package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName EPRRegistrationServiceData
 */
@TableName(value ="EPRRegistrationServiceData")
@Data
public class Eprregistrationservicedata implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer servicedataid;

    /**
     * 
     */
    private Integer productquantity;

    /**
     * 
     */
    private String productname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}