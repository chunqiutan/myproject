package com.rbs.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 公司银行账号
 * </p>
 *
 * @author qckj
 * @since 2018-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_company_account")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer creater;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private Integer updater;

    /**
     * 更新日期
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;

    /**
     * 公司表(外键)
     */
    private Integer companyId;

    /**
     * 开户银行
     */
    private String accountBank;

    /**
     * 开户银行账号
     * 固定的是信用卡:每个银行的信用卡都是16位的; 借记卡是13-19位的.
     */
    @Length(min=13,max=19, message = "银行账号长度不对")
    private String accountBankNumber;

    /**
     * 逻辑删除标记:0未删除,1已删除
     */
    @TableLogic
    private Integer isDeleted;

}
