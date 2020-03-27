package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwActivityProductDao;
import io.renren.modules.generator.entity.KYwActivityProductEntity;
import io.renren.modules.generator.service.KYwActivityProductService;


@Service("kYwActivityProductService")
public class KYwActivityProductServiceImpl extends ServiceImpl<KYwActivityProductDao, KYwActivityProductEntity> implements KYwActivityProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwActivityProductEntity> page = this.page(
                new Query<KYwActivityProductEntity>().getPage(params),
                new QueryWrapper<KYwActivityProductEntity>()
        );

        return new PageUtils(page);
    }

}