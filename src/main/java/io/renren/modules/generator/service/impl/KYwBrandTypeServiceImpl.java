package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandTypeDao;
import io.renren.modules.generator.entity.KYwBrandTypeEntity;
import io.renren.modules.generator.service.KYwBrandTypeService;


@Service("kYwBrandTypeService")
public class KYwBrandTypeServiceImpl extends ServiceImpl<KYwBrandTypeDao, KYwBrandTypeEntity> implements KYwBrandTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandTypeEntity> page = this.page(
                new Query<KYwBrandTypeEntity>().getPage(params),
                new QueryWrapper<KYwBrandTypeEntity>()
        );

        return new PageUtils(page);
    }

}