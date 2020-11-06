package com.dgd.controller;

import com.alibaba.fastjson.JSON;
import com.dgd.model.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author : DaiGD
 * @createtime :  2020年11月06日 10:49
 * @description :
 */
@RestController
public class HelloController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String index() {
        Demo demo = new Demo();
        demo.setName("index");
        LOGGER.info("请求返回结果:{}", demo);
        return JSON.toJSONString(demo);
    }
    
    @GetMapping("/hello")
    public String hello() {
        Demo demo = new Demo();
        demo.setName("hello");
        LOGGER.info("请求返回结果:{}", demo);
        return JSON.toJSONString(demo);
    }
}
