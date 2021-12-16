package com.atguigu.yuntai.statistics.mapper;

import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: gmall
 * @description:
 */
public interface VisitTrafficStatsMapper {
    @Select("select  is_new,uv_count uv, page_count pv,   bounce_rate, ROUND( page_count / sv_count ,1) pv_per_session, avg_duration_sec   dur_per_session " +
            "from  ads_traffic_stats_by_channel  where  dt = #{dt} and recent_days= #{days}   ")
    public List<Map> getNewVisitorStats(@Param("days") int days, @Param("dt") String dt);

    @Select("select * from ads_traffic_stats_by_channel where  dt = #{dt} and recent_days= #{days} ")
    List<AdsTrafficStats> getTrafficStats(int days, String dt);
}
