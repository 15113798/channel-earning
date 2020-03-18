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

import io.renren.modules.generator.entity.KYwProductChangeEntity;
import io.renren.modules.generator.service.KYwProductChangeService;
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
@RequestMapping("generator/kywproductchange")
public class KYwProductChangeController {
    @Autowired
    private KYwProductChangeService kYwProductChangeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproductchange:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductChangeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproductchange:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductChangeEntity kYwProductChange = kYwProductChangeService.getById(id);

        return R.ok().put("kYwProductChange", kYwProductChange);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproductchange:save")
    public R save(@RequestBody KYwProductChangeEntity kYwProductChange){
		kYwProductChangeService.save(kYwProductChange);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproductchange:update")
    public R update(@RequestBody KYwProductChangeEntity kYwProductChange){
		kYwProductChangeService.updateById(kYwProductChange);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproductchange:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductChangeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
