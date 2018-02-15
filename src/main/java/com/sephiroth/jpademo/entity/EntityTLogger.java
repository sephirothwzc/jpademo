package com.sephiroth.jpademo.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_logger")
@Data
public class EntityTLogger  implements Serializable {

  
  /**
   * null
   */
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
   * null
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
  @Column(name = "ali_id")
  private long aliId;

  public static final String  _aliId = "aliId";
  
  /**
   * null
   */
  @Column(name = "clientip")
  private String clientip;

  public static final String  _clientip = "clientip";
  
  /**
   * null
   */
  @Column(name = "ali_uri")
  private String aliUri;

  public static final String  _aliUri = "aliUri";
  
  /**
   * null
   */
  @Column(name = "ali_type")
  private String aliType;

  public static final String  _aliType = "aliType";
  
  /**
   * null
   */
  @Column(name = "ali_method")
  private String aliMethod;

  public static final String  _aliMethod = "aliMethod";
  
  /**
   * null
   */
  @Column(name = "ali_paramdata")
  private String aliParamdata;

  public static final String  _aliParamdata = "aliParamdata";
  
  /**
   * null
   */
  @Column(name = "session_id")
  private String sessionId;

  public static final String  _sessionId = "sessionId";
  
  /**
   * null
   */
  @Column(name = "ali_datetime")
  private java.sql.Timestamp aliDatetime;

  public static final String  _aliDatetime = "aliDatetime";
  
  /**
   * null
   */
  @Column(name = "ali_return_time")
  private java.sql.Timestamp aliReturnTime;

  public static final String  _aliReturnTime = "aliReturnTime";
  
  /**
   * null
   */
  @Column(name = "ali_return_data")
  private String aliReturnData;

  public static final String  _aliReturnData = "aliReturnData";
  
  /**
   * null
   */
  @Column(name = "http_status_code")
  private String httpStatusCode;

  public static final String  _httpStatusCode = "httpStatusCode";
  
  /**
   * null
   */
  @Column(name = "ali_time_consuming")
  private long aliTimeConsuming;

  public static final String  _aliTimeConsuming = "aliTimeConsuming";
  
  /**
   * 登陆用户
   */
  @Column(name = "token_user")
  private String tokenUser;

  public static final String  _tokenUser = "tokenUser";

}
