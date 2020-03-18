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

import io.renren.modules.generator.entity.KYwTgIncomeEntity;
import io.renren.modules.generator.service.KYwTgIncomeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:01:54
 */
@RestController
@RequestMapping("generator/kywtgincome")
public class KYwTgIncomeController {
    @Autowired
    private KYwTgIncomeService kYwTgIncomeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywtgincome:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwTgIncomeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywtgincome:info")
    public R info(@PathVariable("id") Integer id){
		KYwTgIncomeEntity kYwTgIncome = kYwTgIncomeService.getById(id);

        return R.ok().put("kYwTgIncome", kYwTgIncome);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywtgincome:save")
    public R save(@RequestBody KYwTgIncomeEntity kYwTgIncome){
		kYwTgIncomeService.save(kYwTgIncome);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywtgincome:update")
    public R update(@RequestBody KYwTgIncomeEntity kYwTgIncome){
		kYwTgIncomeService.updateById(kYwTgIncome);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywtgincome:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwTgIncomeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
