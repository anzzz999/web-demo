//package com.mengan.webdemo.design.responsibilityChain;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Author: zhanmingwei
// */
//@RestController
//public class HandlerController {
//    @Autowired
//    private InterviewHandlerService interviewHandlerService;
//
//    @RequestMapping("/interview")
//    public String interview() {
//        InterviewHanlder interviewHanlder = interviewHandlerService.getHandler();
//        interviewHanlder.getTheInterview();
//        return "面试pass掉了，Hr让我给她钱让我去公司学习技术.......";
//    }
//}
