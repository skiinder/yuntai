package com.atguigu.yuntai.statistics.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @program: gmall
 * @description: 用户变动
 */
public interface UserChangeMapper {

    @Select("select      sum(user_churn_count)-sum(user_back_count) userChurn,  SUM(user_back_count) userBack  from ads_user_change where dt= #{date}  ")
    public Map getUserChange(@Param("date") String dt, @Param("days") int days);
}
