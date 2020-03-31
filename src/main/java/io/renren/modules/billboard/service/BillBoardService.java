package io.renren.modules.billboard.service;


import io.renren.modules.generator.entity.KYwProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BillBoardService {


    // Todo
    public List<KYwProductEntity> getList(Integer type, Integer page, Integer limit){

        List<KYwProductEntity> list = new ArrayList<>();
        //榜单类型 1.综合榜单 2.实时销量榜 3.全天销量榜 4.热推榜 5.买家热搜榜 6.复购榜
        if(type == 1)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("综合榜单商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("综合榜单商品2");

            list.add(entity);
            list.add(entity2);

        }else if(type == 2)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("实时销量榜商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("实时销量榜商品2");

            list.add(entity);
            list.add(entity2);

        }else if(type == 3)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("全天销量榜商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("全天销量榜商品2");

            list.add(entity);
            list.add(entity2);

        }else if(type == 4)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("热推榜商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("热推榜商品2");

            list.add(entity);
            list.add(entity2);

        }else if(type == 5)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("买家热搜榜商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("买家热搜榜商品2");

            list.add(entity);
            list.add(entity2);

        }else if(type == 6)
        {
            KYwProductEntity entity  = new KYwProductEntity();
            entity.setName("复购榜商品1");

            KYwProductEntity entity2  = new KYwProductEntity();
            entity2.setName("复购榜商品2");

            list.add(entity);
            list.add(entity2);

        }




        return list;
    }


}
