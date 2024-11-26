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
 * @TableName EPRRegistration
 */
@TableName(value ="EPRRegistration")
@Data
public class Eprregistration implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer registrationid;

    /**
     * 
     */
    private String companyname;

    /**
     * 
     */
    private String registrationnumber;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private String servicetype;

    /**
     * 
     */
    private String registrationstatus;

    /**
     * 
     */
    private Date serviceexpirydate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}