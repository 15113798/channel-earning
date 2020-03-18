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

import io.renren.modules.generator.entity.KYwMessageEntity;
import io.renren.modules.generator.service.KYwMessageService;
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
@RequestMapping("generator/kywmessage")
public class KYwMessageController {
    @Autowired
    private KYwMessageService kYwMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywmessage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwMessageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywmessage:info")
    public R info(@PathVariable("id") Integer id){
		KYwMessageEntity kYwMessage = kYwMessageService.getById(id);

        return R.ok().put("kYwMessage", kYwMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywmessage:save")
    public R save(@RequestBody KYwMessageEntity kYwMessage){
		kYwMessageService.save(kYwMessage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywmessage:update")
    public R update(@RequestBody KYwMessageEntity kYwMessage){
		kYwMessageService.updateById(kYwMessage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywmessage:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwMessageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
