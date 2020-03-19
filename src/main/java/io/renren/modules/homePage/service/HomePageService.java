package io.renren.modules.homePage.service;



import io.renren.modules.generator.dao.KYwMuneDao;
import io.renren.modules.generator.entity.KYwMuneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class HomePageService {


    @Autowired
    private KYwMuneDao KYwMunedao;


    public List<KYwMuneEntity> queryMeue(int type,int pid){

        return KYwMunedao.queryMeue(type,pid);
    }



}
