package com.atguigu.yuntai.statistics.service.impl;

import com.atguigu.yuntai.common.utils.EchartsConverter;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.*;
import com.atguigu.yuntai.statistics.mapper.ProductStatsMapper;
import com.atguigu.yuntai.statistics.mapper.ProvinceStatsMapper;
import com.atguigu.yuntai.statistics.mapper.VisitorStatsMapper;
import com.atguigu.yuntai.statistics.service.RealTimeService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实时统计实现类
 */
@DS("clickhouse")
@Service
public class RealTimeServiceImpl implements RealTimeService {

    @Autowired
    ProductStatsMapper productStatsMapper;

    @Autowired
    ProvinceStatsMapper provinceStatsMapper;

    @Autowired
    VisitorStatsMapper visitorStatsMapper;

    @Override
    public BigDecimal getGMV(int date) {
        return productStatsMapper.getGMV(date);
    }

    @Override
    public List<ProductStats> getProductStatsGroupBySpu(int date, int limit) {
        return productStatsMapper.getProductStatsGroupBySpu(date,  limit);
    }

    @Override
    public List<ProductStats> getProductStatsGroupByCategory3(int date, int limit) {
        return productStatsMapper.getProductStatsGroupByCategory3(date,  limit);
    }

    @Override
    public String getProductStatsByTrademark(int date,int limit) {
        List<NameValueData> productStatsByTrademark = productStatsMapper.getProductStatsByTrademark(date, limit);
        return EchartsConverter.converterFromNameValue(productStatsByTrademark, false).toJSONString();
    }

    @Override
    public List<Map> getProvinceStats(int date) {
        List<Map> orderProvinceList = new ArrayList<>();
        List<ProvinceStats> provinceStatsList = provinceStatsMapper.selectProvinceStats(date);
        if(!CollectionUtils.isEmpty(provinceStatsList)){
            for(ProvinceStats provinceStats : provinceStatsList){
                Map<String, String> orderProvinceMap = new HashMap<>();
                orderProvinceMap.put("name",provinceStats.getProvince_name());
                if(!provinceStats.getOrder_amount().equals("0")){
                    orderProvinceMap.put("value",provinceStats.getOrder_amount().toString());
                }else{
                    orderProvinceMap.put("value","0");
                }
                orderProvinceList.add(orderProvinceMap);
            }
        }
        return orderProvinceList;
    }



    @Override
    public List<ReturnVisitorStats> getVisitorStatsByNewFlag(int date) {
        List<VisitorStats> visitorStatsByNewFlag = visitorStatsMapper.selectVisitorStatsByNewFlag(date);
        VisitorStats newVisitorStats = new VisitorStats();
        VisitorStats oldVisitorStats = new VisitorStats();
        List<ReturnVisitorStats> returnVisitorStatsList = new ArrayList<>();
        ReturnVisitorStats returnVisitorStats = new ReturnVisitorStats();
        //循环把数据赋给新访客统计对象和老访客统计对象
        for (VisitorStats visitorStats : visitorStatsByNewFlag) {
            if (visitorStats.getIs_new().equals("1")) {
                newVisitorStats = visitorStats;
            } else {
                oldVisitorStats = visitorStats;
            }
        }

        returnVisitorStats.setType("用户数(人)");
        returnVisitorStats.setNewCount(newVisitorStats.getUv_ct());
        returnVisitorStats.setOldCount(oldVisitorStats.getUv_ct());
        returnVisitorStatsList.add(returnVisitorStats);
        returnVisitorStats = new ReturnVisitorStats();
        returnVisitorStats.setType("总访问页面(次)");
        returnVisitorStats.setNewCount(newVisitorStats.getPv_ct());
        returnVisitorStats.setOldCount(oldVisitorStats.getPv_ct());
        returnVisitorStatsList.add(returnVisitorStats);
        returnVisitorStats = new ReturnVisitorStats();
        returnVisitorStats.setType("跳出率(%)");
        returnVisitorStats.setNewCount(newVisitorStats.getUjRate().longValue());
        returnVisitorStats.setOldCount(oldVisitorStats.getUjRate().longValue());
        returnVisitorStatsList.add(returnVisitorStats);
        returnVisitorStats = new ReturnVisitorStats();
        returnVisitorStats.setType("平均在线时长(秒)");
        returnVisitorStats.setNewCount(newVisitorStats.getDurPerSv().longValue());
        returnVisitorStats.setOldCount(newVisitorStats.getDurPerSv().longValue());
        returnVisitorStatsList.add(returnVisitorStats);
        returnVisitorStats = new ReturnVisitorStats();
        returnVisitorStats.setType("平均访问页面数(人次)");
        returnVisitorStats.setNewCount(newVisitorStats.getPvPerSv().longValue());
        returnVisitorStats.setOldCount(oldVisitorStats.getPvPerSv().longValue());
        returnVisitorStatsList.add(returnVisitorStats);
        return returnVisitorStatsList;
    }

    @Override
    public String getVisitorStatsByHour(int date) {
        List<VisitorStats> visitorStatsHrList = visitorStatsMapper.selectVisitorStatsByHour(date);
        //构建24位数组
        VisitorStats[] visitorStatsArr=new VisitorStats[24];

        //把对应小时的位置赋值
        for (VisitorStats visitorStats : visitorStatsHrList) {
            visitorStatsArr[visitorStats.getHr()] =visitorStats ;
        }
        List<String> hrList=new ArrayList<>();
        List<Long> uvList=new ArrayList<>();
        List<Long> pvList=new ArrayList<>();
        List<Long> newMidList=new ArrayList<>();

        //循环出固定的0-23个小时  从结果map中查询对应的值
        for (int hr = 0; hr <=23 ; hr++) {
            VisitorStats visitorStats = visitorStatsArr[hr];
            if (visitorStats!=null){
                uvList.add(visitorStats.getUv_ct())   ;
                pvList.add( visitorStats.getPv_ct());
                newMidList.add( visitorStats.getNew_uv());
            }else{ //该小时没有流量补零
                uvList.add(0L)   ;
                pvList.add( 0L);
                newMidList.add( 0L);
            }
            //小时数不足两位补零
            hrList.add(String.format("%02d", hr));
        }
        //拼接字符串
        String json = "{\"status\":0,\"data\":{" + "\"categories\":" +
                "[\""+ StringUtils.join(hrList,"\",\"")+ "\"],\"series\":[" +
                "{\"name\":\"uv\",\"data\":["+ StringUtils.join(uvList,",") +"]}," +
                "{\"name\":\"pv\",\"data\":["+ StringUtils.join(pvList,",") +"]}," +
                "{\"name\":\"新用户\",\"data\":["+ StringUtils.join(newMidList,",") +"]}]}}";
        return json;
    }

    @Override
    public Long getPv(int date) {
        return visitorStatsMapper.selectPv(date);
    }

    @Override
    public Long getUv(int date) {
        return visitorStatsMapper.selectUv(date);
    }
}
