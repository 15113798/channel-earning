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

import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwProductService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:00:33
 */
@RestController
@RequestMapping("generator/kywproduct")
public class KYwProductController {
    @Autowired
    private KYwProductService kYwProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproduct:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductEntity kYwProduct = kYwProductService.getById(id);

        return R.ok().put("kYwProduct", kYwProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproduct:save")
    public R save(@RequestBody KYwProductEntity kYwProduct){
		kYwProductService.save(kYwProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproduct:update")
    public R update(@RequestBody KYwProductEntity kYwProduct){
		kYwProductService.updateById(kYwProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
