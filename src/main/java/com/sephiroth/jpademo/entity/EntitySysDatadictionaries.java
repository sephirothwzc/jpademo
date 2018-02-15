package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_datadictionaries")
@Data
public class EntitySysDatadictionaries  implements Serializable {

  
  /**
   * 主键
   */
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;

  public static final String  _id = "id";
  
  /**
   * 创建时间戳
   */
  @Column(name = "createtime")
  private java.sql.Timestamp createtime;

  public static final String  _createtime = "createtime";
  
  /**
   * 更新时间戳
   */
  @Column(name = "updatetime")
  private java.sql.Timestamp updatetime;

  public static final String  _updatetime = "updatetime";
  
  /**
   * 创建人id
   */
  @Column(name = "createby")
  private String createby;

  public static final String  _createby = "createby";
  
  /**
   * 更新人id
   */
  @Column(name = "updateby")
  private String updateby;

  public static final String  _updateby = "updateby";
  
  /**
   * 数据状态1启用0停用-1删除
   */
  @Column(name = "enableflag")
  private String enableflag;

  public static final String  _enableflag = "enableflag";
  
  /**
   * 编码
   */
  @Column(name = "data_code")
  private String dataCode;

  public static final String  _dataCode = "dataCode";
  
  /**
   * 中文名称
   */
  @Column(name = "data_name")
  private String dataName;

  public static final String  _dataName = "dataName";
  
  /**
   * 父级别id
   */
  @Column(name = "pid")
  private String pid;

  public static final String  _pid = "pid";
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;

  public static final String  _remark = "remark";
  
  /**
   * 数据值
   */
  @Column(name = "data_value")
  private String dataValue;

  public static final String  _dataValue = "dataValue";
  
  /**
   * 排序值
   */
  @Column(name = "sort_num")
  private String sortNum;

  public static final String  _sortNum = "sortNum";
  
  /**
   * 显示文本
   */
  @Column(name = "data_display")
  private String dataDisplay;

  public static final String  _dataDisplay = "dataDisplay";

}
