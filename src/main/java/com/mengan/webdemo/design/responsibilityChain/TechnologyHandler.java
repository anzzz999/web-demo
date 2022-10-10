package com.mengan.webdemo.design.responsibilityChain;

/**
 * @Author: zhanmingwei
 */
public class TechnologyHandler extends InterviewHanlder {
    @Override
    public void getTheInterview() {
        System.out.println("技术总监面试--通过----------------");
        nextInterviewFlag();
    }
}
