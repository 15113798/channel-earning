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
 * @date 2020-03-18 14:58:38
 */
@Data
@TableName("k_yw_message")
public class KYwMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 发送人
	 */
	private Integer sendUserId;
	/**
	 * 发送内容
	 */
	private String content;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 发送类型
	 */
	private Integer typeId;
	/**
	 * 接收人
	 */
	private Integer arriverUserId;
	/**
	 * 发送状态1已发送2已读
	 */
	private Integer state;

}
