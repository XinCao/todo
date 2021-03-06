package com.xincao.todo.model;

import com.xincao.todo.util.PatternConstant;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author caoxin
 */
public class User implements Serializable {

    public static final String USER_ROLE = "user_role";
    private int id;
    @NotNull(message = Message_zh_cn.required)
    @Size(min = 6, max = 25, message = Message_zh_cn.rangelength)
    @Pattern(regexp = PatternConstant.common, message = Message_zh_cn.regex)
    private String account;
    @NotNull(message = Message_zh_cn.required)
    @Size(min = 6, max = 255, message = Message_zh_cn.rangelength)
    @Pattern(regexp = PatternConstant.common, message = Message_zh_cn.regex)
    private String passwd;
    @Size(min = 6, max = 255, message = Message_zh_cn.rangelength)
    @Pattern(regexp = PatternConstant.common, message = Message_zh_cn.regex)
    private String againPasswd;
    @Pattern(regexp = PatternConstant.mail, message = Message_zh_cn.email)
    private String email;
    private Date createTime;
    private int valied; // 是否有效
    private int activited; // 是否被激活 1.为未激活, 2.为激活
    private int userRole; // 用户角色 1.为普通， 2.管理角色

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAgainPasswd() {
        return againPasswd;
    }

    public void setAgainPasswd(String againPasswd) {
        this.againPasswd = againPasswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getValied() {
        return valied;
    }

    public void setValied(int valied) {
        this.valied = valied;
    }

    public int getActivited() {
        return activited;
    }

    public void setActivited(int activited) {
        this.activited = activited;
    }

    public boolean againPasswdOk() {
        boolean isOk = true;
        if (this.passwd == null) {
            isOk = false;
        }
        if (this.againPasswd == null) {
            isOk = false;
        }
        if (!passwd.equalsIgnoreCase(againPasswd)) {
            isOk = false;
        }
        return isOk;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", account=" + account + ", passwd=" + passwd + ", email=" + email + ", createTime=" + createTime + ", valied=" + valied + ", activited=" + activited + '}';
    }

    public enum UserRole {
        
        COMMON_USER_ROLE(1, "common"),
        ADMIN_USER_ROLE(2, "common:admin")
        ;

        private int id;
        private String key;

        private UserRole(int id, String key) {
            this.id = id;
            this.key = key;
        }

        public int getId() {
            return this.id;
        }

        public String getKey() {
            return this.key;
        }

        public static UserRole fromId(int id) {
            for (UserRole userRole : values()) {
                if (userRole.getId() == id) {
                    return userRole;
                }
            }
            return null;
        }
    }
}