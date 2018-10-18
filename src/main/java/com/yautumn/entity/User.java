package com.yautumn.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
    public int id;
    public String userName;
    public String password;
    @JSONField(format="yyyy-MM-dd")
    public Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
