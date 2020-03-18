package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductTgContentDao;
import io.renren.modules.generator.entity.KYwProductTgContentEntity;
import io.renren.modules.generator.service.KYwProductTgContentService;


@Service("kYwProductTgContentService")
public class KYwProductTgContentServiceImpl extends ServiceImpl<KYwProductTgContentDao, KYwProductTgContentEntity> implements KYwProductTgContentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductTgContentEntity> page = this.page(
                new Query<KYwProductTgContentEntity>().getPage(params),
                new QueryWrapper<KYwProductTgContentEntity>()
        );

        return new PageUtils(page);
    }

}