package com.baijiaxiu.services.cloud;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 配置中心
 * @author: liuyufeng
 * @date: 2019-08-26 15:06
 */
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigServerApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :" + userName + "; age: " + userAge);
    }

}

@RestController
@RefreshScope
class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age + "!";
    }
}


