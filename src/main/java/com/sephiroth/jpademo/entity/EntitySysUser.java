package com.sephiroth.jpademo.entity;


import com.sephiroth.jpademo.base.jpa.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_user")
@Data
public class EntitySysUser extends BaseEntity implements Serializable {

  
  /**
   * null
   */
  @Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  public String id;

  
  /**
   * null
   */
  @Column(name = "createdate")
  public java.sql.Timestamp createdate;

  
  /**
   * null
   */
  @Column(name = "updatedate")
  public java.sql.Timestamp updatedate;

  
  /**
   * null
   */
  @Column(name = "createby")
  public String createby;

  
  /**
   * null
   */
  @Column(name = "updateby")
  public String updateby;

  
  /**
   * null
   */
  @Column(name = "enableflag")
  public String enableflag;

  
  /**
   * 用户名
   */
  @Column(name = "user_name")
  @NotEmpty
  public String userName;

  
  /**
   * 用户编码
   */
  @Column(name = "user_code")
  public String userCode;

  
  /**
   * 密码
   */
  @Column(name = "password")
  public String password;

  
  /**
   * 备注
   */
  @Column(name = "remark")
  public String remark;

  
  /**
   * 盐
   */
  @Column(name = "salt")
  public String salt;

  
  /**
   * 最后登陆时间
   */
  @Column(name = "last_login")
  public java.sql.Timestamp lastLogin;

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
