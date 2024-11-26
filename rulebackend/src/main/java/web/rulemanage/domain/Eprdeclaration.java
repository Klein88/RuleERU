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
 * @TableName EPRDeclaration
 */
@TableName(value ="EPRDeclaration")
@Data
public class Eprdeclaration implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer declarationid;

    /**
     * 
     */
    private Integer isrequiredtodeclare;

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
    private String declarationcycle;

    /**
     * 
     */
    private String currentdeclarationperiod;

    /**
     * 
     */
    private Date startdeclarationdate;

    /**
     * 
     */
    private Date enddeclarationdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}