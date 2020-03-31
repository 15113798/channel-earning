package io.renren.modules.generator.service.impl;

import io.renren.modules.generator.entity.KYwNoticeEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwRuleDao;
import io.renren.modules.generator.entity.KYwRuleEntity;
import io.renren.modules.generator.service.KYwRuleService;


@Service("kYwRuleService")
public class KYwRuleServiceImpl extends ServiceImpl<KYwRuleDao, KYwRuleEntity> implements KYwRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<KYwRuleEntity> page ;
        if(params.get("title") != null){
            page = this.page(
                    new Query<KYwRuleEntity>().getPage(params),
                    new QueryWrapper<KYwRuleEntity>().like("title",params.get("title"))
            );
        }else{
            page = this.page(
                    new Query<KYwRuleEntity>().getPage(params),
                    new QueryWrapper<KYwRuleEntity>()
            );
        }

        return new PageUtils(page);
    }

}