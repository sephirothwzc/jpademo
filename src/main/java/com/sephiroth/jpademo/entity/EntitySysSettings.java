package com.sephiroth.jpademo.entity;


import com.sephiroth.jpademo.base.jpa.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_settings")
@Data
public class EntitySysSettings extends BaseEntity implements Serializable {

  
  /**
   * null
   */
@Id
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
   * 0停用1启用-1删除
   */
  @Column(name = "enableflag")
  private String enableflag;

  public static final String  _enableflag = "enableflag";
  
  /**
   * 业务编码
   */
  @Column(name = "bdcode")
  private String bdcode;

  public static final String  _bdcode = "bdcode";
  
  /**
   * 公司代码
   */
  @Column(name = "companyno")
  private String companyno;

  public static final String  _companyno = "companyno";
  
  /**
   * null
   */
  @Column(name = "set_key")
  private String setKey;

  public static final String  _setKey = "setKey";
  
  /**
   * null
   */
  @Column(name = "set_value")
  private String setValue;

  public static final String  _setValue = "setValue";
  
  /**
   * null
   */
  @Column(name = "pid")
  private String pid;

  public static final String  _pid = "pid";
  
  /**
   * 备注
   */
  @Column(name = "reamark")
  private String reamark;

  public static final String  _reamark = "reamark";
  
  /**
   * 显示名称
   */
  @Column(name = "set_name")
  private String setName;

  public static final String  _setName = "setName";

}
