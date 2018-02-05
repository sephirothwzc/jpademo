package com.sephiroth.jpademo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_user")
public class E_SysUser  implements Serializable {

  
  /**
   * null
   */
  @Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;
  
  /**
   * null
   */
  @Column(name = "createdate")
  private java.sql.Timestamp createdate;
  
  /**
   * null
   */
  @Column(name = "updatedate")
  private java.sql.Timestamp updatedate;
  
  /**
   * null
   */
  @Column(name = "createby")
  private String createby;
  
  /**
   * null
   */
  @Column(name = "updateby")
  private String updateby;
  
  /**
   * null
   */
  @Column(name = "enableflag")
  private String enableflag;
  
  /**
   * 用户名
   */
  @Column(name = "username")
  private String username;
  
  /**
   * 用户编码
   */
  @Column(name = "usercode")
  private String usercode;
  
  /**
   * 密码
   */
  @Column(name = "password")
  private String password;
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }


  public java.sql.Timestamp getUpdatedate() {
    return updatedate;
  }

  public void setUpdatedate(java.sql.Timestamp updatedate) {
    this.updatedate = updatedate;
  }


  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }


  public String getUpdateby() {
    return updateby;
  }

  public void setUpdateby(String updateby) {
    this.updateby = updateby;
  }


  public String getEnableflag() {
    return enableflag;
  }

  public void setEnableflag(String enableflag) {
    this.enableflag = enableflag;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getUsercode() {
    return usercode;
  }

  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
