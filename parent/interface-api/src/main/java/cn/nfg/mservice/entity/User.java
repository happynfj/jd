package cn.nfg.mservice.entity;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2018/6/22 11:18
 * @Description:
 */
public class User implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
