package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwMessageTypeDao;
import io.renren.modules.generator.entity.KYwMessageTypeEntity;
import io.renren.modules.generator.service.KYwMessageTypeService;


@Service("kYwMessageTypeService")
public class KYwMessageTypeServiceImpl extends ServiceImpl<KYwMessageTypeDao, KYwMessageTypeEntity> implements KYwMessageTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwMessageTypeEntity> page = this.page(
                new Query<KYwMessageTypeEntity>().getPage(params),
                new QueryWrapper<KYwMessageTypeEntity>()
        );

        return new PageUtils(page);
    }

}