package com.baijiaxiu.services.cloud.controller;

import com.baijiaxiu.services.cloud.entity.bi.OrderAccount;
import com.baijiaxiu.services.cloud.service.IOrderAccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-08-24 10:56
 */
@RestController
public class TestController {

    @Autowired
    private IOrderAccountService iOrderAccountService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity index() {
        return new ResponseEntity("index error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity test() {
        return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/sleep", method = RequestMethod.GET)
    public String sleep() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return String.valueOf(a / b);
    }

    @RequestMapping(value = "acoutList", method = RequestMethod.GET)
    public List<OrderAccount> acoutList() {
        QueryWrapper<OrderAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("LIMIT 1");
        return iOrderAccountService.list(queryWrapper);
    }
}

