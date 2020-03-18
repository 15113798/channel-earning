package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductDao;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwProductService;


@Service("kYwProductService")
public class KYwProductServiceImpl extends ServiceImpl<KYwProductDao, KYwProductEntity> implements KYwProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductEntity> page = this.page(
                new Query<KYwProductEntity>().getPage(params),
                new QueryWrapper<KYwProductEntity>()
        );

        return new PageUtils(page);
    }

}