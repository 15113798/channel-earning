package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwBrandProductEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-31 15:38:28
 */
public interface KYwBrandProductService extends IService<KYwBrandProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

