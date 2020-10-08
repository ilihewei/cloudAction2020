package com.lihewei.controller;

import com.lihewei.domain.Order;
import com.lihewei.feign.StorageFeignClient;
import com.lihewei.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:15
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private StorageFeignClient storageFeignClient;

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @GetMapping("/placeOrder/commit")
    public Boolean placeOrderCommit() {

        orderService.placeOrder("1", "product-1", 1);
        return true;
    }

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @GetMapping("/placeOrder/rollback")
    public Boolean placeOrderRollback() {
        // product-2 扣库存时模拟了一个业务异常,
        orderService.placeOrder("1", "product-2", 1);
        return true;
    }


    @GetMapping("/placeOrder")
    public Boolean placeOrder(String userId, String commodityCode, Integer count) {
        orderService.placeOrder(userId, commodityCode, count);
        return true;
    }
}
