package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwApiTypeDao;
import io.renren.modules.generator.entity.KYwApiTypeEntity;
import io.renren.modules.generator.service.KYwApiTypeService;


@Service("kYwApiTypeService")
public class KYwApiTypeServiceImpl extends ServiceImpl<KYwApiTypeDao, KYwApiTypeEntity> implements KYwApiTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwApiTypeEntity> page = this.page(
                new Query<KYwApiTypeEntity>().getPage(params),
                new QueryWrapper<KYwApiTypeEntity>()
        );

        return new PageUtils(page);
    }

}