package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandPaoductDao;
import io.renren.modules.generator.entity.KYwBrandPaoductEntity;
import io.renren.modules.generator.service.KYwBrandPaoductService;


@Service("kYwBrandPaoductService")
public class KYwBrandPaoductServiceImpl extends ServiceImpl<KYwBrandPaoductDao, KYwBrandPaoductEntity> implements KYwBrandPaoductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandPaoductEntity> page = this.page(
                new Query<KYwBrandPaoductEntity>().getPage(params),
                new QueryWrapper<KYwBrandPaoductEntity>()
        );

        return new PageUtils(page);
    }

}