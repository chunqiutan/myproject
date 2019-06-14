package com.rbs.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 通告授权表
 * </p>
 *
 * @author qckj
 * @since 2018-09-30
 */
@Data
@Accessors(chain = true)
@TableName("base_notice_authority")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoticeAuthority implements Serializable {

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
     * 级别(1:公司,2:角色,3:用户)
     */
     private Integer level;

     /**
     * 授权ID：公司ID,角色ID,用户ID
     */
     private Integer authorityId;


     @TableField(exist = false)
     private String authorityName;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof NoticeAuthority){
            NoticeAuthority target=(NoticeAuthority) obj;
            return this.noticeId.equals(target.getNoticeId()) && this.level.equals(target.getLevel()) && this.authorityId.equals(target.getAuthorityId());
        }else{
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        Integer value = this.noticeId + this.level + this.authorityId;
        return value.hashCode();
    }
}
