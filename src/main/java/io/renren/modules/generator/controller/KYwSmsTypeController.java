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

import io.renren.modules.generator.entity.KYwSmsTypeEntity;
import io.renren.modules.generator.service.KYwSmsTypeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:01:55
 */
@RestController
@RequestMapping("generator/kywsmstype")
public class KYwSmsTypeController {
    @Autowired
    private KYwSmsTypeService kYwSmsTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywsmstype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwSmsTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywsmstype:info")
    public R info(@PathVariable("id") Integer id){
		KYwSmsTypeEntity kYwSmsType = kYwSmsTypeService.getById(id);

        return R.ok().put("kYwSmsType", kYwSmsType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywsmstype:save")
    public R save(@RequestBody KYwSmsTypeEntity kYwSmsType){
		kYwSmsTypeService.save(kYwSmsType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywsmstype:update")
    public R update(@RequestBody KYwSmsTypeEntity kYwSmsType){
		kYwSmsTypeService.updateById(kYwSmsType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywsmstype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwSmsTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
