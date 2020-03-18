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

import io.renren.modules.generator.entity.KYwProductActionEntity;
import io.renren.modules.generator.service.KYwProductActionService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 14:58:38
 */
@RestController
@RequestMapping("generator/kywproductaction")
public class KYwProductActionController {
    @Autowired
    private KYwProductActionService kYwProductActionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproductaction:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductActionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproductaction:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductActionEntity kYwProductAction = kYwProductActionService.getById(id);

        return R.ok().put("kYwProductAction", kYwProductAction);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproductaction:save")
    public R save(@RequestBody KYwProductActionEntity kYwProductAction){
		kYwProductActionService.save(kYwProductAction);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproductaction:update")
    public R update(@RequestBody KYwProductActionEntity kYwProductAction){
		kYwProductActionService.updateById(kYwProductAction);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproductaction:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductActionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
