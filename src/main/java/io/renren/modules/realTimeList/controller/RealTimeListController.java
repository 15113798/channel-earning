package io.renren.modules.realTimeList.controller;


import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KYwMuneEntity;
import io.renren.modules.generator.entity.KYwProductCategoryEntity;
import io.renren.modules.generator.entity.KYwProductEntity;
import io.renren.modules.generator.service.KYwProductCategoryService;
import io.renren.modules.homePage.entity.HomePageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * 榜单相关
 *
 */
@RestController
@RequestMapping("/realTimeList")
public class RealTimeListController {


    @Autowired
    private KYwProductCategoryService kYwProductCategoryService;


    @PostMapping("/getColumn")
    public R getColumn(Integer parent_id) {
        //传入type，然后获取到该类型的所有菜单信息。并且按照排序
        List<KYwProductCategoryEntity> data = kYwProductCategoryService.listByParentId(parent_id);

        return R.ok().put("data", data);
    }

    //获取榜单列表
    @PostMapping("/getList")
    public R getList(@RequestParam Map<String, Object> params) {
        String listType = String.valueOf(params.get("listType"));
        String categoryId = String.valueOf(params.get("categoryId"));
        String page = String.valueOf(params.get("page"));
        String limit = String.valueOf("limit");

        List<KYwProductEntity> list = new ArrayList<>();
        KYwProductEntity entity = new KYwProductEntity();
        entity.setName("榜单推荐第一");
        entity.setActionName("活动字段");
        entity.setActionTypeId("活动类型id字段");
        entity.setAdImg("商品主图");
        entity.setBrandId("品牌id");
        entity.setCategoryId("类目id");
        entity.setCoponEndTime("优惠券结束时间");
        entity.setCoponLink("优惠券链接");
        entity.setDaogouText("导购文案");
        entity.setDownTime("下架时间");
        entity.setEndTime("结束时间");
        entity.setId(1);
        entity.setIsRecommend(1);
        entity.setIsverify("0审核中，1审核通过，2审核未通过");
        entity.setJuanmianAfterPrice("券后价98");
        entity.setTotalCoponCount("优惠券总量");

        entity.setProductLink("商品链接");
        entity.setShopId("1");
        entity.setShopName("店铺名称");
        entity.setShortAdImg("短广告图片");
        entity.setTaobaoPrice("淘宝价格");
        entity.setYongjinRate("佣金比例");
        entity.setYongjinTypeId("佣金类型");
        entity.setJuanmianPrice("优惠券价格");
        entity.setPublicUserId("发布者id");
        entity.setTitle("商品短标题");
        entity.setOriginImg("原图片地址");
        entity.setYingxiaoImg("营销图片");
        entity.setProductType("商品归属 1天猫2淘宝");
        entity.setState("0");
        entity.setUpTime("上架时间");
        entity.setUpdateTime("修改时间");
        entity.setRemark("备注");

        list.add(entity);




        KYwProductEntity entity1 = new KYwProductEntity();
        entity1.setName("榜单推荐第二");
        entity1.setActionName("活动字段");
        entity1.setActionTypeId("活动类型id字段");
        entity1.setAdImg("商品主图");
        entity1.setBrandId("品牌id");
        entity1.setCategoryId("类目id");
        entity1.setCoponEndTime("优惠券结束时间");
        entity1.setCoponLink("优惠券链接");
        entity1.setDaogouText("导购文案");
        entity1.setDownTime("下架时间");
        entity1.setEndTime("结束时间");
        entity1.setId(1);
        entity1.setIsRecommend(1);
        entity1.setIsverify("0审核中，1审核通过，2审核未通过");
        entity1.setJuanmianAfterPrice("券后价98");
        entity1.setTotalCoponCount("优惠券总量");

        entity1.setProductLink("商品链接");
        entity1.setShopId("1");
        entity1.setShopName("店铺名称");
        entity1.setShortAdImg("短广告图片");
        entity1.setTaobaoPrice("淘宝价格");
        entity1.setYongjinRate("佣金比例");
        entity1.setYongjinTypeId("佣金类型");
        entity1.setJuanmianPrice("优惠券价格");
        entity1.setPublicUserId("发布者id");
        entity1.setTitle("商品短标题");
        entity1.setOriginImg("原图片地址");
        entity1.setYingxiaoImg("营销图片");
        entity1.setProductType("商品归属 1天猫2淘宝");
        entity1.setState("0");
        entity1.setUpTime("上架时间");
        entity1.setUpdateTime("修改时间");
        entity1.setRemark("备注");

        list.add(entity1);

        return R.ok().put("data",list);
    }




}
