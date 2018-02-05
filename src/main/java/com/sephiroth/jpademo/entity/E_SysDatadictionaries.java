package com.sephiroth.jpademo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sys_datadictionaries")
public class E_SysDatadictionaries  implements Serializable {

  
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


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public java.sql.Timestamp getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(java.sql.Timestamp updatetime) {
    this.updatetime = updatetime;
  }


  public String getCreateby() {
    return createby;
  }

  public void setCreateby(String createby) {
    this.createby = createby;
  }


  public String getUpdateby() {
    return updateby;
  }

  public void setUpdateby(String updateby) {
    this.updateby = updateby;
  }


  public String getEnableflag() {
    return enableflag;
  }

  public void setEnableflag(String enableflag) {
    this.enableflag = enableflag;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public String getSortnum() {
    return sortnum;
  }

  public void setSortnum(String sortnum) {
    this.sortnum = sortnum;
  }


  public String getDisplaytxt() {
    return displaytxt;
  }

  public void setDisplaytxt(String displaytxt) {
    this.displaytxt = displaytxt;
  }

}
