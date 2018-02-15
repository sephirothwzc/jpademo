package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_projectset")
@Data
public class EntityTProjectset  implements Serializable {

  
  /**
   * 主键guid
   */
@Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;

  public static final String  _id = "id";
  
  /**
   * 创建时间
   */
  @Column(name = "createtime")
  private java.sql.Timestamp createtime;

  public static final String  _createtime = "createtime";
  
  /**
   * 创建人id
   */
  @Column(name = "createby")
  private String createby;

  public static final String  _createby = "createby";
  
  /**
   * 更新时间
   */
  @Column(name = "updatetime")
  private java.sql.Timestamp updatetime;

  public static final String  _updatetime = "updatetime";
  
  /**
   * 更新人ID
   */
  @Column(name = "updateby")
  private String updateby;

  public static final String  _updateby = "updateby";
  
  /**
   * 数据有效性0/1
   */
  @Column(name = "enableflag")
  private String enableflag;

  public static final String  _enableflag = "enableflag";
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;

  public static final String  _remark = "remark";
  
  /**
   * 公司代码
   */
  @Column(name = "companyno")
  private String companyno;

  public static final String  _companyno = "companyno";
  
  /**
   * 业务码
   */
  @Column(name = "bdcode")
  private String bdcode;

  public static final String  _bdcode = "bdcode";
  
  /**
   * 项目编号
   */
  @Column(name = "projectset_code")
  private String projectsetCode;

  public static final String  _projectsetCode = "projectsetCode";
  
  /**
   * 项目名称
   */
  @Column(name = "projectset_name")
  private String projectsetName;

  public static final String  _projectsetName = "projectsetName";
  
  /**
   * 事业部
   */
  @Column(name = "departid")
  private String departid;

  public static final String  _departid = "departid";
  
  /**
   * 机会编号
   */
  @Column(name = "chance_code")
  private String chanceCode;

  public static final String  _chanceCode = "chanceCode";
  
  /**
   * 是否研发项目0/1
   */
  @Column(name = "isdevelop")
  private String isdevelop;

  public static final String  _isdevelop = "isdevelop";
  
  /**
   * 销售部门id
   */
  @Column(name = "marketdepartid")
  private String marketdepartid;

  public static final String  _marketdepartid = "marketdepartid";
  
  /**
   * 客户id
   */
  @Column(name = "customerid")
  private String customerid;

  public static final String  _customerid = "customerid";
  
  /**
   * 客户经理id
   */
  @Column(name = "customerpmid")
  private String customerpmid;

  public static final String  _customerpmid = "customerpmid";

}
