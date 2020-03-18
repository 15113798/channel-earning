package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwUserProductDao;
import io.renren.modules.generator.entity.KYwUserProductEntity;
import io.renren.modules.generator.service.KYwUserProductService;


@Service("kYwUserProductService")
public class KYwUserProductServiceImpl extends ServiceImpl<KYwUserProductDao, KYwUserProductEntity> implements KYwUserProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwUserProductEntity> page = this.page(
                new Query<KYwUserProductEntity>().getPage(params),
                new QueryWrapper<KYwUserProductEntity>()
        );

        return new PageUtils(page);
    }

}