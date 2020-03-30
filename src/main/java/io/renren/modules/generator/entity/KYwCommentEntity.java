package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 15:10:25
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
	 * 类型1首页意见反馈2纠错
	 */
	private Integer type;
	/**
	 * 问题类型
	 */
	private Integer questionType;
	/**
	 * 附件图片
	 */
	private String attPict;
	/**
	 * 联系方式
	 */
	private String contactInfo;
	/**
	 * 商品id
	 */
	private Integer productId;
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

	//状态
	private Integer state;


}
