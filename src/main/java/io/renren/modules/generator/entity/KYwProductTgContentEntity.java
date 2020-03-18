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
 * @date 2020-03-18 15:01:54
 */
@Data
@TableName("k_yw_product_tg_content")
public class KYwProductTgContentEntity implements Serializable {
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
	 * 推广类型id
	 */
	private Integer tgTypeId;
	/**
	 * 图片路径,多图的话用逗号分隔
	 */
	private String imgUrl;
	/**
	 * 文案内容
	 */
	private String content;

}
