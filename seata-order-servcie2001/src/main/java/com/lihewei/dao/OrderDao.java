package com.lihewei.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lihewei.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:16
 */
@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order> {
    /**
     * 1 新建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     * @param userId
     * @param status
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
