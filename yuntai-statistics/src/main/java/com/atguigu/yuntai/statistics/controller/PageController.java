//package com.atguigu.yuntai.statistics.controller;
//
//import com.atguigu.yuntai.common.utils.Page;
//import com.atguigu.yuntai.common.utils.PageResponse;
//import com.atguigu.yuntai.common.utils.Pagination;
//import com.atguigu.yuntai.common.utils.QPageQuery;
//import com.atguigu.yuntai.statistics.bean.AdsTrafficStats;
//import com.atguigu.yuntai.statistics.bean.QUnified;
//import com.atguigu.yuntai.statistics.service.PageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @program: gmall
// * @description: 流量统计controller
// * @author: Zhao Yi
// * @create: 2021-12-11 14:06
// */
//@RestController
//public class VisitStatsController {
//
//    @Autowired
//    private PageService visitStatsService;
//
//    @RequestMapping(value ="getTrafficStats",method = {RequestMethod.POST})
//    @CrossOrigin
//    public PageResponse getTrafficStats(QUnified query, Pagination pagination) {
//        final QPageQuery qPageQuery = new QPageQuery(pagination, query);
//        PageResponse pageResponse = new PageResponse();
//        pageResponse.setPagination(pagination);
//        pageResponse.setQuery(query);
//        try {
//            Page<AdsTrafficStats> result = visitStatsService.getTrafficStats(qPageQuery);
//            if (result != null){
//                pageResponse.setPagination(result.getPagination());
//                pageResponse.setResult(result.getResult());
//                pageResponse.success("根据用户分组查询任务统计信息成功");
//            }
//        }catch (Exception e){
//            pageResponse.fail("根据用户分组查询任务统计信息失败" + e.toString());
//        }
//        return pageResponse ;
////        try {
////            rep.success().setResult(visitStatsService.getTrafficStats(days, dt));
////        } catch (Exception e) {
////            rep.fail(e);
////        }
////        return rep;
//    }
//    @RequestMapping("getPagePath")
//    @CrossOrigin
//    public String getPagePath(@RequestParam("days") int days, @RequestParam("dt") String dt) {
//        String pagePathString = visitStatsService.getPagePathCount(days, dt);
//
//        return visitStatsService.getPagePathCount(days, dt);
//    }
//
//
//}
//
//
