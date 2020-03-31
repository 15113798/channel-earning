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
 * @date 2020-03-31 15:38:28
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
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 品牌小标题
	 */
	private String brandTitle;
	/**
	 * 品牌历史
	 */
	private String brandHistory;
	/**
	 * 品牌定位
	 */
	private String brandPosition;
	/**
	 * 消费群体
	 */
	private String consumer;
	/**
	 * 品牌标签
	 */
	private String brandLabel;
	/**
	 * 是否推荐
	 */
	private Integer isRecommend;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private Integer createId;
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
