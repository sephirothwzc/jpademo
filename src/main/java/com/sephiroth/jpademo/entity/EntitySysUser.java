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
  @Column(name = "user_name")
  private String userName;

  
  /**
   * 用户编码
   */
  @Column(name = "user_code")
  private String userCode;

  
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

  
  /**
   * 盐
   */
  @Column(name = "salt")
  private String salt;

  
  /**
   * 最后登陆时间
   */
  @Column(name = "last_login")
  private java.sql.Timestamp lastLogin;

  public static final String  _id = "id";

  public static final String  _createdate = "createdate";

  public static final String  _updatedate = "updatedate";

  public static final String  _createby = "createby";

  public static final String  _updateby = "updateby";

  public static final String  _enableflag = "enableflag";

  public static final String  _userName = "userName";

  public static final String  _userCode = "userCode";

  public static final String  _password = "password";

  public static final String  _remark = "remark";

  public static final String  _salt = "salt";

  public static final String  _lastLogin = "lastLogin";


}
