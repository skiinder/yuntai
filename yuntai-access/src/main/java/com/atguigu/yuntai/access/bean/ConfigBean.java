package com.atguigu.yuntai.access.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;


public class ConfigBean {
    private String bigint_unsigned_handling_mode;
    private String binary_handling_mode;
    private String binlog_buffer_size;
    private String collection_exclude_list;
    private String collection_include_list;
    private String column_exclude_list;
    private String column_include_list;
    private String column_propagate_source_type;
    private String connect_backoff_initial_delay_ms;
    private String connect_backoff_max_delay_ms;
    private String connect_keep_alive;
    private String connect_max_attempts;
    private String connect_timeout_ms;
    private String connector_class;
    private String cursor_max_await_time_ms;
    private String database_connection_adapter;
    private String database_dbname;
    private String database_exclude_list;
    private String database_history_kafka_bootstrap_servers;
    private String database_history_kafka_recovery_attempts;
    private String database_history_kafka_recovery_poll_interval_ms;
    private String database_history_kafka_topic;
    private String database_history_skip_unparseable_ddl;
    private String database_history_store_only_captured_tables_ddl;
    private String database_history_store_only_monitored_tables_ddl;
    private String database_hostname;
    private String database_include_list;
    private String database_initial_statements;
    private String database_names;
    private String database_password;
    private String database_pdb_name;
    private String database_port;
    private String database_server_id;
    private String database_server_name;
    private String database_ssl_mode;
    private String database_sslcert;
    private String database_sslkey;
    private String database_sslmode;
    private String database_sslpassword;
    private String database_sslrootcert;
    private String database_tcpKeepAlive;
    private String database_url;
    private String database_user;
    private String datatype_propagate_source_type;
    private String decimal_handling_mode;
    private String enable_time_adjuster;
    private String event_deserialization_failure_handling_mode;
    private String event_processing_failure_handling_mode;
    private String field_exclude_list;
    private String field_renames;
    private String gtid_new_channel_position;
    private String gtid_source_excludes;
    private String gtid_source_includes;
    private String heartbeat_action_query;
    private String heartbeat_interval_ms;
    private String heartbeat_topics_prefix;
    private String hstore_handling_mode;
    private String include_query;
    private String include_schema_changes;
    private String include_unknown_datatypes;
    private String inconsistent_schema_handling_mode;
    private String incremental_snapshot_chunk_size;
    private String interval_handling_mode;
    private String lob_enabled;
    private String log_mining_archive_destination_name;
    private String log_mining_archive_log_hours;
    private String log_mining_archive_log_only_mode;
    private String log_mining_archive_log_only_scn_poll_interval_ms;
    private String log_mining_batch_size_default;
    private String log_mining_batch_size_max;
    private String log_mining_batch_size_min;
    private String log_mining_buffer_drop_on_stop;
    private String log_mining_buffer_location;
    private String log_mining_buffer_type;
    private String log_mining_scn_gap_detection_gap_size_min;
    private String log_mining_scn_gap_detection_time_interval_max_ms;
    private String log_mining_sleep_time_default_ms;
    private String log_mining_sleep_time_increment_ms;
    private String log_mining_sleep_time_max_ms;
    private String log_mining_sleep_time_min_ms;
    private String log_mining_strategy;
    private String log_mining_transaction_retention_hours;
    private String log_mining_username_exclude_list;
    private String log_mining_view_fetch_size;
    private String max_batch_size;
    private String max_iteration_transactions;
    private String max_queue_size;
    private String max_queue_size_in_bytes;
    private String message_key_columns;
    private String min_row_count_to_stream_results;
    private String mongodb_authsource;
    private String mongodb_connect_timeout_ms;
    private String mongodb_hosts;
    private String mongodb_members_auto_discover;
    private String mongodb_name;
    private String mongodb_password;
    private String mongodb_poll_interval_ms;
    private String mongodb_server_selection_timeout_ms;
    private String mongodb_socket_timeout_ms;
    private String mongodb_ssl_enabled;
    private String mongodb_ssl_invalid_hostname_allowed;
    private String mongodb_user;
    private String name;
    private String plugin_name;
    private String poll_interval_ms;
    private String provide_transaction_metadata;
    private String publication_autocreate_mode;
    private String publication_name;
    private String query_fetch_size;
    private String rac_nodes;
    private String read_only;
    private String retriable_restart_connector_wait_ms;
    private String sanitize_field_names;
    private String schema_exclude_list;
    private String schema_include_list;
    private String schema_refresh_mode;
    private String signal_data_collection;
    private String signal_kafka_bootstrap_servers;
    private String signal_kafka_poll_timeout_ms;
    private String signal_kafka_topic;
    private String skipped_operations;
    private String slot_drop_on_stop;
    private String slot_max_retries;
    private String slot_name;
    private String slot_retry_delay_ms;
    private String slot_stream_params;
    private String snapshot_collection_filter_overrides;
    private String snapshot_custom_class;
    private String snapshot_delay_ms;
    private String snapshot_fetch_size;
    private String snapshot_include_collection_list;
    private String snapshot_isolation_mode;
    private String snapshot_lock_timeout_ms;
    private String snapshot_locking_mode;
    private String snapshot_max_threads;
    private String snapshot_mode;
    private String snapshot_select_statement_overrides;
    private String source_struct_version;
    private String status_update_interval_ms;
    private String table_exclude_list;
    private String table_ignore_builtin;
    private String table_include_list;
    private String tasks_max;
    private String time_precision_mode;
    private String toasted_value_placeholder;
    private String tombstones_on_delete;
    private String truncate_handling_mode;
    private String unavailable_value_placeholder;
    private String vitess_database_password;
    private String vitess_database_user;
    private String vitess_keyspace;
    private String vitess_shard;
    private String vitess_tablet_type;
    private String vitess_vtctld_host;
    private String vitess_vtctld_password;
    private String vitess_vtctld_port;
    private String vitess_vtctld_user;

    private final Class<? extends ConfigBean> thisClass = this.getClass();

    public void readConfig(JSONObject config) {
        for (String key : config.keySet()) {
            try {
                Field field = thisClass.getDeclaredField(key.replace('.', '_'));
                field.setAccessible(true);
                field.set(this, config.get(key));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject dump() {

        JSONObject jsonObject = new JSONObject();

        Field[] fields = thisClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                //遍历所有属性
                if ("thisClass".equals(field.getName())) {
                    continue;
                }
                field.setAccessible(true);

                //获取属性值
                Object temp = field.get(this);

                //向JsonObject中赋值
                if (temp != null) {
                    jsonObject.put(field.getName().replace('_', '.'), temp.toString());
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return jsonObject;

    }



    public String getBigint_unsigned_handling_mode() {
        return bigint_unsigned_handling_mode;
    }

    public void setBigint_unsigned_handling_mode(String bigint_unsigned_handling_mode) {
        this.bigint_unsigned_handling_mode = bigint_unsigned_handling_mode;
    }

    public String getBinary_handling_mode() {
        return binary_handling_mode;
    }

    public void setBinary_handling_mode(String binary_handling_mode) {
        this.binary_handling_mode = binary_handling_mode;
    }

    public String getBinlog_buffer_size() {
        return binlog_buffer_size;
    }

    public void setBinlog_buffer_size(String binlog_buffer_size) {
        this.binlog_buffer_size = binlog_buffer_size;
    }

    public String getCollection_exclude_list() {
        return collection_exclude_list;
    }

    public void setCollection_exclude_list(String collection_exclude_list) {
        this.collection_exclude_list = collection_exclude_list;
    }

    public String getCollection_include_list() {
        return collection_include_list;
    }

    public void setCollection_include_list(String collection_include_list) {
        this.collection_include_list = collection_include_list;
    }

    public String getColumn_exclude_list() {
        return column_exclude_list;
    }

    public void setColumn_exclude_list(String column_exclude_list) {
        this.column_exclude_list = column_exclude_list;
    }

    public String getColumn_include_list() {
        return column_include_list;
    }

    public void setColumn_include_list(String column_include_list) {
        this.column_include_list = column_include_list;
    }

    public String getColumn_propagate_source_type() {
        return column_propagate_source_type;
    }

    public void setColumn_propagate_source_type(String column_propagate_source_type) {
        this.column_propagate_source_type = column_propagate_source_type;
    }

    public String getConnect_backoff_initial_delay_ms() {
        return connect_backoff_initial_delay_ms;
    }

    public void setConnect_backoff_initial_delay_ms(String connect_backoff_initial_delay_ms) {
        this.connect_backoff_initial_delay_ms = connect_backoff_initial_delay_ms;
    }

    public String getConnect_backoff_max_delay_ms() {
        return connect_backoff_max_delay_ms;
    }

    public void setConnect_backoff_max_delay_ms(String connect_backoff_max_delay_ms) {
        this.connect_backoff_max_delay_ms = connect_backoff_max_delay_ms;
    }

    public String getConnect_keep_alive() {
        return connect_keep_alive;
    }

    public void setConnect_keep_alive(String connect_keep_alive) {
        this.connect_keep_alive = connect_keep_alive;
    }

    public String getConnect_max_attempts() {
        return connect_max_attempts;
    }

    public void setConnect_max_attempts(String connect_max_attempts) {
        this.connect_max_attempts = connect_max_attempts;
    }

    public String getConnect_timeout_ms() {
        return connect_timeout_ms;
    }

    public void setConnect_timeout_ms(String connect_timeout_ms) {
        this.connect_timeout_ms = connect_timeout_ms;
    }

    public String getConnector_class() {
        return connector_class;
    }

    public void setConnector_class(String connector_class) {
        this.connector_class = connector_class;
    }

    public String getCursor_max_await_time_ms() {
        return cursor_max_await_time_ms;
    }

    public void setCursor_max_await_time_ms(String cursor_max_await_time_ms) {
        this.cursor_max_await_time_ms = cursor_max_await_time_ms;
    }

    public String getDatabase_connection_adapter() {
        return database_connection_adapter;
    }

    public void setDatabase_connection_adapter(String database_connection_adapter) {
        this.database_connection_adapter = database_connection_adapter;
    }

    public String getDatabase_dbname() {
        return database_dbname;
    }

    public void setDatabase_dbname(String database_dbname) {
        this.database_dbname = database_dbname;
    }

    public String getDatabase_exclude_list() {
        return database_exclude_list;
    }

    public void setDatabase_exclude_list(String database_exclude_list) {
        this.database_exclude_list = database_exclude_list;
    }

    public String getDatabase_history_kafka_bootstrap_servers() {
        return database_history_kafka_bootstrap_servers;
    }

    public void setDatabase_history_kafka_bootstrap_servers(String database_history_kafka_bootstrap_servers) {
        this.database_history_kafka_bootstrap_servers = database_history_kafka_bootstrap_servers;
    }

    public String getDatabase_history_kafka_recovery_attempts() {
        return database_history_kafka_recovery_attempts;
    }

    public void setDatabase_history_kafka_recovery_attempts(String database_history_kafka_recovery_attempts) {
        this.database_history_kafka_recovery_attempts = database_history_kafka_recovery_attempts;
    }

    public String getDatabase_history_kafka_recovery_poll_interval_ms() {
        return database_history_kafka_recovery_poll_interval_ms;
    }

    public void setDatabase_history_kafka_recovery_poll_interval_ms(String database_history_kafka_recovery_poll_interval_ms) {
        this.database_history_kafka_recovery_poll_interval_ms = database_history_kafka_recovery_poll_interval_ms;
    }

    public String getDatabase_history_kafka_topic() {
        return database_history_kafka_topic;
    }

    public void setDatabase_history_kafka_topic(String database_history_kafka_topic) {
        this.database_history_kafka_topic = database_history_kafka_topic;
    }

    public String getDatabase_history_skip_unparseable_ddl() {
        return database_history_skip_unparseable_ddl;
    }

    public void setDatabase_history_skip_unparseable_ddl(String database_history_skip_unparseable_ddl) {
        this.database_history_skip_unparseable_ddl = database_history_skip_unparseable_ddl;
    }

    public String getDatabase_history_store_only_captured_tables_ddl() {
        return database_history_store_only_captured_tables_ddl;
    }

    public void setDatabase_history_store_only_captured_tables_ddl(String database_history_store_only_captured_tables_ddl) {
        this.database_history_store_only_captured_tables_ddl = database_history_store_only_captured_tables_ddl;
    }

    public String getDatabase_history_store_only_monitored_tables_ddl() {
        return database_history_store_only_monitored_tables_ddl;
    }

    public void setDatabase_history_store_only_monitored_tables_ddl(String database_history_store_only_monitored_tables_ddl) {
        this.database_history_store_only_monitored_tables_ddl = database_history_store_only_monitored_tables_ddl;
    }

    public String getDatabase_hostname() {
        return database_hostname;
    }

    public void setDatabase_hostname(String database_hostname) {
        this.database_hostname = database_hostname;
    }

    public String getDatabase_include_list() {
        return database_include_list;
    }

    public void setDatabase_include_list(String database_include_list) {
        this.database_include_list = database_include_list;
    }

    public String getDatabase_initial_statements() {
        return database_initial_statements;
    }

    public void setDatabase_initial_statements(String database_initial_statements) {
        this.database_initial_statements = database_initial_statements;
    }

    public String getDatabase_names() {
        return database_names;
    }

    public void setDatabase_names(String database_names) {
        this.database_names = database_names;
    }

    public String getDatabase_password() {
        return database_password;
    }

    public void setDatabase_password(String database_password) {
        this.database_password = database_password;
    }

    public String getDatabase_pdb_name() {
        return database_pdb_name;
    }

    public void setDatabase_pdb_name(String database_pdb_name) {
        this.database_pdb_name = database_pdb_name;
    }

    public String getDatabase_port() {
        return database_port;
    }

    public void setDatabase_port(String database_port) {
        this.database_port = database_port;
    }

    public String getDatabase_server_id() {
        return database_server_id;
    }

    public void setDatabase_server_id(String database_server_id) {
        this.database_server_id = database_server_id;
    }

    public String getDatabase_server_name() {
        return database_server_name;
    }

    public void setDatabase_server_name(String database_server_name) {
        this.database_server_name = database_server_name;
    }

    public String getDatabase_ssl_mode() {
        return database_ssl_mode;
    }

    public void setDatabase_ssl_mode(String database_ssl_mode) {
        this.database_ssl_mode = database_ssl_mode;
    }

    public String getDatabase_sslcert() {
        return database_sslcert;
    }

    public void setDatabase_sslcert(String database_sslcert) {
        this.database_sslcert = database_sslcert;
    }

    public String getDatabase_sslkey() {
        return database_sslkey;
    }

    public void setDatabase_sslkey(String database_sslkey) {
        this.database_sslkey = database_sslkey;
    }

    public String getDatabase_sslmode() {
        return database_sslmode;
    }

    public void setDatabase_sslmode(String database_sslmode) {
        this.database_sslmode = database_sslmode;
    }

    public String getDatabase_sslpassword() {
        return database_sslpassword;
    }

    public void setDatabase_sslpassword(String database_sslpassword) {
        this.database_sslpassword = database_sslpassword;
    }

    public String getDatabase_sslrootcert() {
        return database_sslrootcert;
    }

    public void setDatabase_sslrootcert(String database_sslrootcert) {
        this.database_sslrootcert = database_sslrootcert;
    }

    public String getDatabase_tcpKeepAlive() {
        return database_tcpKeepAlive;
    }

    public void setDatabase_tcpKeepAlive(String database_tcpKeepAlive) {
        this.database_tcpKeepAlive = database_tcpKeepAlive;
    }

    public String getDatabase_url() {
        return database_url;
    }

    public void setDatabase_url(String database_url) {
        this.database_url = database_url;
    }

    public String getDatabase_user() {
        return database_user;
    }

    public void setDatabase_user(String database_user) {
        this.database_user = database_user;
    }

    public String getDatatype_propagate_source_type() {
        return datatype_propagate_source_type;
    }

    public void setDatatype_propagate_source_type(String datatype_propagate_source_type) {
        this.datatype_propagate_source_type = datatype_propagate_source_type;
    }

    public String getDecimal_handling_mode() {
        return decimal_handling_mode;
    }

    public void setDecimal_handling_mode(String decimal_handling_mode) {
        this.decimal_handling_mode = decimal_handling_mode;
    }

    public String getEnable_time_adjuster() {
        return enable_time_adjuster;
    }

    public void setEnable_time_adjuster(String enable_time_adjuster) {
        this.enable_time_adjuster = enable_time_adjuster;
    }

    public String getEvent_deserialization_failure_handling_mode() {
        return event_deserialization_failure_handling_mode;
    }

    public void setEvent_deserialization_failure_handling_mode(String event_deserialization_failure_handling_mode) {
        this.event_deserialization_failure_handling_mode = event_deserialization_failure_handling_mode;
    }

    public String getEvent_processing_failure_handling_mode() {
        return event_processing_failure_handling_mode;
    }

    public void setEvent_processing_failure_handling_mode(String event_processing_failure_handling_mode) {
        this.event_processing_failure_handling_mode = event_processing_failure_handling_mode;
    }

    public String getField_exclude_list() {
        return field_exclude_list;
    }

    public void setField_exclude_list(String field_exclude_list) {
        this.field_exclude_list = field_exclude_list;
    }

    public String getField_renames() {
        return field_renames;
    }

    public void setField_renames(String field_renames) {
        this.field_renames = field_renames;
    }

    public String getGtid_new_channel_position() {
        return gtid_new_channel_position;
    }

    public void setGtid_new_channel_position(String gtid_new_channel_position) {
        this.gtid_new_channel_position = gtid_new_channel_position;
    }

    public String getGtid_source_excludes() {
        return gtid_source_excludes;
    }

    public void setGtid_source_excludes(String gtid_source_excludes) {
        this.gtid_source_excludes = gtid_source_excludes;
    }

    public String getGtid_source_includes() {
        return gtid_source_includes;
    }

    public void setGtid_source_includes(String gtid_source_includes) {
        this.gtid_source_includes = gtid_source_includes;
    }

    public String getHeartbeat_action_query() {
        return heartbeat_action_query;
    }

    public void setHeartbeat_action_query(String heartbeat_action_query) {
        this.heartbeat_action_query = heartbeat_action_query;
    }

    public String getHeartbeat_interval_ms() {
        return heartbeat_interval_ms;
    }

    public void setHeartbeat_interval_ms(String heartbeat_interval_ms) {
        this.heartbeat_interval_ms = heartbeat_interval_ms;
    }

    public String getHeartbeat_topics_prefix() {
        return heartbeat_topics_prefix;
    }

    public void setHeartbeat_topics_prefix(String heartbeat_topics_prefix) {
        this.heartbeat_topics_prefix = heartbeat_topics_prefix;
    }

    public String getHstore_handling_mode() {
        return hstore_handling_mode;
    }

    public void setHstore_handling_mode(String hstore_handling_mode) {
        this.hstore_handling_mode = hstore_handling_mode;
    }

    public String getInclude_query() {
        return include_query;
    }

    public void setInclude_query(String include_query) {
        this.include_query = include_query;
    }

    public String getInclude_schema_changes() {
        return include_schema_changes;
    }

    public void setInclude_schema_changes(String include_schema_changes) {
        this.include_schema_changes = include_schema_changes;
    }

    public String getInclude_unknown_datatypes() {
        return include_unknown_datatypes;
    }

    public void setInclude_unknown_datatypes(String include_unknown_datatypes) {
        this.include_unknown_datatypes = include_unknown_datatypes;
    }

    public String getInconsistent_schema_handling_mode() {
        return inconsistent_schema_handling_mode;
    }

    public void setInconsistent_schema_handling_mode(String inconsistent_schema_handling_mode) {
        this.inconsistent_schema_handling_mode = inconsistent_schema_handling_mode;
    }

    public String getIncremental_snapshot_chunk_size() {
        return incremental_snapshot_chunk_size;
    }

    public void setIncremental_snapshot_chunk_size(String incremental_snapshot_chunk_size) {
        this.incremental_snapshot_chunk_size = incremental_snapshot_chunk_size;
    }

    public String getInterval_handling_mode() {
        return interval_handling_mode;
    }

    public void setInterval_handling_mode(String interval_handling_mode) {
        this.interval_handling_mode = interval_handling_mode;
    }

    public String getLob_enabled() {
        return lob_enabled;
    }

    public void setLob_enabled(String lob_enabled) {
        this.lob_enabled = lob_enabled;
    }

    public String getLog_mining_archive_destination_name() {
        return log_mining_archive_destination_name;
    }

    public void setLog_mining_archive_destination_name(String log_mining_archive_destination_name) {
        this.log_mining_archive_destination_name = log_mining_archive_destination_name;
    }

    public String getLog_mining_archive_log_hours() {
        return log_mining_archive_log_hours;
    }

    public void setLog_mining_archive_log_hours(String log_mining_archive_log_hours) {
        this.log_mining_archive_log_hours = log_mining_archive_log_hours;
    }

    public String getLog_mining_archive_log_only_mode() {
        return log_mining_archive_log_only_mode;
    }

    public void setLog_mining_archive_log_only_mode(String log_mining_archive_log_only_mode) {
        this.log_mining_archive_log_only_mode = log_mining_archive_log_only_mode;
    }

    public String getLog_mining_archive_log_only_scn_poll_interval_ms() {
        return log_mining_archive_log_only_scn_poll_interval_ms;
    }

    public void setLog_mining_archive_log_only_scn_poll_interval_ms(String log_mining_archive_log_only_scn_poll_interval_ms) {
        this.log_mining_archive_log_only_scn_poll_interval_ms = log_mining_archive_log_only_scn_poll_interval_ms;
    }

    public String getLog_mining_batch_size_default() {
        return log_mining_batch_size_default;
    }

    public void setLog_mining_batch_size_default(String log_mining_batch_size_default) {
        this.log_mining_batch_size_default = log_mining_batch_size_default;
    }

    public String getLog_mining_batch_size_max() {
        return log_mining_batch_size_max;
    }

    public void setLog_mining_batch_size_max(String log_mining_batch_size_max) {
        this.log_mining_batch_size_max = log_mining_batch_size_max;
    }

    public String getLog_mining_batch_size_min() {
        return log_mining_batch_size_min;
    }

    public void setLog_mining_batch_size_min(String log_mining_batch_size_min) {
        this.log_mining_batch_size_min = log_mining_batch_size_min;
    }

    public String getLog_mining_buffer_drop_on_stop() {
        return log_mining_buffer_drop_on_stop;
    }

    public void setLog_mining_buffer_drop_on_stop(String log_mining_buffer_drop_on_stop) {
        this.log_mining_buffer_drop_on_stop = log_mining_buffer_drop_on_stop;
    }

    public String getLog_mining_buffer_location() {
        return log_mining_buffer_location;
    }

    public void setLog_mining_buffer_location(String log_mining_buffer_location) {
        this.log_mining_buffer_location = log_mining_buffer_location;
    }

    public String getLog_mining_buffer_type() {
        return log_mining_buffer_type;
    }

    public void setLog_mining_buffer_type(String log_mining_buffer_type) {
        this.log_mining_buffer_type = log_mining_buffer_type;
    }

    public String getLog_mining_scn_gap_detection_gap_size_min() {
        return log_mining_scn_gap_detection_gap_size_min;
    }

    public void setLog_mining_scn_gap_detection_gap_size_min(String log_mining_scn_gap_detection_gap_size_min) {
        this.log_mining_scn_gap_detection_gap_size_min = log_mining_scn_gap_detection_gap_size_min;
    }

    public String getLog_mining_scn_gap_detection_time_interval_max_ms() {
        return log_mining_scn_gap_detection_time_interval_max_ms;
    }

    public void setLog_mining_scn_gap_detection_time_interval_max_ms(String log_mining_scn_gap_detection_time_interval_max_ms) {
        this.log_mining_scn_gap_detection_time_interval_max_ms = log_mining_scn_gap_detection_time_interval_max_ms;
    }

    public String getLog_mining_sleep_time_default_ms() {
        return log_mining_sleep_time_default_ms;
    }

    public void setLog_mining_sleep_time_default_ms(String log_mining_sleep_time_default_ms) {
        this.log_mining_sleep_time_default_ms = log_mining_sleep_time_default_ms;
    }

    public String getLog_mining_sleep_time_increment_ms() {
        return log_mining_sleep_time_increment_ms;
    }

    public void setLog_mining_sleep_time_increment_ms(String log_mining_sleep_time_increment_ms) {
        this.log_mining_sleep_time_increment_ms = log_mining_sleep_time_increment_ms;
    }

    public String getLog_mining_sleep_time_max_ms() {
        return log_mining_sleep_time_max_ms;
    }

    public void setLog_mining_sleep_time_max_ms(String log_mining_sleep_time_max_ms) {
        this.log_mining_sleep_time_max_ms = log_mining_sleep_time_max_ms;
    }

    public String getLog_mining_sleep_time_min_ms() {
        return log_mining_sleep_time_min_ms;
    }

    public void setLog_mining_sleep_time_min_ms(String log_mining_sleep_time_min_ms) {
        this.log_mining_sleep_time_min_ms = log_mining_sleep_time_min_ms;
    }

    public String getLog_mining_strategy() {
        return log_mining_strategy;
    }

    public void setLog_mining_strategy(String log_mining_strategy) {
        this.log_mining_strategy = log_mining_strategy;
    }

    public String getLog_mining_transaction_retention_hours() {
        return log_mining_transaction_retention_hours;
    }

    public void setLog_mining_transaction_retention_hours(String log_mining_transaction_retention_hours) {
        this.log_mining_transaction_retention_hours = log_mining_transaction_retention_hours;
    }

    public String getLog_mining_username_exclude_list() {
        return log_mining_username_exclude_list;
    }

    public void setLog_mining_username_exclude_list(String log_mining_username_exclude_list) {
        this.log_mining_username_exclude_list = log_mining_username_exclude_list;
    }

    public String getLog_mining_view_fetch_size() {
        return log_mining_view_fetch_size;
    }

    public void setLog_mining_view_fetch_size(String log_mining_view_fetch_size) {
        this.log_mining_view_fetch_size = log_mining_view_fetch_size;
    }

    public String getMax_batch_size() {
        return max_batch_size;
    }

    public void setMax_batch_size(String max_batch_size) {
        this.max_batch_size = max_batch_size;
    }

    public String getMax_iteration_transactions() {
        return max_iteration_transactions;
    }

    public void setMax_iteration_transactions(String max_iteration_transactions) {
        this.max_iteration_transactions = max_iteration_transactions;
    }

    public String getMax_queue_size() {
        return max_queue_size;
    }

    public void setMax_queue_size(String max_queue_size) {
        this.max_queue_size = max_queue_size;
    }

    public String getMax_queue_size_in_bytes() {
        return max_queue_size_in_bytes;
    }

    public void setMax_queue_size_in_bytes(String max_queue_size_in_bytes) {
        this.max_queue_size_in_bytes = max_queue_size_in_bytes;
    }

    public String getMessage_key_columns() {
        return message_key_columns;
    }

    public void setMessage_key_columns(String message_key_columns) {
        this.message_key_columns = message_key_columns;
    }

    public String getMin_row_count_to_stream_results() {
        return min_row_count_to_stream_results;
    }

    public void setMin_row_count_to_stream_results(String min_row_count_to_stream_results) {
        this.min_row_count_to_stream_results = min_row_count_to_stream_results;
    }

    public String getMongodb_authsource() {
        return mongodb_authsource;
    }

    public void setMongodb_authsource(String mongodb_authsource) {
        this.mongodb_authsource = mongodb_authsource;
    }

    public String getMongodb_connect_timeout_ms() {
        return mongodb_connect_timeout_ms;
    }

    public void setMongodb_connect_timeout_ms(String mongodb_connect_timeout_ms) {
        this.mongodb_connect_timeout_ms = mongodb_connect_timeout_ms;
    }

    public String getMongodb_hosts() {
        return mongodb_hosts;
    }

    public void setMongodb_hosts(String mongodb_hosts) {
        this.mongodb_hosts = mongodb_hosts;
    }

    public String getMongodb_members_auto_discover() {
        return mongodb_members_auto_discover;
    }

    public void setMongodb_members_auto_discover(String mongodb_members_auto_discover) {
        this.mongodb_members_auto_discover = mongodb_members_auto_discover;
    }

    public String getMongodb_name() {
        return mongodb_name;
    }

    public void setMongodb_name(String mongodb_name) {
        this.mongodb_name = mongodb_name;
    }

    public String getMongodb_password() {
        return mongodb_password;
    }

    public void setMongodb_password(String mongodb_password) {
        this.mongodb_password = mongodb_password;
    }

    public String getMongodb_poll_interval_ms() {
        return mongodb_poll_interval_ms;
    }

    public void setMongodb_poll_interval_ms(String mongodb_poll_interval_ms) {
        this.mongodb_poll_interval_ms = mongodb_poll_interval_ms;
    }

    public String getMongodb_server_selection_timeout_ms() {
        return mongodb_server_selection_timeout_ms;
    }

    public void setMongodb_server_selection_timeout_ms(String mongodb_server_selection_timeout_ms) {
        this.mongodb_server_selection_timeout_ms = mongodb_server_selection_timeout_ms;
    }

    public String getMongodb_socket_timeout_ms() {
        return mongodb_socket_timeout_ms;
    }

    public void setMongodb_socket_timeout_ms(String mongodb_socket_timeout_ms) {
        this.mongodb_socket_timeout_ms = mongodb_socket_timeout_ms;
    }

    public String getMongodb_ssl_enabled() {
        return mongodb_ssl_enabled;
    }

    public void setMongodb_ssl_enabled(String mongodb_ssl_enabled) {
        this.mongodb_ssl_enabled = mongodb_ssl_enabled;
    }

    public String getMongodb_ssl_invalid_hostname_allowed() {
        return mongodb_ssl_invalid_hostname_allowed;
    }

    public void setMongodb_ssl_invalid_hostname_allowed(String mongodb_ssl_invalid_hostname_allowed) {
        this.mongodb_ssl_invalid_hostname_allowed = mongodb_ssl_invalid_hostname_allowed;
    }

    public String getMongodb_user() {
        return mongodb_user;
    }

    public void setMongodb_user(String mongodb_user) {
        this.mongodb_user = mongodb_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlugin_name() {
        return plugin_name;
    }

    public void setPlugin_name(String plugin_name) {
        this.plugin_name = plugin_name;
    }

    public String getPoll_interval_ms() {
        return poll_interval_ms;
    }

    public void setPoll_interval_ms(String poll_interval_ms) {
        this.poll_interval_ms = poll_interval_ms;
    }

    public String getProvide_transaction_metadata() {
        return provide_transaction_metadata;
    }

    public void setProvide_transaction_metadata(String provide_transaction_metadata) {
        this.provide_transaction_metadata = provide_transaction_metadata;
    }

    public String getPublication_autocreate_mode() {
        return publication_autocreate_mode;
    }

    public void setPublication_autocreate_mode(String publication_autocreate_mode) {
        this.publication_autocreate_mode = publication_autocreate_mode;
    }

    public String getPublication_name() {
        return publication_name;
    }

    public void setPublication_name(String publication_name) {
        this.publication_name = publication_name;
    }

    public String getQuery_fetch_size() {
        return query_fetch_size;
    }

    public void setQuery_fetch_size(String query_fetch_size) {
        this.query_fetch_size = query_fetch_size;
    }

    public String getRac_nodes() {
        return rac_nodes;
    }

    public void setRac_nodes(String rac_nodes) {
        this.rac_nodes = rac_nodes;
    }

    public String getRead_only() {
        return read_only;
    }

    public void setRead_only(String read_only) {
        this.read_only = read_only;
    }

    public String getRetriable_restart_connector_wait_ms() {
        return retriable_restart_connector_wait_ms;
    }

    public void setRetriable_restart_connector_wait_ms(String retriable_restart_connector_wait_ms) {
        this.retriable_restart_connector_wait_ms = retriable_restart_connector_wait_ms;
    }

    public String getSanitize_field_names() {
        return sanitize_field_names;
    }

    public void setSanitize_field_names(String sanitize_field_names) {
        this.sanitize_field_names = sanitize_field_names;
    }

    public String getSchema_exclude_list() {
        return schema_exclude_list;
    }

    public void setSchema_exclude_list(String schema_exclude_list) {
        this.schema_exclude_list = schema_exclude_list;
    }

    public String getSchema_include_list() {
        return schema_include_list;
    }

    public void setSchema_include_list(String schema_include_list) {
        this.schema_include_list = schema_include_list;
    }

    public String getSchema_refresh_mode() {
        return schema_refresh_mode;
    }

    public void setSchema_refresh_mode(String schema_refresh_mode) {
        this.schema_refresh_mode = schema_refresh_mode;
    }

    public String getSignal_data_collection() {
        return signal_data_collection;
    }

    public void setSignal_data_collection(String signal_data_collection) {
        this.signal_data_collection = signal_data_collection;
    }

    public String getSignal_kafka_bootstrap_servers() {
        return signal_kafka_bootstrap_servers;
    }

    public void setSignal_kafka_bootstrap_servers(String signal_kafka_bootstrap_servers) {
        this.signal_kafka_bootstrap_servers = signal_kafka_bootstrap_servers;
    }

    public String getSignal_kafka_poll_timeout_ms() {
        return signal_kafka_poll_timeout_ms;
    }

    public void setSignal_kafka_poll_timeout_ms(String signal_kafka_poll_timeout_ms) {
        this.signal_kafka_poll_timeout_ms = signal_kafka_poll_timeout_ms;
    }

    public String getSignal_kafka_topic() {
        return signal_kafka_topic;
    }

    public void setSignal_kafka_topic(String signal_kafka_topic) {
        this.signal_kafka_topic = signal_kafka_topic;
    }

    public String getSkipped_operations() {
        return skipped_operations;
    }

    public void setSkipped_operations(String skipped_operations) {
        this.skipped_operations = skipped_operations;
    }

    public String getSlot_drop_on_stop() {
        return slot_drop_on_stop;
    }

    public void setSlot_drop_on_stop(String slot_drop_on_stop) {
        this.slot_drop_on_stop = slot_drop_on_stop;
    }

    public String getSlot_max_retries() {
        return slot_max_retries;
    }

    public void setSlot_max_retries(String slot_max_retries) {
        this.slot_max_retries = slot_max_retries;
    }

    public String getSlot_name() {
        return slot_name;
    }

    public void setSlot_name(String slot_name) {
        this.slot_name = slot_name;
    }

    public String getSlot_retry_delay_ms() {
        return slot_retry_delay_ms;
    }

    public void setSlot_retry_delay_ms(String slot_retry_delay_ms) {
        this.slot_retry_delay_ms = slot_retry_delay_ms;
    }

    public String getSlot_stream_params() {
        return slot_stream_params;
    }

    public void setSlot_stream_params(String slot_stream_params) {
        this.slot_stream_params = slot_stream_params;
    }

    public String getSnapshot_collection_filter_overrides() {
        return snapshot_collection_filter_overrides;
    }

    public void setSnapshot_collection_filter_overrides(String snapshot_collection_filter_overrides) {
        this.snapshot_collection_filter_overrides = snapshot_collection_filter_overrides;
    }

    public String getSnapshot_custom_class() {
        return snapshot_custom_class;
    }

    public void setSnapshot_custom_class(String snapshot_custom_class) {
        this.snapshot_custom_class = snapshot_custom_class;
    }

    public String getSnapshot_delay_ms() {
        return snapshot_delay_ms;
    }

    public void setSnapshot_delay_ms(String snapshot_delay_ms) {
        this.snapshot_delay_ms = snapshot_delay_ms;
    }

    public String getSnapshot_fetch_size() {
        return snapshot_fetch_size;
    }

    public void setSnapshot_fetch_size(String snapshot_fetch_size) {
        this.snapshot_fetch_size = snapshot_fetch_size;
    }

    public String getSnapshot_include_collection_list() {
        return snapshot_include_collection_list;
    }

    public void setSnapshot_include_collection_list(String snapshot_include_collection_list) {
        this.snapshot_include_collection_list = snapshot_include_collection_list;
    }

    public String getSnapshot_isolation_mode() {
        return snapshot_isolation_mode;
    }

    public void setSnapshot_isolation_mode(String snapshot_isolation_mode) {
        this.snapshot_isolation_mode = snapshot_isolation_mode;
    }

    public String getSnapshot_lock_timeout_ms() {
        return snapshot_lock_timeout_ms;
    }

    public void setSnapshot_lock_timeout_ms(String snapshot_lock_timeout_ms) {
        this.snapshot_lock_timeout_ms = snapshot_lock_timeout_ms;
    }

    public String getSnapshot_locking_mode() {
        return snapshot_locking_mode;
    }

    public void setSnapshot_locking_mode(String snapshot_locking_mode) {
        this.snapshot_locking_mode = snapshot_locking_mode;
    }

    public String getSnapshot_max_threads() {
        return snapshot_max_threads;
    }

    public void setSnapshot_max_threads(String snapshot_max_threads) {
        this.snapshot_max_threads = snapshot_max_threads;
    }

    public String getSnapshot_mode() {
        return snapshot_mode;
    }

    public void setSnapshot_mode(String snapshot_mode) {
        this.snapshot_mode = snapshot_mode;
    }

    public String getSnapshot_select_statement_overrides() {
        return snapshot_select_statement_overrides;
    }

    public void setSnapshot_select_statement_overrides(String snapshot_select_statement_overrides) {
        this.snapshot_select_statement_overrides = snapshot_select_statement_overrides;
    }

    public String getSource_struct_version() {
        return source_struct_version;
    }

    public void setSource_struct_version(String source_struct_version) {
        this.source_struct_version = source_struct_version;
    }

    public String getStatus_update_interval_ms() {
        return status_update_interval_ms;
    }

    public void setStatus_update_interval_ms(String status_update_interval_ms) {
        this.status_update_interval_ms = status_update_interval_ms;
    }

    public String getTable_exclude_list() {
        return table_exclude_list;
    }

    public void setTable_exclude_list(String table_exclude_list) {
        this.table_exclude_list = table_exclude_list;
    }

    public String getTable_ignore_builtin() {
        return table_ignore_builtin;
    }

    public void setTable_ignore_builtin(String table_ignore_builtin) {
        this.table_ignore_builtin = table_ignore_builtin;
    }

    public String getTable_include_list() {
        return table_include_list;
    }

    public void setTable_include_list(String table_include_list) {
        this.table_include_list = table_include_list;
    }

    public String getTasks_max() {
        return tasks_max;
    }

    public void setTasks_max(String tasks_max) {
        this.tasks_max = tasks_max;
    }

    public String getTime_precision_mode() {
        return time_precision_mode;
    }

    public void setTime_precision_mode(String time_precision_mode) {
        this.time_precision_mode = time_precision_mode;
    }

    public String getToasted_value_placeholder() {
        return toasted_value_placeholder;
    }

    public void setToasted_value_placeholder(String toasted_value_placeholder) {
        this.toasted_value_placeholder = toasted_value_placeholder;
    }

    public String getTombstones_on_delete() {
        return tombstones_on_delete;
    }

    public void setTombstones_on_delete(String tombstones_on_delete) {
        this.tombstones_on_delete = tombstones_on_delete;
    }

    public String getTruncate_handling_mode() {
        return truncate_handling_mode;
    }

    public void setTruncate_handling_mode(String truncate_handling_mode) {
        this.truncate_handling_mode = truncate_handling_mode;
    }

    public String getUnavailable_value_placeholder() {
        return unavailable_value_placeholder;
    }

    public void setUnavailable_value_placeholder(String unavailable_value_placeholder) {
        this.unavailable_value_placeholder = unavailable_value_placeholder;
    }

    public String getVitess_database_password() {
        return vitess_database_password;
    }

    public void setVitess_database_password(String vitess_database_password) {
        this.vitess_database_password = vitess_database_password;
    }

    public String getVitess_database_user() {
        return vitess_database_user;
    }

    public void setVitess_database_user(String vitess_database_user) {
        this.vitess_database_user = vitess_database_user;
    }

    public String getVitess_keyspace() {
        return vitess_keyspace;
    }

    public void setVitess_keyspace(String vitess_keyspace) {
        this.vitess_keyspace = vitess_keyspace;
    }

    public String getVitess_shard() {
        return vitess_shard;
    }

    public void setVitess_shard(String vitess_shard) {
        this.vitess_shard = vitess_shard;
    }

    public String getVitess_tablet_type() {
        return vitess_tablet_type;
    }

    public void setVitess_tablet_type(String vitess_tablet_type) {
        this.vitess_tablet_type = vitess_tablet_type;
    }

    public String getVitess_vtctld_host() {
        return vitess_vtctld_host;
    }

    public void setVitess_vtctld_host(String vitess_vtctld_host) {
        this.vitess_vtctld_host = vitess_vtctld_host;
    }

    public String getVitess_vtctld_password() {
        return vitess_vtctld_password;
    }

    public void setVitess_vtctld_password(String vitess_vtctld_password) {
        this.vitess_vtctld_password = vitess_vtctld_password;
    }

    public String getVitess_vtctld_port() {
        return vitess_vtctld_port;
    }

    public void setVitess_vtctld_port(String vitess_vtctld_port) {
        this.vitess_vtctld_port = vitess_vtctld_port;
    }

    public String getVitess_vtctld_user() {
        return vitess_vtctld_user;
    }

    public void setVitess_vtctld_user(String vitess_vtctld_user) {
        this.vitess_vtctld_user = vitess_vtctld_user;
    }

}
