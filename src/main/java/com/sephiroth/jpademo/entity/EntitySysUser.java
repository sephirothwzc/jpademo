package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_user")
@Data
public class EntitySysUser  implements Serializable {

  
  /**
   * null
   */
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;

  public static final String  _id = "id";
  
  /**
   * null
   */
  @Column(name = "createdate")
  private java.sql.Timestamp createdate;

  public static final String  _createdate = "createdate";
  
  /**
   * null
   */
  @Column(name = "updatedate")
  private java.sql.Timestamp updatedate;

  public static final String  _updatedate = "updatedate";
  
  /**
   * null
   */
  @Column(name = "createby")
  private String createby;

  public static final String  _createby = "createby";
  
  /**
   * null
   */
  @Column(name = "updateby")
  private String updateby;

  public static final String  _updateby = "updateby";
  
  /**
   * null
   */
  @Column(name = "enableflag")
  private String enableflag;

  public static final String  _enableflag = "enableflag";
  
  /**
   * 用户名
   */
  @Column(name = "user_name")
  private String userName;

  public static final String  _userName = "userName";
  
  /**
   * 用户编码
   */
  @Column(name = "user_code")
  private String userCode;

  public static final String  _userCode = "userCode";
  
  /**
   * 密码
   */
  @Column(name = "password")
  private String password;

  public static final String  _password = "password";
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;

  public static final String  _remark = "remark";

}
