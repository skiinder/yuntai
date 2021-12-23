package com.atguigu.yuntai.access.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DataAccessService {
    //新增Connector Post
    public JSONObject registerConnector(JSONObject config);

    //删除Connector
    public void deleteConnector(String name);

    //暂停Connector
    public void pauseConnector(String name);

    //恢复Connector
    public void resumeConnector(String name);

    //查询所有Connector
    public List<String> getConnectorList(String category);

    //查询Connector详情
    public JSONObject getStatus(String name);

    //更新Connector配置 Post
    public void updateConnector(JSONObject config);

    //获取Connector所有Task

    //获取指定Task状态

    //重启Connector

    //重启Task

    //获取Connector的Topic

    //清空指定Topic
}
