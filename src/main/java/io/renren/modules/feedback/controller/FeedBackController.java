/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.feedback.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.R;
import io.renren.modules.data.entity.HPOperateDataEntity;
import io.renren.modules.generator.entity.KYwCommentEntity;
import io.renren.modules.generator.service.KYwCommentService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

/**
        评论反馈
 */
@RestController
@RequestMapping("/feedback")
public class FeedBackController extends AbstractController {


    @Autowired
    private KYwCommentService service;

    //意见反馈条数
    @PostMapping("/count")
    public R count() {
        QueryWrapper<KYwCommentEntity> wrapper = new QueryWrapper();
        wrapper.eq("type","1");
        Integer count = service.count(wrapper);
        return R.ok().put("data", count);
    }


    //新增意见反馈
    @PostMapping("/save")
    public R save(Integer type,String commentContent,String attPict,String contactInfo,Integer commentUserId,Integer questionType){
        KYwCommentEntity kYwComment = new KYwCommentEntity();
        kYwComment.setQuestionType(questionType);
        kYwComment.setAttPict(attPict);
        kYwComment.setType(type);
        kYwComment.setContactInfo(contactInfo);
        kYwComment.setCommentContent(commentContent);
        kYwComment.setCommentUserId(commentUserId);
        kYwComment.setCommentTime(new Date());
        kYwComment.setState(1);
        service.save(kYwComment);
        return R.ok();
    }



    //新增意见反馈
    @PostMapping("/findFeedList")
    public R findFeedList(Integer commentUserId,Integer state){
        QueryWrapper<KYwCommentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("comment_user_id",commentUserId);
        if(state != null){
            wrapper.eq("state",state);
        }
        List<KYwCommentEntity> list = service.list(wrapper);
        return R.ok().put("data",list);
    }


	
}
