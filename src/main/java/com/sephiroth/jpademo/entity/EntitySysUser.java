package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_user")
@Data
public class EntitySysUser implements Serializable {

  
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

}
