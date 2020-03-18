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

import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.service.KYwProductCategoryService;
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
@RequestMapping("generator/kywproductcategory")
public class KYwProductCategoryController {
    @Autowired
    private KYwProductCategoryService kYwProductCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproductcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproductcategory:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductCategoryEntity kYwProductCategory = kYwProductCategoryService.getById(id);

        return R.ok().put("kYwProductCategory", kYwProductCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproductcategory:save")
    public R save(@RequestBody KYwProductCategoryEntity kYwProductCategory){
		kYwProductCategoryService.save(kYwProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproductcategory:update")
    public R update(@RequestBody KYwProductCategoryEntity kYwProductCategory){
		kYwProductCategoryService.updateById(kYwProductCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproductcategory:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
