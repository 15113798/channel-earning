package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductActionDao;
import io.renren.modules.generator.entity.KYwProductActionEntity;
import io.renren.modules.generator.service.KYwProductActionService;


@Service("kYwProductActionService")
public class KYwProductActionServiceImpl extends ServiceImpl<KYwProductActionDao, KYwProductActionEntity> implements KYwProductActionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductActionEntity> page = this.page(
                new Query<KYwProductActionEntity>().getPage(params),
                new QueryWrapper<KYwProductActionEntity>()
        );

        return new PageUtils(page);
    }

}