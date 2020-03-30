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

import io.renren.modules.generator.entity.KYwRuleEntity;
import io.renren.modules.generator.service.KYwRuleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 19:00:49
 */
@RestController
@RequestMapping("generator/kywrule")
public class KYwRuleController {
    @Autowired
    private KYwRuleService kYwRuleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywrule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwRuleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywrule:info")
    public R info(@PathVariable("id") Integer id){
		KYwRuleEntity kYwRule = kYwRuleService.getById(id);

        return R.ok().put("kYwRule", kYwRule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywrule:save")
    public R save(@RequestBody KYwRuleEntity kYwRule){
		kYwRuleService.save(kYwRule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywrule:update")
    public R update(@RequestBody KYwRuleEntity kYwRule){
		kYwRuleService.updateById(kYwRule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywrule:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwRuleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
