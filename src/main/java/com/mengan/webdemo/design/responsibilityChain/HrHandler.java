package com.mengan.webdemo.design.responsibilityChain;

/**
 * @Author: zhanmingwei
 */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * hr面试
 * 第四关hr行政面试
 */
@Service(Constants.INTERVIEW_HR)
@Component
public class HrHandler extends InterviewHanlder {


    @Override
    public void getTheInterview() {
        System.out.println("HR谈面试--通过----------------");

    }

}
