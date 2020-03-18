package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwSendSmsHistoryDao;
import io.renren.modules.generator.entity.KYwSendSmsHistoryEntity;
import io.renren.modules.generator.service.KYwSendSmsHistoryService;


@Service("kYwSendSmsHistoryService")
public class KYwSendSmsHistoryServiceImpl extends ServiceImpl<KYwSendSmsHistoryDao, KYwSendSmsHistoryEntity> implements KYwSendSmsHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwSendSmsHistoryEntity> page = this.page(
                new Query<KYwSendSmsHistoryEntity>().getPage(params),
                new QueryWrapper<KYwSendSmsHistoryEntity>()
        );

        return new PageUtils(page);
    }

}