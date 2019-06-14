package com.rbs.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 通知公告
 * </p>
 *
 * @author qckj
 * @since 2018-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_notice")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(fill = FieldFill.INSERT)
    private Integer creater;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(fill = FieldFill.UPDATE)
    private Integer updater;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;

	/**
     * 公司
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer companyId;

    /**
     * 部门id
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer departId;

    /**
     * 标题
     */
    @NotBlank(message="标题不能为空")
    private String title;

    /**
     * 内容
     */
    @NotBlank(message="内容不能为空")
    private String content;

    /**
     * 类型1：消息，2:公告
     */
    @NotNull(message="类型不能为空")
    @Range(min=1,max=2,message="类型只能为1或2")
    private Integer type;

    /**
     * 级别(1:公司,2:角色,3:用户)
     */
    @NotNull(message="授权级别不能为空")
    @Range(min=1,max=3,message="授权级别只能为1或2或3")
    private Integer level;

    /**
     * 是否发布
     */
    @NotNull(message="是否发布不能为空")
    @Range(min=0,max=1,message="是否发布只能为0或1")
    private Integer isRelease;

    /**
     * 逻辑删除标记:0未删除,1已删除
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private String isRead;

    @TableField(exist = false)
    private List<NoticeAuthority> authoritys;

    //角色表
    @TableField(exist = false)
    private List<Role> roles;

    //用户表
    @TableField(exist = false)
    private List<User> users;


}
