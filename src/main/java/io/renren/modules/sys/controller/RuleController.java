/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.generator.service.KYwNoticeService;
import io.renren.modules.generator.service.KYwRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 规则接口
 *
 */
@RestController
@RequestMapping("/rule")
public class RuleController extends AbstractController {

    @Autowired
    private KYwRuleService service;


    //获取消息列表
    @PostMapping("/getList")
    public R getList(@RequestParam Map<String, Object> params) {
        PageUtils page = service.queryPage(params);

        return R.ok().put("data",page);
    }


	
}
