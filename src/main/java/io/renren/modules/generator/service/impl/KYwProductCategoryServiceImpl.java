package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwProductCategoryDao;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.service.KYwProductCategoryService;


@Service("kYwProductCategoryService")
public class KYwProductCategoryServiceImpl extends ServiceImpl<KYwProductCategoryDao, KYwProductCategoryEntity> implements KYwProductCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwProductCategoryEntity> page = this.page(
                new Query<KYwProductCategoryEntity>().getPage(params),
                new QueryWrapper<KYwProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

}