package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwRuleEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 19:00:49
 */
public interface KYwRuleService extends IService<KYwRuleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

