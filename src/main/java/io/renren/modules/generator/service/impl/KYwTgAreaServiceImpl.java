package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwTgAreaDao;
import io.renren.modules.generator.entity.KYwTgAreaEntity;
import io.renren.modules.generator.service.KYwTgAreaService;


@Service("kYwTgAreaService")
public class KYwTgAreaServiceImpl extends ServiceImpl<KYwTgAreaDao, KYwTgAreaEntity> implements KYwTgAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwTgAreaEntity> page = this.page(
                new Query<KYwTgAreaEntity>().getPage(params),
                new QueryWrapper<KYwTgAreaEntity>()
        );

        return new PageUtils(page);
    }

}