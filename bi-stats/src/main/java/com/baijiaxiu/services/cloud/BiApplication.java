package com.baijiaxiu.services.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-08-24 2:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BiApplication.class, args);
    }
}
