package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-31 16:25:15
 */
@Data
@TableName("k_yw_brand_data")
public class KYwBrandDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 品牌id
	 */
	private Integer brandId;
	/**
	 * 近期销量
	 */
	private Integer recentSales;
	/**
	 * 品牌指数
	 */
	private BigDecimal brandIndex;
	/**
	 * 粉丝数
	 */
	private Integer fansNum;

}
