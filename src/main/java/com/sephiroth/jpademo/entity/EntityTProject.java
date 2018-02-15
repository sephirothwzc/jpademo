package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_project")
@Data
public class EntityTProject  implements Serializable {

  
  /**
   * 主键guid
   */
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
  @Column(name = "project_code")
  private String projectCode;

  public static final String  _projectCode = "projectCode";
  
  /**
   * 项目名称
   */
  @Column(name = "project_name")
  private String projectName;

  public static final String  _projectName = "projectName";
  
  /**
   * 项目类型
   */
  @Column(name = "project_type")
  private String projectType;

  public static final String  _projectType = "projectType";
  
  /**
   * 产品id
   */
  @Column(name = "product")
  private String product;

  public static final String  _product = "product";
  
  /**
   * 事业部
   */
  @Column(name = "departid")
  private String departid;

  public static final String  _departid = "departid";
  
  /**
   * 里程碑模版
   */
  @Column(name = "milestonetp")
  private String milestonetp;

  public static final String  _milestonetp = "milestonetp";
  
  /**
   * 开始时间
   */
  @Column(name = "datebegin")
  private java.sql.Timestamp datebegin;

  public static final String  _datebegin = "datebegin";
  
  /**
   * 结束时间
   */
  @Column(name = "dateend")
  private java.sql.Timestamp dateend;

  public static final String  _dateend = "dateend";
  
  /**
   * 项目实施地
   */
  @Column(name = "areaid")
  private String areaid;

  public static final String  _areaid = "areaid";
  
  /**
   * 所属项目集id
   */
  @Column(name = "projectsetid")
  private String projectsetid;

  public static final String  _projectsetid = "projectsetid";

}
