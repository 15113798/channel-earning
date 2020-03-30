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

import io.renren.modules.generator.entity.KYwNoticeEntity;
import io.renren.modules.generator.service.KYwNoticeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 17:19:24
 */
@RestController
@RequestMapping("generator/kywnotice")
public class KYwNoticeController {
    @Autowired
    private KYwNoticeService kYwNoticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywnotice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwNoticeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywnotice:info")
    public R info(@PathVariable("id") Integer id){
		KYwNoticeEntity kYwNotice = kYwNoticeService.getById(id);

        return R.ok().put("kYwNotice", kYwNotice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywnotice:save")
    public R save(@RequestBody KYwNoticeEntity kYwNotice){
		kYwNoticeService.save(kYwNotice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywnotice:update")
    public R update(@RequestBody KYwNoticeEntity kYwNotice){
		kYwNoticeService.updateById(kYwNotice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywnotice:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwNoticeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
