package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductTgTypeDao;
import io.renren.modules.generator.entity.KYwProductTgTypeEntity;
import io.renren.modules.generator.service.KYwProductTgTypeService;


@Service("kYwProductTgTypeService")
public class KYwProductTgTypeServiceImpl extends ServiceImpl<KYwProductTgTypeDao, KYwProductTgTypeEntity> implements KYwProductTgTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductTgTypeEntity> page = this.page(
                new Query<KYwProductTgTypeEntity>().getPage(params),
                new QueryWrapper<KYwProductTgTypeEntity>()
        );

        return new PageUtils(page);
    }

}