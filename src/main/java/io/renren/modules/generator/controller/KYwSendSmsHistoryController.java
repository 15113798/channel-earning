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

import io.renren.modules.generator.entity.KYwSendSmsHistoryEntity;
import io.renren.modules.generator.service.KYwSendSmsHistoryService;
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
@RequestMapping("generator/kywsendsmshistory")
public class KYwSendSmsHistoryController {
    @Autowired
    private KYwSendSmsHistoryService kYwSendSmsHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywsendsmshistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwSendSmsHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywsendsmshistory:info")
    public R info(@PathVariable("id") Integer id){
		KYwSendSmsHistoryEntity kYwSendSmsHistory = kYwSendSmsHistoryService.getById(id);

        return R.ok().put("kYwSendSmsHistory", kYwSendSmsHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywsendsmshistory:save")
    public R save(@RequestBody KYwSendSmsHistoryEntity kYwSendSmsHistory){
		kYwSendSmsHistoryService.save(kYwSendSmsHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywsendsmshistory:update")
    public R update(@RequestBody KYwSendSmsHistoryEntity kYwSendSmsHistory){
		kYwSendSmsHistoryService.updateById(kYwSendSmsHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywsendsmshistory:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwSendSmsHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
