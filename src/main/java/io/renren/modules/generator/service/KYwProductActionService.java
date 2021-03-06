package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwProductActionEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-27 13:18:34
 */
public interface KYwProductActionService extends IService<KYwProductActionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

