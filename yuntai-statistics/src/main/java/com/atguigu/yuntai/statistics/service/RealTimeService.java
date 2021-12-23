package com.atguigu.yuntai.statistics.service;

import com.atguigu.yuntai.statistics.bean.ProductStats;
import com.atguigu.yuntai.statistics.bean.ProvinceStats;
import com.atguigu.yuntai.statistics.bean.ReturnVisitorStats;
import com.atguigu.yuntai.statistics.bean.VisitorStats;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface RealTimeService {

    //获取某一天的总交易额
    public BigDecimal getGMV(int date);

    //统计某天不同SPU商品交易额排名
    public List<ProductStats> getProductStatsGroupBySpu(int date, int limit);

    //统计某天不同类别商品交易额排名
    public List<ProductStats> getProductStatsGroupByCategory3(int date,int limit);

    //统计某天不同品牌商品交易额排名
    public String getProductStatsByTrademark(int date,int limit);

    //地区
    public List<Map> getProvinceStats(int date);

    List<ReturnVisitorStats> getVisitorStatsByNewFlag(int date);

    public String getVisitorStatsByHour(int date);

    public Long getPv(int date);

    public Long getUv(int date);


}
