package me.newsong.handler.mybatis;

import me.newsong.enums.DeptStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SinjinSong on 2017/4/22.
 */
public class DeptStatusTypeHandler implements TypeHandler<DeptStatus>{
    /**
     * 定义数据如何保存到数据库
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, DeptStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    /**
     * 从数据库中查询出枚举对象
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public DeptStatus getResult(ResultSet rs, String columnName) throws SQLException {
        return DeptStatus.getDeptStatusByCode(rs.getInt(columnName));
    }

    @Override
    public DeptStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        return DeptStatus.getDeptStatusByCode(rs.getInt(columnIndex));
    }

    @Override
    public DeptStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return DeptStatus.getDeptStatusByCode(cs.getInt(columnIndex));
    }
}
