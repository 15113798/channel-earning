package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwIntegralDetailDao;
import io.renren.modules.generator.entity.KYwIntegralDetailEntity;
import io.renren.modules.generator.service.KYwIntegralDetailService;


@Service("kYwIntegralDetailService")
public class KYwIntegralDetailServiceImpl extends ServiceImpl<KYwIntegralDetailDao, KYwIntegralDetailEntity> implements KYwIntegralDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwIntegralDetailEntity> page = this.page(
                new Query<KYwIntegralDetailEntity>().getPage(params),
                new QueryWrapper<KYwIntegralDetailEntity>()
        );

        return new PageUtils(page);
    }

}