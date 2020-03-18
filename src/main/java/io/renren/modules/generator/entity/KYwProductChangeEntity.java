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
@TableName("k_yw_product_change")
public class KYwProductChangeEntity implements Serializable {
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
	 * 当前的销量
	 */
	private Integer volume;
	/**
	 * 优惠券剩余数
	 */
	private Integer couponRemainCount;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
