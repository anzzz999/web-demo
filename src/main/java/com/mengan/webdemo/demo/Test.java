package com.mengan.webdemo.demo;

import com.mengan.webdemo.web.utils.ResultBean;
import com.mengan.webdemo.web.utils.ResultHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
public class Test {

    @GetMapping("/hello")
    public ResultBean hello(){
        log.info("成功进入方法");
        return ResultHandler.ok("Hello~ This is my web-demo.2021-06-20");
    }
}
