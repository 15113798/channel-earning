/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.homePage.controller;


import io.renren.common.utils.R;
import io.renren.modules.common.entity.ReNTbkItem;
import io.renren.modules.common.service.TaoBaoService;
import io.renren.modules.generator.entity.KYwMuneEntity;
import io.renren.modules.generator.service.KYwMuneService;
import io.renren.modules.homePage.service.HomePageService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/homePage")
public class HomePageController extends AbstractController {

    @Autowired
    private HomePageService homePageService;


    @PostMapping("/getMenu")
    public R getMenu(Integer type,Integer pid) {
        //传入type，然后获取到该类型的所有菜单信息。并且按照排序
        List<KYwMuneEntity> data = homePageService.queryMeue(type,pid);

        return R.ok().put("data", data);
    }

	
}
