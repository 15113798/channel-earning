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
 * @date 2020-03-18 15:00:32
 */
@Data
@TableName("k_yw_brand")
public class KYwBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺名称
	 */
	private String name;
	/**
	 * 店铺链接
	 */
	private String shopUrl;
	/**
	 * 品牌分类id
	 */
	private Integer brandTypeId;
	/**
	 * logo路径
	 */
	private String logoUrl;
	/**
	 * 主题图片路径
	 */
	private String themeUrl;
	/**
	 * 活动开始时间
	 */
	private Date activityStartTime;
	/**
	 * 活动结束时间
	 */
	private Date activityEndTime;
	/**
	 * 活动类型
	 */
	private Integer activityType;
	/**
	 * 活动说明
	 */
	private String activityRemark;
	/**
	 * 上架时间
	 */
	private Date upperTime;
	/**
	 * 是否推荐
	 */
	private Integer isRecommend;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态1审核中2审核失败3审核成功4上架5下架6删除
	 */
	private Integer state;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 审核人
	 */
	private Integer checkedId;
	/**
	 * 审核时间
	 */
	private Date checkedTime;
	/**
	 * 审核信息
	 */
	private String checkedMessage;

}
