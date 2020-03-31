/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.billboard.controller;


import io.renren.common.utils.R;
import io.renren.modules.billboard.service.BillBoardService;
import io.renren.modules.data.entity.HPOperateDataEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 榜单接口
 *
 */
@RestController
@RequestMapping("/billBoard")
public class BillBoardController extends AbstractController {

    @Autowired
    private BillBoardService service;


    //获取榜单数据接口
    @PostMapping("/getList")
    public R getList(Integer type,Integer page,Integer limit) {
        List<KYwProductEntity> list = service.getList(type,page,limit);


        return R.ok().put("data", list);
    }


	
}
