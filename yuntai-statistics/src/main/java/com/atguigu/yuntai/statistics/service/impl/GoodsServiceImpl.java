package com.atguigu.yuntai.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.common.utils.EchartsConverter;
import com.atguigu.yuntai.common.utils.NameValueData;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByCate;
import com.atguigu.yuntai.statistics.bean.AdsTradeStatsByTm;
import com.atguigu.yuntai.statistics.mapper.RepeatPurchaseMapper;
import com.atguigu.yuntai.statistics.mapper.SkuCartNumTop3;
import com.atguigu.yuntai.statistics.mapper.TradeStatsCateMapper;
import com.atguigu.yuntai.statistics.mapper.TradeStatsTmMapper;
import com.atguigu.yuntai.statistics.service.GoodsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: gmall
 * @description: 商品统计实现类
 */
@DS("mysql")
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private RepeatPurchaseMapper repeatPurchaseMapper;

    @Autowired
    private TradeStatsTmMapper tradeStatsTmMapper;

    @Autowired
    private TradeStatsCateMapper tradeStatsCateMapper;

    @Autowired
    private SkuCartNumTop3 skuCartNumTop3;

    @Override
    public String getTmRepeat(int recentDays, String curDate, int showNum) {
        List<NameValueData> tmRepeatList = repeatPurchaseMapper.getTmRepeat(recentDays, curDate, showNum);
        return EchartsConverter.converterFromNameValue(tmRepeatList, false).toJSONString();

    }

    @Override
    public List<AdsTradeStatsByTm> getTmTradeStats(int recentDays, String curDate) {
        List<AdsTradeStatsByTm> tradeStatsByTmList = tradeStatsTmMapper.getTmTradeStats(recentDays,curDate);
        if(CollectionUtils.isNotEmpty(tradeStatsByTmList)){
            return tradeStatsByTmList;
        }
        return new ArrayList<AdsTradeStatsByTm>();
    }

    @Override
    public List<JSONObject> getCateTradeStats(int recentDays, String curDate){
        List<JSONObject> childrenList = new ArrayList<>();
        JSONArray children1Array = new JSONArray();
        List<AdsTradeStatsByCate> category1List = tradeStatsCateMapper.getCategory1List(recentDays, curDate);
        if(CollectionUtils.isNotEmpty(category1List)){
            for(AdsTradeStatsByCate adsTradeStatsByCate : category1List){
               JSONObject children1 = new JSONObject();
               JSONArray children2Array = new JSONArray();
               children1.put("name",adsTradeStatsByCate.getCategory1_name());
               List<AdsTradeStatsByCate> category2List = tradeStatsCateMapper.getCategory2List(recentDays, curDate, adsTradeStatsByCate.getCategory1_id());
               for(AdsTradeStatsByCate categroy2 : category2List){
                    JSONObject children2 = new JSONObject();
                    children2.put("name",categroy2.getCategory2_name());
                    children2.put("value",categroy2.getOrderCountTotal());
                    List<NameValueData> category3List = tradeStatsCateMapper.getCategory3List(recentDays, curDate, adsTradeStatsByCate.getCategory1_id(), categroy2.getCategory2_id());
                    children2.put("children",category3List);
                    children2Array.add(children2);
                }
                children1.put("children",children2Array);
                childrenList.add(children1);
            }
        }
        return childrenList;
    }

    @Override
    public List<NameValueData> getCategory1( String curDate) {
        return skuCartNumTop3.getCategory1(curDate);
    }

    @Override
    public List<NameValueData> getCategory2(String curDate, String category1_id) {
        return skuCartNumTop3.getCategory2(curDate,category1_id);
    }


    @Override
    public List<NameValueData> getCategory3(String curDate, String category1_id, String category2_id) {
        return skuCartNumTop3.getCategory3(curDate,category1_id,category2_id);
    }

    @Override
    public String getTmTopNData(String curDate, String category1_id, String category2_id, String category3_id) {
        List<NameValueData> tmTopNData = skuCartNumTop3.getTmTopNData(curDate, category1_id, category2_id, category3_id);
        return EchartsConverter.converterFromNameValue(tmTopNData, false).toJSONString();
    }


}
