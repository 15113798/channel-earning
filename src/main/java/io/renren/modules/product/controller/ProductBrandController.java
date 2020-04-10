/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KYwBrandEntity;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.service.KYwBrandService;
import io.renren.modules.generator.service.KYwProductCategoryService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 品牌相关接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/product/brand")
public class ProductBrandController extends AbstractController {

    @Autowired
    private KYwBrandService service;


    @PostMapping("/getBrand")
    public R getColumn() {
        Map<String,Object> map  =new HashMap<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("create_time");
        List<KYwBrandEntity>list = service.list(wrapper);
        return R.ok().put("data", list);
    }

	
}
