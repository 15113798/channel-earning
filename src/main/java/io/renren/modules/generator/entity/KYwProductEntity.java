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
 * @date 2020-03-18 15:00:33
 */
@Data
@TableName("k_yw_product")
public class KYwProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 商品目录id
	 */
	private String categoryId;
	/**
	 * 店铺id
	 */
	private String shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 佣金种类
	 */
	private String yongjinTypeId;
	/**
	 * 发布者id
	 */
	private String publicUserId;
	/**
	 * 活动类型id
	 */
	private String actionTypeId;
	/**
	 * 活动名
	 */
	private String actionName;
	/**
	 * 商品短标题
	 */
	private String title;
	/**
	 * 商品链接
	 */
	private String productLink;
	/**
	 * 导购文案
	 */
	private String daogouText;
	/**
	 * 原图片地址
	 */
	private String originImg;
	/**
	 * 商品主图
	 */
	private String adImg;
	/**
	 * 短广告图片
	 */
	private String shortAdImg;
	/**
	 * 营销图
	 */
	private String yingxiaoImg;
	/**
	 * 商品归属 0未设置，1天猫，2淘宝
	 */
	private String productType;
	/**
	 * 领券链接
	 */
	private String coponLink;
	/**
	 * 领券结束时间
	 */
	private String coponEndTime;
	/**
	 * 优惠券总量
	 */
	private String totalCoponCount;
	/**
	 * 淘宝价
	 */
	private String taobaoPrice;
	/**
	 * 券面价
	 */
	private String juanmianPrice;
	/**
	 * 券后价
	 */
	private String juanmianAfterPrice;
	/**
	 * 佣金比例
	 */
	private String yongjinRate;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 商品状态0上架1下架
	 */
	private String state;
	/**
	 * 是否推荐0推荐1不推荐
	 */
	private Integer isRecommend;
	/**
	 * 上架时间
	 */
	private String upTime;
	/**
	 * 下架时间
	 */
	private String downTime;
	/**
	 * 0审核中，1审核通过，2审核未通过
	 */
	private String isverify;
	/**
	 * 最后一次更新时间
	 */
	private String updateTime;
	/**
	 * 备注
	 */
	private String remark;

}
