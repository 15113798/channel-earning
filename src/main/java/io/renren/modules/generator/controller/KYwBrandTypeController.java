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

import io.renren.modules.generator.entity.KYwBrandTypeEntity;
import io.renren.modules.generator.service.KYwBrandTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:00:32
 */
@RestController
@RequestMapping("generator/kywbrandtype")
public class KYwBrandTypeController {
    @Autowired
    private KYwBrandTypeService kYwBrandTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbrandtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbrandtype:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandTypeEntity kYwBrandType = kYwBrandTypeService.getById(id);

        return R.ok().put("kYwBrandType", kYwBrandType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbrandtype:save")
    public R save(@RequestBody KYwBrandTypeEntity kYwBrandType){
		kYwBrandTypeService.save(kYwBrandType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbrandtype:update")
    public R update(@RequestBody KYwBrandTypeEntity kYwBrandType){
		kYwBrandTypeService.updateById(kYwBrandType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbrandtype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
