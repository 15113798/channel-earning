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
 * @date 2020-03-30 17:19:24
 */
@Data
@TableName("k_yw_notice")
public class KYwNoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 公告标签
	 */
	private String smallLabel;
	/**
	 * 公告标题
	 */
	private String title;
	/**
	 * 公告内容
	 */
	private String content;
	/**
	 * 作者（原创）
	 */
	private String author;
	/**
	 * 浏览次数
	 */
	private Integer browseCount;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private Integer releaseId;

}
