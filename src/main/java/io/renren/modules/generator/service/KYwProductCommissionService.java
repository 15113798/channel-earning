package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwProductCommissionEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 14:58:38
 */
public interface KYwProductCommissionService extends IService<KYwProductCommissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

