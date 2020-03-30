package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KYwCommentEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 15:10:25
 */
public interface KYwCommentService extends IService<KYwCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

