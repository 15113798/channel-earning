/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.data.controller;


import io.renren.common.utils.R;
import io.renren.modules.data.entity.HPOperateDataEntity;
import io.renren.modules.generator.entity.KYwProductActionEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据接口相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/data")
public class DataController extends AbstractController {


    //获取首页运营数据接口
    @PostMapping("/getHPOperateData")
    public R getHPOperateData() {
        HPOperateDataEntity data = new HPOperateDataEntity();
        data.setDailyActivity("100");
        data.setServiceProNum("1");
        data.setOperationTime("7天");
        return R.ok().put("data", data);
    }


	
}
