package com.database.web.framework.database.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository("jBaseDao")
public class JBaseDao implements JdbcOperations,JModelDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private JModelDao jModelDao;





    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(String sql){
        return getJdbcTemplate().update(sql);
    }

    @Override
    public int[] batchUpdate(String... strings) throws DataAccessException {
        return getJdbcTemplate().batchUpdate(strings);
    }

    @Nullable
    @Override
    public <T> T execute(PreparedStatementCreator preparedStatementCreator, PreparedStatementCallback<T> preparedStatementCallback) throws DataAccessException {
        return getJdbcTemplate().execute(preparedStatementCreator,preparedStatementCallback);
    }

    @Nullable
    @Override
    public <T> T execute(String s, PreparedStatementCallback<T> preparedStatementCallback) throws DataAccessException {
        return getJdbcTemplate().execute(s,preparedStatementCallback);
    }

    @Nullable
    @Override
    public <T> T query(PreparedStatementCreator preparedStatementCreator, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return getJdbcTemplate().query(preparedStatementCreator,resultSetExtractor);
    }

    @Nullable
    @Override
    public <T> T query(String s, @Nullable PreparedStatementSetter preparedStatementSetter, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T query(String s, Object[] objects, int[] ints, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T query(String s, Object[] objects, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T query(String s, ResultSetExtractor<T> resultSetExtractor, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public void query(PreparedStatementCreator preparedStatementCreator, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, @Nullable PreparedStatementSetter preparedStatementSetter, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, Object[] objects, int[] ints, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, Object[] objects, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public void query(String s, RowCallbackHandler rowCallbackHandler, @Nullable Object... objects) throws DataAccessException {

    }

    @Override
    public <T> List<T> query(PreparedStatementCreator preparedStatementCreator, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, @Nullable PreparedStatementSetter preparedStatementSetter, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, Object[] objects, int[] ints, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, Object[] objects, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> query(String s, RowMapper<T> rowMapper, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Object[] objects, int[] ints, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Object[] objects, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, RowMapper<T> rowMapper, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Object[] objects, int[] ints, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Object[] objects, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Class<T> aClass, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String s, Object[] objects, int[] ints) throws DataAccessException {
        return getJdbcTemplate().queryForMap(s,objects,ints);
    }

    @Override
    public Map<String, Object> queryForMap(String s, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Object[] objects, int[] ints, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Object[] objects, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Class<T> aClass, @Nullable Object... objects) throws DataAccessException {
        return getJdbcTemplate().queryForList(s,aClass,objects);
    }

    @Override
    public List<Map<String, Object>> queryForList(String s, Object[] objects, int[] ints) throws DataAccessException {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList(String s, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public SqlRowSet queryForRowSet(String s, Object[] objects, int[] ints) throws DataAccessException {
        return null;
    }

    @Override
    public SqlRowSet queryForRowSet(String s, @Nullable Object... objects) throws DataAccessException {
        return null;
    }

    @Override
    public int update(PreparedStatementCreator preparedStatementCreator) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(PreparedStatementCreator preparedStatementCreator, KeyHolder keyHolder) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, @Nullable PreparedStatementSetter preparedStatementSetter) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, Object[] objects, int[] ints) throws DataAccessException {
        return 0;
    }

    @Override
    public int update(String s, @Nullable Object... objects) throws DataAccessException {
        return 0;
    }

    @Override
    public int[] batchUpdate(String s, BatchPreparedStatementSetter batchPreparedStatementSetter) throws DataAccessException {
        return new int[0];
    }

    @Override
    public int[] batchUpdate(String s, List<Object[]> list) throws DataAccessException {
        return new int[0];
    }

    @Override
    public int[] batchUpdate(String s, List<Object[]> list, int[] ints) throws DataAccessException {
        return new int[0];
    }

    @Override
    public <T> int[][] batchUpdate(String s, Collection<T> collection, int i, ParameterizedPreparedStatementSetter<T> parameterizedPreparedStatementSetter) throws DataAccessException {
        return new int[0][];
    }

    @Nullable
    @Override
    public <T> T execute(CallableStatementCreator callableStatementCreator, CallableStatementCallback<T> callableStatementCallback) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T execute(String s, CallableStatementCallback<T> callableStatementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> call(CallableStatementCreator callableStatementCreator, List<SqlParameter> list) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T execute(ConnectionCallback<T> connectionCallback) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T execute(StatementCallback<T> statementCallback) throws DataAccessException {
        return null;
    }

    @Override
    public void execute(String s) throws DataAccessException {

    }

    @Nullable
    @Override
    public <T> T query(String s, ResultSetExtractor<T> resultSetExtractor) throws DataAccessException {
        return null;
    }

    @Override
    public void query(String s, RowCallbackHandler rowCallbackHandler) throws DataAccessException {

    }

    @Override
    public <T> List<T> query(String s, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, RowMapper<T> rowMapper) throws DataAccessException {
        return null;
    }

    @Nullable
    @Override
    public <T> T queryForObject(String s, Class<T> aClass) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String s) throws DataAccessException {
        return null;
    }

    @Override
    public <T> List<T> queryForList(String s, Class<T> aClass) throws DataAccessException {
        return null;
    }

    public List queryForList(String sql){

        return getJdbcTemplate().queryForList(sql);
    }

    @Override
    public SqlRowSet queryForRowSet(String s) throws DataAccessException {
        return null;
    }


    @Override
    public BaseModel selectModel(BaseModel baseModel) throws Exception {
        return jModelDao.selectModel(baseModel);
    }

    @Override
    public BaseModel updateModel(BaseModel baseModel) throws Exception {
        return jModelDao.updateModel(baseModel);

    }

    @Override
    public BaseModel insertModel(BaseModel baseModel) throws Exception {
        return jModelDao.insertModel(baseModel);
    }

    @Override
    public BaseModel deleteModel(BaseModel baseModel) throws Exception {
        return jModelDao.deleteModel(baseModel);
    }
}
