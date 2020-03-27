package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwActivityProductEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-27 13:21:34
 */
public interface KYwActivityProductService extends IService<KYwActivityProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

