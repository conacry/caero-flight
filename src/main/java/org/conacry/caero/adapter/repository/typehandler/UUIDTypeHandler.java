package org.conacry.caero.adapter.repository.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.UUID;

public class UUIDTypeHandler implements TypeHandler<UUID> {

    @Override
    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setObject(i, null, Types.OTHER);
        } else {
            ps.setObject(i, parameter.toString(), Types.OTHER);
        }
    }

    @Override
    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
        return toUUID(rs.getString(columnName));
    }

    @Override
    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
        return toUUID(rs.getString(columnIndex));
    }

    @Override
    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toUUID(cs.getString(columnIndex));
    }

    private static UUID toUUID(String val) {
        if (val == null || val.isBlank()) {
            return null;
        }

        return UUID.fromString(val);
    }
}
