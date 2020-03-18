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

import io.renren.modules.generator.entity.KYwIntegralDetailEntity;
import io.renren.modules.generator.service.KYwIntegralDetailService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 14:58:38
 */
@RestController
@RequestMapping("generator/kywintegraldetail")
public class KYwIntegralDetailController {
    @Autowired
    private KYwIntegralDetailService kYwIntegralDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywintegraldetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwIntegralDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywintegraldetail:info")
    public R info(@PathVariable("id") Integer id){
		KYwIntegralDetailEntity kYwIntegralDetail = kYwIntegralDetailService.getById(id);

        return R.ok().put("kYwIntegralDetail", kYwIntegralDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywintegraldetail:save")
    public R save(@RequestBody KYwIntegralDetailEntity kYwIntegralDetail){
		kYwIntegralDetailService.save(kYwIntegralDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywintegraldetail:update")
    public R update(@RequestBody KYwIntegralDetailEntity kYwIntegralDetail){
		kYwIntegralDetailService.updateById(kYwIntegralDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywintegraldetail:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwIntegralDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
