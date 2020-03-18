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
@TableName("k_yw_taobao_auth")
public class KYwTaobaoAuthEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 发布者id
	 */
	private Integer userId;
	/**
	 * 淘宝用户id
	 */
	private String taobaoUserId;
	/**
	 * 淘宝用户名
	 */
	private String taobaoUserNick;
	/**
	 * 授权验证code
	 */
	private String authCode;
	/**
	 * 授权令牌
	 */
	private String sessionKey;
	/**
	 * 授权时间
	 */
	private Date authTime;
	/**
	 * 授权过期时间
	 */
	private Date expiresTime;
	/**
	 * 状态；0=不明，1=正常，2=异常
	 */
	private Integer status;
	/**
	 * pid 平台：QQ二合
	 */
	private String ehyPid;
	/**
	 * pid 平台：淘口令
	 */
	private String tklPid;
	/**
	 * pid CMS：QQ二合
	 */
	private String cmsEhyPid;
	/**
	 * pid CMS：淘口令
	 */
	private String cmsTklPid;
	/**
	 * 备注
	 */
	private String comment;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
