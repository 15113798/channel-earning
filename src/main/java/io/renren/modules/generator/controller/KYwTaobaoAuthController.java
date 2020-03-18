package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.KYwTaobaoAuthEntity;
import io.renren.modules.generator.service.KYwTaobaoAuthService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:01:55
 */
@RestController
@RequestMapping("generator/kywtaobaoauth")
public class KYwTaobaoAuthController {
    @Autowired
    private KYwTaobaoAuthService kYwTaobaoAuthService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywtaobaoauth:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwTaobaoAuthService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywtaobaoauth:info")
    public R info(@PathVariable("id") Integer id){
		KYwTaobaoAuthEntity kYwTaobaoAuth = kYwTaobaoAuthService.getById(id);

        return R.ok().put("kYwTaobaoAuth", kYwTaobaoAuth);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywtaobaoauth:save")
    public R save(@RequestBody KYwTaobaoAuthEntity kYwTaobaoAuth){
		kYwTaobaoAuthService.save(kYwTaobaoAuth);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywtaobaoauth:update")
    public R update(@RequestBody KYwTaobaoAuthEntity kYwTaobaoAuth){
		kYwTaobaoAuthService.updateById(kYwTaobaoAuth);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywtaobaoauth:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwTaobaoAuthService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
