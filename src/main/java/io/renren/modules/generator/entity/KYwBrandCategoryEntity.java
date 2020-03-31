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
@TableName("k_yw_brand_category")
public class KYwBrandCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 品牌团id
	 */
	private Integer brandId;
	/**
	 * 商品分类id
	 */
	private Integer productTypeId;
	/**
	 * 是否主营 0是1否
	 */
	private Integer isMain;

}
