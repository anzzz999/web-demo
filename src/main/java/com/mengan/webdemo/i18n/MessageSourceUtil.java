package com.mengan.webdemo.i18n;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @Author: zhanmingwei
 */
@Component
public class MessageSourceUtil {

    private static MessageSource messageSource;

    public MessageSourceUtil(MessageSource messageSource) {
        MessageSourceUtil.messageSource = messageSource;
    }


    /**
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @return
     */
    public static String getMessage(String code, Object... args) {
        return getMessage(code, args, "");
    }

    /**
     * 通用报错模版
     * @param msg
     * @return
     */
    public static String getErrorModalMessage(String msg) {
        return getMessage("ERROR_MODAL_GENERAL_MODEL", msg, "");
    }


    /**
     * @param code           ：对应messages配置的key.
     * @param args           : 数组参数.
     * @param defaultMessage : 没有设置key的时候的默认值.
     * @return
     */
    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String message = messageSource.getMessage(code, args, defaultMessage, locale);
        setCode(code);
        return message;
    }


    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void setCode(String code) {
        threadLocal.set(code);
    }

    public static String getCode() {
        return threadLocal.get();
    }

    public static void removeCode(){
        threadLocal.remove();
    }
}

