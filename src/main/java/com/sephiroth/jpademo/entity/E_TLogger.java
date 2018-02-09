package com.sephiroth.jpademo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_logger")
public class E_TLogger  implements Serializable {

  
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
   * 业务编码
   */
  @Column(name = "bdcode")
  private String bdcode;
  
  /**
   * 公司代码
   */
  @Column(name = "companyno")
  private String companyno;
  
  /**
   * null
   */
  @Column(name = "ali_id")
  private long aliId;
  
  /**
   * null
   */
  @Column(name = "clientip")
  private String clientip;
  
  /**
   * null
   */
  @Column(name = "ali_uri")
  private String aliUri;
  
  /**
   * null
   */
  @Column(name = "ali_type")
  private String aliType;
  
  /**
   * null
   */
  @Column(name = "ali_method")
  private String aliMethod;
  
  /**
   * null
   */
  @Column(name = "ali_paramdata")
  private String aliParamdata;
  
  /**
   * null
   */
  @Column(name = "session_id")
  private String sessionId;
  
  /**
   * null
   */
  @Column(name = "ali_datetime")
  private java.sql.Timestamp aliDatetime;
  
  /**
   * null
   */
  @Column(name = "ali_return_time")
  private java.sql.Timestamp aliReturnTime;
  
  /**
   * null
   */
  @Column(name = "ali_return_data")
  private String aliReturnData;
  
  /**
   * null
   */
  @Column(name = "http_status_code")
  private String httpStatusCode;
  
  /**
   * null
   */
  @Column(name = "ali_time_consuming")
  private long aliTimeConsuming;
  
  /**
   * 登陆用户
   */
  @Column(name = "token_user")
  private String tokenUser;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }


  public java.sql.Timestamp getUpdatedate() {
    return updatedate;
  }

  public void setUpdatedate(java.sql.Timestamp updatedate) {
    this.updatedate = updatedate;
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


  public String getBdcode() {
    return bdcode;
  }

  public void setBdcode(String bdcode) {
    this.bdcode = bdcode;
  }


  public String getCompanyno() {
    return companyno;
  }

  public void setCompanyno(String companyno) {
    this.companyno = companyno;
  }


  public long getAliId() {
    return aliId;
  }

  public void setAliId(long aliId) {
    this.aliId = aliId;
  }


  public String getClientip() {
    return clientip;
  }

  public void setClientip(String clientip) {
    this.clientip = clientip;
  }


  public String getAliUri() {
    return aliUri;
  }

  public void setAliUri(String aliUri) {
    this.aliUri = aliUri;
  }


  public String getAliType() {
    return aliType;
  }

  public void setAliType(String aliType) {
    this.aliType = aliType;
  }


  public String getAliMethod() {
    return aliMethod;
  }

  public void setAliMethod(String aliMethod) {
    this.aliMethod = aliMethod;
  }


  public String getAliParamdata() {
    return aliParamdata;
  }

  public void setAliParamdata(String aliParamdata) {
    this.aliParamdata = aliParamdata;
  }


  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }


  public java.sql.Timestamp getAliDatetime() {
    return aliDatetime;
  }

  public void setAliDatetime(java.sql.Timestamp aliDatetime) {
    this.aliDatetime = aliDatetime;
  }


  public java.sql.Timestamp getAliReturnTime() {
    return aliReturnTime;
  }

  public void setAliReturnTime(java.sql.Timestamp aliReturnTime) {
    this.aliReturnTime = aliReturnTime;
  }


  public String getAliReturnData() {
    return aliReturnData;
  }

  public void setAliReturnData(String aliReturnData) {
    this.aliReturnData = aliReturnData;
  }


  public String getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(String httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }


  public long getAliTimeConsuming() {
    return aliTimeConsuming;
  }

  public void setAliTimeConsuming(long aliTimeConsuming) {
    this.aliTimeConsuming = aliTimeConsuming;
  }


  public String getTokenUser() {
    return tokenUser;
  }

  public void setTokenUser(String tokenUser) {
    this.tokenUser = tokenUser;
  }

}
