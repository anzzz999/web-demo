package com.mengan.webdemo.design.responsibilityChain;

/**
 * @Author: zhanmingwei
 */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 老板面试
 * 第三关面试
 */
@Service(Constants.INTERVIEW_BOOS)
@Component
public class BoosHandler extends InterviewHanlder {


    @Override
    public void getTheInterview() {
        System.out.println("老板面试--通过----------------");
        nextInterviewFlag();
    }
}
