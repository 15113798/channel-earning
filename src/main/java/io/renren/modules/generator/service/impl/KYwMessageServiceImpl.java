package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwMessageDao;
import io.renren.modules.generator.entity.KYwMessageEntity;
import io.renren.modules.generator.service.KYwMessageService;


@Service("kYwMessageService")
public class KYwMessageServiceImpl extends ServiceImpl<KYwMessageDao, KYwMessageEntity> implements KYwMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwMessageEntity> page = this.page(
                new Query<KYwMessageEntity>().getPage(params),
                new QueryWrapper<KYwMessageEntity>()
        );

        return new PageUtils(page);
    }

}