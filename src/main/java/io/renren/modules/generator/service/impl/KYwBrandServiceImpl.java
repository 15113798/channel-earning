package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KYwBrandDao;
import io.renren.modules.generator.entity.KYwBrandEntity;
import io.renren.modules.generator.service.KYwBrandService;


@Service("kYwBrandService")
public class KYwBrandServiceImpl extends ServiceImpl<KYwBrandDao, KYwBrandEntity> implements KYwBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KYwBrandEntity> page;
        if(Integer.parseInt(String.valueOf(params.get("is_recommend"))) == 1){
            page = this.page(
                    new Query<KYwBrandEntity>().getPage(params),
                    new QueryWrapper<KYwBrandEntity>().eq("is_recommend","1").eq("state","2")
            );
        }else{
            page = this.page(
                    new Query<KYwBrandEntity>().getPage(params),
                    new QueryWrapper<KYwBrandEntity>().orderByDesc("create_time").eq("state","2")
            );
        }

        return new PageUtils(page);
    }

}