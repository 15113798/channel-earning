package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwTgIncomeDao;
import io.renren.modules.generator.entity.KYwTgIncomeEntity;
import io.renren.modules.generator.service.KYwTgIncomeService;


@Service("kYwTgIncomeService")
public class KYwTgIncomeServiceImpl extends ServiceImpl<KYwTgIncomeDao, KYwTgIncomeEntity> implements KYwTgIncomeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwTgIncomeEntity> page = this.page(
                new Query<KYwTgIncomeEntity>().getPage(params),
                new QueryWrapper<KYwTgIncomeEntity>()
        );

        return new PageUtils(page);
    }

}