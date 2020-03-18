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

import io.renren.modules.generator.entity.KYwTgAreaEntity;
import io.renren.modules.generator.service.KYwTgAreaService;
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
@RequestMapping("generator/kywtgarea")
public class KYwTgAreaController {
    @Autowired
    private KYwTgAreaService kYwTgAreaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywtgarea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwTgAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywtgarea:info")
    public R info(@PathVariable("id") Integer id){
		KYwTgAreaEntity kYwTgArea = kYwTgAreaService.getById(id);

        return R.ok().put("kYwTgArea", kYwTgArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywtgarea:save")
    public R save(@RequestBody KYwTgAreaEntity kYwTgArea){
		kYwTgAreaService.save(kYwTgArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywtgarea:update")
    public R update(@RequestBody KYwTgAreaEntity kYwTgArea){
		kYwTgAreaService.updateById(kYwTgArea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywtgarea:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwTgAreaService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
