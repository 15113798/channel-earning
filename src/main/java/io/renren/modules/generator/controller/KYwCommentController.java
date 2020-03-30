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

import io.renren.modules.generator.entity.KYwCommentEntity;
import io.renren.modules.generator.service.KYwCommentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 15:10:25
 */
@RestController
@RequestMapping("generator/kywcomment")
public class KYwCommentController {
    @Autowired
    private KYwCommentService kYwCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywcomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywcomment:info")
    public R info(@PathVariable("id") Integer id){
		KYwCommentEntity kYwComment = kYwCommentService.getById(id);

        return R.ok().put("kYwComment", kYwComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywcomment:save")
    public R save(@RequestBody KYwCommentEntity kYwComment){


		kYwCommentService.save(kYwComment);


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywcomment:update")
    public R update(@RequestBody KYwCommentEntity kYwComment){
		kYwCommentService.updateById(kYwComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywcomment:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
