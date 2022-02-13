package com.zdk.hello.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

/**
 * <b>类 名 称</b> :  EncryptTypeHandler<br/>
 * <b>类 描 述</b> :  mybatis-tpyeHandler<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/2/13 9:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/2/13 9:31<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class EncryptStringTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String encrypt, JdbcType jdbcType) throws SQLException {
        if (encrypt == null) {
            preparedStatement.setString(i, null);
            return;
        }
        String encode = Base64.getEncoder().encodeToString(encrypt.getBytes(StandardCharsets.UTF_8));
        preparedStatement.setString(i, encode);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return decrypt(resultSet.getString(columnName));
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return decrypt(resultSet.getString(i));
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return decrypt(callableStatement.getString(i));
    }

    private String decrypt(String value) {
        if (null == value) {
            return null;
        }
        byte[] decode = Base64.getDecoder().decode(value);
        return new String(decode, StandardCharsets.UTF_8);
    }
}
