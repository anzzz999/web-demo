package com.mengan.webdemo.service.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @author zhanmingwei
 */

@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    @Override
    @Retryable
    public String queryOrder(int num) throws Exception {
        if (num > 1) {
            log.info("查询超时，请稍后重试");
            throw new TimeoutException();
        }
        log.info("查询失败");
        throw new Exception();
    }

    @Recover
    public String queryOrderNoResp(int num) {
        log.info("没有获得订单信息");
        return null;
    }
}
