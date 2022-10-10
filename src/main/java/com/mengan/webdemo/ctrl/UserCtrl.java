package com.mengan.webdemo.ctrl;

import com.mengan.webdemo.bean.User;
import com.mengan.webdemo.i18n.MessageSourceUtil;
import com.mengan.webdemo.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
public class UserCtrl {
    @Autowired
    private UserService userService;
    @Autowired
    CacheManager cacheManager;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/userbyname")
    public List<User> getUserByName(User user) {
        System.out.println("------------");
        System.out.println("call  /getuserbyname");
        userService.getUserByName(user.getName());
        threadPoolTaskExecutor.execute(() -> userService.getUserByName(user.getName()));
        return null;
    }

    @GetMapping("/hehe")
    public String hehe() {
        return "hehhehhehe";
    }

    @PostMapping("/updateUser")
    public void updateUser() {
//        userService.updateUser();
    }

    @PostMapping("/redis/add")
    public void redisAdd() {
//        redisTemplate.opsForZSet().add("im.test", set);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1410063315498532866", 1.0);
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1410063313262968834", 2.0);
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1440314158867456002", 3.0);
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1440314158867456003", 3.0);
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1440314158867456004", 1.0);
            redisTemplate.opsForZSet().incrementScore("im.test", "prod_0_1440314158867456005", 2.0);
        }
        long end = System.currentTimeMillis();
        log.info("{}ms", end - start);
        start = System.currentTimeMillis();
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            connection.openPipeline();
            for (int i = 0; i < 20; i++) {
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1410063315498532866".getBytes());
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1410063313262968834".getBytes());
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1440314158867456002".getBytes());
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1440314158867456003".getBytes());
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1440314158867456004".getBytes());
                connection.zIncrBy("im.test".getBytes(), 1.0, "prod_0_1440314158867456005".getBytes());
            }
            return null;
        });
        end = System.currentTimeMillis();
        log.info("pipe:{}ms", end - start);


    }


    @PostMapping("/redis/remove")
    public String rediremove() {
        redisTemplate.opsForZSet().remove("im.test", "prod_0_1410063315498532866");
        return "";
    }

    @PostMapping("/redis/get")
    public String rediGet() {
        Set set = redisTemplate.opsForZSet().reverseRange("im.test", 0, 2);
        return Arrays.toString(set.toArray());
    }

    @GetMapping("/i18n")
    public void testI18n() {
        String key = "error";
        Object[] args = {"tom", "18"};
        log.info(MessageSourceUtil.getMessage(key, args, "", Locale.CHINA));
        log.info(MessageSourceUtil.getMessage(key, args, "", Locale.US));
        log.info("乱码");
    }

    @GetMapping("/testMetaSpace")
    public void testMetaSpace() {
        while (true){
            IdentityHashMap<Object, Object> objectObjectIdentityHashMap = new IdentityHashMap<>();
            objectObjectIdentityHashMap.put("1", "1");
            System.out.println(objectObjectIdentityHashMap);
            String s =
                    "{\\\"spu_ext_id\\\":\\\"test-000001\\\",\\\"stock\\\":88,\\\"channelClientId\\\":\\\"1437968257791119380\\\",\\\"supplierExtId\\\":\\\"1177585913523462144\\\"}";

        }
    }


}
