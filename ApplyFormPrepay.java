package com.rbs.reimburse.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rbs.reimburse.enums.FormTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 预付申请单
 * </p>
 *
 * @author qckj
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("reimburse_apply_form_prepay")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplyFormPrepay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表单类型
     */
    @TableField(exist = false)
    private Integer type = FormTypeEnum.ApplyFormPrepay.getValue();

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
     * 所属公司
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer companyId;

    /**
     * 所属部门
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer departId;
    @TableField(exist = false)
    private String departName;

    /**
     * 编码
     */
    private String code;

    /**
     * 申请人
     */
    private Integer applicant;
    @TableField(exist = false)
    private String applicantName;
    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 立项申请单类型
     */
    @NotNull(message = "立项申请单类型不能为空")
    private Integer applyFormType;

    /**
     * 立项申请单
     */
    @NotNull(message = "立项申请单Id不能为空")
    private Integer applyFormId;
    @TableField(exist = false)
    private String applyFormCode;

    /**
     * 费用归属类型(1,2)
     */
    private Integer ascriptionType;

    /**
     * 费用归属
     */
    private Integer ascriptionId;
    @TableField(exist = false)
    private String ascriptionName;

    /**
     * 支付金额
     */
    @NotNull(message = "预付金额不能为空")
    private BigDecimal total;

    /**
     * 支付事由
     */
    @NotBlank(message = "支付事由不能为空")
    private String cause;

    /**
     * 流程状态
     */
    private Integer bpmStatus;

    /**
     * 逻辑删除标记:0未删除,1已删除
     */
    @TableLogic
    @JsonIgnore
    private Integer isDeleted;


    @TableField(exist = false)
    private List<FormPayee> formPayees;

    /**
     * 附件列表
     */
    @TableField(exist = false)
    private List<FormAttachment> attachments;

}
