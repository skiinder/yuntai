package com.atguigu.yuntai.statistics.controller;

import com.atguigu.yuntai.statistics.bean.ProductStats;
import com.atguigu.yuntai.statistics.bean.ProvinceStats;
import com.atguigu.yuntai.statistics.bean.ReturnVisitorStats;
import com.atguigu.yuntai.statistics.bean.VisitorStats;
import com.atguigu.yuntai.statistics.service.RealTimeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实时统计
 */
@RestController
public class RealTimeController {

    @Autowired
    RealTimeService realTimeService;


    /*
   {
       "status": 0,
       "msg": "",
       "data": 1201081.1632389291
   }
    */
    @RequestMapping("/gmv")
    @CrossOrigin
    public String getGMV(@RequestParam(value = "date",defaultValue = "0") Integer date) {
        if(date==0){
            date=now();
        }
        BigDecimal gmv = realTimeService.getGMV(date);
        String json = "{   \"status\": 0,  \"data\":" + gmv + "}";
        return  json;
    }

    /*
{
    "status": 0,
    "data": {
        "columns": [
            { "name": "商品名称",  "id": "spu_name"
            },
            { "name": "交易额", "id": "order_amount"
            }
        ],
        "rows": [
            {
                "spu_name": "小米10",
                "order_amount": "863399.00"
            },
           {
                "spu_name": "iPhone11",
                "order_amount": "548399.00"
            }
        ]
    }
}
 */
    @RequestMapping("/spu")
    @CrossOrigin
    public List<ProductStats> getProductStatsGroupBySpu(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        if (date == 0) date = now();
        List<ProductStats> statsList
                = realTimeService.getProductStatsGroupBySpu(date, limit);
        return statsList;
    }

    /*
{
    "status": 0,
    "data": [
        {
            "name": "数码类",
            "value": 371570
        },
        {
            "name": "日用品",
            "value": 296016
        }
    ]
}
 */
    @RequestMapping(value ="/category3",method = {RequestMethod.GET})
    @CrossOrigin
    public String getProductStatsGroupByCategory3(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "4") int limit) {
        if (date == 0) {
            date = now();
        }
        List<ProductStats> statsList
                = realTimeService.getProductStatsGroupByCategory3(date, limit);

        StringBuilder dataJson = new StringBuilder("{  \"status\": 0, \"data\": [");
        int i = 0;
        for (ProductStats productStats : statsList) {
            if (i++ > 0) {
                dataJson.append(",");
            }
            ;
            dataJson.append("{\"name\":\"")
                    .append(productStats.getCategory3_name()).append("\",");
            dataJson.append("\"value\":")
                    .append(productStats.getOrder_amount()).append("}");
        }
        dataJson.append("]}");
        return dataJson.toString();
    }
    /*
        {
         "status": 0,
         "data": {
             "categories": [
                 "三星","vivo","oppo"
             ],
             "series": [
                 {
                     "data": [ 406333, 709174, 681971
                     ]
                 }
             ]
         }
        }
    */
    @RequestMapping("/trademark")
    @CrossOrigin
    public String getProductStatsByTrademark(
            @RequestParam(value = "date", defaultValue = "0") Integer date,
            @RequestParam(value = "limit", defaultValue = "20") int limit) {
        if (date == 0) {
            date = now();
        }
        String productStatsByTrademarkList
                = realTimeService.getProductStatsByTrademark(date, limit);
        return productStatsByTrademarkList;
    }

    @RequestMapping("/province")
    @CrossOrigin
    public List<Map> getProvinceStats(@RequestParam(value = "date", defaultValue = "0") Integer date) {
        if (date == 0) {
            date = now();
        }
        List<Map> provinceStatsList = realTimeService.getProvinceStats(date);
        return provinceStatsList;
    }

    @RequestMapping("/visitor")
    @CrossOrigin
    public List<ReturnVisitorStats> getVisitorStatsByNewFlag(@RequestParam(value = "date", defaultValue = "0") Integer date) {
        if (date == 0) date = now();
        List<ReturnVisitorStats> visitorStatsByNewFlag = realTimeService.getVisitorStatsByNewFlag(date);
        return visitorStatsByNewFlag;
    }


    /**
     * 用户访问分时
     * @param date
     * @return
     */
    @RequestMapping("/hr")
    @CrossOrigin
    public String getMidStatsGroupbyHourNewFlag(@RequestParam(value = "date",defaultValue = "0") Integer date ) {
        if(date==0)  date=now();
        String visitorStatsHrList
                = realTimeService.getVisitorStatsByHour(date);
        return  visitorStatsHrList;
    }

    private int now(){
        String yyyyMMdd = DateFormatUtils.format(new Date(), "yyyyMMdd");
        return   Integer.valueOf(yyyyMMdd);
    }
}
