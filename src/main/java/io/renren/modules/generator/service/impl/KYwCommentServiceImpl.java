package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwCommentDao;
import io.renren.modules.generator.entity.KYwCommentEntity;
import io.renren.modules.generator.service.KYwCommentService;


@Service("kYwCommentService")
public class KYwCommentServiceImpl extends ServiceImpl<KYwCommentDao, KYwCommentEntity> implements KYwCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwCommentEntity> page = this.page(
                new Query<KYwCommentEntity>().getPage(params),
                new QueryWrapper<KYwCommentEntity>()
        );

        return new PageUtils(page);
    }

}