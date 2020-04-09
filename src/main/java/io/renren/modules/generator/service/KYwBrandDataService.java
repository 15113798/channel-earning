package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwBrandDataEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-31 16:25:15
 */
public interface KYwBrandDataService extends IService<KYwBrandDataEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

