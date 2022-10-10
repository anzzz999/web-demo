package com.mengan.webdemo.service.retry;

import java.util.concurrent.TimeoutException;

/**
 * @author zhanmingwei
 */


public interface RetryService {

    String queryOrder(int num) throws Exception;



}
