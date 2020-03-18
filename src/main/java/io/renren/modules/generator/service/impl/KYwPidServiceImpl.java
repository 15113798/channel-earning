package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwPidDao;
import io.renren.modules.generator.entity.KYwPidEntity;
import io.renren.modules.generator.service.KYwPidService;


@Service("kYwPidService")
public class KYwPidServiceImpl extends ServiceImpl<KYwPidDao, KYwPidEntity> implements KYwPidService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwPidEntity> page = this.page(
                new Query<KYwPidEntity>().getPage(params),
                new QueryWrapper<KYwPidEntity>()
        );

        return new PageUtils(page);
    }

}