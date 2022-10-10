package com.mengan.webdemo.ctrl;

import com.mengan.webdemo.service.retry.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanmingwei
 */
@Slf4j
@RestController
public class RetryCtrl {
    @Autowired
    private RetryService retryService;


    @GetMapping("/retry")
    public void retryTest() throws Exception {
        retryService.queryOrder(2);
    }

}
