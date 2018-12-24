package com.yautumn.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.yautumn.user.common.UserRowMapper;
import com.yautumn.user.entity.User;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询全部记录数
     * @return
     */
    public List<User> getUserList(){
        String sql = "SELECT * FROM USER";
        RowMapper<User> rowMapper = new UserRowMapper();
        return jdbcTemplate.query(sql,rowMapper);
    }
    
    /**
     * 根据id查询user信息
     * @param id
     * @return
     */
    public User getUserById(int id){
        String sql = "select * from user where id = ?";
        RowMapper<User> rowMapper = new UserRowMapper();
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    
    /**
     * 获取记录数
     * @return
     */
    public int getCount(){
        String sql = "select count(1) from user";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    
    /**
     * 根据id删除记录，并返回boolean型值
     * @param id
     * @return
     */
    public boolean deleteUserById(int id){
        boolean flg = false;
        String sql = "delete from user where id = ?";
        int i = jdbcTemplate.update(sql,id);
        if(i>0){
            flg = true;
        }
        return flg;
    }
    
    /**
     * 	插入操作
     * @param user
     * @return
     */
    public boolean insertUser(User user){
        boolean flg = false;
        String sql = "insert into user values(?,?,?,?)";
        int i = jdbcTemplate.update(sql,null,user.getUserName(),user.getPassword(),user.getBirthday());
        if(i>0){
            flg = true;
        }
        return flg;
    }
    
    /**
     * 	更新user
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
    	boolean flg = false;
    	String sql = "update user set username = ? ,password = ? , birthday = ? where id = ?";
    	int i = jdbcTemplate.update(sql, user.getUserName(),user.getPassword(),user.getBirthday(),user.getId());
    	if(i > 0) {
    		flg = true;
    	}
    	return flg;
    }
}
