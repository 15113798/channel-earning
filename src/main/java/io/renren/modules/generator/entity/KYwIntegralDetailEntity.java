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
@TableName("k_yw_integral_detail")
public class KYwIntegralDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 得分类型
	 */
	private Integer pointTypeId;
	/**
	 * 得分
	 */
	private Integer point;
	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 描述
	 */
	private String descContent;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
