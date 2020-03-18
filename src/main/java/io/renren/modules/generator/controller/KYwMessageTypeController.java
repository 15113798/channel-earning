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

import io.renren.modules.generator.entity.KYwMessageTypeEntity;
import io.renren.modules.generator.service.KYwMessageTypeService;
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
@RequestMapping("generator/kywmessagetype")
public class KYwMessageTypeController {
    @Autowired
    private KYwMessageTypeService kYwMessageTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywmessagetype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwMessageTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywmessagetype:info")
    public R info(@PathVariable("id") Integer id){
		KYwMessageTypeEntity kYwMessageType = kYwMessageTypeService.getById(id);

        return R.ok().put("kYwMessageType", kYwMessageType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywmessagetype:save")
    public R save(@RequestBody KYwMessageTypeEntity kYwMessageType){
		kYwMessageTypeService.save(kYwMessageType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywmessagetype:update")
    public R update(@RequestBody KYwMessageTypeEntity kYwMessageType){
		kYwMessageTypeService.updateById(kYwMessageType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywmessagetype:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwMessageTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
