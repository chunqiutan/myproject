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
 * 事项申请单(立项)
 * </p>
 *
 * @author qckj
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("reimburse_apply_form_other")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplyFormOther implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表单类型
     */
    @TableField(exist = false)
    private Integer type = FormTypeEnum.ApplyFormOther.getValue();

    /**
     * 主键标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
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
    @NotNull(message = "申请人不能为空")
    private Integer applicant;
    @TableField(exist = false)
    private String applicantName;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 费用归属类型(1,2)
     */
    @NotNull(message = "费用归属类型不能为空")
    private Integer ascriptionType;

    /**
     * 费用归属
     */
    @NotNull(message = "费用归属不能为空")
    private Integer ascriptionId;
    @TableField(exist = false)
    private String ascriptionName;

    /**
     * 申请事由
     */
    @NotBlank(message = "申请事由不能为空")
    private String cause;

    /**
     * 预算合计
     */
    private BigDecimal total;

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

    /**
     * 预算明细列表
     */
    @TableField(exist = false)
    @NotNull(message = "预算不能为空！")
    private List<FormBudget> budgets;

    /**
     * 附件列表
     */
    @TableField(exist = false)
    private List<FormAttachment> attachments;

    /**
     * 授权列表
     */
    @TableField(exist = false)
    private List<FormAuthority> authorities;


}
