package com.lihewei.domain;


/**
 * @Author EiletXie
 * @Since 2020/3/18 21:10
 */
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@Data
@Accessors(chain = true)
@TableName("order_tbl")
public class Order {

    @TableId(type=IdType.AUTO)
    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private BigDecimal money;

}
