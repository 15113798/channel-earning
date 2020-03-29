/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.act.controller;


import io.renren.common.utils.R;
import io.renren.modules.act.entity.ActProductDto;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品分类相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/act")
public class ActProductController extends AbstractController {

    @Autowired
    private KYwProductActionService actionService;
    @Autowired
    private KYwProductService productService;



    //获取所有的选品库商品活动列表
    @PostMapping("/getAreaInfo")
    public R getAreaInfo() {
        List<KYwProductActionEntity>list = actionService.list();
        return R.ok().put("data", list);
    }


    //根据商品活动id获取活动详情，包括活动信息以及该活动包含的商品详情
    @PostMapping("/getActProductList")
    public R getActProductList(Integer actId,Integer page,Integer limit) {
        //根据id获取该专区的信息
        KYwProductActionEntity entity = actionService.getById(actId);
        //根据专区去连表获取商品信息

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("actId",actId);
        Integer startLimit = (page-1)*limit;
        map.put("page",page);
        map.put("startLimit",startLimit);
        map.put("limit",limit);
        List<KYwProductEntity> list = productService.findProByActId(map);

        ActProductDto dto = new ActProductDto();
        dto.setProductEntityList(list);
        dto.setProductActionEntity(entity);

        return R.ok().put("data", dto);
    }

	
}
