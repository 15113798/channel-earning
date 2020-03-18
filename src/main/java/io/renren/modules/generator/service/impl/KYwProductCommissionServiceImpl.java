package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductCommissionDao;
import io.renren.modules.generator.entity.KYwProductCommissionEntity;
import io.renren.modules.generator.service.KYwProductCommissionService;


@Service("kYwProductCommissionService")
public class KYwProductCommissionServiceImpl extends ServiceImpl<KYwProductCommissionDao, KYwProductCommissionEntity> implements KYwProductCommissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductCommissionEntity> page = this.page(
                new Query<KYwProductCommissionEntity>().getPage(params),
                new QueryWrapper<KYwProductCommissionEntity>()
        );

        return new PageUtils(page);
    }

}