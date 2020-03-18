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

import io.renren.modules.generator.entity.KYwProductTgContentEntity;
import io.renren.modules.generator.service.KYwProductTgContentService;
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
@RequestMapping("generator/kywproducttgcontent")
public class KYwProductTgContentController {
    @Autowired
    private KYwProductTgContentService kYwProductTgContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywproducttgcontent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwProductTgContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywproducttgcontent:info")
    public R info(@PathVariable("id") Integer id){
		KYwProductTgContentEntity kYwProductTgContent = kYwProductTgContentService.getById(id);

        return R.ok().put("kYwProductTgContent", kYwProductTgContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywproducttgcontent:save")
    public R save(@RequestBody KYwProductTgContentEntity kYwProductTgContent){
		kYwProductTgContentService.save(kYwProductTgContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywproducttgcontent:update")
    public R update(@RequestBody KYwProductTgContentEntity kYwProductTgContent){
		kYwProductTgContentService.updateById(kYwProductTgContent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywproducttgcontent:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwProductTgContentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
