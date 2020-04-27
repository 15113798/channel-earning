package io.renren.modules.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.generator.entity.KYwProductEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface ProductDao extends BaseMapper<KYwProductEntity> {

     List<KYwProductEntity>getSelectStoreList(Map<String,Object>map);


}
