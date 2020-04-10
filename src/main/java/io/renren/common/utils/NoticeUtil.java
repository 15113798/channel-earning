package io.renren.common.utils;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NoticeUtil {



    // TODO
    public static Boolean checkVerCode(String mobile,String ver_code,String type){
        if(type.equals("1")){
            if(!ver_code.equals("111111")){
                return false;
            }
        }else{
            if(!ver_code.equals("222222")){
                return false;
            }
        }
        return true;
    }


}
