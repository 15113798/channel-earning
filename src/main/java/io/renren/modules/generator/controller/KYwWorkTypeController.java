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

import io.renren.modules.generator.entity.KYwWorkTypeEntity;
import io.renren.modules.generator.service.KYwWorkTypeService;
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
@RequestMapping("generator/kywworktype")
public class KYwWorkTypeController {
    @Autowired
    private KYwWorkTypeService kYwWorkTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywworktype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwWorkTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywworktype:info")
    public R info(@PathVariable("id") Integer id){
		KYwWorkTypeEntity kYwWorkType = kYwWorkTypeService.getById(id);

        return R.ok().put("kYwWorkType", kYwWorkType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywworktype:save")
    public R save(@RequestBody KYwWorkTypeEntity kYwWorkType){
		kYwWorkTypeService.save(kYwWorkType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywworktype:update")
    public R update(@RequestBody KYwWorkTypeEntity kYwWorkType){
		kYwWorkTypeService.updateById(kYwWorkType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywworktype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwWorkTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
