package com.atguigu.yuntai.access.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.access.service.DataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataAccessController {

    @Autowired
    private DataAccessService dataAccessService;

    //新增Connector Post
    @RequestMapping(value = "registerConnector", method = RequestMethod.POST)
    public JSON registerConnector(@RequestBody JSONObject config) {
        return dataAccessService.registerConnector(config);
    }

    //删除Connector
    @RequestMapping(value = "deleteConnector", method = RequestMethod.GET)
    public void deleteConnector(@RequestParam String name) {
        dataAccessService.deleteConnector(name);
    }

    //暂停Connector
    @RequestMapping(value = "pauseConnector", method = RequestMethod.GET)
    public void pauseConnector(@RequestParam String name) {
        dataAccessService.pauseConnector(name);
    }

    //恢复Connector
    @RequestMapping(value = "resumeConnector", method = RequestMethod.GET)
    public void resumeConnector(@RequestParam String name) {
        dataAccessService.resumeConnector(name);
    }

    //查询所有Connector
    @RequestMapping(value = "getConnectorList", method = RequestMethod.GET)
    public List<String> getConnectorList(@RequestParam String category) {
        return dataAccessService.getConnectorList(category);
    }

    //查询Connector详情
    @RequestMapping(value = "getStatus", method = RequestMethod.GET)
    public JSONObject getStatus(@RequestParam String name) {
        return dataAccessService.getStatus(name);
    }

    //更新Connector配置 Post
    @RequestMapping(value = "updateConnector", method = RequestMethod.POST)
    public void updateConnector(@RequestBody JSONObject config) {
        dataAccessService.updateConnector(config);
    }

    //获取Connector所有Task

    //获取指定Task状态

    //重启Connector

    //重启Task

    //获取Connector的Topic

    //清空指定Topic
}
