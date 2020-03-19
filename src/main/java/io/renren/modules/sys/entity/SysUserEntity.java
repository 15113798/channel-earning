/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long userId;
	/**
	 * 用户账号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * QQ号
	 */
	private String qqNum;
	/**
	 * 微信号
	 */
	private String weixinNum;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 身份证号码
	 */
	private String idCard;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	 * 真实姓名
	 */
	private String reallyName;
	/**
	 * 地址省级编码
	 */
	private String adressProvince;
	/**
	 * 地址市级编码
	 */
	private String adressCity;
	/**
	 * 地址县级编码
	 */
	private String adressArea;
	/**
	 * 详细地址
	 */
	private String adressDetailed;
	/**
	 * 工作类型
	 */
	private Integer workTypeId;
	/**
	 * 工作性质1全职2兼职
	 */
	private Integer workNature;
	/**
	 * 用户简介
	 */
	private String info;
	/**
	 * 工作单位
	 */
	private String unitName;
	/**
	 * 用户头像地址
	 */
	private String headImg;
	/**
	 * 性别；0=不明，1=男，2=女
	 */
	private Integer sex;
	/**
	 * 推广收入区间id
	 */
	private Integer tgIncomeId;
	/**
	 * 推广领域id,多项用逗号分隔
	 */
	private Integer tgAreaId;
	/**
	 * 用户等级；初始值为0
	 */
	private Integer level;
	/**
	 * 用户经验，不可以扣除，和用户等级关联；来源于发布产品等
	 */
	private Integer exp;
	/**
	 * 用户积分；来源于用户操作，可以进行积分兑换产品等
	 */
	private Integer point;
	/**
	 * 用户虚拟货币数
	 */
	private Integer coin;
	/**
	 * 用户金币，充值用
	 */
	private Integer money;
	/**
	 * 登陆次数
	 */
	private Integer loginNum;
	/**
	 * 上次登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 当前登录时间
	 */
	private Date currentLoginTime;
	/**
	 * 第一次注册完后登陆时间
	 */
	private Date fristLoginTime;
	/**
	 * 第一次注册时间
	 */
	private Date fristRegisterTime;
	/**
	 * 用户活性标记；0=未认证，1=认证成功，2=暂时冻结；3=永久性冻结
	 */
	private Integer status;
	/**
	 * 冻结开始时间
	 */
	private Date freezeStartTime;
	/**
	 * 冻结结束时间
	 */
	private Date freezeEndTime;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 加盐
	 */
	private String salt;
	/**
	 *
	 */
	private Long createUserId;
	/**
	 *
	 */
	private Date createTime;
	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<Long> roleIdList;

	private String ver_code;

}
