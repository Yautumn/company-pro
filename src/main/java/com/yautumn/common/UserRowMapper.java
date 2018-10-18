package com.yautumn.common;

import com.yautumn.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.id = resultSet.getInt("id");
        user.userName = resultSet.getString("username");
        user.password = resultSet.getString("password");
        user.birthday = resultSet.getDate("birthday");
        return user;
    }
}
