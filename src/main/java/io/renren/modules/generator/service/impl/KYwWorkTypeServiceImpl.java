package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwWorkTypeDao;
import io.renren.modules.generator.entity.KYwWorkTypeEntity;
import io.renren.modules.generator.service.KYwWorkTypeService;


@Service("kYwWorkTypeService")
public class KYwWorkTypeServiceImpl extends ServiceImpl<KYwWorkTypeDao, KYwWorkTypeEntity> implements KYwWorkTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwWorkTypeEntity> page = this.page(
                new Query<KYwWorkTypeEntity>().getPage(params),
                new QueryWrapper<KYwWorkTypeEntity>()
        );

        return new PageUtils(page);
    }

}