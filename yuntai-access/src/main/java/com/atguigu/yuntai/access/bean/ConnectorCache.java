package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectorCache {
    private final Map<String, JSONObject> cache;
    private final Map<String, String> categoryMap;

    public ConnectorCache() {
        cache = new HashMap<>();
        categoryMap = new HashMap<>();
        categoryMap.put("mysql", "io.debezium.connector.mysql.MySqlConnector");
        categoryMap.put("postgresql", "io.debezium.connector.postgresql.PostgresConnector");
        categoryMap.put("sqlserver", "io.debezium.connector.sqlserver.SqlServerConnector");
        categoryMap.put("mongodb", "io.debezium.connector.mongodb.MongoDbConnector");
    }

    public void addConnector(JSONObject config) {
        String name = config.getString("name");
        cache.put(name, config);
    }

    public void deleteConnector(String name) {
        cache.remove(name);
    }

    public void clear() {
        cache.clear();
    }

    public List<String> getConnectorList(String category) {
        return cache.values()
                .stream()
                .filter(o -> o.getJSONObject("config").getString("connector.class").equals(categoryMap.get(category)))
                .map(o -> o.getString("name"))
                .collect(Collectors.toList());
    }

    public JSONObject getConnector(String name) {
        return cache.getOrDefault(name, new JSONObject());
    }
}
