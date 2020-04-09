package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandDataDao;
import io.renren.modules.generator.entity.KYwBrandDataEntity;
import io.renren.modules.generator.service.KYwBrandDataService;


@Service("kYwBrandDataService")
public class KYwBrandDataServiceImpl extends ServiceImpl<KYwBrandDataDao, KYwBrandDataEntity> implements KYwBrandDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandDataEntity> page = this.page(
                new Query<KYwBrandDataEntity>().getPage(params),
                new QueryWrapper<KYwBrandDataEntity>()
        );

        return new PageUtils(page);
    }

}