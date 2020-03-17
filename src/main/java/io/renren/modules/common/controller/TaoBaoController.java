package io.renren.modules.common.controller;

import io.renren.common.utils.R;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/taobao")
public class TaoBaoController {

    /**
     * 获取商品信息
     */
    @GetMapping("/getGoods")
    public R getAjaxGoods(String url) {
        System.out.println(url);
        return R.ok().put("response", "1");
    }




}
