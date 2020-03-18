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

import io.renren.modules.generator.entity.KYwBrandEntity;
import io.renren.modules.generator.service.KYwBrandService;
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
@RequestMapping("generator/kywbrand")
public class KYwBrandController {
    @Autowired
    private KYwBrandService kYwBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbrand:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandEntity kYwBrand = kYwBrandService.getById(id);

        return R.ok().put("kYwBrand", kYwBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbrand:save")
    public R save(@RequestBody KYwBrandEntity kYwBrand){
		kYwBrandService.save(kYwBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbrand:update")
    public R update(@RequestBody KYwBrandEntity kYwBrand){
		kYwBrandService.updateById(kYwBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbrand:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
