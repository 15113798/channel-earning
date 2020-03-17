package io.renren.modules.common.controller;

import io.renren.common.utils.R;
import io.renren.modules.common.entity.ReNTbkItem;
import io.renren.modules.common.service.TaoBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/taobao")
public class TaoBaoController {

    @Autowired
    private TaoBaoService taoBaoService;

    /**
     * 获取商品信息
     */
    @GetMapping("/getGoods")
    public R getAjaxGoods(String url) {
        List<ReNTbkItem> data = taoBaoService.getGoodsInfo(url);
        Map<String, Object> map = new HashMap<String, Object>();

        //简单校验url
        if ( data == null || data.isEmpty() || data.size() <= 0) {
            return R.error("请输入正确的商品链接地址！");
        }else if( data.size() == 1){
            ReNTbkItem item = (ReNTbkItem)data.get(0);
            map.put("errCode", item.getErrCode());
            map.put("errMsg", item.getErrMsg());
            map.put("data", item);
            return R.ok(map);
        }
        return R.ok().put("data", data);
    }




}
