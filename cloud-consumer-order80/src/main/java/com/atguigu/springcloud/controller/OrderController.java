package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhangchengwei
 * @create 2023-09-19 9:52
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SRV + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_SRV + "/payment/get/" + id , CommonResult.class);
    }


    @PostMapping("/consumer/payment/create2")
    public CommonResult<Payment> create2(Payment payment) {
        return restTemplate.postForEntity(PAYMENT_SRV + "/payment/create",payment,CommonResult.class).getBody();
    }

}
