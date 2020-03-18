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

import io.renren.modules.generator.entity.KYwApiTypeEntity;
import io.renren.modules.generator.service.KYwApiTypeService;
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
@RequestMapping("generator/kywapitype")
public class KYwApiTypeController {
    @Autowired
    private KYwApiTypeService kYwApiTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywapitype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwApiTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywapitype:info")
    public R info(@PathVariable("id") Integer id){
		KYwApiTypeEntity kYwApiType = kYwApiTypeService.getById(id);

        return R.ok().put("kYwApiType", kYwApiType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywapitype:save")
    public R save(@RequestBody KYwApiTypeEntity kYwApiType){
		kYwApiTypeService.save(kYwApiType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywapitype:update")
    public R update(@RequestBody KYwApiTypeEntity kYwApiType){
		kYwApiTypeService.updateById(kYwApiType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywapitype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwApiTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
