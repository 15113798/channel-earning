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

import io.renren.modules.generator.entity.KYwBrandPaoductEntity;
import io.renren.modules.generator.service.KYwBrandPaoductService;
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
@RequestMapping("generator/kywbrandpaoduct")
public class KYwBrandPaoductController {
    @Autowired
    private KYwBrandPaoductService kYwBrandPaoductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbrandpaoduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandPaoductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbrandpaoduct:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandPaoductEntity kYwBrandPaoduct = kYwBrandPaoductService.getById(id);

        return R.ok().put("kYwBrandPaoduct", kYwBrandPaoduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbrandpaoduct:save")
    public R save(@RequestBody KYwBrandPaoductEntity kYwBrandPaoduct){
		kYwBrandPaoductService.save(kYwBrandPaoduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbrandpaoduct:update")
    public R update(@RequestBody KYwBrandPaoductEntity kYwBrandPaoduct){
		kYwBrandPaoductService.updateById(kYwBrandPaoduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbrandpaoduct:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandPaoductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
