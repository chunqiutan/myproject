package com.rbs.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 城市表
 * </p>
 *
 * @author qckj
 * @since 2018-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_city")
@JsonIgnoreProperties(ignoreUnknown = true)
public class City implements Serializable {

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
     * 所属公司
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer companyId;

    /**
     * 所属部门
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer departId;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 国内/国外
     */
    private Integer type;

    /**
     * 城市类别
     */
    private Integer category;
    /**
     * 城市类别名称
     */
    @TableField( exist = false)
    private String categoryName;

    /**
     * 状态:0启用,1停用
     */
    private Integer status;

    /**
     * 逻辑删除标记:0未删除,1已删除
     */
    @TableLogic
    @JsonIgnore
    private Integer isDeleted;


}
