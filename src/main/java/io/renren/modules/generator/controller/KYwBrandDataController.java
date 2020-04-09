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

import io.renren.modules.generator.entity.KYwBrandDataEntity;
import io.renren.modules.generator.service.KYwBrandDataService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-31 16:25:15
 */
@RestController
@RequestMapping("generator/kywbranddata")
public class KYwBrandDataController {
    @Autowired
    private KYwBrandDataService kYwBrandDataService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbranddata:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandDataService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbranddata:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandDataEntity kYwBrandData = kYwBrandDataService.getById(id);

        return R.ok().put("kYwBrandData", kYwBrandData);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbranddata:save")
    public R save(@RequestBody KYwBrandDataEntity kYwBrandData){
		kYwBrandDataService.save(kYwBrandData);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbranddata:update")
    public R update(@RequestBody KYwBrandDataEntity kYwBrandData){
		kYwBrandDataService.updateById(kYwBrandData);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbranddata:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandDataService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
