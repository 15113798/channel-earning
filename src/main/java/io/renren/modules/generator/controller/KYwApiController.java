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

import io.renren.modules.generator.entity.KYwApiEntity;
import io.renren.modules.generator.service.KYwApiService;
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
@RequestMapping("generator/kywapi")
public class KYwApiController {
    @Autowired
    private KYwApiService kYwApiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywapi:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwApiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywapi:info")
    public R info(@PathVariable("id") Integer id){
		KYwApiEntity kYwApi = kYwApiService.getById(id);

        return R.ok().put("kYwApi", kYwApi);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywapi:save")
    public R save(@RequestBody KYwApiEntity kYwApi){
		kYwApiService.save(kYwApi);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywapi:update")
    public R update(@RequestBody KYwApiEntity kYwApi){
		kYwApiService.updateById(kYwApi);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywapi:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwApiService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
