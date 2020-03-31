package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandProductDao;
import io.renren.modules.generator.entity.KYwBrandProductEntity;
import io.renren.modules.generator.service.KYwBrandProductService;


@Service("kYwBrandProductService")
public class KYwBrandProductServiceImpl extends ServiceImpl<KYwBrandProductDao, KYwBrandProductEntity> implements KYwBrandProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandProductEntity> page = this.page(
                new Query<KYwBrandProductEntity>().getPage(params),
                new QueryWrapper<KYwBrandProductEntity>()
        );

        return new PageUtils(page);
    }

}