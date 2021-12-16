package com.atguigu.yuntai.statistics.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: gmall
 * @description:
 */
@Data
@NoArgsConstructor
public class AdsCouponStats {

    /**
     *统计日期
     */
    private String dt;

    /**
     *优惠券ID
     */
    private String coupon_id;

    /**
     *优惠券名称
     */
    private String coupon_name;

    /**
     *发布日期
     */
    private String start_date;

    /**
     *优惠规则
     */
    private String rule_name;

    /**
     *补贴率
     */
    private BigDecimal reduce_rate;
}
