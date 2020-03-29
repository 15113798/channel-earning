package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-29 13:56:38
 */
@Mapper
public interface KYwProductCategoryDao extends BaseMapper<KYwProductCategoryEntity> {

     List<KYwProductCategoryEntity> listByParentId(Integer parentId);



}
