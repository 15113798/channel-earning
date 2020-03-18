package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwApiDao;
import io.renren.modules.generator.entity.KYwApiEntity;
import io.renren.modules.generator.service.KYwApiService;


@Service("kYwApiService")
public class KYwApiServiceImpl extends ServiceImpl<KYwApiDao, KYwApiEntity> implements KYwApiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwApiEntity> page = this.page(
                new Query<KYwApiEntity>().getPage(params),
                new QueryWrapper<KYwApiEntity>()
        );

        return new PageUtils(page);
    }

}