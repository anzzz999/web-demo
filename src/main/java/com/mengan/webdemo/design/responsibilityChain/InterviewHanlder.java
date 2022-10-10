package com.mengan.webdemo.design.responsibilityChain;

/**
 * <p>
 * 抽取公共实现方法，共同行为，面试
 *
 * @author xy
 * @since 2021-10-21
 */
public abstract class InterviewHanlder {

    /**
     * 定义一个全局的Hanlder
     */
    protected InterviewHanlder interviewHanlder;

    /**
     * 抽取共同行为的方法，面试
     */
    public abstract void getTheInterview();

    /**
     * 面试结果反馈下一轮面试
     *
     * @param nextGatewayHandler
     */
    public void setNextGatewayHandler(InterviewHanlder nextGatewayHandler) {
        this.interviewHanlder = nextGatewayHandler;
    }


    /**
     * 继续下一轮的面试
     */
    protected void nextInterviewFlag() {
        if (interviewHanlder != null)
            interviewHanlder.getTheInterview();
    }
}
