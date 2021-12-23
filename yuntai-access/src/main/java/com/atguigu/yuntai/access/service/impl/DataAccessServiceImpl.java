package com.atguigu.yuntai.access.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.yuntai.access.bean.ConnectorCache;
import com.atguigu.yuntai.access.service.DataAccessService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataAccessServiceImpl implements DataAccessService {

    private final String url = "http://hadoop102:8083";
    private final HttpClient client = new HttpClient();
    private final ConnectorCache connectorCache = new ConnectorCache();


    @Override
    public JSONObject registerConnector(JSONObject config) {
        try {
            PostMethod postMethod = new PostMethod(url + "/connectors/");
            StringRequestEntity request = new StringRequestEntity(
                    config.toJSONString(),
                    "application/json",
                    "UTF-8"
            );
            postMethod.setRequestHeader("Accept", "application/json");
            postMethod.setRequestEntity(request);
            client.executeMethod(postMethod);
            if (postMethod.getStatusLine().getStatusCode() == 201) {
                updateCache();
            }
            JSONObject jsonObject = JSON.parseObject(postMethod.getResponseBodyAsString());
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    @Override
    public void deleteConnector(String name) {
        try {
            DeleteMethod method = new DeleteMethod(url + "/connectors/" + name);
            client.executeMethod(method);
            updateCache();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseConnector(String name) {
        try {
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/pause");
            client.executeMethod(method);
            if (method.getStatusLine().getStatusCode() == 202) {
                updateCache();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void resumeConnector(String name) {
        try {
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/resume");
            client.executeMethod(method);
            if (method.getStatusLine().getStatusCode() == 202) {
                updateCache();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getConnectorList(String category) {
        return connectorCache.getConnectorList(category);
    }

    @Override
    public JSONObject getStatus(String name) {
        return connectorCache.getConnector(name);
    }

    @Override
    public void updateConnector(JSONObject config) {
        try {
            String name = config.getString("name");
            JSONObject rawConfig = config.getJSONObject("config");
            PutMethod method = new PutMethod(url + "/connectors/" + name + "/config");
            method.setRequestHeader("Accept", "application/json");
            StringRequestEntity request = new StringRequestEntity(
                    rawConfig.toJSONString(),
                    "application/json",
                    "UTF-8"
            );
            method.setRequestEntity(request);
            client.executeMethod(method);
            if (method.getStatusLine().getStatusCode() == 200) {
                updateCache();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCache() {
        connectorCache.clear();
        GetMethod getMethod = new GetMethod(url + "/connectors");
        try {
            client.executeMethod(getMethod);
            JSONArray connectors = JSON.parseArray(getMethod.getResponseBodyAsString());
            for (Object connector : connectors) {
                String name = connector.toString();
                GetMethod status = new GetMethod(url + "/connectors/" + name);
                client.executeMethod(status);
                JSONObject connectorStatus = JSON.parseObject(status.getResponseBodyAsString());
                connectorCache.addConnector(connectorStatus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
