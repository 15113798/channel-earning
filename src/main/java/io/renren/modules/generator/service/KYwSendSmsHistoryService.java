package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwSendSmsHistoryEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-09 23:27:09
 */
public interface KYwSendSmsHistoryService extends IService<KYwSendSmsHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

