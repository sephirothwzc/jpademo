package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_jurisdiction")
@Data
public class EntitySysJurisdiction  implements Serializable {

  
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
   * 权限类型1导航2菜单3页签4按钮
   */
  @Column(name = "jur_type")
  private String jurType;

  public static final String  _jurType = "jurType";
  
  /**
   * 编号自动生成
   */
  @Column(name = "jur_code")
  private String jurCode;

  public static final String  _jurCode = "jurCode";
  
  /**
   * 名称
   */
  @Column(name = "jur_name")
  private String jurName;

  public static final String  _jurName = "jurName";
  
  /**
   * 父级别id
   */
  @Column(name = "jur_pid")
  private String jurPid;

  public static final String  _jurPid = "jurPid";
  
  /**
   * 路由
   */
  @Column(name = "jur_path")
  private String jurPath;

  public static final String  _jurPath = "jurPath";
  
  /**
   * 路径默认参数
   */
  @Column(name = "jur_param")
  private String jurParam;

  public static final String  _jurParam = "jurParam";
  
  /**
   * 弹出页签用title
   */
  @Column(name = "jur_title")
  private String jurTitle;

  public static final String  _jurTitle = "jurTitle";
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;

  public static final String  _remark = "remark";

}
