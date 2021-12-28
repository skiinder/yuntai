package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ConfigBean {
    private String connectorClass;
    private String user;
    private String serverId;
    private String hostname;
    private String password;
    private String historyBootstrapServers;
    private String historyTopic;
    private String serverName;
    private String port;
    private String databases;
    private String pluginName;
    private String tables;
    private String dbName;

    public ConfigBean() {
        connectorClass = "";
        user = "";
        serverId = "";
        hostname = "";
        password = "";
        historyBootstrapServers = "";
        historyTopic = "";
        serverName = "";
        port = "";
        databases = "";
        pluginName = "";
        tables = "";
        dbName = "";
    }

    public void readConfig(JSONObject config) {
        connectorClass = config.getString("connector.class");
        user = config.getString("database.user");
        serverId = config.getString("database.server.id");
        hostname = config.getString("database.hostname");
        password = config.getString("database.password");
        historyBootstrapServers = config.getString("database.history.kafka.bootstrap.servers");
        historyTopic = config.getString("database.history.kafka.topic");
        serverName = config.getString("database.server.name");
        port = config.getString("database.port");
        databases = config.getString("database.include.list");
        pluginName = config.getString("plugin.name");
        tables = config.getString("table.include.list");
        dbName = config.getString("database.dbname");
    }

    public JSONObject dump() {
        JSONObject config = new JSONObject();
        config.fluentPut("connector.class", connectorClass)
                .fluentPut("database.user", user)
                .fluentPut("database.server.id", serverId)
                .fluentPut("database.hostname", hostname)
                .fluentPut("database.password", password)
                .fluentPut("database.history.kafka.bootstrap.servers", historyBootstrapServers)
                .fluentPut("database.history.kafka.topic", historyTopic)
                .fluentPut("database.server.name", serverName)
                .fluentPut("database.port", port)
                .fluentPut("database.include.list", databases)
                .fluentPut("plugin.nam", pluginName)
                .fluentPut("table.include.list",tables)
                .fluentPut("database.dbname",databases);
        return config;

    }

    public String getConnectorClass() {
        return connectorClass;
    }

    public void setConnectorClass(String connectorClass) {
        this.connectorClass = connectorClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHistoryBootstrapServers() {
        return historyBootstrapServers;
    }

    public void setHistoryBootstrapServers(String historyBootstrapServers) {
        this.historyBootstrapServers = historyBootstrapServers;
    }

    public String getHistoryTopic() {
        return historyTopic;
    }

    public void setHistoryTopic(String historyTopic) {
        this.historyTopic = historyTopic;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabases() {
        return databases;
    }

    public void setDatabases(String databases) {
        this.databases = databases;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
