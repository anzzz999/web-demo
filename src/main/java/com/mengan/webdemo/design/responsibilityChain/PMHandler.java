package com.mengan.webdemo.design.responsibilityChain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: zhanmingwei
 */
@Service(Constants.INTERVIEW_PM)
@Component
public class PMHandler extends InterviewHanlder {


    @Override
    public void getTheInterview() {
        System.out.println("项目经理面试--通过----------------");
        nextInterviewFlag();
    }
}