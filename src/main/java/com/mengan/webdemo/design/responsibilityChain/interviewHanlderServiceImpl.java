//package com.mengan.webdemo.design.responsibilityChain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>
// * 责任链具体实现类
// * @author xy
// * @since 2021-10-21
// */
//@Service
//public class interviewHanlderServiceImpl implements InterviewHandlerService {
//
//
//    private InterviewHanlder firstGatewayHandler;
//
//
//    @Override
//    public InterviewHanlder getHandler() {
//        //todo 这里最好是写成动态数据库配置 我这里测试使用写死的方式
//        InterviewHanlder firstInterviewHanlder = ApplicationContext.getBean(Constants.INTERVIEW_PM, InterviewHanlder.class);
//        //根据顺序依次设置责任链执行
//        List<String> hanlderList = new ArrayList<>();
//        hanlderList.add(Constants.INTERVIEW_JS);
//        hanlderList.add(Constants.INTERVIEW_BOOS);
//        hanlderList.add(Constants.INTERVIEW_HR);
//        //用一个临时变量接收全局Hanlder
//        InterviewHanlder temoInterviewHanlder = firstInterviewHanlder;
//        for (String hanlder : hanlderList) {
//            //通过代理获取实现类SpringContenxt
//            InterviewHanlder hanlderImpl = SpringUtils.getBean(hanlder, InterviewHanlder.class);
//            temoInterviewHanlder.setNextGatewayHandler(hanlderImpl);
//        }
//        this.firstGatewayHandler = firstInterviewHanlder;
//        return firstGatewayHandler;
//    }
//}