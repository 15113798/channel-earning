package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwSmsTypeDao;
import io.renren.modules.generator.entity.KYwSmsTypeEntity;
import io.renren.modules.generator.service.KYwSmsTypeService;


@Service("kYwSmsTypeService")
public class KYwSmsTypeServiceImpl extends ServiceImpl<KYwSmsTypeDao, KYwSmsTypeEntity> implements KYwSmsTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwSmsTypeEntity> page = this.page(
                new Query<KYwSmsTypeEntity>().getPage(params),
                new QueryWrapper<KYwSmsTypeEntity>()
        );

        return new PageUtils(page);
    }

}