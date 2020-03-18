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

import io.renren.modules.generator.entity.KYwPidEntity;
import io.renren.modules.generator.service.KYwPidService;
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
@RequestMapping("generator/kywpid")
public class KYwPidController {
    @Autowired
    private KYwPidService kYwPidService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywpid:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwPidService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywpid:info")
    public R info(@PathVariable("id") Integer id){
		KYwPidEntity kYwPid = kYwPidService.getById(id);

        return R.ok().put("kYwPid", kYwPid);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywpid:save")
    public R save(@RequestBody KYwPidEntity kYwPid){
		kYwPidService.save(kYwPid);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywpid:update")
    public R update(@RequestBody KYwPidEntity kYwPid){
		kYwPidService.updateById(kYwPid);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywpid:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwPidService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
