package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KYwProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-18 15:00:33
 */
@Mapper
public interface KYwProductDao extends BaseMapper<KYwProductEntity> {

     List<KYwProductEntity> findProByActId(Map<String, Object> params);
}
