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

import io.renren.modules.generator.entity.KYwActivityProductEntity;
import io.renren.modules.generator.service.KYwActivityProductService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-27 13:21:34
 */
@RestController
@RequestMapping("generator/kywactivityproduct")
public class KYwActivityProductController {
    @Autowired
    private KYwActivityProductService kYwActivityProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywactivityproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwActivityProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywactivityproduct:info")
    public R info(@PathVariable("id") Integer id){
		KYwActivityProductEntity kYwActivityProduct = kYwActivityProductService.getById(id);

        return R.ok().put("kYwActivityProduct", kYwActivityProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywactivityproduct:save")
    public R save(@RequestBody KYwActivityProductEntity kYwActivityProduct){
		kYwActivityProductService.save(kYwActivityProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywactivityproduct:update")
    public R update(@RequestBody KYwActivityProductEntity kYwActivityProduct){
		kYwActivityProductService.updateById(kYwActivityProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywactivityproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwActivityProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
