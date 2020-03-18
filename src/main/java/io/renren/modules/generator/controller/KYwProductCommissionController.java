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

import io.renren.modules.generator.entity.KYwProductCommissionEntity;
import io.renren.modules.generator.service.KYwProductCommissionService;
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
@RequestMapping("generator/kywproductcommission")
public class KYwProductCommissionController {
    @Autowired
    private KYwProductCommissionService kYwProductCommissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproductcommission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductCommissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproductcommission:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductCommissionEntity kYwProductCommission = kYwProductCommissionService.getById(id);

        return R.ok().put("kYwProductCommission", kYwProductCommission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproductcommission:save")
    public R save(@RequestBody KYwProductCommissionEntity kYwProductCommission){
		kYwProductCommissionService.save(kYwProductCommission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproductcommission:update")
    public R update(@RequestBody KYwProductCommissionEntity kYwProductCommission){
		kYwProductCommissionService.updateById(kYwProductCommission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproductcommission:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductCommissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
