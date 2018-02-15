package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_result")
@Data
public class EntityTResult  implements Serializable {

  
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
   * 成果物名称
   */
  @Column(name = "resultname")
  private String resultname;

  public static final String  _resultname = "resultname";
  
  /**
   * 是否必须0/1
   */
  @Column(name = "is_must")
  private String isMust;

  public static final String  _isMust = "isMust";
  
  /**
   * 是否提交原件
   */
  @Column(name = "is_original")
  private String isOriginal;

  public static final String  _isOriginal = "isOriginal";
  
  /**
   * 模版下载资源
   */
  @Column(name = "templateurl")
  private String templateurl;

  public static final String  _templateurl = "templateurl";
  
  /**
   * 计划提交时间
   */
  @Column(name = "plansubmitdate")
  private java.sql.Timestamp plansubmitdate;

  public static final String  _plansubmitdate = "plansubmitdate";
  
  /**
   * 实际提交日期
   */
  @Column(name = "realsubmitdate")
  private java.sql.Timestamp realsubmitdate;

  public static final String  _realsubmitdate = "realsubmitdate";
  
  /**
   * 成果物版本
   */
  @Column(name = "version")
  private String version;

  public static final String  _version = "version";
  
  /**
   * 最后提交时间
   */
  @Column(name = "lastsubmitdate")
  private java.sql.Timestamp lastsubmitdate;

  public static final String  _lastsubmitdate = "lastsubmitdate";
  
  /**
   * 最后提交人id
   */
  @Column(name = "lastsubmitby")
  private String lastsubmitby;

  public static final String  _lastsubmitby = "lastsubmitby";
  
  /**
   * 原件快递单号
   */
  @Column(name = "expressno")
  private String expressno;

  public static final String  _expressno = "expressno";
  
  /**
   * 电子版本确认
   */
  @Column(name = "has_electronic")
  private String hasElectronic;

  public static final String  _hasElectronic = "hasElectronic";
  
  /**
   * 原件确认
   */
  @Column(name = "has_original")
  private String hasOriginal;

  public static final String  _hasOriginal = "hasOriginal";
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;

  public static final String  _remark = "remark";
  
  /**
   * 文件名称
   */
  @Column(name = "filename")
  private String filename;

  public static final String  _filename = "filename";

}
