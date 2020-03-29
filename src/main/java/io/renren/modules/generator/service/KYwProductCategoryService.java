package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-29 13:56:38
 */
public interface KYwProductCategoryService extends IService<KYwProductCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

