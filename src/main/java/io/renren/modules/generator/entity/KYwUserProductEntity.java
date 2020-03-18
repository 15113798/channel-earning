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
 * @date 2020-03-18 15:01:55
 */
@Data
@TableName("k_yw_user_product")
public class KYwUserProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 商品id
	 */
	private Integer productId;
	/**
	 * 1收藏2取消收藏
	 */
	private Integer state;
	/**
	 * 收藏时间
	 */
	private Date startTime;
	/**
	 * 取消收藏时间
	 */
	private Date endTime;

}
