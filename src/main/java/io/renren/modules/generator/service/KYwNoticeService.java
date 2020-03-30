package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwNoticeEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 17:19:24
 */
public interface KYwNoticeService extends IService<KYwNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

