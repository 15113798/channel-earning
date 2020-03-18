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

import io.renren.modules.generator.entity.KYwProductTgTypeEntity;
import io.renren.modules.generator.service.KYwProductTgTypeService;
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
@RequestMapping("generator/kywproducttgtype")
public class KYwProductTgTypeController {
    @Autowired
    private KYwProductTgTypeService kYwProductTgTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproducttgtype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductTgTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproducttgtype:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductTgTypeEntity kYwProductTgType = kYwProductTgTypeService.getById(id);

        return R.ok().put("kYwProductTgType", kYwProductTgType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproducttgtype:save")
    public R save(@RequestBody KYwProductTgTypeEntity kYwProductTgType){
		kYwProductTgTypeService.save(kYwProductTgType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproducttgtype:update")
    public R update(@RequestBody KYwProductTgTypeEntity kYwProductTgType){
		kYwProductTgTypeService.updateById(kYwProductTgType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproducttgtype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductTgTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
