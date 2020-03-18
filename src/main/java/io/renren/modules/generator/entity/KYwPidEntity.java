package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:00:33
 */
@Data
@TableName("k_yw_pid")
public class KYwPidEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 推广者id
	 */
	private Integer userId;
	/**
	 * 状态；0=不明，1=正常，2=异常
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String comment;
	/**
	 * 删除标签 0:未删除，1已删除
	 */
	private Integer delFlg;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
