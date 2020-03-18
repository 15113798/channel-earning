package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwTaobaoAuthDao;
import io.renren.modules.generator.entity.KYwTaobaoAuthEntity;
import io.renren.modules.generator.service.KYwTaobaoAuthService;


@Service("kYwTaobaoAuthService")
public class KYwTaobaoAuthServiceImpl extends ServiceImpl<KYwTaobaoAuthDao, KYwTaobaoAuthEntity> implements KYwTaobaoAuthService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwTaobaoAuthEntity> page = this.page(
                new Query<KYwTaobaoAuthEntity>().getPage(params),
                new QueryWrapper<KYwTaobaoAuthEntity>()
        );

        return new PageUtils(page);
    }

}