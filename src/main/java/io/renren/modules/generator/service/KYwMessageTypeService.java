package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwMessageTypeEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:00:33
 */
public interface KYwMessageTypeService extends IService<KYwMessageTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

