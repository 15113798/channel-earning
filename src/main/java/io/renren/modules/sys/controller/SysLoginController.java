/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.em.NoticeTypeEnum;
import io.renren.common.utils.NoticeUtil;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.modules.generator.entity.KYwSendSmsHistoryEntity;
import io.renren.modules.generator.service.KYwSendSmsHistoryService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.form.PasswordForm;
import io.renren.modules.sys.form.SysLoginForm;
import io.renren.modules.sys.service.SysCaptchaService;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 登录相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
public class SysLoginController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;
	@Autowired
	private SysCaptchaService sysCaptchaService;
	@Autowired
	private KYwSendSmsHistoryService sendSmsHistoryService;


	/**
	 * 验证码
	 */
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, String uuid)throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//获取图片验证码
		BufferedImage image = sysCaptchaService.getCaptcha(uuid);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@PostMapping("/sys/login")
	public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(user.getUserId());
		return r;
	}


	/**
	 * 退出
	 */
	@PostMapping("/sys/logout")
	public R logout() {
		sysUserTokenService.logout(getUserId());
		return R.ok();
	}




	@PostMapping("/sys/user/register")
	public R register(String ver_code,String mobile,String password){
		//前端传手机号码，密码以及验证码到后台
		//首先验证验证码
		// TODO: 2020/3/18 校验验证码
		boolean var_bool = NoticeUtil.checkVerCode(mobile,ver_code, NoticeTypeEnum.Register.getCode());
		if(!var_bool){
			return R.error("验证码不正确，请重新输入");
		}
		SysUserEntity checkUser = sysUserService.queryByUserName(mobile);
		if(checkUser != null){
			return R.error("该用户已经注册");
		}

		SysUserEntity user = new SysUserEntity();
		user.setMobile(mobile);
		user.setPassword(password);
		user.setUsername(mobile);
		user.setAccount(mobile);
		user.setStatus(0);
		user.setFristRegisterTime(new Date());
		sysUserService.registerUser(user);
		return R.ok();
	}



	@PostMapping("/sys/user/verUserName")
	public R verUserName(String mobile){
		SysUserEntity checkUser = sysUserService.queryByUserName(mobile);
		if(checkUser != null){
			return R.error("该用户已经注册");
		}
		return R.ok();
	}


	@PostMapping("/sys/user/resetPassword")
	public R password(@RequestBody PasswordForm form){
		String mobile = form.getMobile();
		String ver_code = form.getVer_code();
		Assert.isBlank(form.getMobile(), "用户电话不为能空");
		Assert.isBlank(form.getPassword(), "原密码不能为空");
		Assert.isBlank(form.getNewPassword(), "新密码不为能空");
		Assert.isBlank(form.getVer_code(), "验证码不为能空");

		// TODO: 2020/3/18 校验验证码
		boolean var_bool = NoticeUtil.checkVerCode(mobile,ver_code, NoticeTypeEnum.Reset_Password.getCode());
		if(!var_bool){
			return R.error("验证码不正确，请重新输入");
		}

		//拿到电话号码获取到用户的基本信息
		SysUserEntity entity = sysUserService.queryByUserName(form.getMobile());
		Assert.isNull(entity, "不存在该用户");

		//sha256加密
		String password = new Sha256Hash(form.getPassword(), entity.getSalt()).toHex();
		//sha256加密
		String newPassword = new Sha256Hash(form.getNewPassword(), entity.getSalt()).toHex();


		//更新密码
		boolean flag = sysUserService.updatePassword(entity.getUserId(), password, newPassword);
		if(!flag){
			return R.error("原密码不正确");
		}

		return R.ok();
	}




	// TODO
	@PostMapping("/sys/user/sendNotice")
	public R sendNotice(String mobile,String type){
		KYwSendSmsHistoryEntity entity = new KYwSendSmsHistoryEntity();
		entity.setPhone(mobile);
		entity.setSendType(Integer.valueOf(type));
		entity.setSendTime(new Date());

		// TODO
		if(type.equals("1")){
			entity.setVerCode("111111");
		}else{
			entity.setVerCode("222222");
		}
		sendSmsHistoryService.save(entity);

		return R.ok();
	}







	
}
