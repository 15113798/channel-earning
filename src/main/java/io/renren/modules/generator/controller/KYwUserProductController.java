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

import io.renren.modules.generator.entity.KYwUserProductEntity;
import io.renren.modules.generator.service.KYwUserProductService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:01:55
 */
@RestController
@RequestMapping("generator/kywuserproduct")
public class KYwUserProductController {
    @Autowired
    private KYwUserProductService kYwUserProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kywuserproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kYwUserProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kywuserproduct:info")
    public R info(@PathVariable("id") Integer id){
		KYwUserProductEntity kYwUserProduct = kYwUserProductService.getById(id);

        return R.ok().put("kYwUserProduct", kYwUserProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kywuserproduct:save")
    public R save(@RequestBody KYwUserProductEntity kYwUserProduct){
		kYwUserProductService.save(kYwUserProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kywuserproduct:update")
    public R update(@RequestBody KYwUserProductEntity kYwUserProduct){
		kYwUserProductService.updateById(kYwUserProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kywuserproduct:delete")
    public R delete(@RequestBody Integer[] ids){
		kYwUserProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
