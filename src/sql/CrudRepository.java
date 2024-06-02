package sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudRepository {
    private final Connection connection;

    public CrudRepository(Connection connection) {
        this.connection = connection;
    }

    public void create(String tableName, Map<String, Object> data) {
        String sql = generateInsertQuery(tableName, data.keySet());
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int index = 1;
            for (Object value : data.values()) {
                if (value instanceof java.util.Date) {
                    statement.setTimestamp(index++, new Timestamp(((java.util.Date) value).getTime()));
                } else {
                    statement.setObject(index++, value);
                }
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating record in table " + tableName, e);
        }
    }

    public List<Map<String, Object>> read(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error reading records from table " + tableName, e);
        }
    }
    public List<Map<String, Object>> readWhere(String tableName, String condition) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + condition;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing query on table " + tableName, e);
        }
    }

    public void update(String tableName, int id, Map<String, Object> data) {
        String sql = generateUpdateQuery(tableName, data.keySet(), "id");
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int index = 1;
            for (Object value : data.values()) {
                if (value instanceof java.util.Date) {
                    statement.setTimestamp(index++, new Timestamp(((java.util.Date) value).getTime()));
                } else {
                    statement.setObject(index++, value);
                }
            }
            statement.setInt(index, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating record in table " + tableName, e);
        }
    }

    public void delete(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting record from table " + tableName, e);
        }
    }

    private String generateInsertQuery(String tableName, Iterable<String> columns) {
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        StringBuilder values = new StringBuilder(") VALUES (");
        int count = 0;
        for (String column : columns) {
            sql.append(column);
            values.append("?");
            if (++count < columns.spliterator().getExactSizeIfKnown()) {
                sql.append(", ");
                values.append(", ");
            }
        }
        return sql.append(values).append(")").toString();
    }

    private String generateUpdateQuery(String tableName, Iterable<String> columns, String idColumn) {
        StringBuilder sql = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        int count = 0;
        for (String column : columns) {
            sql.append(column).append(" = ?");
            if (++count < columns.spliterator().getExactSizeIfKnown()) {
                sql.append(", ");
            }
        }
        return sql.append(" WHERE ").append(idColumn).append(" = ?").toString();
    }

    private List<Map<String, Object>> mapResultSetToList(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> results = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                row.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            results.add(row);
        }
        return results;
    }
}