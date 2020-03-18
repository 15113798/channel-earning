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
@TableName("k_yw_comment")
public class KYwCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 商品id
	 */
	private Integer productId;
	/**
	 * 类型1评论2反馈
	 */
	private Integer type;
	/**
	 * 评论人
	 */
	private Integer commentUserId;
	/**
	 * 内容
	 */
	private String commentContent;
	/**
	 * 时间
	 */
	private Date commentTime;
	/**
	 * 回复人
	 */
	private Integer replyUserId;
	/**
	 * 回复内容
	 */
	private String replyContent;
	/**
	 * 回复时间
	 */
	private Date replyTime;

}
