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

import io.renren.modules.generator.entity.KYwBrandCategoryEntity;
import io.renren.modules.generator.service.KYwBrandCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-31 15:38:28
 */
@RestController
@RequestMapping("generator/kywbrandcategory")
public class KYwBrandCategoryController {
    @Autowired
    private KYwBrandCategoryService kYwBrandCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbrandcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbrandcategory:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandCategoryEntity kYwBrandCategory = kYwBrandCategoryService.getById(id);

        return R.ok().put("kYwBrandCategory", kYwBrandCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbrandcategory:save")
    public R save(@RequestBody KYwBrandCategoryEntity kYwBrandCategory){
		kYwBrandCategoryService.save(kYwBrandCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbrandcategory:update")
    public R update(@RequestBody KYwBrandCategoryEntity kYwBrandCategory){
		kYwBrandCategoryService.updateById(kYwBrandCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbrandcategory:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
