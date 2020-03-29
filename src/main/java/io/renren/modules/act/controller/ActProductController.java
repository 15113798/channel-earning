/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.act.controller;


import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KYwActivityProductEntity;
import io.renren.modules.generator.entity.KYwProductActionEntity;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwActivityProductService;
import io.renren.modules.generator.service.KYwProductActionService;
import io.renren.modules.generator.service.KYwProductCategoryService;
import io.renren.modules.generator.service.KYwProductService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/act/")
public class ActProductController extends AbstractController {

    @Autowired
    private KYwProductActionService service;



    //获取所有的选品库商品活动列表
    @PostMapping("/getAreaInfo")
    public R getAreaInfo() {
        List<KYwProductActionEntity>list = service.list();
        return R.ok().put("data", list);
    }

	
}
