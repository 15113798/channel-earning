package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwPointTypeDao;
import io.renren.modules.generator.entity.KYwPointTypeEntity;
import io.renren.modules.generator.service.KYwPointTypeService;


@Service("kYwPointTypeService")
public class KYwPointTypeServiceImpl extends ServiceImpl<KYwPointTypeDao, KYwPointTypeEntity> implements KYwPointTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwPointTypeEntity> page = this.page(
                new Query<KYwPointTypeEntity>().getPage(params),
                new QueryWrapper<KYwPointTypeEntity>()
        );

        return new PageUtils(page);
    }

}