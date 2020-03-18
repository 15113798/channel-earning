package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductChangeDao;
import io.renren.modules.generator.entity.KYwProductChangeEntity;
import io.renren.modules.generator.service.KYwProductChangeService;


@Service("kYwProductChangeService")
public class KYwProductChangeServiceImpl extends ServiceImpl<KYwProductChangeDao, KYwProductChangeEntity> implements KYwProductChangeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductChangeEntity> page = this.page(
                new Query<KYwProductChangeEntity>().getPage(params),
                new QueryWrapper<KYwProductChangeEntity>()
        );

        return new PageUtils(page);
    }

}