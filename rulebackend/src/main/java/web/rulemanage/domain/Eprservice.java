package web.rulemanage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName EPRService
 */
@TableName(value ="EPRService")
@Data
public class Eprservice implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer eprserviceid;

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
    private Integer servicesummit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}