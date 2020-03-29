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
 * @date 2020-03-29 13:56:38
 */
@Data
@TableName("k_yw_product_category")
public class KYwProductCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 父级id，0表示顶级
	 */
	private Integer parentId;
	/**
	 * 栏目名称
	 */
	private String name;

	private Integer sort;

}
