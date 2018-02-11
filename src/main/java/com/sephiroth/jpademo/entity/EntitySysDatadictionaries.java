package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_datadictionaries")
@Data
public class EntitySysDatadictionaries implements Serializable {

  
  /**
   * 主键
   */
  @Id
  @GenericGenerator(name = "user-uuid", strategy = "uuid")
  @GeneratedValue(generator = "user-uuid")
  @Column(name = "id", nullable = false, length = 64)
  private String id;
  
  /**
   * 创建时间戳
   */
  @Column(name = "createtime")
  private java.sql.Timestamp createtime;
  
  /**
   * 更新时间戳
   */
  @Column(name = "updatetime")
  private java.sql.Timestamp updatetime;
  
  /**
   * 创建人id
   */
  @Column(name = "createby")
  private String createby;
  
  /**
   * 更新人id
   */
  @Column(name = "updateby")
  private String updateby;
  
  /**
   * 数据状态1启用0停用-1删除
   */
  @Column(name = "enableflag")
  private String enableflag;
  
  /**
   * 编码
   */
  @Column(name = "code")
  private String code;
  
  /**
   * 中文名称
   */
  @Column(name = "name")
  private String name;
  
  /**
   * 父级别id
   */
  @Column(name = "pid")
  private String pid;
  
  /**
   * 备注
   */
  @Column(name = "remark")
  private String remark;
  
  /**
   * 数据值
   */
  @Column(name = "value")
  private String value;
  
  /**
   * 排序值
   */
  @Column(name = "sortnum")
  private String sortnum;
  
  /**
   * 显示文本
   */
  @Column(name = "displaytxt")
  private String displaytxt;

}
