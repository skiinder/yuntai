package com.atguigu.yuntai.statistics.service;


import com.atguigu.yuntai.common.utils.Page;
import com.atguigu.yuntai.common.utils.QPageQuery;
import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;

import java.util.List;

/**
 * @program: gmall
 * @description: 流量统计service
 * @author: Zhao Yi
 * @create: 2021-12-11 14:08
 */
public interface PageService {

    String getPagePathCount(int days, String dt);

    Page<AdsTrafficStats> getTrafficStats(QPageQuery qPageQuery);

//    List<AdsTrafficStats> getTrafficStats(int days, String dt);
}
