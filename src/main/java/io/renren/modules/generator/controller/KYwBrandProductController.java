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

import io.renren.modules.generator.entity.KYwBrandProductEntity;
import io.renren.modules.generator.service.KYwBrandProductService;
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
@RequestMapping("generator/kywbrandproduct")
public class KYwBrandProductController {
    @Autowired
    private KYwBrandProductService kYwBrandProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywbrandproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwBrandProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywbrandproduct:info")
    public R info(@PathVariable("id") Integer id){
		KYwBrandProductEntity kYwBrandProduct = kYwBrandProductService.getById(id);

        return R.ok().put("kYwBrandProduct", kYwBrandProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywbrandproduct:save")
    public R save(@RequestBody KYwBrandProductEntity kYwBrandProduct){
		kYwBrandProductService.save(kYwBrandProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywbrandproduct:update")
    public R update(@RequestBody KYwBrandProductEntity kYwBrandProduct){
		kYwBrandProductService.updateById(kYwBrandProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywbrandproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwBrandProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
