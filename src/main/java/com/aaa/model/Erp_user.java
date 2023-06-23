package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Erp_user {
    /*
     * 用户管理
     * */
    private Integer u_id;//序号
    private String u_name;//账号
    private String u_pwd;//密码
    private Integer r_id;//角色管理外键
    private Integer oper_id;//员工表外键
    private Integer u_state;//员工账号的是否禁用 0禁用 1 启用
    private Erp_role erp_role;
    private Operator operator;

    public Erp_user(String u_name, String u_pwd) {
        this.u_name = u_name;
        this.u_pwd = u_pwd;
    }
}
