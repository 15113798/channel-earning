/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.product.controller;


import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KYwMuneEntity;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.service.KYwProductCategoryService;
import io.renren.modules.generator.service.KYwProductService;
import io.renren.modules.homePage.service.HomePageService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品分类相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/product/category")
public class ProductCategoryController extends AbstractController {

    @Autowired
    private KYwProductCategoryService kYwProductCategoryService;


    @PostMapping("/getColumn")
    public R getMenu(Integer parent_id) {
        //传入type，然后获取到该类型的所有菜单信息。并且按照排序
        Map map = new HashMap<String,Object>();
        map.put("parent_id",parent_id);
        List<KYwProductCategoryEntity> data = kYwProductCategoryService.listByMap(map);

        return R.ok().put("data", data);
    }

	
}
