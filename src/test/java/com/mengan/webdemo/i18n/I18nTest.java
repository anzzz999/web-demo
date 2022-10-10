package com.mengan.webdemo.i18n;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

/**
 * @Author: zhanmingwei
 */
//@SpringBootTest
@Slf4j
public class I18nTest {

    @Test
    void test() {
        String key = "error";
        Object[] args = {"tom", "18"};
        log.info(MessageSourceUtil.getMessage(key, args, "", Locale.CHINA));
        log.info(MessageSourceUtil.getMessage(key, args, "", Locale.US));
        log.info("乱码");
    }
}
