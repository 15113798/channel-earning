package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwNoticeDao;
import io.renren.modules.generator.entity.KYwNoticeEntity;
import io.renren.modules.generator.service.KYwNoticeService;


@Service("kYwNoticeService")
public class KYwNoticeServiceImpl extends ServiceImpl<KYwNoticeDao, KYwNoticeEntity> implements KYwNoticeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwNoticeEntity> page ;
        if(params.get("title") != null){
            page = this.page(
                    new Query<KYwNoticeEntity>().getPage(params),
                    new QueryWrapper<KYwNoticeEntity>().like("title",params.get("title"))
            );
        }else{
            page = this.page(
                    new Query<KYwNoticeEntity>().getPage(params),
                    new QueryWrapper<KYwNoticeEntity>()
            );
        }
        return new PageUtils(page);
    }

}