package com.rbs.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 通告已读用户表
 * </p>
 *
 * @author qckj
 * @since 2018-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("base_notice_reader")
public class NoticeReader implements Serializable {

    private static final long serialVersionUID = 1L;

     /**
     * 主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息ID
     */
     private Integer noticeId;

     /**
     * 用户ID
     */
     private Integer userId;

     /**
     * 已读时间
     */
      private Date createTime;


}
