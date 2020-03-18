package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandDao;
import io.renren.modules.generator.entity.KYwBrandEntity;
import io.renren.modules.generator.service.KYwBrandService;


@Service("kYwBrandService")
public class KYwBrandServiceImpl extends ServiceImpl<KYwBrandDao, KYwBrandEntity> implements KYwBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandEntity> page = this.page(
                new Query<KYwBrandEntity>().getPage(params),
                new QueryWrapper<KYwBrandEntity>()
        );

        return new PageUtils(page);
    }

}