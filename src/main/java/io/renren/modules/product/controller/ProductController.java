/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KYwBrandEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwBrandService;
import io.renren.modules.generator.service.KYwProductService;
import io.renren.modules.product.service.ProductService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品相关接口
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController {

    @Autowired
    private ProductService service;



    //选品库商品列表
    @PostMapping("/getSelectStoreList")
    public R getSelectStoreList(
            Integer brandId, Integer categoryId,String priceRange,String couponRange,String comRateRange,
            Integer monthSales,Integer sortRule,Integer page,Integer limit
    ) {

        PageUtils data = service.getSelectStoreList(brandId,categoryId,priceRange,couponRange,comRateRange,monthSales,sortRule,page,limit);

        return R.ok().put("data",data);
    }

	
}
