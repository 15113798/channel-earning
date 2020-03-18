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

import io.renren.modules.generator.entity.KYwPointTypeEntity;
import io.renren.modules.generator.service.KYwPointTypeService;
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
@RequestMapping("generator/kywpointtype")
public class KYwPointTypeController {
    @Autowired
    private KYwPointTypeService kYwPointTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywpointtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwPointTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywpointtype:info")
    public R info(@PathVariable("id") Integer id){
		KYwPointTypeEntity kYwPointType = kYwPointTypeService.getById(id);

        return R.ok().put("kYwPointType", kYwPointType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywpointtype:save")
    public R save(@RequestBody KYwPointTypeEntity kYwPointType){
		kYwPointTypeService.save(kYwPointType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywpointtype:update")
    public R update(@RequestBody KYwPointTypeEntity kYwPointType){
		kYwPointTypeService.updateById(kYwPointType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywpointtype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwPointTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
