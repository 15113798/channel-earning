package io.renren.modules.product.service;


import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.dao.KYwMuneDao;
import io.renren.modules.generator.dao.KYwProductDao;
import io.renren.modules.generator.entity.KYwMuneEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwProductService;
import io.renren.modules.product.dao.ProductDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductService {


        @Autowired
        private ProductDao dao;

        public PageUtils getSelectStoreList
                (Integer brandId, Integer categoryId,String priceRange,String couponRange,String comRateRange,
                  Integer monthSales,Integer sortRule,Integer page,Integer limit){


            Map<String,Object> map = new HashMap<String,Object>();
            map.put("brandId",brandId);
            map.put("categoryId",categoryId);
            map.put("sortRule",sortRule);


            //条件比较复杂，不能直接用page公用方法
            List<KYwProductEntity>list = dao.getSelectStoreList(map);
            Integer count = list.size();

            return new PageUtils(list,count,page,limit);

        }





}
